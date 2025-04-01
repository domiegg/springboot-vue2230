package com.dao;

import com.entity.DaoyuanquerenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaoyuanquerenVO;
import com.entity.view.DaoyuanquerenView;


/**
 * 导员确认
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface DaoyuanquerenDao extends BaseMapper<DaoyuanquerenEntity> {
	
	List<DaoyuanquerenVO> selectListVO(@Param("ew") Wrapper<DaoyuanquerenEntity> wrapper);
	
	DaoyuanquerenVO selectVO(@Param("ew") Wrapper<DaoyuanquerenEntity> wrapper);
	
	List<DaoyuanquerenView> selectListView(@Param("ew") Wrapper<DaoyuanquerenEntity> wrapper);

	List<DaoyuanquerenView> selectListView(Pagination page,@Param("ew") Wrapper<DaoyuanquerenEntity> wrapper);
	
	DaoyuanquerenView selectView(@Param("ew") Wrapper<DaoyuanquerenEntity> wrapper);
	

}
