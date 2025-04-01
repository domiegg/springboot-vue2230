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
 * 公共物品
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@TableName("gonggongwupin")
public class GonggongwupinEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GonggongwupinEntity() {
		
	}
	
	public GonggongwupinEntity(T t) {
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
	 * 物品名称
	 */
					
	private String wupinmingcheng;
	
	/**
	 * 物品分类
	 */
					
	private String wupinfenlei;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	/**
	 * 使用说明
	 */
					
	private String shiyongshuoming;
	
	/**
	 * 物品详情
	 */
					
	private String wupinxiangqing;
	
	/**
	 * 宿管账号
	 */
					
	private String suguanzhanghao;
	
	/**
	 * 宿管姓名
	 */
					
	private String suguanxingming;
	
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
	 * 设置：物品分类
	 */
	public void setWupinfenlei(String wupinfenlei) {
		this.wupinfenlei = wupinfenlei;
	}
	/**
	 * 获取：物品分类
	 */
	public String getWupinfenlei() {
		return wupinfenlei;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：规格
	 */
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
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
	 * 设置：使用说明
	 */
	public void setShiyongshuoming(String shiyongshuoming) {
		this.shiyongshuoming = shiyongshuoming;
	}
	/**
	 * 获取：使用说明
	 */
	public String getShiyongshuoming() {
		return shiyongshuoming;
	}
	/**
	 * 设置：物品详情
	 */
	public void setWupinxiangqing(String wupinxiangqing) {
		this.wupinxiangqing = wupinxiangqing;
	}
	/**
	 * 获取：物品详情
	 */
	public String getWupinxiangqing() {
		return wupinxiangqing;
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
