package com.dao;

import com.entity.GenghuansusheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GenghuansusheVO;
import com.entity.view.GenghuansusheView;


/**
 * 更换宿舍
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface GenghuansusheDao extends BaseMapper<GenghuansusheEntity> {
	
	List<GenghuansusheVO> selectListVO(@Param("ew") Wrapper<GenghuansusheEntity> wrapper);
	
	GenghuansusheVO selectVO(@Param("ew") Wrapper<GenghuansusheEntity> wrapper);
	
	List<GenghuansusheView> selectListView(@Param("ew") Wrapper<GenghuansusheEntity> wrapper);

	List<GenghuansusheView> selectListView(Pagination page,@Param("ew") Wrapper<GenghuansusheEntity> wrapper);
	
	GenghuansusheView selectView(@Param("ew") Wrapper<GenghuansusheEntity> wrapper);
	

}
