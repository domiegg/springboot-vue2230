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


import com.dao.SusheweishengDao;
import com.entity.SusheweishengEntity;
import com.service.SusheweishengService;
import com.entity.vo.SusheweishengVO;
import com.entity.view.SusheweishengView;

@Service("susheweishengService")
public class SusheweishengServiceImpl extends ServiceImpl<SusheweishengDao, SusheweishengEntity> implements SusheweishengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SusheweishengEntity> page = this.selectPage(
                new Query<SusheweishengEntity>(params).getPage(),
                new EntityWrapper<SusheweishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SusheweishengEntity> wrapper) {
		  Page<SusheweishengView> page =new Query<SusheweishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SusheweishengVO> selectListVO(Wrapper<SusheweishengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SusheweishengVO selectVO(Wrapper<SusheweishengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SusheweishengView> selectListView(Wrapper<SusheweishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SusheweishengView selectView(Wrapper<SusheweishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
