import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import weixiurenyuan from '@/views/modules/weixiurenyuan/list'
    import shenqingxinxi from '@/views/modules/shenqingxinxi/list'
    import yuyueshiyong from '@/views/modules/yuyueshiyong/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import xunwuqishi from '@/views/modules/xunwuqishi/list'
    import paixingbang from '@/views/modules/paixingbang/list'
    import daoyuanqueren from '@/views/modules/daoyuanqueren/list'
    import shiwuzhaoling from '@/views/modules/shiwuzhaoling/list'
    import genghuansushe from '@/views/modules/genghuansushe/list'
    import shuidianxinxi from '@/views/modules/shuidianxinxi/list'
    import huanjingxinxi from '@/views/modules/huanjingxinxi/list'
    import systemintro from '@/views/modules/systemintro/list'
    import xueshengwupin from '@/views/modules/xueshengwupin/list'
    import jiaoshijinchusushe from '@/views/modules/jiaoshijinchusushe/list'
    import gonggongwupin from '@/views/modules/gonggongwupin/list'
    import baoxiudingdan from '@/views/modules/baoxiudingdan/list'
    import xueshengqiandao from '@/views/modules/xueshengqiandao/list'
    import xueshengbaoxiu from '@/views/modules/xueshengbaoxiu/list'
    import genghuanshenqing from '@/views/modules/genghuanshenqing/list'
    import baoxiujiedan from '@/views/modules/baoxiujiedan/list'
    import wailairenyuan from '@/views/modules/wailairenyuan/list'
    import news from '@/views/modules/news/list'
    import wanguiweiguidengji from '@/views/modules/wanguiweiguidengji/list'
    import suguan from '@/views/modules/suguan/list'
    import koulingma from '@/views/modules/koulingma/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import xueshengjinchusushe from '@/views/modules/xueshengjinchusushe/list'
    import susheweisheng from '@/views/modules/susheweisheng/list'
    import forum from '@/views/modules/forum/list'
    import xueshengpingjia from '@/views/modules/xueshengpingjia/list'
    import quxiaoyuyue from '@/views/modules/quxiaoyuyue/list'
    import xueshengqingjia from '@/views/modules/xueshengqingjia/list'
    import tongzhigonggao from '@/views/modules/tongzhigonggao/list'
    import sushewupin from '@/views/modules/sushewupin/list'
    import xueshengxinxi from '@/views/modules/xueshengxinxi/list'
    import messages from '@/views/modules/messages/list'
    import config from '@/views/modules/config/list'
    import weijidengji from '@/views/modules/weijidengji/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/weixiurenyuan',
        name: '维修人员',
        component: weixiurenyuan
      }
      ,{
	path: '/shenqingxinxi',
        name: '申请信息',
        component: shenqingxinxi
      }
      ,{
	path: '/yuyueshiyong',
        name: '预约使用',
        component: yuyueshiyong
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/xunwuqishi',
        name: '寻物启事',
        component: xunwuqishi
      }
      ,{
	path: '/paixingbang',
        name: '排行榜',
        component: paixingbang
      }
      ,{
	path: '/daoyuanqueren',
        name: '导员确认',
        component: daoyuanqueren
      }
      ,{
	path: '/shiwuzhaoling',
        name: '失物招领',
        component: shiwuzhaoling
      }
      ,{
	path: '/genghuansushe',
        name: '更换宿舍',
        component: genghuansushe
      }
      ,{
	path: '/shuidianxinxi',
        name: '水电信息',
        component: shuidianxinxi
      }
      ,{
	path: '/huanjingxinxi',
        name: '环境信息',
        component: huanjingxinxi
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/xueshengwupin',
        name: '学生物品',
        component: xueshengwupin
      }
      ,{
	path: '/jiaoshijinchusushe',
        name: '教师进出宿舍',
        component: jiaoshijinchusushe
      }
      ,{
	path: '/gonggongwupin',
        name: '公共物品',
        component: gonggongwupin
      }
      ,{
	path: '/baoxiudingdan',
        name: '报修订单',
        component: baoxiudingdan
      }
      ,{
	path: '/xueshengqiandao',
        name: '学生签到',
        component: xueshengqiandao
      }
      ,{
	path: '/xueshengbaoxiu',
        name: '学生报修',
        component: xueshengbaoxiu
      }
      ,{
	path: '/genghuanshenqing',
        name: '更换申请',
        component: genghuanshenqing
      }
      ,{
	path: '/baoxiujiedan',
        name: '报修接单',
        component: baoxiujiedan
      }
      ,{
	path: '/wailairenyuan',
        name: '外来人员',
        component: wailairenyuan
      }
      ,{
	path: '/news',
        name: '校园信息',
        component: news
      }
      ,{
	path: '/wanguiweiguidengji',
        name: '晚归未归登记',
        component: wanguiweiguidengji
      }
      ,{
	path: '/suguan',
        name: '宿管',
        component: suguan
      }
      ,{
	path: '/koulingma',
        name: '口令码',
        component: koulingma
      }
      ,{
	path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
      ,{
	path: '/xueshengjinchusushe',
        name: '学生进出宿舍',
        component: xueshengjinchusushe
      }
      ,{
	path: '/susheweisheng',
        name: '宿舍卫生',
        component: susheweisheng
      }
      ,{
	path: '/forum',
        name: '交流论坛',
        component: forum
      }
      ,{
	path: '/xueshengpingjia',
        name: '学生评价',
        component: xueshengpingjia
      }
      ,{
	path: '/quxiaoyuyue',
        name: '取消预约',
        component: quxiaoyuyue
      }
      ,{
	path: '/xueshengqingjia',
        name: '学生请假',
        component: xueshengqingjia
      }
      ,{
	path: '/tongzhigonggao',
        name: '通知公告',
        component: tongzhigonggao
      }
      ,{
	path: '/sushewupin',
        name: '宿舍物品',
        component: sushewupin
      }
      ,{
	path: '/xueshengxinxi',
        name: '学生信息',
        component: xueshengxinxi
      }
      ,{
	path: '/messages',
        name: '留言板管理',
        component: messages
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/weijidengji',
        name: '违纪登记',
        component: weijidengji
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
