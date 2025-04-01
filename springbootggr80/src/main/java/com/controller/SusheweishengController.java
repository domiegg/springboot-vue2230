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

import com.entity.SusheweishengEntity;
import com.entity.view.SusheweishengView;

import com.service.SusheweishengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 宿舍卫生
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/susheweisheng")
public class SusheweishengController {
    @Autowired
    private SusheweishengService susheweishengService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SusheweishengEntity susheweisheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("suguan")) {
			susheweisheng.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SusheweishengEntity> ew = new EntityWrapper<SusheweishengEntity>();

		PageUtils page = susheweishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, susheweisheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SusheweishengEntity susheweisheng, 
		HttpServletRequest request){
        EntityWrapper<SusheweishengEntity> ew = new EntityWrapper<SusheweishengEntity>();

		PageUtils page = susheweishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, susheweisheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SusheweishengEntity susheweisheng){
       	EntityWrapper<SusheweishengEntity> ew = new EntityWrapper<SusheweishengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( susheweisheng, "susheweisheng")); 
        return R.ok().put("data", susheweishengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SusheweishengEntity susheweisheng){
        EntityWrapper< SusheweishengEntity> ew = new EntityWrapper< SusheweishengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( susheweisheng, "susheweisheng")); 
		SusheweishengView susheweishengView =  susheweishengService.selectView(ew);
		return R.ok("查询宿舍卫生成功").put("data", susheweishengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SusheweishengEntity susheweisheng = susheweishengService.selectById(id);
		susheweisheng.setClicknum(susheweisheng.getClicknum()+1);
		susheweisheng.setClicktime(new Date());
		susheweishengService.updateById(susheweisheng);
        return R.ok().put("data", susheweisheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SusheweishengEntity susheweisheng = susheweishengService.selectById(id);
		susheweisheng.setClicknum(susheweisheng.getClicknum()+1);
		susheweisheng.setClicktime(new Date());
		susheweishengService.updateById(susheweisheng);
        return R.ok().put("data", susheweisheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SusheweishengEntity susheweisheng, HttpServletRequest request){
    	susheweisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(susheweisheng);
        susheweishengService.insert(susheweisheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SusheweishengEntity susheweisheng, HttpServletRequest request){
    	susheweisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(susheweisheng);
        susheweishengService.insert(susheweisheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SusheweishengEntity susheweisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(susheweisheng);
        susheweishengService.updateById(susheweisheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        susheweishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SusheweishengEntity susheweisheng, HttpServletRequest request,String pre){
        EntityWrapper<SusheweishengEntity> ew = new EntityWrapper<SusheweishengEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = susheweishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, susheweisheng), params), params));
        return R.ok().put("data", page);
    }









}
