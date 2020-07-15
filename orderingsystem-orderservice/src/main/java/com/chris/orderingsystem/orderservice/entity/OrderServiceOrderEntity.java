package com.chris.orderingsystem.orderservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @date 2020-07-10 02:31:17
 */
@Data
@TableName("order_service_order")
public class OrderServiceOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private Long orderId;
	/**
	 * 
	 */
	private Long userId;
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
	private Integer deleted;
	/**
	 * 
	 */
	private Integer payState;
	/**
	 * 
	 */
	private Integer finishState;
	/**
	 * 
	 */
	private Long shopId;
	/**
	 * 
	 */
	private Integer orderAccount;

	private Long orderIndex;
}
