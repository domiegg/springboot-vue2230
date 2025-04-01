package com.dao;

import com.entity.XueshengjinchususheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengjinchususheVO;
import com.entity.view.XueshengjinchususheView;


/**
 * 学生进出宿舍
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface XueshengjinchususheDao extends BaseMapper<XueshengjinchususheEntity> {
	
	List<XueshengjinchususheVO> selectListVO(@Param("ew") Wrapper<XueshengjinchususheEntity> wrapper);
	
	XueshengjinchususheVO selectVO(@Param("ew") Wrapper<XueshengjinchususheEntity> wrapper);
	
	List<XueshengjinchususheView> selectListView(@Param("ew") Wrapper<XueshengjinchususheEntity> wrapper);

	List<XueshengjinchususheView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengjinchususheEntity> wrapper);
	
	XueshengjinchususheView selectView(@Param("ew") Wrapper<XueshengjinchususheEntity> wrapper);
	

}
