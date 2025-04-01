package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SusheweishengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SusheweishengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SusheweishengView;


/**
 * 宿舍卫生
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface SusheweishengService extends IService<SusheweishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SusheweishengVO> selectListVO(Wrapper<SusheweishengEntity> wrapper);
   	
   	SusheweishengVO selectVO(@Param("ew") Wrapper<SusheweishengEntity> wrapper);
   	
   	List<SusheweishengView> selectListView(Wrapper<SusheweishengEntity> wrapper);
   	
   	SusheweishengView selectView(@Param("ew") Wrapper<SusheweishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SusheweishengEntity> wrapper);
   	

}

