package com.chris.orderingsystem.payservice.service.impl;

import com.chris.orderingsystem.common.utils.PageUtils;
import com.chris.orderingsystem.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.chris.orderingsystem.payservice.dao.PayServiceCardOpLogDao;
import com.chris.orderingsystem.payservice.entity.PayServiceCardOpLogEntity;
import com.chris.orderingsystem.payservice.service.PayServiceCardOpLogService;


@Service("payServiceCardOpLogService")
public class PayServiceCardOpLogServiceImpl extends ServiceImpl<PayServiceCardOpLogDao, PayServiceCardOpLogEntity> implements PayServiceCardOpLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PayServiceCardOpLogEntity> page = this.page(
                new Query<PayServiceCardOpLogEntity>().getPage(params),
                new QueryWrapper<PayServiceCardOpLogEntity>()
        );

        return new PageUtils(page);
    }

}