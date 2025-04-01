<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","backgroundAttachment":"fixed","alignItems":"center","background":"url(http://codegen.caihongy.cn/20220730/f76d1bdbe6e54705a516e663d5d1114c.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"padding":"80px 0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"0","borderRadius":"50px","background":"#fff","width":"800px","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"margin":"0 0 10px 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"70px","fontSize":"26px","fontWeight":"bold"}' class="title">智慧学生校舍系统注册</div>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">学号</div>
					<el-input  v-model="ruleForm.xuehao"  autocomplete="off" placeholder="学号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">姓名</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">年龄</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in xueshengxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">手机</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">宿舍号</div>
					<el-input  v-model="ruleForm.sushehao"  autocomplete="off" placeholder="宿舍号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">床位号</div>
					<el-input  v-model="ruleForm.chuangweihao"  autocomplete="off" placeholder="床位号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="xueshengtouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">教师账号</div>
					<el-input  v-model="ruleForm.jiaoshizhanghao"  autocomplete="off" placeholder="教师账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">教师姓名</div>
					<el-input  v-model="ruleForm.jiaoshixingming"  autocomplete="off" placeholder="教师姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">年龄</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in jiaoshixingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">联系电话</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">宿舍号</div>
					<el-input  v-model="ruleForm.sushehao"  autocomplete="off" placeholder="宿舍号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">床位号</div>
					<el-input  v-model="ruleForm.chuangweihao"  autocomplete="off" placeholder="床位号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">当前职位</div>
                    <el-select v-model="ruleForm.dangqianzhiwei" placeholder="请选择当前职位" >
                        <el-option
                            v-for="(item,index) in jiaoshidangqianzhiweiOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">专业名称</div>
					<el-input  v-model="ruleForm.zhuanyemingcheng"  autocomplete="off" placeholder="专业名称"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='jiaoshi'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="jiaoshitouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">宿管账号</div>
					<el-input  v-model="ruleForm.suguanzhanghao"  autocomplete="off" placeholder="宿管账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">宿管姓名</div>
					<el-input  v-model="ruleForm.suguanxingming"  autocomplete="off" placeholder="宿管姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">年龄</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in suguanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">联系电话</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">楼栋号</div>
					<el-input  v-model="ruleForm.loudonghao"  autocomplete="off" placeholder="楼栋号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">宿管职级</div>
                    <el-select v-model="ruleForm.suguanzhiji" placeholder="请选择宿管职级" >
                        <el-option
                            v-for="(item,index) in suguansuguanzhijiOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='suguan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="suguantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='wailairenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">账号</div>
					<el-input  v-model="ruleForm.zhanghao"  autocomplete="off" placeholder="账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='wailairenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='wailairenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='wailairenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">姓名</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='wailairenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">年龄</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='wailairenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in wailairenyuanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='wailairenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">手机</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='wailairenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="wailairenyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='weixiurenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">维修账号</div>
					<el-input  v-model="ruleForm.weixiuzhanghao"  autocomplete="off" placeholder="维修账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='weixiurenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='weixiurenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='weixiurenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">维修姓名</div>
					<el-input  v-model="ruleForm.weixiuxingming"  autocomplete="off" placeholder="维修姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='weixiurenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">年龄</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='weixiurenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in weixiurenyuanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='weixiurenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">联系电话</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='weixiurenyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="weixiurenyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#fff","display":"block","outline":"none","borderRadius":"0","background":"#4662A1","width":"60%","fontSize":"18px","height":"70px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","color":"rgba(159, 159, 159, 1)","textAlign":"center","display":"inline-block","width":"100%","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
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

            pageFlag : '',
			tableName:"",
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
		};
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
        this.xueshengxingbieOptions = "男,女".split(',')
        this.$http({
            url: `option/jiaoshi/jiaoshizhanghao`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.xueshengjiaoshizhanghaoOptions = data.data;
            } else {
                this.$message.error(data.msg);
            }
        });
        this.$http({
            url: `option/suguan/suguanzhanghao`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.xueshengsuguanzhanghaoOptions = data.data;
            } else {
                this.$message.error(data.msg);
            }
        });
        this.jiaoshixingbieOptions = "男,女".split(',')
        this.jiaoshidangqianzhiweiOptions = "辅导员,系主任,院领导,导员".split(',')
        this.suguanxingbieOptions = "男,女".split(',')
        this.suguansuguanzhijiOptions = "普通宿管,宿舍楼栋负责人".split(',')
        this.wailairenyuanxingbieOptions = "男,女".split(',')
        this.weixiurenyuanxingbieOptions = "男,女".split(',')
	},
	created() {
    
	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        xueshengtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        // 下二随
        xueshengjiaoshizhanghaoChange () {
            this.$http({
                url: `follow/jiaoshi/jiaoshizhanghao?columnValue=`+ this.ruleForm.jiaoshizhanghao,
                method: "get"
            }).then(({ data }) => {
                if (data && data.code === 0) {
                    if(data.data.jiaoshixingming){
                        this.ruleForm.jiaoshixingming = data.data.jiaoshixingming
                    }
                    if(data.data.suguanxingming){
                        this.ruleForm.suguanxingming = data.data.suguanxingming
                    }
                } else {
                    this.$message.error(data.msg);
                }
            });
        },
        // 下二随
        xueshengsuguanzhanghaoChange () {
            this.$http({
                url: `follow/suguan/suguanzhanghao?columnValue=`+ this.ruleForm.suguanzhanghao,
                method: "get"
            }).then(({ data }) => {
                if (data && data.code === 0) {
                    if(data.data.jiaoshixingming){
                        this.ruleForm.jiaoshixingming = data.data.jiaoshixingming
                    }
                    if(data.data.suguanxingming){
                        this.ruleForm.suguanxingming = data.data.suguanxingming
                    }
                } else {
                    this.$message.error(data.msg);
                }
            });
        },
        jiaoshitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        suguantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        wailairenyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        weixiurenyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.xuehao) && `xuesheng` == this.tableName){
						this.$message.error(`学号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `xuesheng` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xingming) && `xuesheng` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`xuesheng` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`年龄应输入整数`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`xuesheng` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.jiaoshizhanghao) && `jiaoshi` == this.tableName){
						this.$message.error(`教师账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `jiaoshi` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiaoshi` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.jiaoshixingming) && `jiaoshi` == this.tableName){
						this.$message.error(`教师姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`jiaoshi` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`年龄应输入整数`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`jiaoshi` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.suguanzhanghao) && `suguan` == this.tableName){
						this.$message.error(`宿管账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `suguan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `suguan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.suguanxingming) && `suguan` == this.tableName){
						this.$message.error(`宿管姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`suguan` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`年龄应输入整数`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`suguan` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.zhanghao) && `wailairenyuan` == this.tableName){
						this.$message.error(`账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `wailairenyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `wailairenyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xingming) && `wailairenyuan` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`wailairenyuan` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`年龄应输入整数`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`wailairenyuan` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.weixiuzhanghao) && `weixiurenyuan` == this.tableName){
						this.$message.error(`维修账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `weixiurenyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `weixiurenyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.weixiuxingming) && `weixiurenyuan` == this.tableName){
						this.$message.error(`维修姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`weixiurenyuan` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`年龄应输入整数`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`weixiurenyuan` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
			
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20220730/f76d1bdbe6e54705a516e663d5d1114c.png);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
						outline: none;
						color: #000;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
						outline: none;
						color: #000;
						width: 560px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
						outline: none;
						color: #000;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
						outline: none;
						color: #000;
						width: 100%;
						font-size: 14px;
						height: 44px;
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
		  		  border: 1px dashed #888;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #888;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 160px;
		  		  text-align: center;
		  		  height: 160px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed #888;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #888;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 160px;
		  		  text-align: center;
		  		  height: 160px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed #888;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #888;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 160px;
		  		  text-align: center;
		  		  height: 160px;
		  		}
	}
</style>
