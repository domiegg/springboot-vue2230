package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyueshiyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyueshiyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyueshiyongView;


/**
 * 预约使用
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface YuyueshiyongService extends IService<YuyueshiyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyueshiyongVO> selectListVO(Wrapper<YuyueshiyongEntity> wrapper);
   	
   	YuyueshiyongVO selectVO(@Param("ew") Wrapper<YuyueshiyongEntity> wrapper);
   	
   	List<YuyueshiyongView> selectListView(Wrapper<YuyueshiyongEntity> wrapper);
   	
   	YuyueshiyongView selectView(@Param("ew") Wrapper<YuyueshiyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyueshiyongEntity> wrapper);
   	

}

