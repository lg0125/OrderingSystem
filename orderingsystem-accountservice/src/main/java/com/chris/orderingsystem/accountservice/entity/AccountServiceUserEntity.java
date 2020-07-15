package com.chris.orderingsystem.accountservice.entity;

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
 * @date 2020-07-10 02:34:28
 */
@Data
@TableName("account_service_user")
public class AccountServiceUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long userPassword;
	/**
	 * 
	 */
	private String nickName;
	/**
	 * 
	 */
	private String gender;
	/**
	 * 
	 */
	private Long telephone;
	/**
	 * 
	 */
	private Date registerDate;
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
	private Long addressId;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private Long cardId;

}
