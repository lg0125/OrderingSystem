package com.chris.orderingsystem.accountservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-07-10 02:34:28
 */
@Data
@TableName("account_service_user_address")
public class AccountServiceUserAddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private BigDecimal latitude;
	/**
	 * 
	 */
	private BigDecimal longitude;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Long addressId;

}
