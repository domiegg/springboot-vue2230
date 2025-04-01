package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GenghuansusheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GenghuansusheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GenghuansusheView;


/**
 * 更换宿舍
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface GenghuansusheService extends IService<GenghuansusheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GenghuansusheVO> selectListVO(Wrapper<GenghuansusheEntity> wrapper);
   	
   	GenghuansusheVO selectVO(@Param("ew") Wrapper<GenghuansusheEntity> wrapper);
   	
   	List<GenghuansusheView> selectListView(Wrapper<GenghuansusheEntity> wrapper);
   	
   	GenghuansusheView selectView(@Param("ew") Wrapper<GenghuansusheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GenghuansusheEntity> wrapper);
   	

}

