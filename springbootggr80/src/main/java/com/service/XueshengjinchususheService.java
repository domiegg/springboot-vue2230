package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengjinchususheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengjinchususheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengjinchususheView;


/**
 * 学生进出宿舍
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface XueshengjinchususheService extends IService<XueshengjinchususheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengjinchususheVO> selectListVO(Wrapper<XueshengjinchususheEntity> wrapper);
   	
   	XueshengjinchususheVO selectVO(@Param("ew") Wrapper<XueshengjinchususheEntity> wrapper);
   	
   	List<XueshengjinchususheView> selectListView(Wrapper<XueshengjinchususheEntity> wrapper);
   	
   	XueshengjinchususheView selectView(@Param("ew") Wrapper<XueshengjinchususheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengjinchususheEntity> wrapper);
   	

}

