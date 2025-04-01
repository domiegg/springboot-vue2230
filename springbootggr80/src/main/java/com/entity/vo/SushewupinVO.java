package com.entity.vo;

import com.entity.SushewupinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 宿舍物品
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public class SushewupinVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 物品类别
	 */
	
	private String wupinleibie;
		
	/**
	 * 物品所属
	 */
	
	private String wupinsuoshu;
		
	/**
	 * 所处位置
	 */
	
	private String suochuweizhi;
		
	/**
	 * 物品数量
	 */
	
	private Integer wupinshuliang;
		
	/**
	 * 当前状态
	 */
	
	private String dangqianzhuangtai;
		
	/**
	 * 使用状态
	 */
	
	private String shiyongzhuangtai;
		
	/**
	 * 当前使用人
	 */
	
	private String dangqianshiyongren;
		
	/**
	 * 使用人宿舍号
	 */
	
	private String shiyongrensushehao;
		
	/**
	 * 楼栋号
	 */
	
	private String loudonghao;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		
	/**
	 * 物品简介
	 */
	
	private String wupinjianjie;
		
	/**
	 * 宿管账号
	 */
	
	private String suguanzhanghao;
		
	/**
	 * 宿管姓名
	 */
	
	private String suguanxingming;
				
	
	/**
	 * 设置：物品类别
	 */
	 
	public void setWupinleibie(String wupinleibie) {
		this.wupinleibie = wupinleibie;
	}
	
	/**
	 * 获取：物品类别
	 */
	public String getWupinleibie() {
		return wupinleibie;
	}
				
	
	/**
	 * 设置：物品所属
	 */
	 
	public void setWupinsuoshu(String wupinsuoshu) {
		this.wupinsuoshu = wupinsuoshu;
	}
	
	/**
	 * 获取：物品所属
	 */
	public String getWupinsuoshu() {
		return wupinsuoshu;
	}
				
	
	/**
	 * 设置：所处位置
	 */
	 
	public void setSuochuweizhi(String suochuweizhi) {
		this.suochuweizhi = suochuweizhi;
	}
	
	/**
	 * 获取：所处位置
	 */
	public String getSuochuweizhi() {
		return suochuweizhi;
	}
				
	
	/**
	 * 设置：物品数量
	 */
	 
	public void setWupinshuliang(Integer wupinshuliang) {
		this.wupinshuliang = wupinshuliang;
	}
	
	/**
	 * 获取：物品数量
	 */
	public Integer getWupinshuliang() {
		return wupinshuliang;
	}
				
	
	/**
	 * 设置：当前状态
	 */
	 
	public void setDangqianzhuangtai(String dangqianzhuangtai) {
		this.dangqianzhuangtai = dangqianzhuangtai;
	}
	
	/**
	 * 获取：当前状态
	 */
	public String getDangqianzhuangtai() {
		return dangqianzhuangtai;
	}
				
	
	/**
	 * 设置：使用状态
	 */
	 
	public void setShiyongzhuangtai(String shiyongzhuangtai) {
		this.shiyongzhuangtai = shiyongzhuangtai;
	}
	
	/**
	 * 获取：使用状态
	 */
	public String getShiyongzhuangtai() {
		return shiyongzhuangtai;
	}
				
	
	/**
	 * 设置：当前使用人
	 */
	 
	public void setDangqianshiyongren(String dangqianshiyongren) {
		this.dangqianshiyongren = dangqianshiyongren;
	}
	
	/**
	 * 获取：当前使用人
	 */
	public String getDangqianshiyongren() {
		return dangqianshiyongren;
	}
				
	
	/**
	 * 设置：使用人宿舍号
	 */
	 
	public void setShiyongrensushehao(String shiyongrensushehao) {
		this.shiyongrensushehao = shiyongrensushehao;
	}
	
	/**
	 * 获取：使用人宿舍号
	 */
	public String getShiyongrensushehao() {
		return shiyongrensushehao;
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
	 * 设置：物品简介
	 */
	 
	public void setWupinjianjie(String wupinjianjie) {
		this.wupinjianjie = wupinjianjie;
	}
	
	/**
	 * 获取：物品简介
	 */
	public String getWupinjianjie() {
		return wupinjianjie;
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
