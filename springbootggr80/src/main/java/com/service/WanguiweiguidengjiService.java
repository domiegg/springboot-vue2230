package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WanguiweiguidengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WanguiweiguidengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WanguiweiguidengjiView;


/**
 * 晚归未归登记
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface WanguiweiguidengjiService extends IService<WanguiweiguidengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WanguiweiguidengjiVO> selectListVO(Wrapper<WanguiweiguidengjiEntity> wrapper);
   	
   	WanguiweiguidengjiVO selectVO(@Param("ew") Wrapper<WanguiweiguidengjiEntity> wrapper);
   	
   	List<WanguiweiguidengjiView> selectListView(Wrapper<WanguiweiguidengjiEntity> wrapper);
   	
   	WanguiweiguidengjiView selectView(@Param("ew") Wrapper<WanguiweiguidengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WanguiweiguidengjiEntity> wrapper);
   	

}

