<template>
	<div class="main-content" :style='{"padding":"30px","background":"url(http://codegen.caihongy.cn/20220730/4b6f6d88fde34446904f3e1cd2807e39.png) center center/cover fixed no-repeat","height":"calc(100vh - 120px)"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"margin":"0 0 20px"}' :inline="true" :model="searchForm">
				<el-row :style='{"display":"block"}' >
					<div :style='{"width":"auto","margin":"0 10px 30px 0","background":"none","display":"inline-block"}'>
						<label :style='{"padding":"0 10px","margin":"0 10px 0 0","color":"#000","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">维修账号</label>
						<el-input v-model="searchForm.weixiuzhanghao" placeholder="维修账号" clearable></el-input>
					</div>
					<div :style='{"width":"auto","margin":"0 10px 30px 0","background":"none","display":"inline-block"}'>
						<label :style='{"padding":"0 10px","margin":"0 10px 0 0","color":"#000","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">维修姓名</label>
						<el-input v-model="searchForm.weixiuxingming" placeholder="维修姓名" clearable></el-input>
					</div>
					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","outline":"none","margin":"0 10px","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"margin":"40px 0","display":"flex"}'>
					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('weixiurenyuan','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('weixiurenyuan','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>

					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('weixiurenyuan','导入')" type="success" @click="importHandler()">导入</el-button>
                    <el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('weixiurenyuan','上传模板')" type="success" @click="importClcik">上传模板</el-button>
                    <el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('weixiurenyuan','下载模板')" type="success" @click="download($base.url + 'upload/weixiurenyuan_template.xlsx')">下载模板</el-button>


					<download-excel v-if="isAuth('weixiurenyuan','导出')" class="export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "维修人员.xls">
						<!-- 导出excel -->
						<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' type="danger">导出</el-button>
					</download-excel>
					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('weixiurenyuan','打印')" type="success" @click="printJson">打印</el-button>


					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('weixiurenyuan','维修人员')" type="warning" @click="chartDialog1()">维修人员</el-button>
				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","borderColor":"#eee","borderRadius":"30px","borderWidth":"1px 0 0 1px","background":"#fff","width":"100%","borderStyle":"solid"}' 
					v-if="isAuth('weixiurenyuan','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="weixiuzhanghao"
					label="维修账号">
						<template slot-scope="scope">
							{{scope.row.weixiuzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="weixiuxingming"
					label="维修姓名">
						<template slot-scope="scope">
							{{scope.row.weixiuxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="nianling"
					label="年龄">
						<template slot-scope="scope">
							{{scope.row.nianling}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="xingbie"
					label="性别">
						<template slot-scope="scope">
							{{scope.row.xingbie}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="lianxidianhua"
					label="联系电话">
						<template slot-scope="scope">
							{{scope.row.lianxidianhua}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="touxiang" width="200" label="头像">
						<template slot-scope="scope">
							<div v-if="scope.row.touxiang">
								<img v-if="scope.row.touxiang.substring(0,4)=='http'" :src="scope.row.touxiang.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.touxiang.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"#4662A1","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('weixiurenyuan','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"#4662A1","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('weixiurenyuan','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"#4662A1","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('weixiurenyuan','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="true"
					:style='{"width":"100%","padding":"0","margin":"20px 0 0","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>



		<el-dialog title="导入" :visible.sync="importVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item class="upload" label="文件" prop="excelFile">
				  <excel-file-upload
				  tip="点击上传直接导入excel文件"
				  action="weixiurenyuan/importExcel"
				  :limit="1"
                  @change="importChange"
				  ></excel-file-upload>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="importHandler()">关 闭</el-button>
			</span>
		</el-dialog>
        <el-dialog title="上传模板" :visible.sync="importVis" width="50%">
            <el-form ref="form" :model="importForm" label-width="80px">
                <el-form-item class="upload" label="文件" prop="excelFile">
                    <el-upload class="upload-demo" drag :action="$base.url + 'file/upload?type=weixiurenyuan_template'"
                        :show-file-list="false" :on-success="importSuccess">
                        <i class="el-icon-upload"></i>
                        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                    </el-upload>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="importVis=false">关 闭</el-button>
            </span>
        </el-dialog>


		<el-dialog
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="xingbieChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>
	</div>
</template>

<script>
//折滑面
//维修人员
//[]
import * as echarts from 'echarts'
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      importVisiable: false,
      importVis: false,
      importForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      layouts: ["total","prev","pager","next","sizes","jumper"],
//导出excel
      json_fields: {
      "维修账号": "weixiuzhanghao",    //常规字段
      "密码": "mima",    //常规字段
      "维修姓名": "weixiuxingming",    //常规字段
      "年龄": "nianling",    //常规字段
      "性别": "xingbie",    //常规字段
      "联系电话": "lianxidianhua",    //常规字段
      "头像": "touxiang",    //常规字段
      },
      json_meta: [
        [
          {
            " key ": " charset ",
            " value ": " utf- 8 "
          }
        ]
      ],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },



//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{

        var xingbieChart1 = echarts.init(document.getElementById("xingbieChart1"),'macarons');
        this.$http({
            url: "weixiurenyuan/group/xingbie",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].xingbie);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].xingbie
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '维修人员',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'line',
                        areaStyle: {},
                        smooth: true
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                xingbieChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    xingbieChart1.resize();
                };
            }
        });
      })
    },





    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.weixiuzhanghao!='' && this.searchForm.weixiuzhanghao!=undefined){
            params['weixiuzhanghao'] = '%' + this.searchForm.weixiuzhanghao + '%'
          }
           if(this.searchForm.weixiuxingming!='' && this.searchForm.weixiuxingming!=undefined){
            params['weixiuxingming'] = '%' + this.searchForm.weixiuxingming + '%'
          }
      this.$http({
        url: "weixiurenyuan/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    importChange(){
        this.importHandler()
        this.getDataList()
    },
    importClcik() {
        this.importVis = true
    },
    importSuccess(e) {
        if(e.code==0){
            this.$message.success('上传成功');
            this.importVis = false
            
        }
    },
    importHandler() {
        this.importVisiable = !this.importVisiable;
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "weixiurenyuan/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


    async printJson() {
      //通过getdata调用后台接口获取数据封装到res
      this.list = this.dataList;
      let data = []
      for (let i=0; i < this.list.length; i++) {
          data.push({
          weixiuzhanghao: this.list[i].weixiuzhanghao,
          mima: this.list[i].mima,
          weixiuxingming: this.list[i].weixiuxingming,
          nianling: this.list[i].nianling,
          xingbie: this.list[i].xingbie,
          lianxidianhua: this.list[i].lianxidianhua,
        })
      }
      printJS({
        printable: data,
        properties: [
	  {
		field: 'weixiuzhanghao',
		displayName: '维修账号',
		columnSize: 1
	  },
	  {
		field: 'mima',
		displayName: '密码',
		columnSize: 1
	  },
	  {
		field: 'weixiuxingming',
		displayName: '维修姓名',
		columnSize: 1
	  },
	  {
		field: 'nianling',
		displayName: '年龄',
		columnSize: 1
	  },
	  {
		field: 'xingbie',
		displayName: '性别',
		columnSize: 1
	  },
	  {
		field: 'lianxidianhua',
		displayName: '联系电话',
		columnSize: 1
	  },
        ],
        type: 'json',
        header: '维修人员',
        // 样式设置
        gridStyle: 'border: 2px solid #3971A5;',
        gridHeaderStyle: 'color: red;  border: 2px solid #3971A5;'
      })
    },
  }

};
</script>
<style lang="scss" scoped>
	//导出excel
	.export-excel-wrapper{
		display: inline-block;
	}
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #4662A1;
				border-radius: 0;
				padding: 0 12px;
				box-shadow: 0px 10px 0px 10px #4662A1;
				outline: none;
				color: #000;
				width: auto;
				font-size: 14px;
				min-width: 120px;
				height: 40px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid #4662A1;
				border-radius: 0;
				padding: 0 10px;
				box-shadow: 0px 10px 0px 10px #4662A1;
				outline: none;
				margin: 0 10px;
				color: #000;
				width: auto;
				font-size: 14px;
				min-width: 120px;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #4662A1;
				border-radius: 0;
				padding: 0 10px 0 20px;
				box-shadow: 0px 10px 0px 10px #4662A1;
				outline: none;
				margin: 0 10px;
				color: rgba(64, 158, 255, 1);
				width: auto;
				font-size: 14px;
				min-width: 120px;
				height: 40px;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: #D4D4D4;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				color: #000;
				background: transparent;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #666;
				background: #fff;
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #000;
				background: #EFEFF0;
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #666;
				background: #fff;
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #4662A1;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #FFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #4662A1;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
