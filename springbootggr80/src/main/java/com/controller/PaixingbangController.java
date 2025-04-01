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

import com.entity.PaixingbangEntity;
import com.entity.view.PaixingbangView;

import com.service.PaixingbangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 排行榜
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/paixingbang")
public class PaixingbangController {
    @Autowired
    private PaixingbangService paixingbangService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaixingbangEntity paixingbang,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		paixingbang.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<PaixingbangEntity> ew = new EntityWrapper<PaixingbangEntity>();

		PageUtils page = paixingbangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paixingbang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaixingbangEntity paixingbang, 
		HttpServletRequest request){
        EntityWrapper<PaixingbangEntity> ew = new EntityWrapper<PaixingbangEntity>();

		PageUtils page = paixingbangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paixingbang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaixingbangEntity paixingbang){
       	EntityWrapper<PaixingbangEntity> ew = new EntityWrapper<PaixingbangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paixingbang, "paixingbang")); 
        return R.ok().put("data", paixingbangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PaixingbangEntity paixingbang){
        EntityWrapper< PaixingbangEntity> ew = new EntityWrapper< PaixingbangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paixingbang, "paixingbang")); 
		PaixingbangView paixingbangView =  paixingbangService.selectView(ew);
		return R.ok("查询排行榜成功").put("data", paixingbangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaixingbangEntity paixingbang = paixingbangService.selectById(id);
        return R.ok().put("data", paixingbang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaixingbangEntity paixingbang = paixingbangService.selectById(id);
        return R.ok().put("data", paixingbang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaixingbangEntity paixingbang, HttpServletRequest request){
    	paixingbang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paixingbang);
    	paixingbang.setUserid((Long)request.getSession().getAttribute("userId"));
        paixingbangService.insert(paixingbang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody PaixingbangEntity paixingbang, HttpServletRequest request){
    	paixingbang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paixingbang);
        paixingbangService.insert(paixingbang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PaixingbangEntity paixingbang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paixingbang);
        paixingbangService.updateById(paixingbang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paixingbangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
