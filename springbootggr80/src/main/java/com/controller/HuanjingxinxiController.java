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

import com.entity.HuanjingxinxiEntity;
import com.entity.view.HuanjingxinxiView;

import com.service.HuanjingxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 环境信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/huanjingxinxi")
public class HuanjingxinxiController {
    @Autowired
    private HuanjingxinxiService huanjingxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuanjingxinxiEntity huanjingxinxi,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		huanjingxinxi.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<HuanjingxinxiEntity> ew = new EntityWrapper<HuanjingxinxiEntity>();

		PageUtils page = huanjingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huanjingxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuanjingxinxiEntity huanjingxinxi, 
		HttpServletRequest request){
        EntityWrapper<HuanjingxinxiEntity> ew = new EntityWrapper<HuanjingxinxiEntity>();

		PageUtils page = huanjingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huanjingxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuanjingxinxiEntity huanjingxinxi){
       	EntityWrapper<HuanjingxinxiEntity> ew = new EntityWrapper<HuanjingxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huanjingxinxi, "huanjingxinxi")); 
        return R.ok().put("data", huanjingxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuanjingxinxiEntity huanjingxinxi){
        EntityWrapper< HuanjingxinxiEntity> ew = new EntityWrapper< HuanjingxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huanjingxinxi, "huanjingxinxi")); 
		HuanjingxinxiView huanjingxinxiView =  huanjingxinxiService.selectView(ew);
		return R.ok("查询环境信息成功").put("data", huanjingxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuanjingxinxiEntity huanjingxinxi = huanjingxinxiService.selectById(id);
        return R.ok().put("data", huanjingxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuanjingxinxiEntity huanjingxinxi = huanjingxinxiService.selectById(id);
        return R.ok().put("data", huanjingxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuanjingxinxiEntity huanjingxinxi, HttpServletRequest request){
    	huanjingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huanjingxinxi);
    	huanjingxinxi.setUserid((Long)request.getSession().getAttribute("userId"));
        huanjingxinxiService.insert(huanjingxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody HuanjingxinxiEntity huanjingxinxi, HttpServletRequest request){
    	huanjingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huanjingxinxi);
        huanjingxinxiService.insert(huanjingxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuanjingxinxiEntity huanjingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huanjingxinxi);
        huanjingxinxiService.updateById(huanjingxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huanjingxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
