package com.chris.orderingsystem.productservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chris.orderingsystem.common.utils.Query;
import com.chris.orderingsystem.common.utils.R;
import com.chris.orderingsystem.productservice.entity.*;
import com.chris.orderingsystem.productservice.service.*;
import com.chris.orderingsystem.productservice.to.FoodTo;
import com.chris.orderingsystem.productservice.to.ShopTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("productservice/feign")
public class ProductFeignController {

    @Autowired
    ProductServiceActivityService activityService;

    @Autowired
    ProductServiceShopAddressService addressService;

    @Autowired
    ProductServiceSupportService supportService;

    @Autowired
    ProductServiceShopInfoService infoService;

    @Autowired
    ProductServiceShopFoodService foodService;

    @Autowired
    ProductServiceFoodTypeService foodTypeService;

    @GetMapping("/shops/{latitude}/{longitude}")
    public R getShops(@PathVariable BigDecimal latitude, @PathVariable BigDecimal longitude){

        //先查询地址
        QueryWrapper<ProductServiceShopAddressEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("latitude",latitude);
        wrapper1.eq("longitude",longitude);
        ProductServiceShopAddressEntity address = addressService.getOne(wrapper1);

        if(address == null){
            return R.ok().put("shops",new ArrayList<ShopTo>());
        }
        String city = address.getCity();

        QueryWrapper<ProductServiceShopAddressEntity> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("city",city);
        List<ProductServiceShopAddressEntity> addressList = addressService.list(wrapper2);

        List<ShopTo> shops = addressList.stream()
                .map(addr -> {
                    ShopTo shop = new ShopTo();

                    Long addrId = addr.getAddressId();

                    QueryWrapper<ProductServiceShopInfoEntity> wrapper3 = new QueryWrapper<>();
                    wrapper3.eq("address_id",addrId);
                    ProductServiceShopInfoEntity info = infoService.getOne(wrapper3);

                    Long supportId = info.getSupportId();
                    QueryWrapper<ProductServiceSupportEntity> wrapper4 = new QueryWrapper<>();
                    wrapper4.eq("support_id",supportId);
                    ProductServiceSupportEntity support = supportService.getOne(wrapper4);

                    Long activityId = info.getActivityId();
                    QueryWrapper<ProductServiceActivityEntity> wrapper5 = new QueryWrapper<>();
                    wrapper5.eq("activity_id",activityId);
                    ProductServiceActivityEntity activity = activityService.getOne(wrapper5);

                    shop.setActivity(activity);
                    shop.setAddress(addr);
                    shop.setInfo(info);
                    shop.setSupport(support);

                    return shop;
                }).collect(Collectors.toList());

        return R.ok().put("shops",shops);
    }

    @GetMapping("/shops/flavor")
    public R getSearchShops(@RequestParam String flavor){
        QueryWrapper<ProductServiceShopFoodEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("flavor",flavor);
        List<ProductServiceShopFoodEntity> foodList = foodService.list(wrapper1);

        if(foodList.size() == 0){
            return R.ok().put("searchShops",new ArrayList<ShopTo>());
        }

        List<ShopTo> searchShops = foodList.stream()
                .map(food -> {
                    ShopTo shop = new ShopTo();

                    Long shopId = food.getShopId();

                    QueryWrapper<ProductServiceShopInfoEntity> wrapper2 = new QueryWrapper<>();
                    wrapper2.eq("shop_id",shopId);
                    ProductServiceShopInfoEntity info = infoService.getOne(wrapper2);

                    Long addressId = info.getAddressId();
                    QueryWrapper<ProductServiceShopAddressEntity> wrapper3 = new QueryWrapper<>();
                    wrapper3.eq("address_id",addressId);
                    ProductServiceShopAddressEntity address = addressService.getOne(wrapper3);

                    Long supportId = info.getSupportId();
                    QueryWrapper<ProductServiceSupportEntity> wrapper4 = new QueryWrapper<>();
                    wrapper4.eq("support_id",supportId);
                    ProductServiceSupportEntity support = supportService.getOne(wrapper4);


                    Long activityId = info.getActivityId();
                    QueryWrapper<ProductServiceActivityEntity> wrapper5 = new QueryWrapper<>();
                    wrapper5.eq("activity_id",activityId);
                    ProductServiceActivityEntity activity = activityService.getOne(wrapper5);

                    shop.setSupport(support);
                    shop.setAddress(address);
                    shop.setActivity(activity);
                    shop.setInfo(info);

                    return shop;
                }).collect(Collectors.toList());

        return R.ok().put("searchShops",searchShops);
    }

    @GetMapping("/info/{shop_id}")
    public R getShopInfo(@PathVariable Long shop_id){
        ShopTo shop = new ShopTo();

        QueryWrapper<ProductServiceShopInfoEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("shop_id",shop_id);
        ProductServiceShopInfoEntity info = infoService.getOne(wrapper1);

        if(info == null){
            return R.ok().put("info",new ShopTo());
        }

        Long supportId = info.getSupportId();
        QueryWrapper<ProductServiceSupportEntity> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("support_id",supportId);
        ProductServiceSupportEntity support = supportService.getOne(wrapper2);

        Long activityId = info.getActivityId();
        QueryWrapper<ProductServiceActivityEntity> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("activity_id",activityId);
        ProductServiceActivityEntity activity = activityService.getOne(wrapper3);

        Long addressId = info.getAddressId();
        QueryWrapper<ProductServiceShopAddressEntity> wrapper4 = new QueryWrapper<>();
        wrapper4.eq("address_id",addressId);
        ProductServiceShopAddressEntity address = addressService.getOne(wrapper4);

        shop.setSupport(support);
        shop.setAddress(address);
        shop.setActivity(activity);
        shop.setInfo(info);

        return R.ok().put("info",shop);
    }

    @GetMapping("/goods/{shop_id}")
    public R getShopGoods(@PathVariable Long shop_id){
        QueryWrapper<ProductServiceShopFoodEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("shop_id",shop_id);
        List<ProductServiceShopFoodEntity> foodList = foodService.list(wrapper1);

        if(foodList.size() == 0){
            return R.ok().put("goods",new ArrayList<FoodTo>());
        }

        List<FoodTo> goods = foodList.stream()
                .map(food -> {
                    FoodTo good = new FoodTo();

                    Long typeId = food.getTypeId();
                    QueryWrapper<ProductServiceFoodTypeEntity> wrapper2 = new QueryWrapper<>();
                    wrapper2.eq("type_id",typeId);
                    ProductServiceFoodTypeEntity foodType = foodTypeService.getOne(wrapper2);

                    good.setFood(food);
                    good.setFoodType(foodType);

                    return good;
                }).collect(Collectors.toList());

        return R.ok().put("goods",goods);
    }
}
