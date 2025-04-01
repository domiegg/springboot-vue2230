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

import com.entity.WailairenyuanEntity;
import com.entity.view.WailairenyuanView;

import com.service.WailairenyuanService;
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
 * 外来人员
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-08 12:49:58
 */
@RestController
@RequestMapping("/wailairenyuan")
public class WailairenyuanController {
    @Autowired
    private WailairenyuanService wailairenyuanService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		WailairenyuanEntity u = wailairenyuanService.selectOne(new EntityWrapper<WailairenyuanEntity>().eq("zhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"wailairenyuan",  "外来人员" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WailairenyuanEntity wailairenyuan){
    	//ValidatorUtils.validateEntity(wailairenyuan);
    	WailairenyuanEntity u = wailairenyuanService.selectOne(new EntityWrapper<WailairenyuanEntity>().eq("zhanghao", wailairenyuan.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		wailairenyuan.setId(uId);
        wailairenyuanService.insert(wailairenyuan);
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
        WailairenyuanEntity u = wailairenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	WailairenyuanEntity u = wailairenyuanService.selectOne(new EntityWrapper<WailairenyuanEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        wailairenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WailairenyuanEntity wailairenyuan,
		HttpServletRequest request){
        EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();

		PageUtils page = wailairenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wailairenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WailairenyuanEntity wailairenyuan, 
		HttpServletRequest request){
        EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();

		PageUtils page = wailairenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wailairenyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WailairenyuanEntity wailairenyuan){
       	EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wailairenyuan, "wailairenyuan")); 
        return R.ok().put("data", wailairenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WailairenyuanEntity wailairenyuan){
        EntityWrapper< WailairenyuanEntity> ew = new EntityWrapper< WailairenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wailairenyuan, "wailairenyuan")); 
		WailairenyuanView wailairenyuanView =  wailairenyuanService.selectView(ew);
		return R.ok("查询外来人员成功").put("data", wailairenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WailairenyuanEntity wailairenyuan = wailairenyuanService.selectById(id);
        return R.ok().put("data", wailairenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WailairenyuanEntity wailairenyuan = wailairenyuanService.selectById(id);
        return R.ok().put("data", wailairenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WailairenyuanEntity wailairenyuan, HttpServletRequest request){
    	wailairenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wailairenyuan);
    	WailairenyuanEntity u = wailairenyuanService.selectOne(new EntityWrapper<WailairenyuanEntity>().eq("zhanghao", wailairenyuan.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		wailairenyuan.setId(new Date().getTime());
        wailairenyuanService.insert(wailairenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WailairenyuanEntity wailairenyuan, HttpServletRequest request){
    	wailairenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wailairenyuan);
    	WailairenyuanEntity u = wailairenyuanService.selectOne(new EntityWrapper<WailairenyuanEntity>().eq("zhanghao", wailairenyuan.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		wailairenyuan.setId(new Date().getTime());
        wailairenyuanService.insert(wailairenyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WailairenyuanEntity wailairenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wailairenyuan);
        wailairenyuanService.updateById(wailairenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wailairenyuanService.deleteBatchIds(Arrays.asList(ids));
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
                    WailairenyuanEntity wailairenyuanEntity =new WailairenyuanEntity();
                    wailairenyuanEntity.setId(new Date().getTime());
                    String zhanghao = CommonUtil.getCellValue(row.getCell(0));
                    wailairenyuanEntity.setZhanghao(zhanghao);
                    String mima = CommonUtil.getCellValue(row.getCell(1));
                    wailairenyuanEntity.setMima(mima);
                    String xingming = CommonUtil.getCellValue(row.getCell(2));
                    wailairenyuanEntity.setXingming(xingming);
                    String nianling = CommonUtil.getCellValue(row.getCell(3));
                    wailairenyuanEntity.setNianling(Integer.parseInt(nianling));
                    String xingbie = CommonUtil.getCellValue(row.getCell(4));
                    wailairenyuanEntity.setXingbie(xingbie);
                    String shouji = CommonUtil.getCellValue(row.getCell(5));
                    wailairenyuanEntity.setShouji(shouji);
                     
                    //想数据库中添加新对象
                    wailairenyuanService.insert(wailairenyuanEntity);//方法
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
        EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();
        List<Map<String, Object>> result = wailairenyuanService.selectValue(params, ew);
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
        EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = wailairenyuanService.selectValue(params, ew);
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
        EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();
        List<Map<String, Object>> result = wailairenyuanService.selectTimeStatValue(params, ew);
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
        EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = wailairenyuanService.selectTimeStatValue(params, ew);
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
        EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();
        List<Map<String, Object>> result = wailairenyuanService.selectGroup(params, ew);
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
    public R count(@RequestParam Map<String, Object> params,WailairenyuanEntity wailairenyuan, HttpServletRequest request){
        EntityWrapper<WailairenyuanEntity> ew = new EntityWrapper<WailairenyuanEntity>();
        int count = wailairenyuanService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wailairenyuan), params), params));
        return R.ok().put("data", count);
    }


}
