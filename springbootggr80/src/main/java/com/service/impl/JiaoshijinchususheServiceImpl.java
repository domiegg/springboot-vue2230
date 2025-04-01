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


import com.dao.JiaoshijinchususheDao;
import com.entity.JiaoshijinchususheEntity;
import com.service.JiaoshijinchususheService;
import com.entity.vo.JiaoshijinchususheVO;
import com.entity.view.JiaoshijinchususheView;

@Service("jiaoshijinchususheService")
public class JiaoshijinchususheServiceImpl extends ServiceImpl<JiaoshijinchususheDao, JiaoshijinchususheEntity> implements JiaoshijinchususheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoshijinchususheEntity> page = this.selectPage(
                new Query<JiaoshijinchususheEntity>(params).getPage(),
                new EntityWrapper<JiaoshijinchususheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoshijinchususheEntity> wrapper) {
		  Page<JiaoshijinchususheView> page =new Query<JiaoshijinchususheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaoshijinchususheVO> selectListVO(Wrapper<JiaoshijinchususheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaoshijinchususheVO selectVO(Wrapper<JiaoshijinchususheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaoshijinchususheView> selectListView(Wrapper<JiaoshijinchususheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoshijinchususheView selectView(Wrapper<JiaoshijinchususheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
