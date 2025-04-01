package com.dao;

import com.entity.SushewupinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SushewupinVO;
import com.entity.view.SushewupinView;


/**
 * 宿舍物品
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface SushewupinDao extends BaseMapper<SushewupinEntity> {
	
	List<SushewupinVO> selectListVO(@Param("ew") Wrapper<SushewupinEntity> wrapper);
	
	SushewupinVO selectVO(@Param("ew") Wrapper<SushewupinEntity> wrapper);
	
	List<SushewupinView> selectListView(@Param("ew") Wrapper<SushewupinEntity> wrapper);

	List<SushewupinView> selectListView(Pagination page,@Param("ew") Wrapper<SushewupinEntity> wrapper);
	
	SushewupinView selectView(@Param("ew") Wrapper<SushewupinEntity> wrapper);
	

}
