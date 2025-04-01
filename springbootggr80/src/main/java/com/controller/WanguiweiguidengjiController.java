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

import com.entity.WanguiweiguidengjiEntity;
import com.entity.view.WanguiweiguidengjiView;

import com.service.WanguiweiguidengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 晚归未归登记
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/wanguiweiguidengji")
public class WanguiweiguidengjiController {
    @Autowired
    private WanguiweiguidengjiService wanguiweiguidengjiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WanguiweiguidengjiEntity wanguiweiguidengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wanguiweiguidengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			wanguiweiguidengji.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WanguiweiguidengjiEntity> ew = new EntityWrapper<WanguiweiguidengjiEntity>();

		PageUtils page = wanguiweiguidengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wanguiweiguidengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WanguiweiguidengjiEntity wanguiweiguidengji, 
		HttpServletRequest request){
        EntityWrapper<WanguiweiguidengjiEntity> ew = new EntityWrapper<WanguiweiguidengjiEntity>();

		PageUtils page = wanguiweiguidengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wanguiweiguidengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WanguiweiguidengjiEntity wanguiweiguidengji){
       	EntityWrapper<WanguiweiguidengjiEntity> ew = new EntityWrapper<WanguiweiguidengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wanguiweiguidengji, "wanguiweiguidengji")); 
        return R.ok().put("data", wanguiweiguidengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WanguiweiguidengjiEntity wanguiweiguidengji){
        EntityWrapper< WanguiweiguidengjiEntity> ew = new EntityWrapper< WanguiweiguidengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wanguiweiguidengji, "wanguiweiguidengji")); 
		WanguiweiguidengjiView wanguiweiguidengjiView =  wanguiweiguidengjiService.selectView(ew);
		return R.ok("查询晚归未归登记成功").put("data", wanguiweiguidengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WanguiweiguidengjiEntity wanguiweiguidengji = wanguiweiguidengjiService.selectById(id);
        return R.ok().put("data", wanguiweiguidengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WanguiweiguidengjiEntity wanguiweiguidengji = wanguiweiguidengjiService.selectById(id);
        return R.ok().put("data", wanguiweiguidengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WanguiweiguidengjiEntity wanguiweiguidengji, HttpServletRequest request){
    	wanguiweiguidengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wanguiweiguidengji);
        wanguiweiguidengjiService.insert(wanguiweiguidengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody WanguiweiguidengjiEntity wanguiweiguidengji, HttpServletRequest request){
    	wanguiweiguidengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wanguiweiguidengji);
        wanguiweiguidengjiService.insert(wanguiweiguidengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WanguiweiguidengjiEntity wanguiweiguidengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wanguiweiguidengji);
        wanguiweiguidengjiService.updateById(wanguiweiguidengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wanguiweiguidengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
