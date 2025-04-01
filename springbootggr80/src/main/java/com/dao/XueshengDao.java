package com.dao;

import com.entity.XueshengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengVO;
import com.entity.view.XueshengView;


/**
 * 学生
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface XueshengDao extends BaseMapper<XueshengEntity> {
	
	List<XueshengVO> selectListVO(@Param("ew") Wrapper<XueshengEntity> wrapper);
	
	XueshengVO selectVO(@Param("ew") Wrapper<XueshengEntity> wrapper);
	
	List<XueshengView> selectListView(@Param("ew") Wrapper<XueshengEntity> wrapper);

	List<XueshengView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengEntity> wrapper);
	
	XueshengView selectView(@Param("ew") Wrapper<XueshengEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengEntity> wrapper);



}
