<template>
<div :style='{"border":"1px solid #dfdfdf","padding":"20px","margin":"20px auto 0","borderRadius":"16px","background":"#fff","width":"1200px","position":"relative"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="申请编号" prop="shenqingbianhao">
              <el-input v-model="ruleForm.shenqingbianhao" placeholder="申请编号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="原宿舍号" prop="yuansushehao">
            <el-input v-model="ruleForm.yuansushehao" 
                placeholder="原宿舍号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="新宿舍号" prop="xinsushehao">
            <el-input v-model="ruleForm.xinsushehao" 
                placeholder="新宿舍号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="申请时间" prop="shenqingshijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.shenqingshijian" 
                  type="datetime"
                  placeholder="申请时间">
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
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="宿管账号" prop="suguanzhanghao">
            <el-input v-model="ruleForm.suguanzhanghao" 
                placeholder="宿管账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="宿管姓名" prop="suguanxingming">
            <el-input v-model="ruleForm.suguanxingming" 
                placeholder="宿管姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="更换原因" prop="genghuanyuanyin">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="更换原因"
              v-model="ruleForm.genghuanyuanyin">
            </el-input>
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
            shenqingbianhao : false,
            yuansushehao : false,
            xinsushehao : false,
            genghuanyuanyin : false,
            shenqingshijian : false,
            xuehao : false,
            xingming : false,
            shouji : false,
            suguanzhanghao : false,
            suguanxingming : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          shenqingbianhao: this.getUUID(),
          yuansushehao: '',
          xinsushehao: '',
          genghuanyuanyin: '',
          shenqingshijian: '',
          xuehao: '',
          xingming: '',
          shouji: '',
          suguanzhanghao: '',
          suguanxingming: '',
        },


        rules: {
          shenqingbianhao: [
          ],
          yuansushehao: [
            { required: true, message: '原宿舍号不能为空', trigger: 'blur' },
          ],
          xinsushehao: [
            { required: true, message: '新宿舍号不能为空', trigger: 'blur' },
          ],
          genghuanyuanyin: [
            { required: true, message: '更换原因不能为空', trigger: 'blur' },
          ],
          shenqingshijian: [
          ],
          xuehao: [
          ],
          xingming: [
          ],
          shouji: [
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
      this.ruleForm.shenqingshijian = this.getCurDateTime()
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
            if(o=='shenqingbianhao'){
              this.ruleForm.shenqingbianhao = obj[o];
              this.ro.shenqingbianhao = true;
              continue;
            }
            if(o=='yuansushehao'){
              this.ruleForm.yuansushehao = obj[o];
              this.ro.yuansushehao = true;
              continue;
            }
            if(o=='xinsushehao'){
              this.ruleForm.xinsushehao = obj[o];
              this.ro.xinsushehao = true;
              continue;
            }
            if(o=='genghuanyuanyin'){
              this.ruleForm.genghuanyuanyin = obj[o];
              this.ro.genghuanyuanyin = true;
              continue;
            }
            if(o=='shenqingshijian'){
              this.ruleForm.shenqingshijian = obj[o];
              this.ro.shenqingshijian = true;
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
            if((json.xuehao!=''&&json.xuehao) || json.xuehao==0){
                this.ruleForm.xuehao = json.xuehao
            }
            if((json.xingming!=''&&json.xingming) || json.xingming==0){
                this.ruleForm.xingming = json.xingming
            }
            if((json.shouji!=''&&json.shouji) || json.shouji==0){
                this.ruleForm.shouji = json.shouji
            }
            if((json.suguanzhanghao!=''&&json.suguanzhanghao) || json.suguanzhanghao==0){
                this.ruleForm.suguanzhanghao = json.suguanzhanghao
            }
            if((json.suguanxingming!=''&&json.suguanxingming) || json.suguanxingming==0){
                this.ruleForm.suguanxingming = json.suguanxingming
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('genghuanshenqing/detail/${id}', {emulateJSON: true}).then(res => {
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
                 this.$http.get('genghuanshenqing/list', {
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


                          this.$http.post('genghuanshenqing/add', this.ruleForm).then(res => {
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


                  this.$http.post('genghuanshenqing/add', this.ruleForm).then(res => {
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
