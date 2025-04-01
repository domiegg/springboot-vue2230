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


import com.dao.YuyueshiyongDao;
import com.entity.YuyueshiyongEntity;
import com.service.YuyueshiyongService;
import com.entity.vo.YuyueshiyongVO;
import com.entity.view.YuyueshiyongView;

@Service("yuyueshiyongService")
public class YuyueshiyongServiceImpl extends ServiceImpl<YuyueshiyongDao, YuyueshiyongEntity> implements YuyueshiyongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyueshiyongEntity> page = this.selectPage(
                new Query<YuyueshiyongEntity>(params).getPage(),
                new EntityWrapper<YuyueshiyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyueshiyongEntity> wrapper) {
		  Page<YuyueshiyongView> page =new Query<YuyueshiyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuyueshiyongVO> selectListVO(Wrapper<YuyueshiyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyueshiyongVO selectVO(Wrapper<YuyueshiyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyueshiyongView> selectListView(Wrapper<YuyueshiyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyueshiyongView selectView(Wrapper<YuyueshiyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
