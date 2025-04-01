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

import com.entity.WeijidengjiEntity;
import com.entity.view.WeijidengjiView;

import com.service.WeijidengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 违纪登记
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/weijidengji")
public class WeijidengjiController {
    @Autowired
    private WeijidengjiService weijidengjiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeijidengjiEntity weijidengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			weijidengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			weijidengji.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeijidengjiEntity> ew = new EntityWrapper<WeijidengjiEntity>();

		PageUtils page = weijidengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weijidengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeijidengjiEntity weijidengji, 
		HttpServletRequest request){
        EntityWrapper<WeijidengjiEntity> ew = new EntityWrapper<WeijidengjiEntity>();

		PageUtils page = weijidengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weijidengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeijidengjiEntity weijidengji){
       	EntityWrapper<WeijidengjiEntity> ew = new EntityWrapper<WeijidengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weijidengji, "weijidengji")); 
        return R.ok().put("data", weijidengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeijidengjiEntity weijidengji){
        EntityWrapper< WeijidengjiEntity> ew = new EntityWrapper< WeijidengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weijidengji, "weijidengji")); 
		WeijidengjiView weijidengjiView =  weijidengjiService.selectView(ew);
		return R.ok("查询违纪登记成功").put("data", weijidengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeijidengjiEntity weijidengji = weijidengjiService.selectById(id);
        return R.ok().put("data", weijidengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeijidengjiEntity weijidengji = weijidengjiService.selectById(id);
        return R.ok().put("data", weijidengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeijidengjiEntity weijidengji, HttpServletRequest request){
    	weijidengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weijidengji);
        weijidengjiService.insert(weijidengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeijidengjiEntity weijidengji, HttpServletRequest request){
    	weijidengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weijidengji);
        weijidengjiService.insert(weijidengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeijidengjiEntity weijidengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weijidengji);
        weijidengjiService.updateById(weijidengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weijidengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
