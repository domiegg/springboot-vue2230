package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WailairenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WailairenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WailairenyuanView;


/**
 * 外来人员
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface WailairenyuanService extends IService<WailairenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WailairenyuanVO> selectListVO(Wrapper<WailairenyuanEntity> wrapper);
   	
   	WailairenyuanVO selectVO(@Param("ew") Wrapper<WailairenyuanEntity> wrapper);
   	
   	List<WailairenyuanView> selectListView(Wrapper<WailairenyuanEntity> wrapper);
   	
   	WailairenyuanView selectView(@Param("ew") Wrapper<WailairenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WailairenyuanEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<WailairenyuanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<WailairenyuanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<WailairenyuanEntity> wrapper);



}

