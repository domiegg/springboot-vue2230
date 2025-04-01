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

import com.entity.XueshengjinchususheEntity;
import com.entity.view.XueshengjinchususheView;

import com.service.XueshengjinchususheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生进出宿舍
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/xueshengjinchusushe")
public class XueshengjinchususheController {
    @Autowired
    private XueshengjinchususheService xueshengjinchususheService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengjinchususheEntity xueshengjinchusushe,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengjinchusushe.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			xueshengjinchusushe.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengjinchususheEntity> ew = new EntityWrapper<XueshengjinchususheEntity>();

		PageUtils page = xueshengjinchususheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengjinchusushe), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengjinchususheEntity xueshengjinchusushe, 
		HttpServletRequest request){
        EntityWrapper<XueshengjinchususheEntity> ew = new EntityWrapper<XueshengjinchususheEntity>();

		PageUtils page = xueshengjinchususheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengjinchusushe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengjinchususheEntity xueshengjinchusushe){
       	EntityWrapper<XueshengjinchususheEntity> ew = new EntityWrapper<XueshengjinchususheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengjinchusushe, "xueshengjinchusushe")); 
        return R.ok().put("data", xueshengjinchususheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengjinchususheEntity xueshengjinchusushe){
        EntityWrapper< XueshengjinchususheEntity> ew = new EntityWrapper< XueshengjinchususheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengjinchusushe, "xueshengjinchusushe")); 
		XueshengjinchususheView xueshengjinchususheView =  xueshengjinchususheService.selectView(ew);
		return R.ok("查询学生进出宿舍成功").put("data", xueshengjinchususheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengjinchususheEntity xueshengjinchusushe = xueshengjinchususheService.selectById(id);
        return R.ok().put("data", xueshengjinchusushe);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengjinchususheEntity xueshengjinchusushe = xueshengjinchususheService.selectById(id);
        return R.ok().put("data", xueshengjinchusushe);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengjinchususheEntity xueshengjinchusushe, HttpServletRequest request){
    	xueshengjinchusushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengjinchusushe);
        xueshengjinchususheService.insert(xueshengjinchusushe);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody XueshengjinchususheEntity xueshengjinchusushe, HttpServletRequest request){
    	xueshengjinchusushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengjinchusushe);
        xueshengjinchususheService.insert(xueshengjinchusushe);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengjinchususheEntity xueshengjinchusushe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengjinchusushe);
        xueshengjinchususheService.updateById(xueshengjinchusushe);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengjinchususheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
