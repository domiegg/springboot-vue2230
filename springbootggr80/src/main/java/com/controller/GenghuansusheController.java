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

import com.entity.GenghuansusheEntity;
import com.entity.view.GenghuansusheView;

import com.service.GenghuansusheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 更换宿舍
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/genghuansushe")
public class GenghuansusheController {
    @Autowired
    private GenghuansusheService genghuansusheService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GenghuansusheEntity genghuansushe,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			genghuansushe.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			genghuansushe.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GenghuansusheEntity> ew = new EntityWrapper<GenghuansusheEntity>();

		PageUtils page = genghuansusheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, genghuansushe), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GenghuansusheEntity genghuansushe, 
		HttpServletRequest request){
        EntityWrapper<GenghuansusheEntity> ew = new EntityWrapper<GenghuansusheEntity>();

		PageUtils page = genghuansusheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, genghuansushe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GenghuansusheEntity genghuansushe){
       	EntityWrapper<GenghuansusheEntity> ew = new EntityWrapper<GenghuansusheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( genghuansushe, "genghuansushe")); 
        return R.ok().put("data", genghuansusheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GenghuansusheEntity genghuansushe){
        EntityWrapper< GenghuansusheEntity> ew = new EntityWrapper< GenghuansusheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( genghuansushe, "genghuansushe")); 
		GenghuansusheView genghuansusheView =  genghuansusheService.selectView(ew);
		return R.ok("查询更换宿舍成功").put("data", genghuansusheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GenghuansusheEntity genghuansushe = genghuansusheService.selectById(id);
        return R.ok().put("data", genghuansushe);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GenghuansusheEntity genghuansushe = genghuansusheService.selectById(id);
        return R.ok().put("data", genghuansushe);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GenghuansusheEntity genghuansushe, HttpServletRequest request){
    	genghuansushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(genghuansushe);
        genghuansusheService.insert(genghuansushe);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GenghuansusheEntity genghuansushe, HttpServletRequest request){
    	genghuansushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(genghuansushe);
        genghuansusheService.insert(genghuansushe);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GenghuansusheEntity genghuansushe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(genghuansushe);
        genghuansusheService.updateById(genghuansushe);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        genghuansusheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
