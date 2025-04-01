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


import com.dao.WailairenyuanDao;
import com.entity.WailairenyuanEntity;
import com.service.WailairenyuanService;
import com.entity.vo.WailairenyuanVO;
import com.entity.view.WailairenyuanView;

@Service("wailairenyuanService")
public class WailairenyuanServiceImpl extends ServiceImpl<WailairenyuanDao, WailairenyuanEntity> implements WailairenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WailairenyuanEntity> page = this.selectPage(
                new Query<WailairenyuanEntity>(params).getPage(),
                new EntityWrapper<WailairenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WailairenyuanEntity> wrapper) {
		  Page<WailairenyuanView> page =new Query<WailairenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WailairenyuanVO> selectListVO(Wrapper<WailairenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WailairenyuanVO selectVO(Wrapper<WailairenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WailairenyuanView> selectListView(Wrapper<WailairenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WailairenyuanView selectView(Wrapper<WailairenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<WailairenyuanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<WailairenyuanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<WailairenyuanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
