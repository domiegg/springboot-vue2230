package com.entity.model;

import com.entity.PaixingbangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 排行榜
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public class PaixingbangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
