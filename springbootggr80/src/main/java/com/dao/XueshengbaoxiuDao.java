package com.dao;

import com.entity.XueshengbaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengbaoxiuVO;
import com.entity.view.XueshengbaoxiuView;


/**
 * 学生报修
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface XueshengbaoxiuDao extends BaseMapper<XueshengbaoxiuEntity> {
	
	List<XueshengbaoxiuVO> selectListVO(@Param("ew") Wrapper<XueshengbaoxiuEntity> wrapper);
	
	XueshengbaoxiuVO selectVO(@Param("ew") Wrapper<XueshengbaoxiuEntity> wrapper);
	
	List<XueshengbaoxiuView> selectListView(@Param("ew") Wrapper<XueshengbaoxiuEntity> wrapper);

	List<XueshengbaoxiuView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengbaoxiuEntity> wrapper);
	
	XueshengbaoxiuView selectView(@Param("ew") Wrapper<XueshengbaoxiuEntity> wrapper);
	

}
