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
 * 更换宿舍
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@TableName("genghuansushe")
public class GenghuansusheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GenghuansusheEntity() {
		
	}
	
	public GenghuansusheEntity(T t) {
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
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 原宿舍号
	 */
					
	private String yuansushehao;
	
	/**
	 * 新宿舍号
	 */
					
	private String xinsushehao;
	
	/**
	 * 更换日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date genghuanriqi;
	
	/**
	 * 更换原因
	 */
					
	private String genghuanyuanyin;
	
	/**
	 * 宿管账号
	 */
					
	private String suguanzhanghao;
	
	/**
	 * 宿管姓名
	 */
					
	private String suguanxingming;
	
	
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
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：原宿舍号
	 */
	public void setYuansushehao(String yuansushehao) {
		this.yuansushehao = yuansushehao;
	}
	/**
	 * 获取：原宿舍号
	 */
	public String getYuansushehao() {
		return yuansushehao;
	}
	/**
	 * 设置：新宿舍号
	 */
	public void setXinsushehao(String xinsushehao) {
		this.xinsushehao = xinsushehao;
	}
	/**
	 * 获取：新宿舍号
	 */
	public String getXinsushehao() {
		return xinsushehao;
	}
	/**
	 * 设置：更换日期
	 */
	public void setGenghuanriqi(Date genghuanriqi) {
		this.genghuanriqi = genghuanriqi;
	}
	/**
	 * 获取：更换日期
	 */
	public Date getGenghuanriqi() {
		return genghuanriqi;
	}
	/**
	 * 设置：更换原因
	 */
	public void setGenghuanyuanyin(String genghuanyuanyin) {
		this.genghuanyuanyin = genghuanyuanyin;
	}
	/**
	 * 获取：更换原因
	 */
	public String getGenghuanyuanyin() {
		return genghuanyuanyin;
	}
	/**
	 * 设置：宿管账号
	 */
	public void setSuguanzhanghao(String suguanzhanghao) {
		this.suguanzhanghao = suguanzhanghao;
	}
	/**
	 * 获取：宿管账号
	 */
	public String getSuguanzhanghao() {
		return suguanzhanghao;
	}
	/**
	 * 设置：宿管姓名
	 */
	public void setSuguanxingming(String suguanxingming) {
		this.suguanxingming = suguanxingming;
	}
	/**
	 * 获取：宿管姓名
	 */
	public String getSuguanxingming() {
		return suguanxingming;
	}

}
