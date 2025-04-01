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


import com.dao.HuanjingxinxiDao;
import com.entity.HuanjingxinxiEntity;
import com.service.HuanjingxinxiService;
import com.entity.vo.HuanjingxinxiVO;
import com.entity.view.HuanjingxinxiView;

@Service("huanjingxinxiService")
public class HuanjingxinxiServiceImpl extends ServiceImpl<HuanjingxinxiDao, HuanjingxinxiEntity> implements HuanjingxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuanjingxinxiEntity> page = this.selectPage(
                new Query<HuanjingxinxiEntity>(params).getPage(),
                new EntityWrapper<HuanjingxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuanjingxinxiEntity> wrapper) {
		  Page<HuanjingxinxiView> page =new Query<HuanjingxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuanjingxinxiVO> selectListVO(Wrapper<HuanjingxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuanjingxinxiVO selectVO(Wrapper<HuanjingxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuanjingxinxiView> selectListView(Wrapper<HuanjingxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuanjingxinxiView selectView(Wrapper<HuanjingxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
