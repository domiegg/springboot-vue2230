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

import com.entity.DaoyuanquerenEntity;
import com.entity.view.DaoyuanquerenView;

import com.service.DaoyuanquerenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 导员确认
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/daoyuanqueren")
public class DaoyuanquerenController {
    @Autowired
    private DaoyuanquerenService daoyuanquerenService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaoyuanquerenEntity daoyuanqueren,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("wailairenyuan")) {
			daoyuanqueren.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			daoyuanqueren.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			daoyuanqueren.setJiaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DaoyuanquerenEntity> ew = new EntityWrapper<DaoyuanquerenEntity>();

		PageUtils page = daoyuanquerenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyuanqueren), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaoyuanquerenEntity daoyuanqueren, 
		HttpServletRequest request){
        EntityWrapper<DaoyuanquerenEntity> ew = new EntityWrapper<DaoyuanquerenEntity>();

		PageUtils page = daoyuanquerenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyuanqueren), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaoyuanquerenEntity daoyuanqueren){
       	EntityWrapper<DaoyuanquerenEntity> ew = new EntityWrapper<DaoyuanquerenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daoyuanqueren, "daoyuanqueren")); 
        return R.ok().put("data", daoyuanquerenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaoyuanquerenEntity daoyuanqueren){
        EntityWrapper< DaoyuanquerenEntity> ew = new EntityWrapper< DaoyuanquerenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daoyuanqueren, "daoyuanqueren")); 
		DaoyuanquerenView daoyuanquerenView =  daoyuanquerenService.selectView(ew);
		return R.ok("查询导员确认成功").put("data", daoyuanquerenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaoyuanquerenEntity daoyuanqueren = daoyuanquerenService.selectById(id);
        return R.ok().put("data", daoyuanqueren);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaoyuanquerenEntity daoyuanqueren = daoyuanquerenService.selectById(id);
        return R.ok().put("data", daoyuanqueren);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaoyuanquerenEntity daoyuanqueren, HttpServletRequest request){
    	daoyuanqueren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyuanqueren);
        daoyuanquerenService.insert(daoyuanqueren);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaoyuanquerenEntity daoyuanqueren, HttpServletRequest request){
    	daoyuanqueren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyuanqueren);
        daoyuanquerenService.insert(daoyuanqueren);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DaoyuanquerenEntity daoyuanqueren, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daoyuanqueren);
        daoyuanquerenService.updateById(daoyuanqueren);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<DaoyuanquerenEntity> list = new ArrayList<DaoyuanquerenEntity>();
        for(Long id : ids) {
            DaoyuanquerenEntity daoyuanqueren = daoyuanquerenService.selectById(id);
            daoyuanqueren.setSfsh(sfsh);
            daoyuanqueren.setShhf(shhf);
            list.add(daoyuanqueren);
        }
        daoyuanquerenService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daoyuanquerenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
