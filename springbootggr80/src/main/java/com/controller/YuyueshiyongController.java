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

import com.entity.YuyueshiyongEntity;
import com.entity.view.YuyueshiyongView;

import com.service.YuyueshiyongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约使用
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/yuyueshiyong")
public class YuyueshiyongController {
    @Autowired
    private YuyueshiyongService yuyueshiyongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyueshiyongEntity yuyueshiyong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			yuyueshiyong.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			yuyueshiyong.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyueshiyongEntity> ew = new EntityWrapper<YuyueshiyongEntity>();

		PageUtils page = yuyueshiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyueshiyong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyueshiyongEntity yuyueshiyong, 
		HttpServletRequest request){
        EntityWrapper<YuyueshiyongEntity> ew = new EntityWrapper<YuyueshiyongEntity>();

		PageUtils page = yuyueshiyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyueshiyong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyueshiyongEntity yuyueshiyong){
       	EntityWrapper<YuyueshiyongEntity> ew = new EntityWrapper<YuyueshiyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyueshiyong, "yuyueshiyong")); 
        return R.ok().put("data", yuyueshiyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyueshiyongEntity yuyueshiyong){
        EntityWrapper< YuyueshiyongEntity> ew = new EntityWrapper< YuyueshiyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyueshiyong, "yuyueshiyong")); 
		YuyueshiyongView yuyueshiyongView =  yuyueshiyongService.selectView(ew);
		return R.ok("查询预约使用成功").put("data", yuyueshiyongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyueshiyongEntity yuyueshiyong = yuyueshiyongService.selectById(id);
        return R.ok().put("data", yuyueshiyong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyueshiyongEntity yuyueshiyong = yuyueshiyongService.selectById(id);
        return R.ok().put("data", yuyueshiyong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyueshiyongEntity yuyueshiyong, HttpServletRequest request){
    	yuyueshiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyueshiyong);
        yuyueshiyongService.insert(yuyueshiyong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyueshiyongEntity yuyueshiyong, HttpServletRequest request){
    	yuyueshiyong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyueshiyong);
        yuyueshiyongService.insert(yuyueshiyong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyueshiyongEntity yuyueshiyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyueshiyong);
        yuyueshiyongService.updateById(yuyueshiyong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YuyueshiyongEntity> list = new ArrayList<YuyueshiyongEntity>();
        for(Long id : ids) {
            YuyueshiyongEntity yuyueshiyong = yuyueshiyongService.selectById(id);
            yuyueshiyong.setSfsh(sfsh);
            yuyueshiyong.setShhf(shhf);
            list.add(yuyueshiyong);
        }
        yuyueshiyongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyueshiyongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
