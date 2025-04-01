<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221029/e35b6d97fed04bd2a3e7b21cbb5114db.jpg) no-repeat","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"20px","boxShadow":"0 1px 3px rgba(64, 158, 255, .8)","margin":"0","borderRadius":"16px 32px","background":"url(http://codegen.caihongy.cn/20221029/ea2be95667c4485286b36febaa97a64e.png) no-repeat center top,url(http://codegen.caihongy.cn/20221029/238e5e194bc348e9b292b2ffaed4c06d.png) no-repeat center bottom,linear-gradient(180deg, rgba(204,204,204,1) 0%, rgba(246,246,246,1) 15%, rgba(255,255,255,1) 51%, rgba(246,246,246,1) 85%, rgba(204,204,204,1) 100%)","width":"800px","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="true" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)","fontWeight":"bold"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"0 0 24px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)","fontWeight":"bold"}'>智慧学生校舍系统注册</p></div>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="xuehao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>学号：</div>
				<el-input v-model="registerForm.xuehao"  placeholder="请输入学号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="xingming">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="nianling">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="xingbie">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in xueshengxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="shouji">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="sushehao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>宿舍号：</div>
				<el-input v-model="registerForm.sushehao"  placeholder="请输入宿舍号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="chuangweihao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>床位号：</div>
				<el-input v-model="registerForm.chuangweihao"  placeholder="请输入床位号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='xuesheng'" prop="touxiang">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="xueshengtouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="jiaoshizhanghao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>教师账号：</div>
				<el-input v-model="registerForm.jiaoshizhanghao"  placeholder="请输入教师账号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="jiaoshixingming">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>教师姓名：</div>
				<el-input v-model="registerForm.jiaoshixingming"  placeholder="请输入教师姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="nianling">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="xingbie">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in jiaoshixingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="lianxidianhua">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="sushehao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>宿舍号：</div>
				<el-input v-model="registerForm.sushehao"  placeholder="请输入宿舍号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="chuangweihao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>床位号：</div>
				<el-input v-model="registerForm.chuangweihao"  placeholder="请输入床位号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="dangqianzhiwei">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>当前职位：</div>
                <el-select v-model="registerForm.dangqianzhiwei" placeholder="请选择当前职位" >
                  <el-option
                      v-for="(item,index) in jiaoshidangqianzhiweiOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="zhuanyemingcheng">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>专业名称：</div>
				<el-input v-model="registerForm.zhuanyemingcheng"  placeholder="请输入专业名称" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='jiaoshi'" prop="touxiang">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="jiaoshitouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="suguanzhanghao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>宿管账号：</div>
				<el-input v-model="registerForm.suguanzhanghao"  placeholder="请输入宿管账号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="suguanxingming">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>宿管姓名：</div>
				<el-input v-model="registerForm.suguanxingming"  placeholder="请输入宿管姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="nianling">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="xingbie">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in suguanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="lianxidianhua">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="loudonghao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>楼栋号：</div>
				<el-input v-model="registerForm.loudonghao"  placeholder="请输入楼栋号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="suguanzhiji">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>宿管职级：</div>
                <el-select v-model="registerForm.suguanzhiji" placeholder="请选择宿管职级" >
                  <el-option
                      v-for="(item,index) in suguansuguanzhijiOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='suguan'" prop="touxiang">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="suguantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='wailairenyuan'" prop="zhanghao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>账号：</div>
				<el-input v-model="registerForm.zhanghao"  placeholder="请输入账号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='wailairenyuan'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='wailairenyuan'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='wailairenyuan'" prop="xingming">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='wailairenyuan'" prop="nianling">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='wailairenyuan'" prop="xingbie">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in wailairenyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='wailairenyuan'" prop="shouji">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='wailairenyuan'" prop="touxiang">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="wailairenyuantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='weixiurenyuan'" prop="weixiuzhanghao">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>维修账号：</div>
				<el-input v-model="registerForm.weixiuzhanghao"  placeholder="请输入维修账号" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='weixiurenyuan'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='weixiurenyuan'" prop="mima">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='weixiurenyuan'" prop="weixiuxingming">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>维修姓名：</div>
				<el-input v-model="registerForm.weixiuxingming"  placeholder="请输入维修姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='weixiurenyuan'" prop="nianling">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='weixiurenyuan'" prop="xingbie">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in weixiurenyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='weixiurenyuan'" prop="lianxidianhua">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-form-item :style='{"width":"66%","padding":"0","margin":"0px auto 24px","position":"relative","height":"auto"}' v-if="tableName=='weixiurenyuan'" prop="touxiang">
				<div v-if="true" :style='{"color":"rgba(64, 158, 255, 1)","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="weixiurenyuantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","boxShadow":"1px 2px 3px #52a1db","margin":"12px 16px 5px 290px","color":"#fff","display":"inline-block","outline":"none","borderRadius":"30%","background":"radial-gradient(circle, rgba(128,184,246,1) 0%, rgba(36,153,251,1) 100%)","width":"auto","fontSize":"16px","height":"40px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0 24px","boxShadow":"1px 2px 3px #ccc","margin":"12px auto 5px","color":"#999","display":"inline-block","outline":"none","borderRadius":"30%","background":"#fff","width":"auto","fontSize":"16px","height":"40px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 10%","color":"#278bd5","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {
                xingbie: '',
                jiaoshixingming: '',
                suguanxingming: '',
                xingbie: '',
                dangqianzhiwei: '',
                xingbie: '',
                suguanzhiji: '',
                xingbie: '',
                xingbie: '',
            },
			rules: {},
            xueshengxingbieOptions: [],
            xueshengjiaoshizhanghaoOptions: [],
            xueshengsuguanzhanghaoOptions: [],
            jiaoshixingbieOptions: [],
            jiaoshidangqianzhiweiOptions: [],
            suguanxingbieOptions: [],
            suguansuguanzhijiOptions: [],
            wailairenyuanxingbieOptions: [],
            weixiurenyuanxingbieOptions: [],
		}
    },
	mounted() {
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      this.tableName = this.$route.query.role;
      if ('xuesheng' == this.tableName) {
        this.rules.xuehao = [{ required: true, message: '请输入学号', trigger: 'blur' }];
      }
      if ('xuesheng' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('xuesheng' == this.tableName) {
        this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
      }
      if ('xuesheng' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
        this.xueshengxingbieOptions = "男,女".split(',');
      if ('xuesheng' == this.tableName) {
        this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
        this.$http({
          url: `option/jiaoshi/jiaoshizhanghao`,
          method: "get",
          params: {}
        }).then(({ data }) => {
          if (data && data.code === 0) {
              this.xueshengjiaoshizhanghaoOptions = data.data;
          }
        });
        this.$http({
          url: `option/suguan/suguanzhanghao`,
          method: "get",
          params: {}
        }).then(({ data }) => {
          if (data && data.code === 0) {
              this.xueshengsuguanzhanghaoOptions = data.data;
          }
        });
      if ('jiaoshi' == this.tableName) {
        this.rules.jiaoshizhanghao = [{ required: true, message: '请输入教师账号', trigger: 'blur' }];
      }
      if ('jiaoshi' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('jiaoshi' == this.tableName) {
        this.rules.jiaoshixingming = [{ required: true, message: '请输入教师姓名', trigger: 'blur' }];
      }
      if ('jiaoshi' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
        this.jiaoshixingbieOptions = "男,女".split(',');
      if ('jiaoshi' == this.tableName) {
        this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
        this.jiaoshidangqianzhiweiOptions = "辅导员,系主任,院领导,导员".split(',');
      if ('suguan' == this.tableName) {
        this.rules.suguanzhanghao = [{ required: true, message: '请输入宿管账号', trigger: 'blur' }];
      }
      if ('suguan' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('suguan' == this.tableName) {
        this.rules.suguanxingming = [{ required: true, message: '请输入宿管姓名', trigger: 'blur' }];
      }
      if ('suguan' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
        this.suguanxingbieOptions = "男,女".split(',');
      if ('suguan' == this.tableName) {
        this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
        this.suguansuguanzhijiOptions = "普通宿管,宿舍楼栋负责人".split(',');
      if ('wailairenyuan' == this.tableName) {
        this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }];
      }
      if ('wailairenyuan' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('wailairenyuan' == this.tableName) {
        this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
      }
      if ('wailairenyuan' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
        this.wailairenyuanxingbieOptions = "男,女".split(',');
      if ('wailairenyuan' == this.tableName) {
        this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('weixiurenyuan' == this.tableName) {
        this.rules.weixiuzhanghao = [{ required: true, message: '请输入维修账号', trigger: 'blur' }];
      }
      if ('weixiurenyuan' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('weixiurenyuan' == this.tableName) {
        this.rules.weixiuxingming = [{ required: true, message: '请输入维修姓名', trigger: 'blur' }];
      }
      if ('weixiurenyuan' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
        this.weixiurenyuanxingbieOptions = "男,女".split(',');
      if ('weixiurenyuan' == this.tableName) {
        this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
    },
    //方法集合
    methods: {
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      xueshengtouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
        xueshengjiaoshizhanghaoChange () {
          this.$http({
            url: `follow/jiaoshi/jiaoshizhanghao?columnValue=`+ this.registerForm.jiaoshizhanghao,
            method: "get",
            params: {}
          }).then(({ data }) => {
            if (data && data.code === 0) {
            if(data.data.jiaoshixingming){
              this.registerForm.jiaoshixingming = data.data.jiaoshixingming
            }
            if(data.data.suguanxingming){
              this.registerForm.suguanxingming = data.data.suguanxingming
            }
            }
          });
        },
        xueshengsuguanzhanghaoChange () {
          this.$http({
            url: `follow/suguan/suguanzhanghao?columnValue=`+ this.registerForm.suguanzhanghao,
            method: "get",
            params: {}
          }).then(({ data }) => {
            if (data && data.code === 0) {
            if(data.data.jiaoshixingming){
              this.registerForm.jiaoshixingming = data.data.jiaoshixingming
            }
            if(data.data.suguanxingming){
              this.registerForm.suguanxingming = data.data.suguanxingming
            }
            }
          });
        },
      jiaoshitouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      suguantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      wailairenyuantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      weixiurenyuantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
               if(`xuesheng` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
               if(`jiaoshi` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
               if(`suguan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
               if(`wailairenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
               if(`weixiurenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
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

		.el-date-editor.el-input {
			width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #999;
						border-radius: 8px;
						padding: 0 10px;
						box-shadow: 1px 2px 4px #ccc;
						outline: none;
						color: #999;
						background: -webkit-linear-gradient(top,#fff,#eee);
						width: 100%;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #999;
						border-radius: 8px;
						padding: 0 10px;
						box-shadow: 1px 2px 4px #ccc;
						outline: none;
						color: #999;
						background: -webkit-linear-gradient(top,#fff,#eee);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #999;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						box-shadow: 1px 2px 4px #ccc;
						outline: none;
						color: #999;
						background: -webkit-linear-gradient(top,#fff,#eee);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #999;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						box-shadow: 1px 2px 4px #ccc;
						outline: none;
						color: #999;
						background: -webkit-linear-gradient(top,#fff,#eee);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px dashed #999;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 120px;
		  		  text-align: center;
		  		  height: 120px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed #999;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 120px;
		  		  text-align: center;
		  		  height: 120px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed #999;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 120px;
		  		  text-align: center;
		  		  height: 120px;
		  		}
	}
</style>
