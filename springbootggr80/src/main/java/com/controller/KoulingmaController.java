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

import com.entity.KoulingmaEntity;
import com.entity.view.KoulingmaView;

import com.service.KoulingmaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 口令码
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/koulingma")
public class KoulingmaController {
    @Autowired
    private KoulingmaService koulingmaService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KoulingmaEntity koulingma,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			koulingma.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			koulingma.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KoulingmaEntity> ew = new EntityWrapper<KoulingmaEntity>();

		PageUtils page = koulingmaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, koulingma), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KoulingmaEntity koulingma, 
		HttpServletRequest request){
        EntityWrapper<KoulingmaEntity> ew = new EntityWrapper<KoulingmaEntity>();

		PageUtils page = koulingmaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, koulingma), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KoulingmaEntity koulingma){
       	EntityWrapper<KoulingmaEntity> ew = new EntityWrapper<KoulingmaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( koulingma, "koulingma")); 
        return R.ok().put("data", koulingmaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KoulingmaEntity koulingma){
        EntityWrapper< KoulingmaEntity> ew = new EntityWrapper< KoulingmaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( koulingma, "koulingma")); 
		KoulingmaView koulingmaView =  koulingmaService.selectView(ew);
		return R.ok("查询口令码成功").put("data", koulingmaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KoulingmaEntity koulingma = koulingmaService.selectById(id);
        return R.ok().put("data", koulingma);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KoulingmaEntity koulingma = koulingmaService.selectById(id);
        return R.ok().put("data", koulingma);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KoulingmaEntity koulingma, HttpServletRequest request){
    	koulingma.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(koulingma);
        koulingmaService.insert(koulingma);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody KoulingmaEntity koulingma, HttpServletRequest request){
    	koulingma.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(koulingma);
        koulingmaService.insert(koulingma);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KoulingmaEntity koulingma, HttpServletRequest request){
        //ValidatorUtils.validateEntity(koulingma);
        koulingmaService.updateById(koulingma);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        koulingmaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
