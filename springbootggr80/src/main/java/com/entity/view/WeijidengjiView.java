package com.entity.view;

import com.entity.WeijidengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 违纪登记
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@TableName("weijidengji")
public class WeijidengjiView  extends WeijidengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeijidengjiView(){
	}
 
 	public WeijidengjiView(WeijidengjiEntity weijidengjiEntity){
 	try {
			BeanUtils.copyProperties(this, weijidengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
