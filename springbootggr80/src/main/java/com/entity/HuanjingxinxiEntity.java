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
 * 环境信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@TableName("huanjingxinxi")
public class HuanjingxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuanjingxinxiEntity() {
		
	}
	
	public HuanjingxinxiEntity(T t) {
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
	 * 楼栋号
	 */
					
	private String loudonghao;
	
	/**
	 * 楼道
	 */
					
	private String loudao;
	
	/**
	 * 宿舍号
	 */
					
	private String sushehao;
	
	/**
	 * 湿度
	 */
					
	private Double shidu;
	
	/**
	 * 温度
	 */
					
	private Double wendu;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	/**
	 * 详情
	 */
					
	private String xiangqing;
	
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
	 * 设置：楼栋号
	 */
	public void setLoudonghao(String loudonghao) {
		this.loudonghao = loudonghao;
	}
	/**
	 * 获取：楼栋号
	 */
	public String getLoudonghao() {
		return loudonghao;
	}
	/**
	 * 设置：楼道
	 */
	public void setLoudao(String loudao) {
		this.loudao = loudao;
	}
	/**
	 * 获取：楼道
	 */
	public String getLoudao() {
		return loudao;
	}
	/**
	 * 设置：宿舍号
	 */
	public void setSushehao(String sushehao) {
		this.sushehao = sushehao;
	}
	/**
	 * 获取：宿舍号
	 */
	public String getSushehao() {
		return sushehao;
	}
	/**
	 * 设置：湿度
	 */
	public void setShidu(Double shidu) {
		this.shidu = shidu;
	}
	/**
	 * 获取：湿度
	 */
	public Double getShidu() {
		return shidu;
	}
	/**
	 * 设置：温度
	 */
	public void setWendu(Double wendu) {
		this.wendu = wendu;
	}
	/**
	 * 获取：温度
	 */
	public Double getWendu() {
		return wendu;
	}
	/**
	 * 设置：登记日期
	 */
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
	/**
	 * 设置：详情
	 */
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
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
