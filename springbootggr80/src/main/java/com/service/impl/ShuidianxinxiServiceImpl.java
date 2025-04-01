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


import com.dao.ShuidianxinxiDao;
import com.entity.ShuidianxinxiEntity;
import com.service.ShuidianxinxiService;
import com.entity.vo.ShuidianxinxiVO;
import com.entity.view.ShuidianxinxiView;

@Service("shuidianxinxiService")
public class ShuidianxinxiServiceImpl extends ServiceImpl<ShuidianxinxiDao, ShuidianxinxiEntity> implements ShuidianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShuidianxinxiEntity> page = this.selectPage(
                new Query<ShuidianxinxiEntity>(params).getPage(),
                new EntityWrapper<ShuidianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShuidianxinxiEntity> wrapper) {
		  Page<ShuidianxinxiView> page =new Query<ShuidianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShuidianxinxiVO> selectListVO(Wrapper<ShuidianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShuidianxinxiVO selectVO(Wrapper<ShuidianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShuidianxinxiView> selectListView(Wrapper<ShuidianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShuidianxinxiView selectView(Wrapper<ShuidianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
