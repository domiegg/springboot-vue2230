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

import com.entity.SushewupinEntity;
import com.entity.view.SushewupinView;

import com.service.SushewupinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 宿舍物品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/sushewupin")
public class SushewupinController {
    @Autowired
    private SushewupinService sushewupinService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SushewupinEntity sushewupin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("suguan")) {
			sushewupin.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SushewupinEntity> ew = new EntityWrapper<SushewupinEntity>();

		PageUtils page = sushewupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sushewupin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SushewupinEntity sushewupin, 
		HttpServletRequest request){
        EntityWrapper<SushewupinEntity> ew = new EntityWrapper<SushewupinEntity>();

		PageUtils page = sushewupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sushewupin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SushewupinEntity sushewupin){
       	EntityWrapper<SushewupinEntity> ew = new EntityWrapper<SushewupinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sushewupin, "sushewupin")); 
        return R.ok().put("data", sushewupinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SushewupinEntity sushewupin){
        EntityWrapper< SushewupinEntity> ew = new EntityWrapper< SushewupinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sushewupin, "sushewupin")); 
		SushewupinView sushewupinView =  sushewupinService.selectView(ew);
		return R.ok("查询宿舍物品成功").put("data", sushewupinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SushewupinEntity sushewupin = sushewupinService.selectById(id);
        return R.ok().put("data", sushewupin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SushewupinEntity sushewupin = sushewupinService.selectById(id);
        return R.ok().put("data", sushewupin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SushewupinEntity sushewupin, HttpServletRequest request){
    	sushewupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(sushewupin);
        sushewupinService.insert(sushewupin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SushewupinEntity sushewupin, HttpServletRequest request){
    	sushewupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(sushewupin);
        sushewupinService.insert(sushewupin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SushewupinEntity sushewupin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sushewupin);
        sushewupinService.updateById(sushewupin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sushewupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
