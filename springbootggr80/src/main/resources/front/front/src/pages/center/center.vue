<template>
<div class="center-preview" :style='{"border":"1px solid #dfdfdf","boxShadow":"1px 2px 3px #eee","margin":"20px auto","borderRadius":"16px","background":"#fff","width":"1200px","position":"relative"}'>
	<div class="title" :style='{"margin":"0px 0","color":"#2087c3","borderRadius":"8px 8px 0 0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20221029/f414ce6eeb09429c9bc4d3d6643d9bd1.png) no-repeat center top","fontSize":"24px","lineHeight":"150px","fontWeight":"bold"}'>{{ title }}</div>

    <el-tabs tab-position="left" :style='{"border":"0","padding":"20px","margin":"0","borderRadius":"0 0 16px 16px","background":"none"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="80px">
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="学号" prop="xuehao">
            <el-input v-model="sessionForm.xuehao" placeholder="学号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="姓名" prop="xingming">
            <el-input v-model="sessionForm.xingming" placeholder="姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="手机" prop="shouji">
            <el-input v-model="sessionForm.shouji" placeholder="手机" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="宿舍号" prop="sushehao">
            <el-input v-model="sessionForm.sushehao" placeholder="宿舍号" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="床位号" prop="chuangweihao">
            <el-input v-model="sessionForm.chuangweihao" placeholder="床位号" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="xueshengtouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #999","cursor":"pointer","color":"#999","borderRadius":"6px","textAlign":"center","background":"#f9f9f9","width":"200px","fontSize":"32px","lineHeight":"100px","height":"auto"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="教师账号">
            <el-select v-model="sessionForm.jiaoshizhanghao" placeholder="请选择教师账号" @change="jiaoshizhanghaoChange" disabled>
              <el-option v-for="(item, index) in dynamicProp.jiaoshizhanghao" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="教师姓名" prop="jiaoshixingming">
            <el-input v-model="sessionForm.jiaoshixingming" placeholder="教师姓名" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="宿管账号">
            <el-select v-model="sessionForm.suguanzhanghao" placeholder="请选择宿管账号" @change="suguanzhanghaoChange" disabled>
              <el-option v-for="(item, index) in dynamicProp.suguanzhanghao" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='xuesheng'" label="宿管姓名" prop="suguanxingming">
            <el-input v-model="sessionForm.suguanxingming" placeholder="宿管姓名" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="教师账号" prop="jiaoshizhanghao">
            <el-input v-model="sessionForm.jiaoshizhanghao" placeholder="教师账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="教师姓名" prop="jiaoshixingming">
            <el-input v-model="sessionForm.jiaoshixingming" placeholder="教师姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="宿舍号" prop="sushehao">
            <el-input v-model="sessionForm.sushehao" placeholder="宿舍号" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="床位号" prop="chuangweihao">
            <el-input v-model="sessionForm.chuangweihao" placeholder="床位号" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="当前职位">
            <el-select v-model="sessionForm.dangqianzhiwei" placeholder="请选择当前职位" >
              <el-option v-for="(item, index) in dynamicProp.dangqianzhiwei" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="专业名称" prop="zhuanyemingcheng">
            <el-input v-model="sessionForm.zhuanyemingcheng" placeholder="专业名称" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='jiaoshi'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="jiaoshitouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #999","cursor":"pointer","color":"#999","borderRadius":"6px","textAlign":"center","background":"#f9f9f9","width":"200px","fontSize":"32px","lineHeight":"100px","height":"auto"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="宿管账号" prop="suguanzhanghao">
            <el-input v-model="sessionForm.suguanzhanghao" placeholder="宿管账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="宿管姓名" prop="suguanxingming">
            <el-input v-model="sessionForm.suguanxingming" placeholder="宿管姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="楼栋号" prop="loudonghao">
            <el-input v-model="sessionForm.loudonghao" placeholder="楼栋号" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="宿管职级">
            <el-select v-model="sessionForm.suguanzhiji" placeholder="请选择宿管职级" >
              <el-option v-for="(item, index) in dynamicProp.suguanzhiji" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='suguan'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="suguantouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #999","cursor":"pointer","color":"#999","borderRadius":"6px","textAlign":"center","background":"#f9f9f9","width":"200px","fontSize":"32px","lineHeight":"100px","height":"auto"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='wailairenyuan'" label="账号" prop="zhanghao">
            <el-input v-model="sessionForm.zhanghao" placeholder="账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='wailairenyuan'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='wailairenyuan'" label="姓名" prop="xingming">
            <el-input v-model="sessionForm.xingming" placeholder="姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='wailairenyuan'" label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='wailairenyuan'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='wailairenyuan'" label="手机" prop="shouji">
            <el-input v-model="sessionForm.shouji" placeholder="手机" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='wailairenyuan'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="wailairenyuantouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #999","cursor":"pointer","color":"#999","borderRadius":"6px","textAlign":"center","background":"#f9f9f9","width":"200px","fontSize":"32px","lineHeight":"100px","height":"auto"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='weixiurenyuan'" label="维修账号" prop="weixiuzhanghao">
            <el-input v-model="sessionForm.weixiuzhanghao" placeholder="维修账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='weixiurenyuan'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='weixiurenyuan'" label="维修姓名" prop="weixiuxingming">
            <el-input v-model="sessionForm.weixiuxingming" placeholder="维修姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='weixiurenyuan'" label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='weixiurenyuan'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='weixiurenyuan'" label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' v-if="userTableName=='weixiurenyuan'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="weixiurenyuantouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #999","cursor":"pointer","color":"#999","borderRadius":"6px","textAlign":"center","background":"#f9f9f9","width":"200px","fontSize":"32px","lineHeight":"100px","height":"auto"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"20px 0 20px 0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","boxShadow":"1px 2px 3px #52a1db","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","outline":"none","borderRadius":"30%","background":"radial-gradient(circle, rgba(128,184,246,1) 0%, rgba(36,153,251,1) 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0","boxShadow":"1px 2px 3px #ccc","margin":"0","color":"#999","outline":"none","borderRadius":"30%","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
		
        <el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="充值金额" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
            <el-button type="primary" @click="chongzhi">确认充值</el-button>
          </div>
        </el-dialog>
        <el-dialog title="会员购买" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="会员卡" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/年"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">取 消</el-button>
            <el-button type="primary" @click="chongzhivip">确认支付</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="我的发布"></el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {}
      }
    },
    created() {
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'xuehao', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'xingming', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'shouji', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'sushehao', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'chuangweihao', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaoshizhanghao', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaoshixingming', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'suguanzhanghao', null);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.sessionForm, 'suguanxingming', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaoshizhanghao', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaoshixingming', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxidianhua', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'sushehao', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'chuangweihao', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'dangqianzhiwei', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'zhuanyemingcheng', null);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'suguanzhanghao', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'suguanxingming', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxidianhua', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'loudonghao', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'suguanzhiji', null);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'zhanghao', null);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'xingming', null);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'shouji', null);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'weixiuzhanghao', null);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'weixiuxingming', null);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxidianhua', null);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }

      if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'xuehao', [{ required: true, message: '请输入学号', trigger: 'blur' }]);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
      if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'xingming', [{ required: true, message: '请输入姓名', trigger: 'blur' }]);
      }
			if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('xuesheng' == this.userTableName) {
        this.$set(this.rules, 'shouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'jiaoshizhanghao', [{ required: true, message: '请输入教师账号', trigger: 'blur' }]);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
      if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'jiaoshixingming', [{ required: true, message: '请输入教师姓名', trigger: 'blur' }]);
      }
			if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('jiaoshi' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.rules, 'suguanzhanghao', [{ required: true, message: '请输入宿管账号', trigger: 'blur' }]);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
      if ('suguan' == this.userTableName) {
        this.$set(this.rules, 'suguanxingming', [{ required: true, message: '请输入宿管姓名', trigger: 'blur' }]);
      }
			if ('suguan' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('suguan' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.rules, 'zhanghao', [{ required: true, message: '请输入账号', trigger: 'blur' }]);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
      if ('wailairenyuan' == this.userTableName) {
        this.$set(this.rules, 'xingming', [{ required: true, message: '请输入姓名', trigger: 'blur' }]);
      }
			if ('wailairenyuan' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('wailairenyuan' == this.userTableName) {
        this.$set(this.rules, 'shouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.rules, 'weixiuzhanghao', [{ required: true, message: '请输入维修账号', trigger: 'blur' }]);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
      if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.rules, 'weixiuxingming', [{ required: true, message: '请输入维修姓名', trigger: 'blur' }]);
      }
			if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('weixiurenyuan' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },
    //方法集合
    methods: {
      init() {
        if ('xuesheng' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
				if ('xuesheng' == this.userTableName) {
          this.$http.get('option/jiaoshi/jiaoshizhanghao', {emulateJSON: true}).then(res => {
            if (res.data.code == 0) {
              this.dynamicProp.jiaoshizhanghao = res.data.data;
            }
          });
        }    
				if ('xuesheng' == this.userTableName) {
          this.$http.get('option/suguan/suguanzhanghao', {emulateJSON: true}).then(res => {
            if (res.data.code == 0) {
              this.dynamicProp.suguanzhanghao = res.data.data;
            }
          });
        }    
        if ('jiaoshi' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
        if ('jiaoshi' == this.userTableName) {
          this.dynamicProp.dangqianzhiwei = '辅导员,系主任,院领导,导员'.split(',');
        }
        if ('suguan' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
        if ('suguan' == this.userTableName) {
          this.dynamicProp.suguanzhiji = '普通宿管,宿舍楼栋负责人'.split(',');
        }
        if ('wailairenyuan' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
        if ('weixiurenyuan' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
      jiaoshizhanghaoChange(value) {
        this.$http.get('follow/jiaoshi/jiaoshizhanghao', {params: {columnValue: value}}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm.jiaoshixingming = res.data.data.jiaoshixingming;
            this.sessionForm.suguanxingming = res.data.data.suguanxingming;
          }
        });
      },
      suguanzhanghaoChange(value) {
        this.$http.get('follow/suguan/suguanzhanghao', {params: {columnValue: value}}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm.jiaoshixingming = res.data.data.jiaoshixingming;
            this.sessionForm.suguanxingming = res.data.data.suguanxingming;
          }
        });
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
            if(res.data.data.touxiang) {
                localStorage.setItem('headportrait', res.data.data.touxiang);
            } else if(res.data.data.headportrait) {
                localStorage.setItem('headportrait', res.data.data.headportrait);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: '更新成功',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      xueshengtouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('xuesheng' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      jiaoshitouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('jiaoshi' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      suguantouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('suguan' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      wailairenyuantouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('wailairenyuan' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      weixiurenyuantouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('weixiurenyuan' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseFloat(this.sessionForm.money) + parseFloat(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择支付方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == '是') {
          this.$message({
            message: '您已是我们的尊贵会员。',
            type: 'success',
            duration: 1500
          });
          return;
        }
        
        this.sessionForm.vip = "是"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '会员购买成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '我的发布':
            tab.$router.push('/index/myForumList');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	border-radius: 12px;
	padding: 12px 0 16px;
	box-shadow: 1px 3px 6px #bbb;
	margin: 0px;
	background: linear-gradient(180deg, rgba(160,215,255,1) 0%, rgba(39,139,213,1) 100%);
	width: 226px;
	border-color: #007abf;
	border-width: 1px 1px 1px 1px;
	position: relative;
	float: left;
	border-style: solid;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	margin: 0 12px 8px 12px;
  	color: #333;
  	white-space: nowrap;
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	text-overflow: ellipsis;
  	border-radius: 12px;
  	box-shadow: 1px 2px 4px #1f6599,inset 0px 0px 56px 0px #f6f6f6;
  	overflow: hidden;
  	background: #d9e8f3;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	border-radius: 12px;
  	padding: 0 10px;
  	box-shadow: 1px 2px 4px #1f6599;
  	margin: 0 12px 8px 12px;
  	color: #fff;
  	background: radial-gradient(circle, rgba(146,195,249,1) 0%, rgba(36,153,251,1) 100%);
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	border-radius: 12px;
  	padding: 0 10px;
  	box-shadow: 1px 2px 4px #1f6599;
  	margin: 0 12px 8px 12px;
  	color: #fff;
  	background: radial-gradient(circle, rgba(146,195,249,1) 0%, rgba(36,153,251,1) 100%);
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	padding: 0px;
  	background: none;
  	width: 900px;
  	float: right;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 80px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 80px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid #ccc;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #999;
  	background: #f9f9f9;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid #ccc;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #999;
  	background: #f9f9f9;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border: 1px solid #ccc;
  	border-radius: 4px;
  	padding: 0 10px 0 30px;
  	outline: none;
  	color: #999;
  	background: #f9f9f9;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px dashed #999;
  	cursor: pointer;
  	border-radius: 6px;
  	color: #999;
  	background: #f9f9f9;
  	width: 200px;
  	font-size: 32px;
  	line-height: 100px;
  	text-align: center;
  	height: auto;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #ccc;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	margin: 0 8px 0 0;
  	color: #999;
  	background: #f9f9f9;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
</style>
