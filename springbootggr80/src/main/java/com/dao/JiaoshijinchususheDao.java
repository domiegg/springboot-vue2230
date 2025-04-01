package com.dao;

import com.entity.JiaoshijinchususheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaoshijinchususheVO;
import com.entity.view.JiaoshijinchususheView;


/**
 * 教师进出宿舍
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface JiaoshijinchususheDao extends BaseMapper<JiaoshijinchususheEntity> {
	
	List<JiaoshijinchususheVO> selectListVO(@Param("ew") Wrapper<JiaoshijinchususheEntity> wrapper);
	
	JiaoshijinchususheVO selectVO(@Param("ew") Wrapper<JiaoshijinchususheEntity> wrapper);
	
	List<JiaoshijinchususheView> selectListView(@Param("ew") Wrapper<JiaoshijinchususheEntity> wrapper);

	List<JiaoshijinchususheView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoshijinchususheEntity> wrapper);
	
	JiaoshijinchususheView selectView(@Param("ew") Wrapper<JiaoshijinchususheEntity> wrapper);
	

}
