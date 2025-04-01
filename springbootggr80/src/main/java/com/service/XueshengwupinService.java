package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengwupinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengwupinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengwupinView;


/**
 * 学生物品
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface XueshengwupinService extends IService<XueshengwupinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengwupinVO> selectListVO(Wrapper<XueshengwupinEntity> wrapper);
   	
   	XueshengwupinVO selectVO(@Param("ew") Wrapper<XueshengwupinEntity> wrapper);
   	
   	List<XueshengwupinView> selectListView(Wrapper<XueshengwupinEntity> wrapper);
   	
   	XueshengwupinView selectView(@Param("ew") Wrapper<XueshengwupinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengwupinEntity> wrapper);
   	

}

