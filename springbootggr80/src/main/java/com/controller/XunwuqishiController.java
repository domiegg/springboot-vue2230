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

import com.entity.XunwuqishiEntity;
import com.entity.view.XunwuqishiView;

import com.service.XunwuqishiService;
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
 * 寻物启事
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:59
 */
@RestController
@RequestMapping("/xunwuqishi")
public class XunwuqishiController {
    @Autowired
    private XunwuqishiService xunwuqishiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XunwuqishiEntity xunwuqishi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xunwuqishi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("suguan")) {
			xunwuqishi.setSuguanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XunwuqishiEntity> ew = new EntityWrapper<XunwuqishiEntity>();

		PageUtils page = xunwuqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunwuqishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XunwuqishiEntity xunwuqishi, 
		HttpServletRequest request){
        EntityWrapper<XunwuqishiEntity> ew = new EntityWrapper<XunwuqishiEntity>();

		PageUtils page = xunwuqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunwuqishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XunwuqishiEntity xunwuqishi){
       	EntityWrapper<XunwuqishiEntity> ew = new EntityWrapper<XunwuqishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xunwuqishi, "xunwuqishi")); 
        return R.ok().put("data", xunwuqishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XunwuqishiEntity xunwuqishi){
        EntityWrapper< XunwuqishiEntity> ew = new EntityWrapper< XunwuqishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xunwuqishi, "xunwuqishi")); 
		XunwuqishiView xunwuqishiView =  xunwuqishiService.selectView(ew);
		return R.ok("查询寻物启事成功").put("data", xunwuqishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XunwuqishiEntity xunwuqishi = xunwuqishiService.selectById(id);
		xunwuqishi.setClicknum(xunwuqishi.getClicknum()+1);
		xunwuqishi.setClicktime(new Date());
		xunwuqishiService.updateById(xunwuqishi);
        return R.ok().put("data", xunwuqishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XunwuqishiEntity xunwuqishi = xunwuqishiService.selectById(id);
		xunwuqishi.setClicknum(xunwuqishi.getClicknum()+1);
		xunwuqishi.setClicktime(new Date());
		xunwuqishiService.updateById(xunwuqishi);
        return R.ok().put("data", xunwuqishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XunwuqishiEntity xunwuqishi, HttpServletRequest request){
    	xunwuqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xunwuqishi);
        xunwuqishiService.insert(xunwuqishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XunwuqishiEntity xunwuqishi, HttpServletRequest request){
    	xunwuqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xunwuqishi);
        xunwuqishiService.insert(xunwuqishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XunwuqishiEntity xunwuqishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xunwuqishi);
        xunwuqishiService.updateById(xunwuqishi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XunwuqishiEntity> list = new ArrayList<XunwuqishiEntity>();
        for(Long id : ids) {
            XunwuqishiEntity xunwuqishi = xunwuqishiService.selectById(id);
            xunwuqishi.setSfsh(sfsh);
            xunwuqishi.setShhf(shhf);
            list.add(xunwuqishi);
        }
        xunwuqishiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xunwuqishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XunwuqishiEntity xunwuqishi, HttpServletRequest request,String pre){
        EntityWrapper<XunwuqishiEntity> ew = new EntityWrapper<XunwuqishiEntity>();
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
		PageUtils page = xunwuqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunwuqishi), params), params));
        return R.ok().put("data", page);
    }









}
