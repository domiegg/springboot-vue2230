package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 维修人员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@TableName("weixiurenyuan")
public class WeixiurenyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WeixiurenyuanEntity() {
		
	}
	
	public WeixiurenyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 维修账号
	 */
					
	private String weixiuzhanghao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 维修姓名
	 */
					
	private String weixiuxingming;
	
	/**
	 * 年龄
	 */
					
	private Integer nianling;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：维修账号
	 */
	public void setWeixiuzhanghao(String weixiuzhanghao) {
		this.weixiuzhanghao = weixiuzhanghao;
	}
	/**
	 * 获取：维修账号
	 */
	public String getWeixiuzhanghao() {
		return weixiuzhanghao;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：维修姓名
	 */
	public void setWeixiuxingming(String weixiuxingming) {
		this.weixiuxingming = weixiuxingming;
	}
	/**
	 * 获取：维修姓名
	 */
	public String getWeixiuxingming() {
		return weixiuxingming;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getNianling() {
		return nianling;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}

}
