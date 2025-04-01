package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShuidianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShuidianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuidianxinxiView;


/**
 * 水电信息
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface ShuidianxinxiService extends IService<ShuidianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShuidianxinxiVO> selectListVO(Wrapper<ShuidianxinxiEntity> wrapper);
   	
   	ShuidianxinxiVO selectVO(@Param("ew") Wrapper<ShuidianxinxiEntity> wrapper);
   	
   	List<ShuidianxinxiView> selectListView(Wrapper<ShuidianxinxiEntity> wrapper);
   	
   	ShuidianxinxiView selectView(@Param("ew") Wrapper<ShuidianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShuidianxinxiEntity> wrapper);
   	

}

