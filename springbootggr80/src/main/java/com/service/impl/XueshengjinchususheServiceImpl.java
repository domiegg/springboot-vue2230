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


import com.dao.XueshengjinchususheDao;
import com.entity.XueshengjinchususheEntity;
import com.service.XueshengjinchususheService;
import com.entity.vo.XueshengjinchususheVO;
import com.entity.view.XueshengjinchususheView;

@Service("xueshengjinchususheService")
public class XueshengjinchususheServiceImpl extends ServiceImpl<XueshengjinchususheDao, XueshengjinchususheEntity> implements XueshengjinchususheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengjinchususheEntity> page = this.selectPage(
                new Query<XueshengjinchususheEntity>(params).getPage(),
                new EntityWrapper<XueshengjinchususheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengjinchususheEntity> wrapper) {
		  Page<XueshengjinchususheView> page =new Query<XueshengjinchususheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengjinchususheVO> selectListVO(Wrapper<XueshengjinchususheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengjinchususheVO selectVO(Wrapper<XueshengjinchususheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengjinchususheView> selectListView(Wrapper<XueshengjinchususheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengjinchususheView selectView(Wrapper<XueshengjinchususheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
