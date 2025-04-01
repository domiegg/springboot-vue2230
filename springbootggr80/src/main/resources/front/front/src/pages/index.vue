<template>
	<div class="main-containers">
		<div class="top-container" :style='{"boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","padding":"0px","margin":"0 auto","overflow":"hidden","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221028/83b96336016c4895aa387cda7fa006ae.png) fixed","display":"flex","width":"100%","position":"relative","justifyContent":"flex-end","height":"75px","zIndex":"1002"}'>
			<img v-if='false' :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"block","height":"44px"}' src='http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg'>
			<div v-if="true" :style='{"margin":"0 autol 12px","color":"rgba(64, 158, 255, 1)","textAlign":"center","left":"10%","background":"none","display":"inline-block","width":"75%","fontSize":"32px","position":"absolute","fontWeight":"bold"}'>智慧学生校舍系统</div>
			<div>
				<div v-if="true" :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#666","display":"inline-block","zIndex":"999"}'></div>
				<div v-if="Token" :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#666","display":"inline-block","zIndex":"999"}'>{{username}}</div>
				<el-button v-if="!Token" @click="toLogin()" :style='{"border":"1px solid #1773c1","padding":"0 12px","boxShadow":"1px 2px 4px #aaa","margin":"0 0 12px","color":"#f4f4f5","borderRadius":"2px","background":"#278bd5","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px","zIndex":"999"}'>登录/注册</el-button>
                <el-button v-if="Token" @click="logout" :style='{"border":"1px solid #278bd5","padding":"0 12px","boxShadow":"1px 2px 4px #bbb","margin":"0 30px 0 10px","color":"#278bd5","borderRadius":"2px","background":"#fff","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px","zIndex":"999"}'>退出</el-button>
			</div>
		</div>
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"minHeight":"100vh","padding":"0","margin":"0","position":"relative","background":"url(http://codegen.caihongy.cn/20221028/83b96336016c4895aa387cda7fa006ae.png) fixed"}'>
			<div class="menu-preview" :style='{"padding":"0 20px","borderColor":"#efefef","textAlign":"center","background":"url(http://codegen.caihongy.cn/20221027/4058b35f34564533adc258a0075041ed.png) repeat-x","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}'>
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0","margin":"0 auto","borderColor":"#006fc3","alignItems":"flex-end","display":"flex","justifyContent":"center","listStyle":"none","overflow":"hidden","flexWrap":"wrap","background":"none","borderWidth":"0px 1px 0px 0px","width":"100%","position":"relative","borderStyle":"solid","height":"40px"}' :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<el-image v-if="false" :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					<el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"40px","fontSize":"16px","height":"40px"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"40px","fontSize":"16px","color":"inherit","height":"40px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item @click="goBackend">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"40px","fontSize":"16px","height":"40px"}' class="el-icon-box"></i>
						<span :style='{"padding":"0 10px","lineHeight":"40px","fontSize":"16px","color":"inherit","height":"40px"}'>后台管理</span>
					</el-menu-item>
					<el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"40px","fontSize":"16px","height":"40px"}' class="el-icon-user"></i>
						<span :style='{"padding":"0 10px","lineHeight":"40px","fontSize":"16px","color":"inherit","height":"40px"}'>个人中心</span>
					</el-menu-item>
				</el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"100%","margin":"0","height":"auto"}'>
				<el-carousel :style='{"width":"100%","margin":"0 auto"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="500px" :autoplay="true" :interval="3000" :loop="true">
					<el-carousel-item :style='{"borderRadius":"0","width":"100%","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"minHeight":"150px","padding":"20px 0","alignItems":"center","color":"#fff","background":"url(http://codegen.caihongy.cn/20221027/7dde17b7fdcf4f6caa0c0a26be67a1e8.png) #034281 repeat-x","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center"}'>
			    <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除","学生人数","打印","导出","导入","首页总数","首页统计"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除","教师人数","打印","导出","导入","首页总数","首页统计"],"menu":"教师","menuJump":"列表","tableName":"jiaoshi"}],"menu":"教师管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除","宿管人数","打印","导出","导入","首页总数","首页统计"],"menu":"宿管","menuJump":"列表","tableName":"suguan"}],"menu":"宿管管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除","外来人员","打印","导出","导入","首页总数","首页统计"],"menu":"外来人员","menuJump":"列表","tableName":"wailairenyuan"}],"menu":"外来人员管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除","维修人员","打印","导出","导入","首页总数","首页统计"],"menu":"维修人员","menuJump":"列表","tableName":"weixiurenyuan"}],"menu":"维修人员管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","删除"],"menu":"学生签到","menuJump":"列表","tableName":"xueshengqiandao"}],"menu":"学生签到管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["删除","查看"],"menu":"学生物品","menuJump":"列表","tableName":"xueshengwupin"}],"menu":"学生物品管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","删除"],"menu":"口令码","menuJump":"列表","tableName":"koulingma"}],"menu":"口令码管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除"],"menu":"学生进出宿舍","menuJump":"列表","tableName":"xueshengjinchusushe"}],"menu":"学生进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除"],"menu":"教师进出宿舍","menuJump":"列表","tableName":"jiaoshijinchusushe"}],"menu":"教师进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","删除"],"menu":"申请信息","menuJump":"列表","tableName":"shenqingxinxi"}],"menu":"申请信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["删除","查看"],"menu":"导员确认","menuJump":"列表","tableName":"daoyuanqueren"}],"menu":"导员确认管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","删除"],"menu":"宿舍物品","menuJump":"列表","tableName":"sushewupin"}],"menu":"宿舍物品管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","删除"],"menu":"公共物品","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除"],"menu":"预约使用","menuJump":"列表","tableName":"yuyueshiyong"}],"menu":"预约使用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","删除"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["删除","查看","打印","导出"],"menu":"水电信息","menuJump":"列表","tableName":"shuidianxinxi"}],"menu":"水电信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["删除","查看"],"menu":"宿舍卫生","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["删除","查看","导出","打印"],"menu":"晚归未归登记","menuJump":"列表","tableName":"wanguiweiguidengji"}],"menu":"晚归未归登记管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["删除","查看"],"menu":"失物招领","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["删除","查看"],"menu":"寻物启事","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","删除"],"menu":"违纪登记","menuJump":"列表","tableName":"weijidengji"}],"menu":"违纪登记管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","删除"],"menu":"环境信息","menuJump":"列表","tableName":"huanjingxinxi"}],"menu":"环境信息管理"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["删除","查看"],"menu":"通知公告","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","删除"],"menu":"学生请假","menuJump":"列表","tableName":"xueshengqingjia"}],"menu":"学生请假管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","删除"],"menu":"更换宿舍","menuJump":"列表","tableName":"genghuansushe"}],"menu":"更换宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","删除"],"menu":"更换申请","menuJump":"列表","tableName":"genghuanshenqing"}],"menu":"更换申请管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["删除","查看"],"menu":"学生报修","menuJump":"列表","tableName":"xueshengbaoxiu"}],"menu":"学生报修管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["删除","查看"],"menu":"报修接单","menuJump":"列表","tableName":"baoxiujiedan"}],"menu":"报修接单管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["删除","查看"],"menu":"报修订单","menuJump":"列表","tableName":"baoxiudingdan"}],"menu":"报修订单管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"学生评价","menuJump":"列表","tableName":"xueshengpingjia"}],"menu":"学生评价管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","删除"],"menu":"排行榜","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","修改","回复","删除"],"menu":"留言板管理","tableName":"messages"}],"menu":"留言板管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["查看","修改","删除"],"menu":"交流论坛","tableName":"forum"}],"menu":"交流论坛"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"校园信息","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"学生签到","menuJump":"列表","tableName":"xueshengqiandao"}],"menu":"学生签到管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["新增","查看","修改","删除"],"menu":"学生物品","menuJump":"列表","tableName":"xueshengwupin"}],"menu":"学生物品管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看"],"menu":"口令码","menuJump":"列表","tableName":"koulingma"}],"menu":"口令码管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除"],"menu":"学生进出宿舍","menuJump":"列表","tableName":"xueshengjinchusushe"}],"menu":"学生进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","预约取消","取消预约"],"menu":"预约使用","menuJump":"列表","tableName":"yuyueshiyong"}],"menu":"预约使用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","删除"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看"],"menu":"水电信息","menuJump":"列表","tableName":"shuidianxinxi"}],"menu":"水电信息管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"晚归未归登记","menuJump":"列表","tableName":"wanguiweiguidengji"}],"menu":"晚归未归登记管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"失物招领","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"寻物启事","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"违纪登记","menuJump":"列表","tableName":"weijidengji"}],"menu":"违纪登记管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"学生请假","menuJump":"列表","tableName":"xueshengqingjia"}],"menu":"学生请假管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看"],"menu":"更换宿舍","menuJump":"列表","tableName":"genghuansushe"}],"menu":"更换宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["新增","查看","修改","删除"],"menu":"更换申请","menuJump":"列表","tableName":"genghuanshenqing"}],"menu":"更换申请管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除"],"menu":"学生报修","menuJump":"列表","tableName":"xueshengbaoxiu"}],"menu":"学生报修管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"报修接单","menuJump":"列表","tableName":"baoxiujiedan"}],"menu":"报修接单管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","审核","学生评价"],"menu":"报修订单","menuJump":"列表","tableName":"baoxiudingdan"}],"menu":"报修订单管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除"],"menu":"学生评价","menuJump":"列表","tableName":"xueshengpingjia"}],"menu":"学生评价管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"教师进出宿舍","menuJump":"列表","tableName":"jiaoshijinchusushe"}],"menu":"教师进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除","审核"],"menu":"导员确认","menuJump":"列表","tableName":"daoyuanqueren"}],"menu":"导员确认管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"教师","tableName":"jiaoshi"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除"],"menu":"外来人员","menuJump":"列表","tableName":"wailairenyuan"}],"menu":"外来人员管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除"],"menu":"维修人员","menuJump":"列表","tableName":"weixiurenyuan"}],"menu":"维修人员管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","删除"],"menu":"学生签到","menuJump":"列表","tableName":"xueshengqiandao"}],"menu":"学生签到管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看","删除"],"menu":"学生物品","menuJump":"列表","tableName":"xueshengwupin"}],"menu":"学生物品管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"口令码","menuJump":"列表","tableName":"koulingma"}],"menu":"口令码管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除"],"menu":"学生进出宿舍","menuJump":"列表","tableName":"xueshengjinchusushe"}],"menu":"学生进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除"],"menu":"教师进出宿舍","menuJump":"列表","tableName":"jiaoshijinchusushe"}],"menu":"教师进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","删除","审核","申请提交"],"menu":"申请信息","menuJump":"列表","tableName":"shenqingxinxi"}],"menu":"申请信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除"],"menu":"导员确认","menuJump":"列表","tableName":"daoyuanqueren"}],"menu":"导员确认管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"宿舍物品","menuJump":"列表","tableName":"sushewupin"}],"menu":"宿舍物品管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除"],"menu":"公共物品","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","审核"],"menu":"预约使用","menuJump":"列表","tableName":"yuyueshiyong"}],"menu":"预约使用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["审核","查看","删除"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除","打印","导出"],"menu":"水电信息","menuJump":"列表","tableName":"shuidianxinxi"}],"menu":"水电信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"宿舍卫生","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除","打印","导出"],"menu":"晚归未归登记","menuJump":"列表","tableName":"wanguiweiguidengji"}],"menu":"晚归未归登记管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除","审核"],"menu":"失物招领","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除","审核"],"menu":"寻物启事","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"违纪登记","menuJump":"列表","tableName":"weijidengji"}],"menu":"违纪登记管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["新增","查看","修改","删除"],"menu":"环境信息","menuJump":"列表","tableName":"huanjingxinxi"}],"menu":"环境信息管理"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["新增","查看","修改","删除","审核"],"menu":"通知公告","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","删除","审核"],"menu":"学生请假","menuJump":"列表","tableName":"xueshengqingjia"}],"menu":"学生请假管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["新增","查看","修改","删除","导出"],"menu":"更换宿舍","menuJump":"列表","tableName":"genghuansushe"}],"menu":"更换宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","删除","审核"],"menu":"更换申请","menuJump":"列表","tableName":"genghuanshenqing"}],"menu":"更换申请管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","删除","审核"],"menu":"学生报修","menuJump":"列表","tableName":"xueshengbaoxiu"}],"menu":"学生报修管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","审核"],"menu":"报修接单","menuJump":"列表","tableName":"baoxiujiedan"}],"menu":"报修接单管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","删除"],"menu":"报修订单","menuJump":"列表","tableName":"baoxiudingdan"}],"menu":"报修订单管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","删除"],"menu":"学生评价","menuJump":"列表","tableName":"xueshengpingjia"}],"menu":"学生评价管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"排行榜","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"宿管","tableName":"suguan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-send","buttons":["新增","查看","修改","删除"],"menu":"申请信息","menuJump":"列表","tableName":"shenqingxinxi"}],"menu":"申请信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"导员确认","menuJump":"列表","tableName":"daoyuanqueren"}],"menu":"导员确认管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"外来人员","tableName":"wailairenyuan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","报修接单"],"menu":"学生报修","menuJump":"列表","tableName":"xueshengbaoxiu"}],"menu":"学生报修管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","报修处理"],"menu":"报修接单","menuJump":"列表","tableName":"baoxiujiedan"}],"menu":"报修接单管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改","删除"],"menu":"报修订单","menuJump":"列表","tableName":"baoxiudingdan"}],"menu":"报修订单管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"学生评价","menuJump":"列表","tableName":"xueshengpingjia"}],"menu":"学生评价管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"维修人员","tableName":"weixiurenyuan"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],	
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
            window.scrollTo( 0, 100 )
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出成功',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		padding: 0;
		color: #fff;
		white-space: nowrap;
		display: block;
		font-size: 16px;
		border-color:  #00254a #00254a #006fc3 #006fc3;
		line-height: 40px;
		background: none;
		width: 120px;
		border-width: 0px 0px 0px 1px;
		position: relative;
		border-style: solid;
		list-style: none;
		height: 40px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		padding: 0;
		color: #fff;
		white-space: nowrap;
		font-size: 16px;
		border-color:  #00254a #00254a #006fc3 #006fc3;
		line-height: 40px;
		background: url(http://codegen.caihongy.cn/20221027/8c0f3f3d4c0b4e38bd59dee72577a66b.png) no-repeat;
		width: 120px;
		border-width: 0px 0px 0px 1px;
		position: relative;
		border-style: solid;
		list-style: none;
		height: 40px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		padding: 0;
		color: #fff;
		white-space: nowrap;
		font-size: 16px;
		border-color:  #00254a #00254a #006fc3 #006fc3;
		line-height: 40px;
		background: url(http://codegen.caihongy.cn/20221027/8c0f3f3d4c0b4e38bd59dee72577a66b.png) no-repeat;
		width: 120px;
		border-width: 0px 0px 0px 1px;
		position: relative;
		border-style: solid;
		list-style: none;
		height: 40px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #2087c3;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #2087c3;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0 0 12px 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
        padding-bottom: 20px;
        width: 100%;
        margin-bottom: 10px;
        max-height: 300px;
        height: 300px;
        overflow-y: scroll;
        border: 1px solid #eeeeee;
        background: #fff;

        .left-content {
            float: left;
            margin-bottom: 10px;
            padding: 10px;
            max-width: 80%;
        }

        .right-content {
            float: right;
            margin-bottom: 10px;
            padding: 10px;
            max-width: 80%;
        }
    }

    .clear-float {
        clear: both;
    }
</style>
