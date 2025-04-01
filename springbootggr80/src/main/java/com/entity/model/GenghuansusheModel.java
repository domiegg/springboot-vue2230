package com.entity.model;

import com.entity.GenghuansusheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 更换宿舍
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public class GenghuansusheModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
