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


import com.dao.XueshengwupinDao;
import com.entity.XueshengwupinEntity;
import com.service.XueshengwupinService;
import com.entity.vo.XueshengwupinVO;
import com.entity.view.XueshengwupinView;

@Service("xueshengwupinService")
public class XueshengwupinServiceImpl extends ServiceImpl<XueshengwupinDao, XueshengwupinEntity> implements XueshengwupinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengwupinEntity> page = this.selectPage(
                new Query<XueshengwupinEntity>(params).getPage(),
                new EntityWrapper<XueshengwupinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengwupinEntity> wrapper) {
		  Page<XueshengwupinView> page =new Query<XueshengwupinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengwupinVO> selectListVO(Wrapper<XueshengwupinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengwupinVO selectVO(Wrapper<XueshengwupinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengwupinView> selectListView(Wrapper<XueshengwupinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengwupinView selectView(Wrapper<XueshengwupinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
