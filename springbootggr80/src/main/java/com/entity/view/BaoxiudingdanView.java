package com.entity.view;

import com.entity.BaoxiudingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 报修订单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@TableName("baoxiudingdan")
public class BaoxiudingdanView  extends BaoxiudingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaoxiudingdanView(){
	}
 
 	public BaoxiudingdanView(BaoxiudingdanEntity baoxiudingdanEntity){
 	try {
			BeanUtils.copyProperties(this, baoxiudingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
