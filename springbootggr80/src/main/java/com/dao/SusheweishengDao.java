package com.dao;

import com.entity.SusheweishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SusheweishengVO;
import com.entity.view.SusheweishengView;


/**
 * 宿舍卫生
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface SusheweishengDao extends BaseMapper<SusheweishengEntity> {
	
	List<SusheweishengVO> selectListVO(@Param("ew") Wrapper<SusheweishengEntity> wrapper);
	
	SusheweishengVO selectVO(@Param("ew") Wrapper<SusheweishengEntity> wrapper);
	
	List<SusheweishengView> selectListView(@Param("ew") Wrapper<SusheweishengEntity> wrapper);

	List<SusheweishengView> selectListView(Pagination page,@Param("ew") Wrapper<SusheweishengEntity> wrapper);
	
	SusheweishengView selectView(@Param("ew") Wrapper<SusheweishengEntity> wrapper);
	

}
