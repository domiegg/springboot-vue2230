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


import com.dao.KoulingmaDao;
import com.entity.KoulingmaEntity;
import com.service.KoulingmaService;
import com.entity.vo.KoulingmaVO;
import com.entity.view.KoulingmaView;

@Service("koulingmaService")
public class KoulingmaServiceImpl extends ServiceImpl<KoulingmaDao, KoulingmaEntity> implements KoulingmaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KoulingmaEntity> page = this.selectPage(
                new Query<KoulingmaEntity>(params).getPage(),
                new EntityWrapper<KoulingmaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KoulingmaEntity> wrapper) {
		  Page<KoulingmaView> page =new Query<KoulingmaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KoulingmaVO> selectListVO(Wrapper<KoulingmaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KoulingmaVO selectVO(Wrapper<KoulingmaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KoulingmaView> selectListView(Wrapper<KoulingmaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KoulingmaView selectView(Wrapper<KoulingmaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
