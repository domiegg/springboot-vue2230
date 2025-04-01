<template>
<div :style='{"border":"1px solid #dfdfdf","padding":"20px","margin":"20px auto 0","borderRadius":"16px","background":"#fff","width":"1200px","position":"relative"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="物品名称" prop="wupinmingcheng">
            <el-input v-model="ruleForm.wupinmingcheng" 
                placeholder="物品名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="物品类别" prop="wupinleibie">
            <el-input v-model="ruleForm.wupinleibie" 
                placeholder="物品类别" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="物品所属" prop="wupinsuoshu">
            <el-input v-model="ruleForm.wupinsuoshu" 
                placeholder="物品所属" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="所处位置" prop="suochuweizhi">
            <el-input v-model="ruleForm.suochuweizhi" 
                placeholder="所处位置" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="物品数量" prop="wupinshuliang">
            <el-input v-model="ruleForm.wupinshuliang" 
                placeholder="物品数量" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}'  label="当前状态" prop="dangqianzhuangtai">
            <el-select v-model="ruleForm.dangqianzhuangtai" placeholder="请选择当前状态"  >
              <el-option
                  v-for="(item,index) in dangqianzhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}'  label="使用状态" prop="shiyongzhuangtai">
            <el-select v-model="ruleForm.shiyongzhuangtai" placeholder="请选择使用状态"  >
              <el-option
                  v-for="(item,index) in shiyongzhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="当前使用人" prop="dangqianshiyongren">
            <el-input v-model="ruleForm.dangqianshiyongren" 
                placeholder="当前使用人" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="使用人宿舍号" prop="shiyongrensushehao">
            <el-input v-model="ruleForm.shiyongrensushehao" 
                placeholder="使用人宿舍号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="楼栋号" prop="loudonghao">
            <el-input v-model="ruleForm.loudonghao" 
                placeholder="楼栋号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="登记日期" prop="dengjiriqi" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.dengjiriqi" 
                  type="date"
                  placeholder="登记日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="宿管账号" prop="suguanzhanghao">
            <el-input v-model="ruleForm.suguanzhanghao" 
                placeholder="宿管账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="宿管姓名" prop="suguanxingming">
            <el-input v-model="ruleForm.suguanxingming" 
                placeholder="宿管姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)"}' label="物品简介" prop="wupinjianjie">
            <editor 
                :style='{"minHeight":"300px","padding":"0","margin":"0","borderColor":"#ccc","backgroundColor":"#f9f9f9","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.wupinjianjie" 
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
            wupinmingcheng : false,
            wupinleibie : false,
            wupinsuoshu : false,
            suochuweizhi : false,
            wupinshuliang : false,
            dangqianzhuangtai : false,
            shiyongzhuangtai : false,
            dangqianshiyongren : false,
            shiyongrensushehao : false,
            loudonghao : false,
            dengjiriqi : false,
            wupinjianjie : false,
            suguanzhanghao : false,
            suguanxingming : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          wupinmingcheng: '',
          wupinleibie: '',
          wupinsuoshu: '',
          suochuweizhi: '',
          wupinshuliang: '',
          dangqianzhuangtai: '',
          shiyongzhuangtai: '',
          dangqianshiyongren: '',
          shiyongrensushehao: '',
          loudonghao: '',
          dengjiriqi: '',
          wupinjianjie: '',
          suguanzhanghao: '',
          suguanxingming: '',
        },
        dangqianzhuangtaiOptions: [],
        shiyongzhuangtaiOptions: [],


        rules: {
          wupinmingcheng: [
            { required: true, message: '物品名称不能为空', trigger: 'blur' },
          ],
          wupinleibie: [
            { required: true, message: '物品类别不能为空', trigger: 'blur' },
          ],
          wupinsuoshu: [
            { required: true, message: '物品所属不能为空', trigger: 'blur' },
          ],
          suochuweizhi: [
            { required: true, message: '所处位置不能为空', trigger: 'blur' },
          ],
          wupinshuliang: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          dangqianzhuangtai: [
          ],
          shiyongzhuangtai: [
          ],
          dangqianshiyongren: [
            { required: true, message: '当前使用人不能为空', trigger: 'blur' },
          ],
          shiyongrensushehao: [
            { required: true, message: '使用人宿舍号不能为空', trigger: 'blur' },
          ],
          loudonghao: [
          ],
          dengjiriqi: [
          ],
          wupinjianjie: [
          ],
          suguanzhanghao: [
          ],
          suguanxingming: [
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
      this.ruleForm.dengjiriqi = this.getCurDate()
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
            if(o=='wupinmingcheng'){
              this.ruleForm.wupinmingcheng = obj[o];
              this.ro.wupinmingcheng = true;
              continue;
            }
            if(o=='wupinleibie'){
              this.ruleForm.wupinleibie = obj[o];
              this.ro.wupinleibie = true;
              continue;
            }
            if(o=='wupinsuoshu'){
              this.ruleForm.wupinsuoshu = obj[o];
              this.ro.wupinsuoshu = true;
              continue;
            }
            if(o=='suochuweizhi'){
              this.ruleForm.suochuweizhi = obj[o];
              this.ro.suochuweizhi = true;
              continue;
            }
            if(o=='wupinshuliang'){
              this.ruleForm.wupinshuliang = obj[o];
              this.ro.wupinshuliang = true;
              continue;
            }
            if(o=='dangqianzhuangtai'){
              this.ruleForm.dangqianzhuangtai = obj[o];
              this.ro.dangqianzhuangtai = true;
              continue;
            }
            if(o=='shiyongzhuangtai'){
              this.ruleForm.shiyongzhuangtai = obj[o];
              this.ro.shiyongzhuangtai = true;
              continue;
            }
            if(o=='dangqianshiyongren'){
              this.ruleForm.dangqianshiyongren = obj[o];
              this.ro.dangqianshiyongren = true;
              continue;
            }
            if(o=='shiyongrensushehao'){
              this.ruleForm.shiyongrensushehao = obj[o];
              this.ro.shiyongrensushehao = true;
              continue;
            }
            if(o=='loudonghao'){
              this.ruleForm.loudonghao = obj[o];
              this.ro.loudonghao = true;
              continue;
            }
            if(o=='dengjiriqi'){
              this.ruleForm.dengjiriqi = obj[o];
              this.ro.dengjiriqi = true;
              continue;
            }
            if(o=='wupinjianjie'){
              this.ruleForm.wupinjianjie = obj[o];
              this.ro.wupinjianjie = true;
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
            if((json.suguanzhanghao!=''&&json.suguanzhanghao) || json.suguanzhanghao==0){
                this.ruleForm.suguanzhanghao = json.suguanzhanghao
            }
            if((json.suguanxingming!=''&&json.suguanxingming) || json.suguanxingming==0){
                this.ruleForm.suguanxingming = json.suguanxingming
            }
          }
        });
        this.dangqianzhuangtaiOptions = "正常,损坏".split(',')
        this.shiyongzhuangtaiOptions = "已预约,使用中,未使用".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('sushewupin/detail/${id}', {emulateJSON: true}).then(res => {
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
                 this.$http.get('sushewupin/list', {
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


                          this.$http.post('sushewupin/add', this.ruleForm).then(res => {
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


                  this.$http.post('sushewupin/add', this.ruleForm).then(res => {
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
