package com.entity.view;

import com.entity.XueshengjinchususheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学生进出宿舍
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@TableName("xueshengjinchusushe")
public class XueshengjinchususheView  extends XueshengjinchususheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueshengjinchususheView(){
	}
 
 	public XueshengjinchususheView(XueshengjinchususheEntity xueshengjinchususheEntity){
 	try {
			BeanUtils.copyProperties(this, xueshengjinchususheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
