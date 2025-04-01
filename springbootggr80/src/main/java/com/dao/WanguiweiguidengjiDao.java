package com.dao;

import com.entity.WanguiweiguidengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WanguiweiguidengjiVO;
import com.entity.view.WanguiweiguidengjiView;


/**
 * 晚归未归登记
 * 
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface WanguiweiguidengjiDao extends BaseMapper<WanguiweiguidengjiEntity> {
	
	List<WanguiweiguidengjiVO> selectListVO(@Param("ew") Wrapper<WanguiweiguidengjiEntity> wrapper);
	
	WanguiweiguidengjiVO selectVO(@Param("ew") Wrapper<WanguiweiguidengjiEntity> wrapper);
	
	List<WanguiweiguidengjiView> selectListView(@Param("ew") Wrapper<WanguiweiguidengjiEntity> wrapper);

	List<WanguiweiguidengjiView> selectListView(Pagination page,@Param("ew") Wrapper<WanguiweiguidengjiEntity> wrapper);
	
	WanguiweiguidengjiView selectView(@Param("ew") Wrapper<WanguiweiguidengjiEntity> wrapper);
	

}
