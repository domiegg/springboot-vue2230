package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaoxiujiedanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaoxiujiedanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoxiujiedanView;


/**
 * 报修接单
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface BaoxiujiedanService extends IService<BaoxiujiedanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaoxiujiedanVO> selectListVO(Wrapper<BaoxiujiedanEntity> wrapper);
   	
   	BaoxiujiedanVO selectVO(@Param("ew") Wrapper<BaoxiujiedanEntity> wrapper);
   	
   	List<BaoxiujiedanView> selectListView(Wrapper<BaoxiujiedanEntity> wrapper);
   	
   	BaoxiujiedanView selectView(@Param("ew") Wrapper<BaoxiujiedanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaoxiujiedanEntity> wrapper);
   	

}

