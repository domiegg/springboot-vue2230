package com.dao;

import com.entity.YuyueshiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyueshiyongVO;
import com.entity.view.YuyueshiyongView;


/**
 * 预约使用
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
public interface YuyueshiyongDao extends BaseMapper<YuyueshiyongEntity> {
	
	List<YuyueshiyongVO> selectListVO(@Param("ew") Wrapper<YuyueshiyongEntity> wrapper);
	
	YuyueshiyongVO selectVO(@Param("ew") Wrapper<YuyueshiyongEntity> wrapper);
	
	List<YuyueshiyongView> selectListView(@Param("ew") Wrapper<YuyueshiyongEntity> wrapper);

	List<YuyueshiyongView> selectListView(Pagination page,@Param("ew") Wrapper<YuyueshiyongEntity> wrapper);
	
	YuyueshiyongView selectView(@Param("ew") Wrapper<YuyueshiyongEntity> wrapper);
	

}
