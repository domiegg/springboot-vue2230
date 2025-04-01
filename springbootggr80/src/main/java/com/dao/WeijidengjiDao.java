package com.dao;

import com.entity.WeijidengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeijidengjiVO;
import com.entity.view.WeijidengjiView;


/**
 * 违纪登记
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface WeijidengjiDao extends BaseMapper<WeijidengjiEntity> {
	
	List<WeijidengjiVO> selectListVO(@Param("ew") Wrapper<WeijidengjiEntity> wrapper);
	
	WeijidengjiVO selectVO(@Param("ew") Wrapper<WeijidengjiEntity> wrapper);
	
	List<WeijidengjiView> selectListView(@Param("ew") Wrapper<WeijidengjiEntity> wrapper);

	List<WeijidengjiView> selectListView(Pagination page,@Param("ew") Wrapper<WeijidengjiEntity> wrapper);
	
	WeijidengjiView selectView(@Param("ew") Wrapper<WeijidengjiEntity> wrapper);
	

}
