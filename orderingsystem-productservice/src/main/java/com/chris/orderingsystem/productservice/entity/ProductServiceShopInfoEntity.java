package com.chris.orderingsystem.productservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:28:53
 */
@Data
@TableName("product_service_shop_info")
public class ProductServiceShopInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long shopId;
	/**
	 * 
	 */
	private Long addressId;
	/**
	 * 
	 */
	private Long phone;
	/**
	 * 
	 */
	private Long supportId;
	/**
	 * 
	 */
	private Integer sellNum;
	/**
	 * 
	 */
	private Integer minPrice;
	/**
	 * 
	 */
	private Integer deliveryPrice;
	/**
	 * 
	 */
	private Integer distance;
	/**
	 * 
	 */
	private Long activityId;
	/**
	 * 
	 */
	private String imageUrl;
	/**
	 * 
	 */
	private Integer version;
	/**
	 * 
	 */
	private Integer deleted;
	/**
	 * 
	 */
	private Date gmtCreate;
	/**
	 * 
	 */
	private Date gmtModified;

}
