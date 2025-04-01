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

import com.entity.ShenqingxinxiEntity;
import com.entity.view.ShenqingxinxiView;

import com.service.ShenqingxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 申请信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/shenqingxinxi")
public class ShenqingxinxiController {
    @Autowired
    private ShenqingxinxiService shenqingxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingxinxiEntity shenqingxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("wailairenyuan")) {
			shenqingxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			shenqingxinxi.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenqingxinxiEntity> ew = new EntityWrapper<ShenqingxinxiEntity>();

		PageUtils page = shenqingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenqingxinxiEntity shenqingxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShenqingxinxiEntity> ew = new EntityWrapper<ShenqingxinxiEntity>();

		PageUtils page = shenqingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingxinxiEntity shenqingxinxi){
       	EntityWrapper<ShenqingxinxiEntity> ew = new EntityWrapper<ShenqingxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingxinxi, "shenqingxinxi")); 
        return R.ok().put("data", shenqingxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingxinxiEntity shenqingxinxi){
        EntityWrapper< ShenqingxinxiEntity> ew = new EntityWrapper< ShenqingxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingxinxi, "shenqingxinxi")); 
		ShenqingxinxiView shenqingxinxiView =  shenqingxinxiService.selectView(ew);
		return R.ok("查询申请信息成功").put("data", shenqingxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingxinxiEntity shenqingxinxi = shenqingxinxiService.selectById(id);
        return R.ok().put("data", shenqingxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingxinxiEntity shenqingxinxi = shenqingxinxiService.selectById(id);
        return R.ok().put("data", shenqingxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShenqingxinxiEntity shenqingxinxi, HttpServletRequest request){
    	shenqingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingxinxi);
        shenqingxinxiService.insert(shenqingxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingxinxiEntity shenqingxinxi, HttpServletRequest request){
    	shenqingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingxinxi);
        shenqingxinxiService.insert(shenqingxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShenqingxinxiEntity shenqingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingxinxi);
        shenqingxinxiService.updateById(shenqingxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShenqingxinxiEntity> list = new ArrayList<ShenqingxinxiEntity>();
        for(Long id : ids) {
            ShenqingxinxiEntity shenqingxinxi = shenqingxinxiService.selectById(id);
            shenqingxinxi.setSfsh(sfsh);
            shenqingxinxi.setShhf(shhf);
            list.add(shenqingxinxi);
        }
        shenqingxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shenqingxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
