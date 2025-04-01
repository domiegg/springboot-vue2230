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

import com.entity.XueshengqingjiaEntity;
import com.entity.view.XueshengqingjiaView;

import com.service.XueshengqingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生请假
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/xueshengqingjia")
public class XueshengqingjiaController {
    @Autowired
    private XueshengqingjiaService xueshengqingjiaService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengqingjiaEntity xueshengqingjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengqingjia.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			xueshengqingjia.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengqingjiaEntity> ew = new EntityWrapper<XueshengqingjiaEntity>();

		PageUtils page = xueshengqingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengqingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengqingjiaEntity xueshengqingjia, 
		HttpServletRequest request){
        EntityWrapper<XueshengqingjiaEntity> ew = new EntityWrapper<XueshengqingjiaEntity>();

		PageUtils page = xueshengqingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengqingjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengqingjiaEntity xueshengqingjia){
       	EntityWrapper<XueshengqingjiaEntity> ew = new EntityWrapper<XueshengqingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengqingjia, "xueshengqingjia")); 
        return R.ok().put("data", xueshengqingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengqingjiaEntity xueshengqingjia){
        EntityWrapper< XueshengqingjiaEntity> ew = new EntityWrapper< XueshengqingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengqingjia, "xueshengqingjia")); 
		XueshengqingjiaView xueshengqingjiaView =  xueshengqingjiaService.selectView(ew);
		return R.ok("查询学生请假成功").put("data", xueshengqingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengqingjiaEntity xueshengqingjia = xueshengqingjiaService.selectById(id);
        return R.ok().put("data", xueshengqingjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengqingjiaEntity xueshengqingjia = xueshengqingjiaService.selectById(id);
        return R.ok().put("data", xueshengqingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengqingjiaEntity xueshengqingjia, HttpServletRequest request){
    	xueshengqingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengqingjia);
        xueshengqingjiaService.insert(xueshengqingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody XueshengqingjiaEntity xueshengqingjia, HttpServletRequest request){
    	xueshengqingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengqingjia);
        xueshengqingjiaService.insert(xueshengqingjia);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengqingjiaEntity xueshengqingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengqingjia);
        xueshengqingjiaService.updateById(xueshengqingjia);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XueshengqingjiaEntity> list = new ArrayList<XueshengqingjiaEntity>();
        for(Long id : ids) {
            XueshengqingjiaEntity xueshengqingjia = xueshengqingjiaService.selectById(id);
            xueshengqingjia.setSfsh(sfsh);
            xueshengqingjia.setShhf(shhf);
            list.add(xueshengqingjia);
        }
        xueshengqingjiaService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengqingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
