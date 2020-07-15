package com.chris.orderingsystem.payservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.payservice.entity.PayServiceCardEntity;
import com.chris.orderingsystem.payservice.entity.PayServiceCardOpLogEntity;
import com.chris.orderingsystem.payservice.service.PayServiceCardOpLogService;
import com.chris.orderingsystem.payservice.service.PayServiceCardService;
import com.chris.orderingsystem.payservice.to.PayTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("payservice/feign")
public class PayFeignController {

    @Autowired
    PayServiceCardService cardService;

    @Autowired
    PayServiceCardOpLogService logService;

    @PostMapping("/pay")
    public R pay(@RequestBody PayTo payto){
        PayServiceCardOpLogEntity logEntity = new PayServiceCardOpLogEntity();
        logEntity.setOrderId(payto.getOrderId());
        logEntity.setOrderMoney(payto.getPayMoney());
        logEntity.setPayState(1);
        logService.save(logEntity);

        Map<String,Object> map = new HashMap<>();
        map.put("card_id",payto.getCardId());
        map.put("card_password",payto.getCardPassword());
        QueryWrapper<PayServiceCardEntity> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        PayServiceCardEntity cardEntity = cardService.getOne(wrapper);

        if(cardEntity == null) return R.ok().put("result","error");

        Integer cardMoney = cardEntity.getCardMoney();
        Integer payMoney = payto.getPayMoney();

        if(payMoney.compareTo(cardMoney) > 0) return R.ok().put("result","error");

        cardEntity.setCardMoney(cardMoney - payMoney);
        cardService.update(cardEntity,wrapper);

        return R.ok().put("result","success");
    }

}
