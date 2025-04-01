package com.dao;

import com.entity.WailairenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WailairenyuanVO;
import com.entity.view.WailairenyuanView;


/**
 * 外来人员
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface WailairenyuanDao extends BaseMapper<WailairenyuanEntity> {
	
	List<WailairenyuanVO> selectListVO(@Param("ew") Wrapper<WailairenyuanEntity> wrapper);
	
	WailairenyuanVO selectVO(@Param("ew") Wrapper<WailairenyuanEntity> wrapper);
	
	List<WailairenyuanView> selectListView(@Param("ew") Wrapper<WailairenyuanEntity> wrapper);

	List<WailairenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<WailairenyuanEntity> wrapper);
	
	WailairenyuanView selectView(@Param("ew") Wrapper<WailairenyuanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WailairenyuanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WailairenyuanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WailairenyuanEntity> wrapper);



}
