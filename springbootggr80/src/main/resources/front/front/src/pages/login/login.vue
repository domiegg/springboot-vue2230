<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221029/e35b6d97fed04bd2a3e7b21cbb5114db.jpg) no-repeat","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"35px 20px 30px","boxShadow":"0 1px 3px rgba(64, 158, 255, .8)","margin":"0","borderRadius":"32px 32px","background":"url(http://codegen.caihongy.cn/20221029/ea2be95667c4485286b36febaa97a64e.png) no-repeat center top,url(http://codegen.caihongy.cn/20221029/238e5e194bc348e9b292b2ffaed4c06d.png) no-repeat center bottom,linear-gradient(180deg, rgba(204,204,204,1) 0%, rgba(246,246,246,1) 15%, rgba(255,255,255,1) 51%, rgba(246,246,246,1) 85%, rgba(204,204,204,1) 100%)","width":"800px","height":"auto"}' :rules="rules">
			<div v-if="true" :style='{"margin":"0 0 10px 0","color":"#409eff","textAlign":"center","width":"100%","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)","fontWeight":"bold"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"0 0 20px 0","color":"#409eff","textAlign":"center","width":"100%","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)","fontWeight":"bold"}'>智慧学生校舍系统登录</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"66%","margin":"0 auto 20px","position":"relative"}' prop="username">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute"}'>账号：</div>
				<input :style='{"border":"1px solid #999","padding":"0 10px","boxShadow":"1px 2px 4px #ccc","color":"#999","borderRadius":"8px","background":"-webkit-linear-gradient(top,#fff,#eee)","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"66%","margin":"0 auto 20px","position":"relative"}' prop="password">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"40px","fontSize":"14px","position":"absolute"}'>密码：</div>
				<input :style='{"border":"1px solid #999","padding":"0 10px","boxShadow":"1px 2px 4px #ccc","color":"#999","borderRadius":"8px","background":"-webkit-linear-gradient(top,#fff,#eee)","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>
			<el-form-item class="list-code" v-if="true && loginType==1" :style='{"width":"66%","margin":"20px auto","position":"relative"}'>
				<div v-if="true" :style='{"verticalAlign":"middle","color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","display":"inline-block","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>验证码：</div>
				<input :style='{"border":"1px solid #999","padding":"0 10px","verticalAlign":"middle","boxShadow":"1px 2px 4px #ccc","outline":"none","color":"#999","borderRadius":"8px","background":"-webkit-linear-gradient(top,#fff,#eee)","display":"inline-block","width":"calc(100% - 164px)","fontSize":"14px","height":"44px"}' v-model="loginForm.code" placeholder="请输入验证码" id="code" type="text">
				<div :style='{"cursor":"pointer","verticalAlign":"middle","boxShadow":"1px 2px 4px #ccc","borderColor":"#999","textAlign":"center","display":"inline-block","float":"right","borderRadius":"8px","borderWidth":"1px","background":"#f5f5f5","width":"80px","borderStyle":"solid","height":"44px"}' class="nums" id="nums" @click="randomString()">
					<span :style="{color:item.color,transform:item.rotate,fontSize:item.size,padding: '0 3px',display:'inline-block'}" v-for="(item, index) in codes" :key="index">{{ item.num }}</span>
				</div>
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"66%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"66%","margin":"20px auto"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","boxShadow":"1px 2px 3px #52a1db","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"30%","background":"radial-gradient(circle, rgba(128,184,246,1) 0%, rgba(36,153,251,1) 100%)","width":"auto","fontSize":"14px","height":"40px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button v-if="loginType==1" :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0 24px","boxShadow":"1px 2px 3px #ccc","margin":"0 5px","outline":"none","color":"#999","borderRadius":"30%","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' @click="resetForm('loginForm')">重置</el-button>
			</el-form-item>
			<div :style='{"width":"66%","margin":"20px auto"}'>
			<router-link :style='{"cursor":"pointer","margin":"0 5px","fontSize":"14px","textDecoration":"none","color":"#278bd5"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除","学生人数","打印","导出","导入","首页总数","首页统计"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除","教师人数","打印","导出","导入","首页总数","首页统计"],"menu":"教师","menuJump":"列表","tableName":"jiaoshi"}],"menu":"教师管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除","宿管人数","打印","导出","导入","首页总数","首页统计"],"menu":"宿管","menuJump":"列表","tableName":"suguan"}],"menu":"宿管管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除","外来人员","打印","导出","导入","首页总数","首页统计"],"menu":"外来人员","menuJump":"列表","tableName":"wailairenyuan"}],"menu":"外来人员管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除","维修人员","打印","导出","导入","首页总数","首页统计"],"menu":"维修人员","menuJump":"列表","tableName":"weixiurenyuan"}],"menu":"维修人员管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","删除"],"menu":"学生签到","menuJump":"列表","tableName":"xueshengqiandao"}],"menu":"学生签到管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["删除","查看"],"menu":"学生物品","menuJump":"列表","tableName":"xueshengwupin"}],"menu":"学生物品管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","删除"],"menu":"口令码","menuJump":"列表","tableName":"koulingma"}],"menu":"口令码管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除"],"menu":"学生进出宿舍","menuJump":"列表","tableName":"xueshengjinchusushe"}],"menu":"学生进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除"],"menu":"教师进出宿舍","menuJump":"列表","tableName":"jiaoshijinchusushe"}],"menu":"教师进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","删除"],"menu":"申请信息","menuJump":"列表","tableName":"shenqingxinxi"}],"menu":"申请信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["删除","查看"],"menu":"导员确认","menuJump":"列表","tableName":"daoyuanqueren"}],"menu":"导员确认管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","删除"],"menu":"宿舍物品","menuJump":"列表","tableName":"sushewupin"}],"menu":"宿舍物品管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","删除"],"menu":"公共物品","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除"],"menu":"预约使用","menuJump":"列表","tableName":"yuyueshiyong"}],"menu":"预约使用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","删除"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["删除","查看","打印","导出"],"menu":"水电信息","menuJump":"列表","tableName":"shuidianxinxi"}],"menu":"水电信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["删除","查看"],"menu":"宿舍卫生","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["删除","查看","导出","打印"],"menu":"晚归未归登记","menuJump":"列表","tableName":"wanguiweiguidengji"}],"menu":"晚归未归登记管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["删除","查看"],"menu":"失物招领","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["删除","查看"],"menu":"寻物启事","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","删除"],"menu":"违纪登记","menuJump":"列表","tableName":"weijidengji"}],"menu":"违纪登记管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","删除"],"menu":"环境信息","menuJump":"列表","tableName":"huanjingxinxi"}],"menu":"环境信息管理"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["删除","查看"],"menu":"通知公告","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","删除"],"menu":"学生请假","menuJump":"列表","tableName":"xueshengqingjia"}],"menu":"学生请假管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","删除"],"menu":"更换宿舍","menuJump":"列表","tableName":"genghuansushe"}],"menu":"更换宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","删除"],"menu":"更换申请","menuJump":"列表","tableName":"genghuanshenqing"}],"menu":"更换申请管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["删除","查看"],"menu":"学生报修","menuJump":"列表","tableName":"xueshengbaoxiu"}],"menu":"学生报修管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["删除","查看"],"menu":"报修接单","menuJump":"列表","tableName":"baoxiujiedan"}],"menu":"报修接单管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["删除","查看"],"menu":"报修订单","menuJump":"列表","tableName":"baoxiudingdan"}],"menu":"报修订单管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"学生评价","menuJump":"列表","tableName":"xueshengpingjia"}],"menu":"学生评价管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","删除"],"menu":"排行榜","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","修改","回复","删除"],"menu":"留言板管理","tableName":"messages"}],"menu":"留言板管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["查看","修改","删除"],"menu":"交流论坛","tableName":"forum"}],"menu":"交流论坛"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"校园信息","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"学生签到","menuJump":"列表","tableName":"xueshengqiandao"}],"menu":"学生签到管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["新增","查看","修改","删除"],"menu":"学生物品","menuJump":"列表","tableName":"xueshengwupin"}],"menu":"学生物品管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看"],"menu":"口令码","menuJump":"列表","tableName":"koulingma"}],"menu":"口令码管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除"],"menu":"学生进出宿舍","menuJump":"列表","tableName":"xueshengjinchusushe"}],"menu":"学生进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","预约取消","取消预约"],"menu":"预约使用","menuJump":"列表","tableName":"yuyueshiyong"}],"menu":"预约使用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","删除"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看"],"menu":"水电信息","menuJump":"列表","tableName":"shuidianxinxi"}],"menu":"水电信息管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"晚归未归登记","menuJump":"列表","tableName":"wanguiweiguidengji"}],"menu":"晚归未归登记管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"失物招领","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"寻物启事","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"违纪登记","menuJump":"列表","tableName":"weijidengji"}],"menu":"违纪登记管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"学生请假","menuJump":"列表","tableName":"xueshengqingjia"}],"menu":"学生请假管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看"],"menu":"更换宿舍","menuJump":"列表","tableName":"genghuansushe"}],"menu":"更换宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["新增","查看","修改","删除"],"menu":"更换申请","menuJump":"列表","tableName":"genghuanshenqing"}],"menu":"更换申请管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除"],"menu":"学生报修","menuJump":"列表","tableName":"xueshengbaoxiu"}],"menu":"学生报修管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"报修接单","menuJump":"列表","tableName":"baoxiujiedan"}],"menu":"报修接单管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","审核","学生评价"],"menu":"报修订单","menuJump":"列表","tableName":"baoxiudingdan"}],"menu":"报修订单管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除"],"menu":"学生评价","menuJump":"列表","tableName":"xueshengpingjia"}],"menu":"学生评价管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"教师进出宿舍","menuJump":"列表","tableName":"jiaoshijinchusushe"}],"menu":"教师进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除","审核"],"menu":"导员确认","menuJump":"列表","tableName":"daoyuanqueren"}],"menu":"导员确认管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"教师","tableName":"jiaoshi"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除"],"menu":"外来人员","menuJump":"列表","tableName":"wailairenyuan"}],"menu":"外来人员管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除"],"menu":"维修人员","menuJump":"列表","tableName":"weixiurenyuan"}],"menu":"维修人员管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","删除"],"menu":"学生签到","menuJump":"列表","tableName":"xueshengqiandao"}],"menu":"学生签到管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看","删除"],"menu":"学生物品","menuJump":"列表","tableName":"xueshengwupin"}],"menu":"学生物品管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"口令码","menuJump":"列表","tableName":"koulingma"}],"menu":"口令码管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除"],"menu":"学生进出宿舍","menuJump":"列表","tableName":"xueshengjinchusushe"}],"menu":"学生进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除"],"menu":"教师进出宿舍","menuJump":"列表","tableName":"jiaoshijinchusushe"}],"menu":"教师进出宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","删除","审核","申请提交"],"menu":"申请信息","menuJump":"列表","tableName":"shenqingxinxi"}],"menu":"申请信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除"],"menu":"导员确认","menuJump":"列表","tableName":"daoyuanqueren"}],"menu":"导员确认管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"宿舍物品","menuJump":"列表","tableName":"sushewupin"}],"menu":"宿舍物品管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除"],"menu":"公共物品","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","审核"],"menu":"预约使用","menuJump":"列表","tableName":"yuyueshiyong"}],"menu":"预约使用管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["审核","查看","删除"],"menu":"取消预约","menuJump":"列表","tableName":"quxiaoyuyue"}],"menu":"取消预约管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除","打印","导出"],"menu":"水电信息","menuJump":"列表","tableName":"shuidianxinxi"}],"menu":"水电信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"宿舍卫生","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除","打印","导出"],"menu":"晚归未归登记","menuJump":"列表","tableName":"wanguiweiguidengji"}],"menu":"晚归未归登记管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除","审核"],"menu":"失物招领","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除","审核"],"menu":"寻物启事","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"违纪登记","menuJump":"列表","tableName":"weijidengji"}],"menu":"违纪登记管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["新增","查看","修改","删除"],"menu":"环境信息","menuJump":"列表","tableName":"huanjingxinxi"}],"menu":"环境信息管理"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["新增","查看","修改","删除","审核"],"menu":"通知公告","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","删除","审核"],"menu":"学生请假","menuJump":"列表","tableName":"xueshengqingjia"}],"menu":"学生请假管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["新增","查看","修改","删除","导出"],"menu":"更换宿舍","menuJump":"列表","tableName":"genghuansushe"}],"menu":"更换宿舍管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","删除","审核"],"menu":"更换申请","menuJump":"列表","tableName":"genghuanshenqing"}],"menu":"更换申请管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","删除","审核"],"menu":"学生报修","menuJump":"列表","tableName":"xueshengbaoxiu"}],"menu":"学生报修管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","审核"],"menu":"报修接单","menuJump":"列表","tableName":"baoxiujiedan"}],"menu":"报修接单管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","删除"],"menu":"报修订单","menuJump":"列表","tableName":"baoxiudingdan"}],"menu":"报修订单管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","删除"],"menu":"学生评价","menuJump":"列表","tableName":"xueshengpingjia"}],"menu":"学生评价管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"排行榜","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"宿管","tableName":"suguan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-send","buttons":["新增","查看","修改","删除"],"menu":"申请信息","menuJump":"列表","tableName":"shenqingxinxi"}],"menu":"申请信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"导员确认","menuJump":"列表","tableName":"daoyuanqueren"}],"menu":"导员确认管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"外来人员","tableName":"wailairenyuan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","报修接单"],"menu":"学生报修","menuJump":"列表","tableName":"xueshengbaoxiu"}],"menu":"学生报修管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","报修处理"],"menu":"报修接单","menuJump":"列表","tableName":"baoxiujiedan"}],"menu":"报修接单管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改","删除"],"menu":"报修订单","menuJump":"列表","tableName":"baoxiudingdan"}],"menu":"报修订单管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"学生评价","menuJump":"列表","tableName":"xueshengpingjia"}],"menu":"学生评价管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","预约使用"],"menu":"公共物品列表","menuJump":"列表","tableName":"gonggongwupin"}],"menu":"公共物品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"宿舍卫生列表","menuJump":"列表","tableName":"susheweisheng"}],"menu":"宿舍卫生模块"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"失物招领列表","menuJump":"列表","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"寻物启事列表","menuJump":"列表","tableName":"xunwuqishi"}],"menu":"寻物启事模块"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"通知公告列表","menuJump":"列表","tableName":"tongzhigonggao"}],"menu":"通知公告模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"排行榜列表","menuJump":"列表","tableName":"paixingbang"}],"menu":"排行榜模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"维修人员","tableName":"weixiurenyuan"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
  components: {
  },
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
		this.randomString();
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        let code = ''
        for(let i in this.codes) {
            code += this.codes[i].num
        }
        if (!this.loginForm.code) {
            this.$message.error("请输入验证码");
            return;
        }
        if (this.loginForm.code.toLowerCase() != code.toLowerCase()) {
            this.$message.error("验证码输入有误");
            return;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: '登录成功',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20221029/e35b6d97fed04bd2a3e7b21cbb5114db.jpg) no-repeat;
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid #999;
			border-radius: 8px;
			padding: 0 10px;
			box-shadow: 1px 2px 4px #ccc;
			color: #999;
			background: -webkit-linear-gradient(top,#fff,#eee);
			width: 100%;
			font-size: 14px;
			height: 44px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid #999;
			border-radius: 8px;
			padding: 0 10px;
			box-shadow: 1px 2px 4px #ccc;
			outline: none;
			color: #999;
			background: -webkit-linear-gradient(top,#fff,#eee);
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 164px);
			font-size: 14px;
			height: 44px;
		}
		
		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: rgba(64, 158, 255, 1);
			border-color: rgba(64, 158, 255, 1);
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: rgba(64, 158, 255, 1);
			font-size: 14px;
		}
	}
</style>
