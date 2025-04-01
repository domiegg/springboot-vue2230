package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GenghuanshenqingEntity;
import com.entity.view.GenghuanshenqingView;

import com.service.GenghuanshenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 更换申请
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/genghuanshenqing")
public class GenghuanshenqingController {
    @Autowired
    private GenghuanshenqingService genghuanshenqingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GenghuanshenqingEntity genghuanshenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			genghuanshenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			genghuanshenqing.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GenghuanshenqingEntity> ew = new EntityWrapper<GenghuanshenqingEntity>();

		PageUtils page = genghuanshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, genghuanshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GenghuanshenqingEntity genghuanshenqing, 
		HttpServletRequest request){
        EntityWrapper<GenghuanshenqingEntity> ew = new EntityWrapper<GenghuanshenqingEntity>();

		PageUtils page = genghuanshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, genghuanshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GenghuanshenqingEntity genghuanshenqing){
       	EntityWrapper<GenghuanshenqingEntity> ew = new EntityWrapper<GenghuanshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( genghuanshenqing, "genghuanshenqing")); 
        return R.ok().put("data", genghuanshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GenghuanshenqingEntity genghuanshenqing){
        EntityWrapper< GenghuanshenqingEntity> ew = new EntityWrapper< GenghuanshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( genghuanshenqing, "genghuanshenqing")); 
		GenghuanshenqingView genghuanshenqingView =  genghuanshenqingService.selectView(ew);
		return R.ok("查询更换申请成功").put("data", genghuanshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GenghuanshenqingEntity genghuanshenqing = genghuanshenqingService.selectById(id);
        return R.ok().put("data", genghuanshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GenghuanshenqingEntity genghuanshenqing = genghuanshenqingService.selectById(id);
        return R.ok().put("data", genghuanshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GenghuanshenqingEntity genghuanshenqing, HttpServletRequest request){
    	genghuanshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(genghuanshenqing);
        genghuanshenqingService.insert(genghuanshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody GenghuanshenqingEntity genghuanshenqing, HttpServletRequest request){
    	genghuanshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(genghuanshenqing);
        genghuanshenqingService.insert(genghuanshenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GenghuanshenqingEntity genghuanshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(genghuanshenqing);
        genghuanshenqingService.updateById(genghuanshenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<GenghuanshenqingEntity> list = new ArrayList<GenghuanshenqingEntity>();
        for(Long id : ids) {
            GenghuanshenqingEntity genghuanshenqing = genghuanshenqingService.selectById(id);
            genghuanshenqing.setSfsh(sfsh);
            genghuanshenqing.setShhf(shhf);
            list.add(genghuanshenqing);
        }
        genghuanshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        genghuanshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
