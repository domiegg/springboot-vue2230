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

import com.entity.GonggongwupinEntity;
import com.entity.view.GonggongwupinView;

import com.service.GonggongwupinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 公共物品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/gonggongwupin")
public class GonggongwupinController {
    @Autowired
    private GonggongwupinService gonggongwupinService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GonggongwupinEntity gonggongwupin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("suguan")) {
			gonggongwupin.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GonggongwupinEntity> ew = new EntityWrapper<GonggongwupinEntity>();

		PageUtils page = gonggongwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggongwupin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GonggongwupinEntity gonggongwupin, 
		HttpServletRequest request){
        EntityWrapper<GonggongwupinEntity> ew = new EntityWrapper<GonggongwupinEntity>();

		PageUtils page = gonggongwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggongwupin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GonggongwupinEntity gonggongwupin){
       	EntityWrapper<GonggongwupinEntity> ew = new EntityWrapper<GonggongwupinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gonggongwupin, "gonggongwupin")); 
        return R.ok().put("data", gonggongwupinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GonggongwupinEntity gonggongwupin){
        EntityWrapper< GonggongwupinEntity> ew = new EntityWrapper< GonggongwupinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gonggongwupin, "gonggongwupin")); 
		GonggongwupinView gonggongwupinView =  gonggongwupinService.selectView(ew);
		return R.ok("查询公共物品成功").put("data", gonggongwupinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GonggongwupinEntity gonggongwupin = gonggongwupinService.selectById(id);
		gonggongwupin.setClicknum(gonggongwupin.getClicknum()+1);
		gonggongwupin.setClicktime(new Date());
		gonggongwupinService.updateById(gonggongwupin);
        return R.ok().put("data", gonggongwupin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GonggongwupinEntity gonggongwupin = gonggongwupinService.selectById(id);
		gonggongwupin.setClicknum(gonggongwupin.getClicknum()+1);
		gonggongwupin.setClicktime(new Date());
		gonggongwupinService.updateById(gonggongwupin);
        return R.ok().put("data", gonggongwupin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GonggongwupinEntity gonggongwupin, HttpServletRequest request){
    	gonggongwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonggongwupin);
        gonggongwupinService.insert(gonggongwupin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GonggongwupinEntity gonggongwupin, HttpServletRequest request){
    	gonggongwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonggongwupin);
        gonggongwupinService.insert(gonggongwupin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GonggongwupinEntity gonggongwupin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggongwupin);
        gonggongwupinService.updateById(gonggongwupin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gonggongwupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GonggongwupinEntity gonggongwupin, HttpServletRequest request,String pre){
        EntityWrapper<GonggongwupinEntity> ew = new EntityWrapper<GonggongwupinEntity>();
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
		PageUtils page = gonggongwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggongwupin), params), params));
        return R.ok().put("data", page);
    }









}
