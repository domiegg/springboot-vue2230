package com.entity.view;

import com.entity.WailairenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 外来人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@TableName("wailairenyuan")
public class WailairenyuanView  extends WailairenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WailairenyuanView(){
	}
 
 	public WailairenyuanView(WailairenyuanEntity wailairenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, wailairenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
