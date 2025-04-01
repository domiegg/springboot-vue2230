package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeijidengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeijidengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeijidengjiView;


/**
 * 违纪登记
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface WeijidengjiService extends IService<WeijidengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeijidengjiVO> selectListVO(Wrapper<WeijidengjiEntity> wrapper);
   	
   	WeijidengjiVO selectVO(@Param("ew") Wrapper<WeijidengjiEntity> wrapper);
   	
   	List<WeijidengjiView> selectListView(Wrapper<WeijidengjiEntity> wrapper);
   	
   	WeijidengjiView selectView(@Param("ew") Wrapper<WeijidengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeijidengjiEntity> wrapper);
   	

}

