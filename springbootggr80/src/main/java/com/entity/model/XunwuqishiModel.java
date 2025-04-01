package com.entity.model;

import com.entity.XunwuqishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 寻物启事
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public class XunwuqishiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 物品名称
	 */
	
	private String wupinmingcheng;
		
	/**
	 * 物品图片
	 */
	
	private String wupintupian;
		
	/**
	 * 丢失地点
	 */
	
	private String diushididian;
		
	/**
	 * 丢失时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date diushishijian;
		
	/**
	 * 详细描述
	 */
	
	private String xiangximiaoshu;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
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
	 * 设置：丢失地点
	 */
	 
	public void setDiushididian(String diushididian) {
		this.diushididian = diushididian;
	}
	
	/**
	 * 获取：丢失地点
	 */
	public String getDiushididian() {
		return diushididian;
	}
				
	
	/**
	 * 设置：丢失时间
	 */
	 
	public void setDiushishijian(Date diushishijian) {
		this.diushishijian = diushishijian;
	}
	
	/**
	 * 获取：丢失时间
	 */
	public Date getDiushishijian() {
		return diushishijian;
	}
				
	
	/**
	 * 设置：详细描述
	 */
	 
	public void setXiangximiaoshu(String xiangximiaoshu) {
		this.xiangximiaoshu = xiangximiaoshu;
	}
	
	/**
	 * 获取：详细描述
	 */
	public String getXiangximiaoshu() {
		return xiangximiaoshu;
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
