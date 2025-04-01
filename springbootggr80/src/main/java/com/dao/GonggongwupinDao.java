package com.dao;

import com.entity.GonggongwupinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GonggongwupinVO;
import com.entity.view.GonggongwupinView;


/**
 * 公共物品
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface GonggongwupinDao extends BaseMapper<GonggongwupinEntity> {
	
	List<GonggongwupinVO> selectListVO(@Param("ew") Wrapper<GonggongwupinEntity> wrapper);
	
	GonggongwupinVO selectVO(@Param("ew") Wrapper<GonggongwupinEntity> wrapper);
	
	List<GonggongwupinView> selectListView(@Param("ew") Wrapper<GonggongwupinEntity> wrapper);

	List<GonggongwupinView> selectListView(Pagination page,@Param("ew") Wrapper<GonggongwupinEntity> wrapper);
	
	GonggongwupinView selectView(@Param("ew") Wrapper<GonggongwupinEntity> wrapper);
	

}
