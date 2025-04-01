package com.dao;

import com.entity.ShuidianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShuidianxinxiVO;
import com.entity.view.ShuidianxinxiView;


/**
 * 水电信息
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface ShuidianxinxiDao extends BaseMapper<ShuidianxinxiEntity> {
	
	List<ShuidianxinxiVO> selectListVO(@Param("ew") Wrapper<ShuidianxinxiEntity> wrapper);
	
	ShuidianxinxiVO selectVO(@Param("ew") Wrapper<ShuidianxinxiEntity> wrapper);
	
	List<ShuidianxinxiView> selectListView(@Param("ew") Wrapper<ShuidianxinxiEntity> wrapper);

	List<ShuidianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShuidianxinxiEntity> wrapper);
	
	ShuidianxinxiView selectView(@Param("ew") Wrapper<ShuidianxinxiEntity> wrapper);
	

}
