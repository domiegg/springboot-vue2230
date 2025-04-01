package com.dao;

import com.entity.XueshengwupinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengwupinVO;
import com.entity.view.XueshengwupinView;


/**
 * 学生物品
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface XueshengwupinDao extends BaseMapper<XueshengwupinEntity> {
	
	List<XueshengwupinVO> selectListVO(@Param("ew") Wrapper<XueshengwupinEntity> wrapper);
	
	XueshengwupinVO selectVO(@Param("ew") Wrapper<XueshengwupinEntity> wrapper);
	
	List<XueshengwupinView> selectListView(@Param("ew") Wrapper<XueshengwupinEntity> wrapper);

	List<XueshengwupinView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengwupinEntity> wrapper);
	
	XueshengwupinView selectView(@Param("ew") Wrapper<XueshengwupinEntity> wrapper);
	

}
