package com.entity.vo;

import com.entity.BaoxiujiedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 报修接单
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public class BaoxiujiedanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 报修名称
	 */
	
	private String baoxiumingcheng;
		
	/**
	 * 问题简述
	 */
	
	private String wentijianshu;
		
	/**
	 * 安排时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date anpaishijian;
		
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
	 * 宿舍号
	 */
	
	private String sushehao;
		
	/**
	 * 维修账号
	 */
	
	private String weixiuzhanghao;
		
	/**
	 * 维修姓名
	 */
	
	private String weixiuxingming;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
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
	 * 设置：报修名称
	 */
	 
	public void setBaoxiumingcheng(String baoxiumingcheng) {
		this.baoxiumingcheng = baoxiumingcheng;
	}
	
	/**
	 * 获取：报修名称
	 */
	public String getBaoxiumingcheng() {
		return baoxiumingcheng;
	}
				
	
	/**
	 * 设置：问题简述
	 */
	 
	public void setWentijianshu(String wentijianshu) {
		this.wentijianshu = wentijianshu;
	}
	
	/**
	 * 获取：问题简述
	 */
	public String getWentijianshu() {
		return wentijianshu;
	}
				
	
	/**
	 * 设置：安排时间
	 */
	 
	public void setAnpaishijian(Date anpaishijian) {
		this.anpaishijian = anpaishijian;
	}
	
	/**
	 * 获取：安排时间
	 */
	public Date getAnpaishijian() {
		return anpaishijian;
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
			
}
