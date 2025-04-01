<template>
	<div class="main-content" :style='{"padding":"30px","background":"url(http://codegen.caihongy.cn/20220730/4b6f6d88fde34446904f3e1cd2807e39.png) center center/cover fixed no-repeat","height":"calc(100vh - 120px)"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"margin":"0 0 20px"}' :inline="true" :model="searchForm">
				<el-row :style='{"display":"block"}' >
					<div :style='{"width":"auto","margin":"0 10px 30px 0","background":"none","display":"inline-block"}' class="select" label="学号" prop="xuehao">
						<label :style='{"padding":"0 10px","margin":"0 10px 0 0","color":"#000","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">学号</label>
						<el-select  @change="xuehaoChange" clearable v-model="searchForm.xuehao" placeholder="请选择学号">
							<el-option v-for="(item,index) in xuehaoOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"width":"auto","margin":"0 10px 30px 0","background":"none","display":"inline-block"}'>
						<label :style='{"padding":"0 10px","margin":"0 10px 0 0","color":"#000","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">姓名</label>
						<el-input v-model="searchForm.xingming" placeholder="姓名" clearable></el-input>
					</div>
					<div :style='{"width":"auto","margin":"0 10px 30px 0","background":"none","display":"inline-block"}' class="select" label="类型" prop="leixing">
						<label :style='{"padding":"0 10px","margin":"0 10px 0 0","color":"#000","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">类型</label>
						<el-select  @change="leixingChange" clearable v-model="searchForm.leixing" placeholder="请选择类型">
							<el-option v-for="(item,index) in leixingOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"width":"auto","margin":"0 10px 30px 0","background":"none","display":"inline-block"}'>
						<label :style='{"padding":"0 10px","margin":"0 10px 0 0","color":"#000","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">宿管姓名</label>
						<el-input v-model="searchForm.suguanxingming" placeholder="宿管姓名" clearable></el-input>
					</div>
					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","outline":"none","margin":"0 10px","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"margin":"40px 0","display":"flex"}'>
					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('wanguiweiguidengji','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('wanguiweiguidengji','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>


					<download-excel v-if="isAuth('wanguiweiguidengji','导出')" class="export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "晚归未归登记.xls">
						<!-- 导出excel -->
						<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' type="danger">导出</el-button>
					</download-excel>
					<el-button :style='{"border":"1px solid #4662A1","cursor":"pointer","padding":"0 24px","boxShadow":"0 2px 0 0 #97C9D6","margin":"0 10px 0 0","outline":"none","color":"#4662A1","borderRadius":"0","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('wanguiweiguidengji','打印')" type="success" @click="printJson">打印</el-button>


				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","borderColor":"#eee","borderRadius":"30px","borderWidth":"1px 0 0 1px","background":"#fff","width":"100%","borderStyle":"solid"}' 
					v-if="isAuth('wanguiweiguidengji','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="dengjibianhao"
					label="登记编号">
						<template slot-scope="scope">
							{{scope.row.dengjibianhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="xuehao"
					label="学号">
						<template slot-scope="scope">
							{{scope.row.xuehao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="xingming"
					label="姓名">
						<template slot-scope="scope">
							{{scope.row.xingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="sushehao"
					label="宿舍号">
						<template slot-scope="scope">
							{{scope.row.sushehao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="chuangweihao"
					label="床位号">
						<template slot-scope="scope">
							{{scope.row.chuangweihao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="leixing"
					label="类型">
						<template slot-scope="scope">
							{{scope.row.leixing}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="dengjiriqi"
					label="登记日期">
						<template slot-scope="scope">
							{{scope.row.dengjiriqi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="suguanzhanghao"
					label="宿管账号">
						<template slot-scope="scope">
							{{scope.row.suguanzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="suguanxingming"
					label="宿管姓名">
						<template slot-scope="scope">
							{{scope.row.suguanxingming}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"#4662A1","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('wanguiweiguidengji','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"#4662A1","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('wanguiweiguidengji','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#fff","borderRadius":"30px","background":"#4662A1","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('wanguiweiguidengji','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
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





	</div>
</template>

<script>
//$graphType1
//$buttonName1
//$subNameList1
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      xuehaoOptions: [],
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
      "登记编号": "dengjibianhao",    //常规字段
      "学号": "xuehao",    //常规字段
      "姓名": "xingming",    //常规字段
      "宿舍号": "sushehao",    //常规字段
      "床位号": "chuangweihao",    //常规字段
      "类型": "leixing",    //常规字段
      "登记日期": "dengjiriqi",    //常规字段
      "备注": "beizhu",    //常规字段
      "宿管账号": "suguanzhanghao",    //常规字段
      "宿管姓名": "suguanxingming",    //常规字段
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








    init () {
          this.$http({
            url: `option/xuesheng/xuehao`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.xuehaoOptions = data.data;
            } else {
              this.$message.error(data.msg);
            }
          });
          this.leixingOptions = "晚归,未归".split(',')
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
           if(this.searchForm.xuehao!='' && this.searchForm.xuehao!=undefined){
            params['xuehao'] = this.searchForm.xuehao
          }
           if(this.searchForm.xingming!='' && this.searchForm.xingming!=undefined){
            params['xingming'] = '%' + this.searchForm.xingming + '%'
          }
           if(this.searchForm.leixing!='' && this.searchForm.leixing!=undefined){
            params['leixing'] = this.searchForm.leixing
          }
           if(this.searchForm.suguanxingming!='' && this.searchForm.suguanxingming!=undefined){
            params['suguanxingming'] = '%' + this.searchForm.suguanxingming + '%'
          }
      this.$http({
        url: "wanguiweiguidengji/page",
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
          url: "wanguiweiguidengji/delete",
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
          dengjibianhao: this.list[i].dengjibianhao,
          xuehao: this.list[i].xuehao,
          xingming: this.list[i].xingming,
          sushehao: this.list[i].sushehao,
          chuangweihao: this.list[i].chuangweihao,
          leixing: this.list[i].leixing,
          dengjiriqi: this.list[i].dengjiriqi,
          suguanzhanghao: this.list[i].suguanzhanghao,
          suguanxingming: this.list[i].suguanxingming,
        })
      }
      printJS({
        printable: data,
        properties: [
	  {
		field: 'dengjibianhao',
		displayName: '登记编号',
		columnSize: 1
	  },
	  {
		field: 'xuehao',
		displayName: '学号',
		columnSize: 1
	  },
	  {
		field: 'xingming',
		displayName: '姓名',
		columnSize: 1
	  },
	  {
		field: 'sushehao',
		displayName: '宿舍号',
		columnSize: 1
	  },
	  {
		field: 'chuangweihao',
		displayName: '床位号',
		columnSize: 1
	  },
	  {
		field: 'leixing',
		displayName: '类型',
		columnSize: 1
	  },
	  {
		field: 'dengjiriqi',
		displayName: '登记日期',
		columnSize: 1
	  },
	  {
		field: 'suguanzhanghao',
		displayName: '宿管账号',
		columnSize: 1
	  },
	  {
		field: 'suguanxingming',
		displayName: '宿管姓名',
		columnSize: 1
	  },
        ],
        type: 'json',
        header: '晚归未归登记',
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
