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


import com.dao.BaoxiujiedanDao;
import com.entity.BaoxiujiedanEntity;
import com.service.BaoxiujiedanService;
import com.entity.vo.BaoxiujiedanVO;
import com.entity.view.BaoxiujiedanView;

@Service("baoxiujiedanService")
public class BaoxiujiedanServiceImpl extends ServiceImpl<BaoxiujiedanDao, BaoxiujiedanEntity> implements BaoxiujiedanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaoxiujiedanEntity> page = this.selectPage(
                new Query<BaoxiujiedanEntity>(params).getPage(),
                new EntityWrapper<BaoxiujiedanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaoxiujiedanEntity> wrapper) {
		  Page<BaoxiujiedanView> page =new Query<BaoxiujiedanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BaoxiujiedanVO> selectListVO(Wrapper<BaoxiujiedanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BaoxiujiedanVO selectVO(Wrapper<BaoxiujiedanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BaoxiujiedanView> selectListView(Wrapper<BaoxiujiedanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaoxiujiedanView selectView(Wrapper<BaoxiujiedanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
