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

import com.entity.XueshengwupinEntity;
import com.entity.view.XueshengwupinView;

import com.service.XueshengwupinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生物品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/xueshengwupin")
public class XueshengwupinController {
    @Autowired
    private XueshengwupinService xueshengwupinService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengwupinEntity xueshengwupin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengwupin.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			xueshengwupin.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengwupinEntity> ew = new EntityWrapper<XueshengwupinEntity>();

		PageUtils page = xueshengwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengwupin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengwupinEntity xueshengwupin, 
		HttpServletRequest request){
        EntityWrapper<XueshengwupinEntity> ew = new EntityWrapper<XueshengwupinEntity>();

		PageUtils page = xueshengwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengwupin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengwupinEntity xueshengwupin){
       	EntityWrapper<XueshengwupinEntity> ew = new EntityWrapper<XueshengwupinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengwupin, "xueshengwupin")); 
        return R.ok().put("data", xueshengwupinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengwupinEntity xueshengwupin){
        EntityWrapper< XueshengwupinEntity> ew = new EntityWrapper< XueshengwupinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengwupin, "xueshengwupin")); 
		XueshengwupinView xueshengwupinView =  xueshengwupinService.selectView(ew);
		return R.ok("查询学生物品成功").put("data", xueshengwupinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengwupinEntity xueshengwupin = xueshengwupinService.selectById(id);
        return R.ok().put("data", xueshengwupin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengwupinEntity xueshengwupin = xueshengwupinService.selectById(id);
        return R.ok().put("data", xueshengwupin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengwupinEntity xueshengwupin, HttpServletRequest request){
    	xueshengwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengwupin);
        xueshengwupinService.insert(xueshengwupin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengwupinEntity xueshengwupin, HttpServletRequest request){
    	xueshengwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengwupin);
        xueshengwupinService.insert(xueshengwupin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengwupinEntity xueshengwupin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengwupin);
        xueshengwupinService.updateById(xueshengwupin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengwupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
