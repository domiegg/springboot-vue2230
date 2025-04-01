package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuanjingxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuanjingxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuanjingxinxiView;


/**
 * 环境信息
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface HuanjingxinxiService extends IService<HuanjingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuanjingxinxiVO> selectListVO(Wrapper<HuanjingxinxiEntity> wrapper);
   	
   	HuanjingxinxiVO selectVO(@Param("ew") Wrapper<HuanjingxinxiEntity> wrapper);
   	
   	List<HuanjingxinxiView> selectListView(Wrapper<HuanjingxinxiEntity> wrapper);
   	
   	HuanjingxinxiView selectView(@Param("ew") Wrapper<HuanjingxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuanjingxinxiEntity> wrapper);
   	

}

