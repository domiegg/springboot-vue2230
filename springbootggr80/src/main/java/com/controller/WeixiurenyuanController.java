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

import com.entity.WeixiurenyuanEntity;
import com.entity.view.WeixiurenyuanView;

import com.service.WeixiurenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 维修人员
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/weixiurenyuan")
public class WeixiurenyuanController {
    @Autowired
    private WeixiurenyuanService weixiurenyuanService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"weixiurenyuan",  "维修人员" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WeixiurenyuanEntity weixiurenyuan){
    	//ValidatorUtils.validateEntity(weixiurenyuan);
    	WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", weixiurenyuan.getWeixiuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		weixiurenyuan.setId(uId);
        weixiurenyuanService.insert(weixiurenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        WeixiurenyuanEntity u = weixiurenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        weixiurenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiurenyuanEntity weixiurenyuan,
		HttpServletRequest request){
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();

		PageUtils page = weixiurenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiurenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiurenyuanEntity weixiurenyuan, 
		HttpServletRequest request){
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();

		PageUtils page = weixiurenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiurenyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiurenyuanEntity weixiurenyuan){
       	EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiurenyuan, "weixiurenyuan")); 
        return R.ok().put("data", weixiurenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiurenyuanEntity weixiurenyuan){
        EntityWrapper< WeixiurenyuanEntity> ew = new EntityWrapper< WeixiurenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiurenyuan, "weixiurenyuan")); 
		WeixiurenyuanView weixiurenyuanView =  weixiurenyuanService.selectView(ew);
		return R.ok("查询维修人员成功").put("data", weixiurenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectById(id);
        return R.ok().put("data", weixiurenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectById(id);
        return R.ok().put("data", weixiurenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
    	weixiurenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiurenyuan);
    	WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", weixiurenyuan.getWeixiuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weixiurenyuan.setId(new Date().getTime());
        weixiurenyuanService.insert(weixiurenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
    	weixiurenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiurenyuan);
    	WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", weixiurenyuan.getWeixiuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weixiurenyuan.setId(new Date().getTime());
        weixiurenyuanService.insert(weixiurenyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiurenyuan);
        weixiurenyuanService.updateById(weixiurenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiurenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    WeixiurenyuanEntity weixiurenyuanEntity =new WeixiurenyuanEntity();
                    weixiurenyuanEntity.setId(new Date().getTime());
                    String weixiuzhanghao = CommonUtil.getCellValue(row.getCell(0));
                    weixiurenyuanEntity.setWeixiuzhanghao(weixiuzhanghao);
                    String mima = CommonUtil.getCellValue(row.getCell(1));
                    weixiurenyuanEntity.setMima(mima);
                    String weixiuxingming = CommonUtil.getCellValue(row.getCell(2));
                    weixiurenyuanEntity.setWeixiuxingming(weixiuxingming);
                    String nianling = CommonUtil.getCellValue(row.getCell(3));
                    weixiurenyuanEntity.setNianling(Integer.parseInt(nianling));
                    String xingbie = CommonUtil.getCellValue(row.getCell(4));
                    weixiurenyuanEntity.setXingbie(xingbie);
                    String lianxidianhua = CommonUtil.getCellValue(row.getCell(5));
                    weixiurenyuanEntity.setLianxidianhua(lianxidianhua);
                     
                    //想数据库中添加新对象
                    weixiurenyuanService.insert(weixiurenyuanEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }

    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();
        List<Map<String, Object>> result = weixiurenyuanService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = weixiurenyuanService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();
        List<Map<String, Object>> result = weixiurenyuanService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = weixiurenyuanService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();
        List<Map<String, Object>> result = weixiurenyuanService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();
        int count = weixiurenyuanService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiurenyuan), params), params));
        return R.ok().put("data", count);
    }


}
