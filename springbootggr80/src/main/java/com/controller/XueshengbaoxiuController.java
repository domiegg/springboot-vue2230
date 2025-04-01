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

import com.entity.XueshengbaoxiuEntity;
import com.entity.view.XueshengbaoxiuView;

import com.service.XueshengbaoxiuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生报修
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/xueshengbaoxiu")
public class XueshengbaoxiuController {
    @Autowired
    private XueshengbaoxiuService xueshengbaoxiuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengbaoxiuEntity xueshengbaoxiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengbaoxiu.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			xueshengbaoxiu.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengbaoxiuEntity> ew = new EntityWrapper<XueshengbaoxiuEntity>();

		PageUtils page = xueshengbaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengbaoxiu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengbaoxiuEntity xueshengbaoxiu, 
		HttpServletRequest request){
        EntityWrapper<XueshengbaoxiuEntity> ew = new EntityWrapper<XueshengbaoxiuEntity>();

		PageUtils page = xueshengbaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengbaoxiu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengbaoxiuEntity xueshengbaoxiu){
       	EntityWrapper<XueshengbaoxiuEntity> ew = new EntityWrapper<XueshengbaoxiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengbaoxiu, "xueshengbaoxiu")); 
        return R.ok().put("data", xueshengbaoxiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengbaoxiuEntity xueshengbaoxiu){
        EntityWrapper< XueshengbaoxiuEntity> ew = new EntityWrapper< XueshengbaoxiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengbaoxiu, "xueshengbaoxiu")); 
		XueshengbaoxiuView xueshengbaoxiuView =  xueshengbaoxiuService.selectView(ew);
		return R.ok("查询学生报修成功").put("data", xueshengbaoxiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengbaoxiuEntity xueshengbaoxiu = xueshengbaoxiuService.selectById(id);
        return R.ok().put("data", xueshengbaoxiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengbaoxiuEntity xueshengbaoxiu = xueshengbaoxiuService.selectById(id);
        return R.ok().put("data", xueshengbaoxiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengbaoxiuEntity xueshengbaoxiu, HttpServletRequest request){
    	xueshengbaoxiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengbaoxiu);
        xueshengbaoxiuService.insert(xueshengbaoxiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody XueshengbaoxiuEntity xueshengbaoxiu, HttpServletRequest request){
    	xueshengbaoxiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengbaoxiu);
        xueshengbaoxiuService.insert(xueshengbaoxiu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengbaoxiuEntity xueshengbaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengbaoxiu);
        xueshengbaoxiuService.updateById(xueshengbaoxiu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XueshengbaoxiuEntity> list = new ArrayList<XueshengbaoxiuEntity>();
        for(Long id : ids) {
            XueshengbaoxiuEntity xueshengbaoxiu = xueshengbaoxiuService.selectById(id);
            xueshengbaoxiu.setSfsh(sfsh);
            xueshengbaoxiu.setShhf(shhf);
            list.add(xueshengbaoxiu);
        }
        xueshengbaoxiuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengbaoxiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
