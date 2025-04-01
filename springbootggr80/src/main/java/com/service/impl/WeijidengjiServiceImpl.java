package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WeijidengjiDao;
import com.entity.WeijidengjiEntity;
import com.service.WeijidengjiService;
import com.entity.vo.WeijidengjiVO;
import com.entity.view.WeijidengjiView;

@Service("weijidengjiService")
public class WeijidengjiServiceImpl extends ServiceImpl<WeijidengjiDao, WeijidengjiEntity> implements WeijidengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeijidengjiEntity> page = this.selectPage(
                new Query<WeijidengjiEntity>(params).getPage(),
                new EntityWrapper<WeijidengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeijidengjiEntity> wrapper) {
		  Page<WeijidengjiView> page =new Query<WeijidengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeijidengjiVO> selectListVO(Wrapper<WeijidengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeijidengjiVO selectVO(Wrapper<WeijidengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeijidengjiView> selectListView(Wrapper<WeijidengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeijidengjiView selectView(Wrapper<WeijidengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
