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


import com.dao.DaoyuanquerenDao;
import com.entity.DaoyuanquerenEntity;
import com.service.DaoyuanquerenService;
import com.entity.vo.DaoyuanquerenVO;
import com.entity.view.DaoyuanquerenView;

@Service("daoyuanquerenService")
public class DaoyuanquerenServiceImpl extends ServiceImpl<DaoyuanquerenDao, DaoyuanquerenEntity> implements DaoyuanquerenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaoyuanquerenEntity> page = this.selectPage(
                new Query<DaoyuanquerenEntity>(params).getPage(),
                new EntityWrapper<DaoyuanquerenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaoyuanquerenEntity> wrapper) {
		  Page<DaoyuanquerenView> page =new Query<DaoyuanquerenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DaoyuanquerenVO> selectListVO(Wrapper<DaoyuanquerenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaoyuanquerenVO selectVO(Wrapper<DaoyuanquerenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaoyuanquerenView> selectListView(Wrapper<DaoyuanquerenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaoyuanquerenView selectView(Wrapper<DaoyuanquerenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
