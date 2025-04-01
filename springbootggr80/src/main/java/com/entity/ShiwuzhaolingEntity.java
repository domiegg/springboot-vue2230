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
 * 失物招领
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@TableName("shiwuzhaoling")
public class ShiwuzhaolingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShiwuzhaolingEntity() {
		
	}
	
	public ShiwuzhaolingEntity(T t) {
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
	 * 物品名称
	 */
					
	private String wupinmingcheng;
	
	/**
	 * 物品图片
	 */
					
	private String wupintupian;
	
	/**
	 * 拾得地址
	 */
					
	private String shidedizhi;
	
	/**
	 * 拾得时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shideshijian;
	
	/**
	 * 认领地址
	 */
					
	private String renlingdizhi;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 物品描述
	 */
					
	private String wupinmiaoshu;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 宿管账号
	 */
					
	private String suguanzhanghao;
	
	/**
	 * 宿管姓名
	 */
					
	private String suguanxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
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
	 * 设置：物品名称
	 */
	public void setWupinmingcheng(String wupinmingcheng) {
		this.wupinmingcheng = wupinmingcheng;
	}
	/**
	 * 获取：物品名称
	 */
	public String getWupinmingcheng() {
		return wupinmingcheng;
	}
	/**
	 * 设置：物品图片
	 */
	public void setWupintupian(String wupintupian) {
		this.wupintupian = wupintupian;
	}
	/**
	 * 获取：物品图片
	 */
	public String getWupintupian() {
		return wupintupian;
	}
	/**
	 * 设置：拾得地址
	 */
	public void setShidedizhi(String shidedizhi) {
		this.shidedizhi = shidedizhi;
	}
	/**
	 * 获取：拾得地址
	 */
	public String getShidedizhi() {
		return shidedizhi;
	}
	/**
	 * 设置：拾得时间
	 */
	public void setShideshijian(Date shideshijian) {
		this.shideshijian = shideshijian;
	}
	/**
	 * 获取：拾得时间
	 */
	public Date getShideshijian() {
		return shideshijian;
	}
	/**
	 * 设置：认领地址
	 */
	public void setRenlingdizhi(String renlingdizhi) {
		this.renlingdizhi = renlingdizhi;
	}
	/**
	 * 获取：认领地址
	 */
	public String getRenlingdizhi() {
		return renlingdizhi;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：物品描述
	 */
	public void setWupinmiaoshu(String wupinmiaoshu) {
		this.wupinmiaoshu = wupinmiaoshu;
	}
	/**
	 * 获取：物品描述
	 */
	public String getWupinmiaoshu() {
		return wupinmiaoshu;
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
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
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
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
