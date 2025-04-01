package com.dao;

import com.entity.BaoxiudingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BaoxiudingdanVO;
import com.entity.view.BaoxiudingdanView;


/**
 * 报修订单
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface BaoxiudingdanDao extends BaseMapper<BaoxiudingdanEntity> {
	
	List<BaoxiudingdanVO> selectListVO(@Param("ew") Wrapper<BaoxiudingdanEntity> wrapper);
	
	BaoxiudingdanVO selectVO(@Param("ew") Wrapper<BaoxiudingdanEntity> wrapper);
	
	List<BaoxiudingdanView> selectListView(@Param("ew") Wrapper<BaoxiudingdanEntity> wrapper);

	List<BaoxiudingdanView> selectListView(Pagination page,@Param("ew") Wrapper<BaoxiudingdanEntity> wrapper);
	
	BaoxiudingdanView selectView(@Param("ew") Wrapper<BaoxiudingdanEntity> wrapper);
	

}
