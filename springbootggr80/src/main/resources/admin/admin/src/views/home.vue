<template>
<div class="content" :style='{"padding":"30px"}'>
	<div class="text" :style='{"margin":"50px auto","fontSize":"33px","color":"rgb(51, 51, 51)","textAlign":"center","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
    <div class="cardView">
        <div class="cards" :style='{"margin":"0 0 20px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
			<div :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('xuesheng','首页总数')">
				<div :style='{"width":"80px","background":"#4662A1","height":"80px"}'></div>
				<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{xueshengCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>学生总数</div>
				</div>
			</div>
			<div :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('jiaoshi','首页总数')">
				<div :style='{"width":"80px","background":"#4662A1","height":"80px"}'></div>
				<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{jiaoshiCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>教师总数</div>
				</div>
			</div>
			<div :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('suguan','首页总数')">
				<div :style='{"width":"80px","background":"#4662A1","height":"80px"}'></div>
				<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{suguanCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>宿管总数</div>
				</div>
			</div>
			<div :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('wailairenyuan','首页总数')">
				<div :style='{"width":"80px","background":"#4662A1","height":"80px"}'></div>
				<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{wailairenyuanCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>外来人员总数</div>
				</div>
			</div>
			<div :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('weixiurenyuan','首页总数')">
				<div :style='{"width":"80px","background":"#4662A1","height":"80px"}'></div>
				<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{weixiurenyuanCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>维修人员总数</div>
				</div>
			</div>
        </div>
        <div style="display: flex;align-items: center;width: 100%;margin-bottom: 10px;">
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('xuesheng','首页统计')">
                <div id="xueshengChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('jiaoshi','首页统计')">
                <div id="jiaoshiChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('suguan','首页统计')">
                <div id="suguanChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('wailairenyuan','首页统计')">
                <div id="wailairenyuanChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('weixiurenyuan','首页统计')">
                <div id="weixiurenyuanChart1" style="width:100%;height:400px;"></div>
            </el-card>
        </div>
    </div>
</div>
</template>
<script>
//5
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            xueshengCount: 0,
            jiaoshiCount: 0,
            suguanCount: 0,
            wailairenyuanCount: 0,
            weixiurenyuanCount: 0,
		};
	},
  mounted(){
    this.init();
    this.getxueshengCount();
    this.xueshengChat1();
    this.getjiaoshiCount();
    this.jiaoshiChat1();
    this.getsuguanCount();
    this.suguanChat1();
    this.getwailairenyuanCount();
    this.wailairenyuanChat1();
    this.getweixiurenyuanCount();
    this.weixiurenyuanChat1();
  },
  methods:{
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    },
    getxueshengCount() {
        this.$http({
            url: `xuesheng/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.xueshengCount = data.data
            }
        })
    },

    xueshengChat1() {
      this.$nextTick(()=>{

        var xueshengChart1 = echarts.init(document.getElementById("xueshengChart1"),'macarons');
        this.$http({
            url: "xuesheng/group/xingbie",
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
                            text: '学生人数',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                xueshengChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    xueshengChart1.resize();
                };
            }
        });
      })
    },






    getjiaoshiCount() {
        this.$http({
            url: `jiaoshi/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.jiaoshiCount = data.data
            }
        })
    },

    jiaoshiChat1() {
      this.$nextTick(()=>{

        var jiaoshiChart1 = echarts.init(document.getElementById("jiaoshiChart1"),'macarons');
        this.$http({
            url: "jiaoshi/group/xingbie",
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
                            text: '教师人数',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: ['25%', '55%'],
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                jiaoshiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    jiaoshiChart1.resize();
                };
            }
        });
      })
    },






    getsuguanCount() {
        this.$http({
            url: `suguan/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.suguanCount = data.data
            }
        })
    },

    suguanChat1() {
      this.$nextTick(()=>{

        var suguanChart1 = echarts.init(document.getElementById("suguanChart1"),'macarons');
        this.$http({
            url: "suguan/group/xingbie",
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
                        text: '宿管人数',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                suguanChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    suguanChart1.resize();
                };
            }
        });
      })
    },






    getwailairenyuanCount() {
        this.$http({
            url: `wailairenyuan/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.wailairenyuanCount = data.data
            }
        })
    },

    wailairenyuanChat1() {
      this.$nextTick(()=>{

        var wailairenyuanChart1 = echarts.init(document.getElementById("wailairenyuanChart1"),'macarons');
        this.$http({
            url: "wailairenyuan/group/xingbie",
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
                        text: '外来人员',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'value'
                    },
                    yAxis: {
                        type: 'category',
                        data: xAxis
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                wailairenyuanChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    wailairenyuanChart1.resize();
                };
            }
        });
      })
    },






    getweixiurenyuanCount() {
        this.$http({
            url: `weixiurenyuan/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.weixiurenyuanCount = data.data
            }
        })
    },

    weixiurenyuanChat1() {
      this.$nextTick(()=>{

        var weixiurenyuanChart1 = echarts.init(document.getElementById("weixiurenyuanChart1"),'macarons');
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
                weixiurenyuanChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    weixiurenyuanChart1.resize();
                };
            }
        });
      })
    },






  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
</style>
