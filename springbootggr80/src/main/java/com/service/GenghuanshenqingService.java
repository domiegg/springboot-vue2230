package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GenghuanshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GenghuanshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GenghuanshenqingView;


/**
 * 更换申请
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface GenghuanshenqingService extends IService<GenghuanshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GenghuanshenqingVO> selectListVO(Wrapper<GenghuanshenqingEntity> wrapper);
   	
   	GenghuanshenqingVO selectVO(@Param("ew") Wrapper<GenghuanshenqingEntity> wrapper);
   	
   	List<GenghuanshenqingView> selectListView(Wrapper<GenghuanshenqingEntity> wrapper);
   	
   	GenghuanshenqingView selectView(@Param("ew") Wrapper<GenghuanshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GenghuanshenqingEntity> wrapper);
   	

}

