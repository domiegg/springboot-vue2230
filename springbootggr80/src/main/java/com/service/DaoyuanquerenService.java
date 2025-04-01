package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaoyuanquerenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaoyuanquerenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaoyuanquerenView;


/**
 * 导员确认
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface DaoyuanquerenService extends IService<DaoyuanquerenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoyuanquerenVO> selectListVO(Wrapper<DaoyuanquerenEntity> wrapper);
   	
   	DaoyuanquerenVO selectVO(@Param("ew") Wrapper<DaoyuanquerenEntity> wrapper);
   	
   	List<DaoyuanquerenView> selectListView(Wrapper<DaoyuanquerenEntity> wrapper);
   	
   	DaoyuanquerenView selectView(@Param("ew") Wrapper<DaoyuanquerenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoyuanquerenEntity> wrapper);
   	

}

