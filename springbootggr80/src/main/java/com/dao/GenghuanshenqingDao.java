package com.dao;

import com.entity.GenghuanshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GenghuanshenqingVO;
import com.entity.view.GenghuanshenqingView;


/**
 * 更换申请
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface GenghuanshenqingDao extends BaseMapper<GenghuanshenqingEntity> {
	
	List<GenghuanshenqingVO> selectListVO(@Param("ew") Wrapper<GenghuanshenqingEntity> wrapper);
	
	GenghuanshenqingVO selectVO(@Param("ew") Wrapper<GenghuanshenqingEntity> wrapper);
	
	List<GenghuanshenqingView> selectListView(@Param("ew") Wrapper<GenghuanshenqingEntity> wrapper);

	List<GenghuanshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<GenghuanshenqingEntity> wrapper);
	
	GenghuanshenqingView selectView(@Param("ew") Wrapper<GenghuanshenqingEntity> wrapper);
	

}
