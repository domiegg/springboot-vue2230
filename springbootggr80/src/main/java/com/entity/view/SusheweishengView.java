package com.entity.view;

import com.entity.SusheweishengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宿舍卫生
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@TableName("susheweisheng")
public class SusheweishengView  extends SusheweishengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SusheweishengView(){
	}
 
 	public SusheweishengView(SusheweishengEntity susheweishengEntity){
 	try {
			BeanUtils.copyProperties(this, susheweishengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
