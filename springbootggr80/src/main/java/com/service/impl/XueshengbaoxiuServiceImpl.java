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


import com.dao.XueshengbaoxiuDao;
import com.entity.XueshengbaoxiuEntity;
import com.service.XueshengbaoxiuService;
import com.entity.vo.XueshengbaoxiuVO;
import com.entity.view.XueshengbaoxiuView;

@Service("xueshengbaoxiuService")
public class XueshengbaoxiuServiceImpl extends ServiceImpl<XueshengbaoxiuDao, XueshengbaoxiuEntity> implements XueshengbaoxiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengbaoxiuEntity> page = this.selectPage(
                new Query<XueshengbaoxiuEntity>(params).getPage(),
                new EntityWrapper<XueshengbaoxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengbaoxiuEntity> wrapper) {
		  Page<XueshengbaoxiuView> page =new Query<XueshengbaoxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengbaoxiuVO> selectListVO(Wrapper<XueshengbaoxiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengbaoxiuVO selectVO(Wrapper<XueshengbaoxiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengbaoxiuView> selectListView(Wrapper<XueshengbaoxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengbaoxiuView selectView(Wrapper<XueshengbaoxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
