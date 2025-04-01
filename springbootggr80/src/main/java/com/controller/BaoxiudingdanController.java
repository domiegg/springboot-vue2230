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

import com.entity.BaoxiudingdanEntity;
import com.entity.view.BaoxiudingdanView;

import com.service.BaoxiudingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 报修订单
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/baoxiudingdan")
public class BaoxiudingdanController {
    @Autowired
    private BaoxiudingdanService baoxiudingdanService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaoxiudingdanEntity baoxiudingdan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			baoxiudingdan.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("weixiurenyuan")) {
			baoxiudingdan.setWeixiuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			baoxiudingdan.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaoxiudingdanEntity> ew = new EntityWrapper<BaoxiudingdanEntity>();

		PageUtils page = baoxiudingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoxiudingdan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaoxiudingdanEntity baoxiudingdan, 
		HttpServletRequest request){
        EntityWrapper<BaoxiudingdanEntity> ew = new EntityWrapper<BaoxiudingdanEntity>();

		PageUtils page = baoxiudingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoxiudingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaoxiudingdanEntity baoxiudingdan){
       	EntityWrapper<BaoxiudingdanEntity> ew = new EntityWrapper<BaoxiudingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baoxiudingdan, "baoxiudingdan")); 
        return R.ok().put("data", baoxiudingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaoxiudingdanEntity baoxiudingdan){
        EntityWrapper< BaoxiudingdanEntity> ew = new EntityWrapper< BaoxiudingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baoxiudingdan, "baoxiudingdan")); 
		BaoxiudingdanView baoxiudingdanView =  baoxiudingdanService.selectView(ew);
		return R.ok("查询报修订单成功").put("data", baoxiudingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaoxiudingdanEntity baoxiudingdan = baoxiudingdanService.selectById(id);
        return R.ok().put("data", baoxiudingdan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaoxiudingdanEntity baoxiudingdan = baoxiudingdanService.selectById(id);
        return R.ok().put("data", baoxiudingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaoxiudingdanEntity baoxiudingdan, HttpServletRequest request){
    	baoxiudingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baoxiudingdan);
        baoxiudingdanService.insert(baoxiudingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody BaoxiudingdanEntity baoxiudingdan, HttpServletRequest request){
    	baoxiudingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baoxiudingdan);
        baoxiudingdanService.insert(baoxiudingdan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaoxiudingdanEntity baoxiudingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baoxiudingdan);
        baoxiudingdanService.updateById(baoxiudingdan);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<BaoxiudingdanEntity> list = new ArrayList<BaoxiudingdanEntity>();
        for(Long id : ids) {
            BaoxiudingdanEntity baoxiudingdan = baoxiudingdanService.selectById(id);
            baoxiudingdan.setSfsh(sfsh);
            baoxiudingdan.setShhf(shhf);
            list.add(baoxiudingdan);
        }
        baoxiudingdanService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baoxiudingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
