package com.dao;

import com.entity.ShenqingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenqingxinxiVO;
import com.entity.view.ShenqingxinxiView;


/**
 * 申请信息
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface ShenqingxinxiDao extends BaseMapper<ShenqingxinxiEntity> {
	
	List<ShenqingxinxiVO> selectListVO(@Param("ew") Wrapper<ShenqingxinxiEntity> wrapper);
	
	ShenqingxinxiVO selectVO(@Param("ew") Wrapper<ShenqingxinxiEntity> wrapper);
	
	List<ShenqingxinxiView> selectListView(@Param("ew") Wrapper<ShenqingxinxiEntity> wrapper);

	List<ShenqingxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingxinxiEntity> wrapper);
	
	ShenqingxinxiView selectView(@Param("ew") Wrapper<ShenqingxinxiEntity> wrapper);
	

}
