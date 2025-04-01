package com.dao;

import com.entity.PaixingbangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PaixingbangVO;
import com.entity.view.PaixingbangView;


/**
 * 排行榜
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface PaixingbangDao extends BaseMapper<PaixingbangEntity> {
	
	List<PaixingbangVO> selectListVO(@Param("ew") Wrapper<PaixingbangEntity> wrapper);
	
	PaixingbangVO selectVO(@Param("ew") Wrapper<PaixingbangEntity> wrapper);
	
	List<PaixingbangView> selectListView(@Param("ew") Wrapper<PaixingbangEntity> wrapper);

	List<PaixingbangView> selectListView(Pagination page,@Param("ew") Wrapper<PaixingbangEntity> wrapper);
	
	PaixingbangView selectView(@Param("ew") Wrapper<PaixingbangEntity> wrapper);
	

}
