package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KoulingmaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KoulingmaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KoulingmaView;


/**
 * 口令码
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface KoulingmaService extends IService<KoulingmaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KoulingmaVO> selectListVO(Wrapper<KoulingmaEntity> wrapper);
   	
   	KoulingmaVO selectVO(@Param("ew") Wrapper<KoulingmaEntity> wrapper);
   	
   	List<KoulingmaView> selectListView(Wrapper<KoulingmaEntity> wrapper);
   	
   	KoulingmaView selectView(@Param("ew") Wrapper<KoulingmaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KoulingmaEntity> wrapper);
   	

}

