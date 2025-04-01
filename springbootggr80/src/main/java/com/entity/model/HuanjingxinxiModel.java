package com.entity.model;

import com.entity.HuanjingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 环境信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public class HuanjingxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
