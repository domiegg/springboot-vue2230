package com.dao;

import com.entity.KoulingmaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KoulingmaVO;
import com.entity.view.KoulingmaView;


/**
 * 口令码
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface KoulingmaDao extends BaseMapper<KoulingmaEntity> {
	
	List<KoulingmaVO> selectListVO(@Param("ew") Wrapper<KoulingmaEntity> wrapper);
	
	KoulingmaVO selectVO(@Param("ew") Wrapper<KoulingmaEntity> wrapper);
	
	List<KoulingmaView> selectListView(@Param("ew") Wrapper<KoulingmaEntity> wrapper);

	List<KoulingmaView> selectListView(Pagination page,@Param("ew") Wrapper<KoulingmaEntity> wrapper);
	
	KoulingmaView selectView(@Param("ew") Wrapper<KoulingmaEntity> wrapper);
	

}
