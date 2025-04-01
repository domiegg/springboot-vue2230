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
 * 排行榜
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@TableName("paixingbang")
public class PaixingbangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PaixingbangEntity() {
		
	}
	
	public PaixingbangEntity(T t) {
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
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 第一名
	 */
					
	private String diyiming;
	
	/**
	 * 第二名
	 */
					
	private String dierming;
	
	/**
	 * 第三名
	 */
					
	private String disanming;
	
	/**
	 * 第四名
	 */
					
	private String disiming;
	
	/**
	 * 第五名
	 */
					
	private String diwuming;
	
	/**
	 * 第六名
	 */
					
	private String diliuming;
	
	/**
	 * 第七名
	 */
					
	private String diqiming;
	
	/**
	 * 第八名
	 */
					
	private String dibaming;
	
	/**
	 * 第九名
	 */
					
	private String dijiuming;
	
	/**
	 * 第十名
	 */
					
	private String dishiming;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
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
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
	/**
	 * 设置：第一名
	 */
	public void setDiyiming(String diyiming) {
		this.diyiming = diyiming;
	}
	/**
	 * 获取：第一名
	 */
	public String getDiyiming() {
		return diyiming;
	}
	/**
	 * 设置：第二名
	 */
	public void setDierming(String dierming) {
		this.dierming = dierming;
	}
	/**
	 * 获取：第二名
	 */
	public String getDierming() {
		return dierming;
	}
	/**
	 * 设置：第三名
	 */
	public void setDisanming(String disanming) {
		this.disanming = disanming;
	}
	/**
	 * 获取：第三名
	 */
	public String getDisanming() {
		return disanming;
	}
	/**
	 * 设置：第四名
	 */
	public void setDisiming(String disiming) {
		this.disiming = disiming;
	}
	/**
	 * 获取：第四名
	 */
	public String getDisiming() {
		return disiming;
	}
	/**
	 * 设置：第五名
	 */
	public void setDiwuming(String diwuming) {
		this.diwuming = diwuming;
	}
	/**
	 * 获取：第五名
	 */
	public String getDiwuming() {
		return diwuming;
	}
	/**
	 * 设置：第六名
	 */
	public void setDiliuming(String diliuming) {
		this.diliuming = diliuming;
	}
	/**
	 * 获取：第六名
	 */
	public String getDiliuming() {
		return diliuming;
	}
	/**
	 * 设置：第七名
	 */
	public void setDiqiming(String diqiming) {
		this.diqiming = diqiming;
	}
	/**
	 * 获取：第七名
	 */
	public String getDiqiming() {
		return diqiming;
	}
	/**
	 * 设置：第八名
	 */
	public void setDibaming(String dibaming) {
		this.dibaming = dibaming;
	}
	/**
	 * 获取：第八名
	 */
	public String getDibaming() {
		return dibaming;
	}
	/**
	 * 设置：第九名
	 */
	public void setDijiuming(String dijiuming) {
		this.dijiuming = dijiuming;
	}
	/**
	 * 获取：第九名
	 */
	public String getDijiuming() {
		return dijiuming;
	}
	/**
	 * 设置：第十名
	 */
	public void setDishiming(String dishiming) {
		this.dishiming = dishiming;
	}
	/**
	 * 获取：第十名
	 */
	public String getDishiming() {
		return dishiming;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
