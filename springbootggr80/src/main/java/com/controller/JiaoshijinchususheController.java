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

import com.entity.JiaoshijinchususheEntity;
import com.entity.view.JiaoshijinchususheView;

import com.service.JiaoshijinchususheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 教师进出宿舍
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/jiaoshijinchusushe")
public class JiaoshijinchususheController {
    @Autowired
    private JiaoshijinchususheService jiaoshijinchususheService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoshijinchususheEntity jiaoshijinchusushe,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jiaoshijinchusushe.setJiaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			jiaoshijinchusushe.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaoshijinchususheEntity> ew = new EntityWrapper<JiaoshijinchususheEntity>();

		PageUtils page = jiaoshijinchususheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoshijinchusushe), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoshijinchususheEntity jiaoshijinchusushe, 
		HttpServletRequest request){
        EntityWrapper<JiaoshijinchususheEntity> ew = new EntityWrapper<JiaoshijinchususheEntity>();

		PageUtils page = jiaoshijinchususheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoshijinchusushe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoshijinchususheEntity jiaoshijinchusushe){
       	EntityWrapper<JiaoshijinchususheEntity> ew = new EntityWrapper<JiaoshijinchususheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoshijinchusushe, "jiaoshijinchusushe")); 
        return R.ok().put("data", jiaoshijinchususheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoshijinchususheEntity jiaoshijinchusushe){
        EntityWrapper< JiaoshijinchususheEntity> ew = new EntityWrapper< JiaoshijinchususheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoshijinchusushe, "jiaoshijinchusushe")); 
		JiaoshijinchususheView jiaoshijinchususheView =  jiaoshijinchususheService.selectView(ew);
		return R.ok("查询教师进出宿舍成功").put("data", jiaoshijinchususheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoshijinchususheEntity jiaoshijinchusushe = jiaoshijinchususheService.selectById(id);
        return R.ok().put("data", jiaoshijinchusushe);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoshijinchususheEntity jiaoshijinchusushe = jiaoshijinchususheService.selectById(id);
        return R.ok().put("data", jiaoshijinchusushe);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoshijinchususheEntity jiaoshijinchusushe, HttpServletRequest request){
    	jiaoshijinchusushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoshijinchusushe);
        jiaoshijinchususheService.insert(jiaoshijinchusushe);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody JiaoshijinchususheEntity jiaoshijinchusushe, HttpServletRequest request){
    	jiaoshijinchusushe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoshijinchusushe);
        jiaoshijinchususheService.insert(jiaoshijinchusushe);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaoshijinchususheEntity jiaoshijinchusushe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoshijinchusushe);
        jiaoshijinchususheService.updateById(jiaoshijinchusushe);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoshijinchususheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
