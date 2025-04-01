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

import com.entity.ShiwuzhaolingEntity;
import com.entity.view.ShiwuzhaolingView;

import com.service.ShiwuzhaolingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 失物招领
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/shiwuzhaoling")
public class ShiwuzhaolingController {
    @Autowired
    private ShiwuzhaolingService shiwuzhaolingService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiwuzhaolingEntity shiwuzhaoling,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shiwuzhaoling.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			shiwuzhaoling.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShiwuzhaolingEntity> ew = new EntityWrapper<ShiwuzhaolingEntity>();

		PageUtils page = shiwuzhaolingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwuzhaoling), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiwuzhaolingEntity shiwuzhaoling, 
		HttpServletRequest request){
        EntityWrapper<ShiwuzhaolingEntity> ew = new EntityWrapper<ShiwuzhaolingEntity>();

		PageUtils page = shiwuzhaolingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwuzhaoling), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiwuzhaolingEntity shiwuzhaoling){
       	EntityWrapper<ShiwuzhaolingEntity> ew = new EntityWrapper<ShiwuzhaolingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiwuzhaoling, "shiwuzhaoling")); 
        return R.ok().put("data", shiwuzhaolingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiwuzhaolingEntity shiwuzhaoling){
        EntityWrapper< ShiwuzhaolingEntity> ew = new EntityWrapper< ShiwuzhaolingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiwuzhaoling, "shiwuzhaoling")); 
		ShiwuzhaolingView shiwuzhaolingView =  shiwuzhaolingService.selectView(ew);
		return R.ok("查询失物招领成功").put("data", shiwuzhaolingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiwuzhaolingEntity shiwuzhaoling = shiwuzhaolingService.selectById(id);
		shiwuzhaoling.setClicknum(shiwuzhaoling.getClicknum()+1);
		shiwuzhaoling.setClicktime(new Date());
		shiwuzhaolingService.updateById(shiwuzhaoling);
        return R.ok().put("data", shiwuzhaoling);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiwuzhaolingEntity shiwuzhaoling = shiwuzhaolingService.selectById(id);
		shiwuzhaoling.setClicknum(shiwuzhaoling.getClicknum()+1);
		shiwuzhaoling.setClicktime(new Date());
		shiwuzhaolingService.updateById(shiwuzhaoling);
        return R.ok().put("data", shiwuzhaoling);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiwuzhaolingEntity shiwuzhaoling, HttpServletRequest request){
    	shiwuzhaoling.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiwuzhaoling);
        shiwuzhaolingService.insert(shiwuzhaoling);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ShiwuzhaolingEntity shiwuzhaoling, HttpServletRequest request){
    	shiwuzhaoling.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiwuzhaoling);
        shiwuzhaolingService.insert(shiwuzhaoling);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiwuzhaolingEntity shiwuzhaoling, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiwuzhaoling);
        shiwuzhaolingService.updateById(shiwuzhaoling);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShiwuzhaolingEntity> list = new ArrayList<ShiwuzhaolingEntity>();
        for(Long id : ids) {
            ShiwuzhaolingEntity shiwuzhaoling = shiwuzhaolingService.selectById(id);
            shiwuzhaoling.setSfsh(sfsh);
            shiwuzhaoling.setShhf(shhf);
            list.add(shiwuzhaoling);
        }
        shiwuzhaolingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiwuzhaolingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShiwuzhaolingEntity shiwuzhaoling, HttpServletRequest request,String pre){
        EntityWrapper<ShiwuzhaolingEntity> ew = new EntityWrapper<ShiwuzhaolingEntity>();
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
		PageUtils page = shiwuzhaolingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwuzhaoling), params), params));
        return R.ok().put("data", page);
    }









}
