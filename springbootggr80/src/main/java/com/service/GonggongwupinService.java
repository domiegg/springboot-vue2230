package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GonggongwupinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GonggongwupinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GonggongwupinView;


/**
 * 公共物品
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface GonggongwupinService extends IService<GonggongwupinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GonggongwupinVO> selectListVO(Wrapper<GonggongwupinEntity> wrapper);
   	
   	GonggongwupinVO selectVO(@Param("ew") Wrapper<GonggongwupinEntity> wrapper);
   	
   	List<GonggongwupinView> selectListView(Wrapper<GonggongwupinEntity> wrapper);
   	
   	GonggongwupinView selectView(@Param("ew") Wrapper<GonggongwupinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GonggongwupinEntity> wrapper);
   	

}

