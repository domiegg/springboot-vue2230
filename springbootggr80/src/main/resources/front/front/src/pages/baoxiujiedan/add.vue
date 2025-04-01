<template>
<div :style='{"border":"1px solid #dfdfdf","padding":"20px","margin":"20px auto 0","borderRadius":"16px","background":"#fff","width":"1200px","position":"relative"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="报修编号" prop="baoxiubianhao">
            <el-input v-model="ruleForm.baoxiubianhao" 
                placeholder="报修编号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="报修名称" prop="baoxiumingcheng">
            <el-input v-model="ruleForm.baoxiumingcheng" 
                placeholder="报修名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="安排时间" prop="anpaishijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.anpaishijian" 
                  type="datetime"
                  placeholder="安排时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="学号" prop="xuehao">
            <el-input v-model="ruleForm.xuehao" 
                placeholder="学号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="姓名" prop="xingming">
            <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="手机" prop="shouji">
            <el-input v-model="ruleForm.shouji" 
                placeholder="手机" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="宿舍号" prop="sushehao">
            <el-input v-model="ruleForm.sushehao" 
                placeholder="宿舍号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="维修账号" prop="weixiuzhanghao">
            <el-select  @change="weixiuzhanghaoChange" v-model="ruleForm.weixiuzhanghao" placeholder="请选择维修账号">
              <el-option
                  v-for="(item,index) in weixiuzhanghaoOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="维修姓名" prop="weixiuxingming">
            <el-input v-model="ruleForm.weixiuxingming" 
                placeholder="维修姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="联系电话" prop="lianxidianhua">
            <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="宿管账号" prop="suguanzhanghao">
            <el-input v-model="ruleForm.suguanzhanghao" 
                placeholder="宿管账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="宿管姓名" prop="suguanxingming">
            <el-input v-model="ruleForm.suguanxingming" 
                placeholder="宿管姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="问题简述" prop="wentijianshu">
            <editor 
                :style='{"minHeight":"300px","padding":"0","margin":"0","borderColor":"#ccc","backgroundColor":"#f9f9f9","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.wentijianshu" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"20px 0 20px 0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","boxShadow":"1px 2px 6px #52a1db","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","outline":"none","borderRadius":"30%","background":"radial-gradient(circle, rgba(128,184,246,1) 0%, rgba(36,153,251,1) 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0","boxShadow":"1px 2px 6px #ccc","margin":"0","color":"#999","outline":"none","borderRadius":"30%","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            baoxiubianhao : false,
            baoxiumingcheng : false,
            wentijianshu : false,
            anpaishijian : false,
            xuehao : false,
            xingming : false,
            shouji : false,
            sushehao : false,
            weixiuzhanghao : false,
            weixiuxingming : false,
            lianxidianhua : false,
            suguanzhanghao : false,
            suguanxingming : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          baoxiubianhao: '',
          baoxiumingcheng: '',
          wentijianshu: '',
          anpaishijian: '',
          xuehao: '',
          xingming: '',
          shouji: '',
          sushehao: '',
          weixiuzhanghao: '',
          weixiuxingming: '',
          lianxidianhua: '',
          suguanzhanghao: '',
          suguanxingming: '',
        },
        weixiuzhanghaoOptions: [],


        rules: {
          baoxiubianhao: [
          ],
          baoxiumingcheng: [
            { required: true, message: '报修名称不能为空', trigger: 'blur' },
          ],
          wentijianshu: [
          ],
          anpaishijian: [
          ],
          xuehao: [
          ],
          xingming: [
          ],
          shouji: [
          ],
          sushehao: [
          ],
          weixiuzhanghao: [
            { required: true, message: '维修账号不能为空', trigger: 'blur' },
          ],
          weixiuxingming: [
          ],
          lianxidianhua: [
          ],
          suguanzhanghao: [
          ],
          suguanxingming: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.anpaishijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='baoxiubianhao'){
              this.ruleForm.baoxiubianhao = obj[o];
              this.ro.baoxiubianhao = true;
              continue;
            }
            if(o=='baoxiumingcheng'){
              this.ruleForm.baoxiumingcheng = obj[o];
              this.ro.baoxiumingcheng = true;
              continue;
            }
            if(o=='wentijianshu'){
              this.ruleForm.wentijianshu = obj[o];
              this.ro.wentijianshu = true;
              continue;
            }
            if(o=='anpaishijian'){
              this.ruleForm.anpaishijian = obj[o];
              this.ro.anpaishijian = true;
              continue;
            }
            if(o=='xuehao'){
              this.ruleForm.xuehao = obj[o];
              this.ro.xuehao = true;
              continue;
            }
            if(o=='xingming'){
              this.ruleForm.xingming = obj[o];
              this.ro.xingming = true;
              continue;
            }
            if(o=='shouji'){
              this.ruleForm.shouji = obj[o];
              this.ro.shouji = true;
              continue;
            }
            if(o=='sushehao'){
              this.ruleForm.sushehao = obj[o];
              this.ro.sushehao = true;
              continue;
            }
            if(o=='weixiuzhanghao'){
              this.ruleForm.weixiuzhanghao = obj[o];
              this.ro.weixiuzhanghao = true;
              continue;
            }
            if(o=='weixiuxingming'){
              this.ruleForm.weixiuxingming = obj[o];
              this.ro.weixiuxingming = true;
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
              continue;
            }
            if(o=='suguanzhanghao'){
              this.ruleForm.suguanzhanghao = obj[o];
              this.ro.suguanzhanghao = true;
              continue;
            }
            if(o=='suguanxingming'){
              this.ruleForm.suguanxingming = obj[o];
              this.ro.suguanxingming = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.weixiuzhanghao!=''&&json.weixiuzhanghao) || json.weixiuzhanghao==0){
                this.ruleForm.weixiuzhanghao = json.weixiuzhanghao
            }
            if((json.weixiuxingming!=''&&json.weixiuxingming) || json.weixiuxingming==0){
                this.ruleForm.weixiuxingming = json.weixiuxingming
            }
            if((json.lianxidianhua!=''&&json.lianxidianhua) || json.lianxidianhua==0){
                this.ruleForm.lianxidianhua = json.lianxidianhua
            }
            if((json.suguanzhanghao!=''&&json.suguanzhanghao) || json.suguanzhanghao==0){
                this.ruleForm.suguanzhanghao = json.suguanzhanghao
            }
            if((json.suguanxingming!=''&&json.suguanxingming) || json.suguanxingming==0){
                this.ruleForm.suguanxingming = json.suguanxingming
            }
          }
        });
        this.$http.get('option/weixiurenyuan/weixiuzhanghao', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.weixiuzhanghaoOptions = res.data.data;
          }
        });
      },
      // 下二随
      weixiuzhanghaoChange () {
        this.$http.get('follow/weixiurenyuan/weixiuzhanghao?columnValue=' + this.ruleForm.weixiuzhanghao, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.weixiuxingming){
              this.ruleForm.weixiuxingming = res.data.data.weixiuxingming
            }
            if(res.data.data.lianxidianhua){
              this.ruleForm.lianxidianhua = res.data.data.lianxidianhua
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('baoxiujiedan/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('baoxiujiedan/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('baoxiujiedan/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('baoxiujiedan/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
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
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #999;
	  background: #f9f9f9;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
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
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #ccc;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: #f9f9f9;
	  width: 200px;
	  font-size: 32px;
	  line-height: 180px;
	  text-align: center;
	  height: 180px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #ccc;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: #f9f9f9;
	  width: 200px;
	  font-size: 32px;
	  line-height: 180px;
	  text-align: center;
	  height: 180px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #ccc;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: #f9f9f9;
	  width: 200px;
	  font-size: 32px;
	  line-height: 180px;
	  text-align: center;
	  height: 180px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #999;
	  background: #f9f9f9;
	  width: 400px;
	  font-size: 14px;
	  min-height: 120px;
	}
</style>
