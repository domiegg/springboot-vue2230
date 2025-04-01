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


import com.dao.WanguiweiguidengjiDao;
import com.entity.WanguiweiguidengjiEntity;
import com.service.WanguiweiguidengjiService;
import com.entity.vo.WanguiweiguidengjiVO;
import com.entity.view.WanguiweiguidengjiView;

@Service("wanguiweiguidengjiService")
public class WanguiweiguidengjiServiceImpl extends ServiceImpl<WanguiweiguidengjiDao, WanguiweiguidengjiEntity> implements WanguiweiguidengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WanguiweiguidengjiEntity> page = this.selectPage(
                new Query<WanguiweiguidengjiEntity>(params).getPage(),
                new EntityWrapper<WanguiweiguidengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WanguiweiguidengjiEntity> wrapper) {
		  Page<WanguiweiguidengjiView> page =new Query<WanguiweiguidengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WanguiweiguidengjiVO> selectListVO(Wrapper<WanguiweiguidengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WanguiweiguidengjiVO selectVO(Wrapper<WanguiweiguidengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WanguiweiguidengjiView> selectListView(Wrapper<WanguiweiguidengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WanguiweiguidengjiView selectView(Wrapper<WanguiweiguidengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
