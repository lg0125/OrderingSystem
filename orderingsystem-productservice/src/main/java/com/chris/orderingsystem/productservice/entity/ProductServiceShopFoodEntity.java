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
@TableName("product_service_shop_food")
public class ProductServiceShopFoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String foodName;
	/**
	 * 
	 */
	private Integer foodPrice;
	/**
	 * 
	 */
	private Long foodNum;
	/**
	 * 
	 */
	private Long typeId;
	/**
	 * 
	 */
	private String flavor;
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
	/**
	 * 
	 */
	private Long shopId;
	/**
	 * 
	 */
	private Long foodId;
	/**
	 * 
	 */
	private Integer version;
	/**
	 * 
	 */
	private String imageUrl;

}
