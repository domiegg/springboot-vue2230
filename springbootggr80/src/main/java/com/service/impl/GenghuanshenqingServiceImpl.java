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


import com.dao.GenghuanshenqingDao;
import com.entity.GenghuanshenqingEntity;
import com.service.GenghuanshenqingService;
import com.entity.vo.GenghuanshenqingVO;
import com.entity.view.GenghuanshenqingView;

@Service("genghuanshenqingService")
public class GenghuanshenqingServiceImpl extends ServiceImpl<GenghuanshenqingDao, GenghuanshenqingEntity> implements GenghuanshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GenghuanshenqingEntity> page = this.selectPage(
                new Query<GenghuanshenqingEntity>(params).getPage(),
                new EntityWrapper<GenghuanshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GenghuanshenqingEntity> wrapper) {
		  Page<GenghuanshenqingView> page =new Query<GenghuanshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GenghuanshenqingVO> selectListVO(Wrapper<GenghuanshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GenghuanshenqingVO selectVO(Wrapper<GenghuanshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GenghuanshenqingView> selectListView(Wrapper<GenghuanshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GenghuanshenqingView selectView(Wrapper<GenghuanshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
