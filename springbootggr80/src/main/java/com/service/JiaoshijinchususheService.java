package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaoshijinchususheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaoshijinchususheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoshijinchususheView;


/**
 * 教师进出宿舍
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface JiaoshijinchususheService extends IService<JiaoshijinchususheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoshijinchususheVO> selectListVO(Wrapper<JiaoshijinchususheEntity> wrapper);
   	
   	JiaoshijinchususheVO selectVO(@Param("ew") Wrapper<JiaoshijinchususheEntity> wrapper);
   	
   	List<JiaoshijinchususheView> selectListView(Wrapper<JiaoshijinchususheEntity> wrapper);
   	
   	JiaoshijinchususheView selectView(@Param("ew") Wrapper<JiaoshijinchususheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoshijinchususheEntity> wrapper);
   	

}

