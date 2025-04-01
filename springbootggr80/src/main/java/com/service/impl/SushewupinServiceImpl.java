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


import com.dao.SushewupinDao;
import com.entity.SushewupinEntity;
import com.service.SushewupinService;
import com.entity.vo.SushewupinVO;
import com.entity.view.SushewupinView;

@Service("sushewupinService")
public class SushewupinServiceImpl extends ServiceImpl<SushewupinDao, SushewupinEntity> implements SushewupinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SushewupinEntity> page = this.selectPage(
                new Query<SushewupinEntity>(params).getPage(),
                new EntityWrapper<SushewupinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SushewupinEntity> wrapper) {
		  Page<SushewupinView> page =new Query<SushewupinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SushewupinVO> selectListVO(Wrapper<SushewupinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SushewupinVO selectVO(Wrapper<SushewupinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SushewupinView> selectListView(Wrapper<SushewupinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SushewupinView selectView(Wrapper<SushewupinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
