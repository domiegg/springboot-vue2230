package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaoxiudingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaoxiudingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoxiudingdanView;


/**
 * 报修订单
 *
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
public interface BaoxiudingdanService extends IService<BaoxiudingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaoxiudingdanVO> selectListVO(Wrapper<BaoxiudingdanEntity> wrapper);
   	
   	BaoxiudingdanVO selectVO(@Param("ew") Wrapper<BaoxiudingdanEntity> wrapper);
   	
   	List<BaoxiudingdanView> selectListView(Wrapper<BaoxiudingdanEntity> wrapper);
   	
   	BaoxiudingdanView selectView(@Param("ew") Wrapper<BaoxiudingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaoxiudingdanEntity> wrapper);
   	

}

