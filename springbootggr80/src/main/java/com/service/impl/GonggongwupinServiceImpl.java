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


import com.dao.GonggongwupinDao;
import com.entity.GonggongwupinEntity;
import com.service.GonggongwupinService;
import com.entity.vo.GonggongwupinVO;
import com.entity.view.GonggongwupinView;

@Service("gonggongwupinService")
public class GonggongwupinServiceImpl extends ServiceImpl<GonggongwupinDao, GonggongwupinEntity> implements GonggongwupinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GonggongwupinEntity> page = this.selectPage(
                new Query<GonggongwupinEntity>(params).getPage(),
                new EntityWrapper<GonggongwupinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GonggongwupinEntity> wrapper) {
		  Page<GonggongwupinView> page =new Query<GonggongwupinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GonggongwupinVO> selectListVO(Wrapper<GonggongwupinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GonggongwupinVO selectVO(Wrapper<GonggongwupinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GonggongwupinView> selectListView(Wrapper<GonggongwupinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GonggongwupinView selectView(Wrapper<GonggongwupinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
