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


import com.dao.ShenqingxinxiDao;
import com.entity.ShenqingxinxiEntity;
import com.service.ShenqingxinxiService;
import com.entity.vo.ShenqingxinxiVO;
import com.entity.view.ShenqingxinxiView;

@Service("shenqingxinxiService")
public class ShenqingxinxiServiceImpl extends ServiceImpl<ShenqingxinxiDao, ShenqingxinxiEntity> implements ShenqingxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingxinxiEntity> page = this.selectPage(
                new Query<ShenqingxinxiEntity>(params).getPage(),
                new EntityWrapper<ShenqingxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingxinxiEntity> wrapper) {
		  Page<ShenqingxinxiView> page =new Query<ShenqingxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenqingxinxiVO> selectListVO(Wrapper<ShenqingxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenqingxinxiVO selectVO(Wrapper<ShenqingxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenqingxinxiView> selectListView(Wrapper<ShenqingxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingxinxiView selectView(Wrapper<ShenqingxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
