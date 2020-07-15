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
@TableName("product_service_support")
public class ProductServiceSupportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long supportId;
	/**
	 * 
	 */
	private String supportName;
	/**
	 * 
	 */
	private String iconName;
	/**
	 * 
	 */
	private String description;
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
