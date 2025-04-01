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


import com.dao.GenghuansusheDao;
import com.entity.GenghuansusheEntity;
import com.service.GenghuansusheService;
import com.entity.vo.GenghuansusheVO;
import com.entity.view.GenghuansusheView;

@Service("genghuansusheService")
public class GenghuansusheServiceImpl extends ServiceImpl<GenghuansusheDao, GenghuansusheEntity> implements GenghuansusheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GenghuansusheEntity> page = this.selectPage(
                new Query<GenghuansusheEntity>(params).getPage(),
                new EntityWrapper<GenghuansusheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GenghuansusheEntity> wrapper) {
		  Page<GenghuansusheView> page =new Query<GenghuansusheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GenghuansusheVO> selectListVO(Wrapper<GenghuansusheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GenghuansusheVO selectVO(Wrapper<GenghuansusheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GenghuansusheView> selectListView(Wrapper<GenghuansusheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GenghuansusheView selectView(Wrapper<GenghuansusheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
