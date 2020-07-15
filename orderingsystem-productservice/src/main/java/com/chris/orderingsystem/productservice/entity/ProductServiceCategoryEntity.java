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
 * @date 2020-07-10 02:28:52
 */
@Data
@TableName("product_service_category")
public class ProductServiceCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long categoryId;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String link;
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
