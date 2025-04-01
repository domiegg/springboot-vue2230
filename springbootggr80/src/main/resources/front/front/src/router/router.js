import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import jiaoshiList from '../pages/jiaoshi/list'
import jiaoshiDetail from '../pages/jiaoshi/detail'
import jiaoshiAdd from '../pages/jiaoshi/add'
import suguanList from '../pages/suguan/list'
import suguanDetail from '../pages/suguan/detail'
import suguanAdd from '../pages/suguan/add'
import wailairenyuanList from '../pages/wailairenyuan/list'
import wailairenyuanDetail from '../pages/wailairenyuan/detail'
import wailairenyuanAdd from '../pages/wailairenyuan/add'
import weixiurenyuanList from '../pages/weixiurenyuan/list'
import weixiurenyuanDetail from '../pages/weixiurenyuan/detail'
import weixiurenyuanAdd from '../pages/weixiurenyuan/add'
import xueshengxinxiList from '../pages/xueshengxinxi/list'
import xueshengxinxiDetail from '../pages/xueshengxinxi/detail'
import xueshengxinxiAdd from '../pages/xueshengxinxi/add'
import xueshengqiandaoList from '../pages/xueshengqiandao/list'
import xueshengqiandaoDetail from '../pages/xueshengqiandao/detail'
import xueshengqiandaoAdd from '../pages/xueshengqiandao/add'
import xueshengwupinList from '../pages/xueshengwupin/list'
import xueshengwupinDetail from '../pages/xueshengwupin/detail'
import xueshengwupinAdd from '../pages/xueshengwupin/add'
import koulingmaList from '../pages/koulingma/list'
import koulingmaDetail from '../pages/koulingma/detail'
import koulingmaAdd from '../pages/koulingma/add'
import xueshengjinchususheList from '../pages/xueshengjinchusushe/list'
import xueshengjinchususheDetail from '../pages/xueshengjinchusushe/detail'
import xueshengjinchususheAdd from '../pages/xueshengjinchusushe/add'
import jiaoshijinchususheList from '../pages/jiaoshijinchusushe/list'
import jiaoshijinchususheDetail from '../pages/jiaoshijinchusushe/detail'
import jiaoshijinchususheAdd from '../pages/jiaoshijinchusushe/add'
import shenqingxinxiList from '../pages/shenqingxinxi/list'
import shenqingxinxiDetail from '../pages/shenqingxinxi/detail'
import shenqingxinxiAdd from '../pages/shenqingxinxi/add'
import daoyuanquerenList from '../pages/daoyuanqueren/list'
import daoyuanquerenDetail from '../pages/daoyuanqueren/detail'
import daoyuanquerenAdd from '../pages/daoyuanqueren/add'
import sushewupinList from '../pages/sushewupin/list'
import sushewupinDetail from '../pages/sushewupin/detail'
import sushewupinAdd from '../pages/sushewupin/add'
import gonggongwupinList from '../pages/gonggongwupin/list'
import gonggongwupinDetail from '../pages/gonggongwupin/detail'
import gonggongwupinAdd from '../pages/gonggongwupin/add'
import yuyueshiyongList from '../pages/yuyueshiyong/list'
import yuyueshiyongDetail from '../pages/yuyueshiyong/detail'
import yuyueshiyongAdd from '../pages/yuyueshiyong/add'
import quxiaoyuyueList from '../pages/quxiaoyuyue/list'
import quxiaoyuyueDetail from '../pages/quxiaoyuyue/detail'
import quxiaoyuyueAdd from '../pages/quxiaoyuyue/add'
import shuidianxinxiList from '../pages/shuidianxinxi/list'
import shuidianxinxiDetail from '../pages/shuidianxinxi/detail'
import shuidianxinxiAdd from '../pages/shuidianxinxi/add'
import susheweishengList from '../pages/susheweisheng/list'
import susheweishengDetail from '../pages/susheweisheng/detail'
import susheweishengAdd from '../pages/susheweisheng/add'
import wanguiweiguidengjiList from '../pages/wanguiweiguidengji/list'
import wanguiweiguidengjiDetail from '../pages/wanguiweiguidengji/detail'
import wanguiweiguidengjiAdd from '../pages/wanguiweiguidengji/add'
import shiwuzhaolingList from '../pages/shiwuzhaoling/list'
import shiwuzhaolingDetail from '../pages/shiwuzhaoling/detail'
import shiwuzhaolingAdd from '../pages/shiwuzhaoling/add'
import xunwuqishiList from '../pages/xunwuqishi/list'
import xunwuqishiDetail from '../pages/xunwuqishi/detail'
import xunwuqishiAdd from '../pages/xunwuqishi/add'
import weijidengjiList from '../pages/weijidengji/list'
import weijidengjiDetail from '../pages/weijidengji/detail'
import weijidengjiAdd from '../pages/weijidengji/add'
import huanjingxinxiList from '../pages/huanjingxinxi/list'
import huanjingxinxiDetail from '../pages/huanjingxinxi/detail'
import huanjingxinxiAdd from '../pages/huanjingxinxi/add'
import tongzhigonggaoList from '../pages/tongzhigonggao/list'
import tongzhigonggaoDetail from '../pages/tongzhigonggao/detail'
import tongzhigonggaoAdd from '../pages/tongzhigonggao/add'
import xueshengqingjiaList from '../pages/xueshengqingjia/list'
import xueshengqingjiaDetail from '../pages/xueshengqingjia/detail'
import xueshengqingjiaAdd from '../pages/xueshengqingjia/add'
import genghuansusheList from '../pages/genghuansushe/list'
import genghuansusheDetail from '../pages/genghuansushe/detail'
import genghuansusheAdd from '../pages/genghuansushe/add'
import genghuanshenqingList from '../pages/genghuanshenqing/list'
import genghuanshenqingDetail from '../pages/genghuanshenqing/detail'
import genghuanshenqingAdd from '../pages/genghuanshenqing/add'
import xueshengbaoxiuList from '../pages/xueshengbaoxiu/list'
import xueshengbaoxiuDetail from '../pages/xueshengbaoxiu/detail'
import xueshengbaoxiuAdd from '../pages/xueshengbaoxiu/add'
import baoxiujiedanList from '../pages/baoxiujiedan/list'
import baoxiujiedanDetail from '../pages/baoxiujiedan/detail'
import baoxiujiedanAdd from '../pages/baoxiujiedan/add'
import baoxiudingdanList from '../pages/baoxiudingdan/list'
import baoxiudingdanDetail from '../pages/baoxiudingdan/detail'
import baoxiudingdanAdd from '../pages/baoxiudingdan/add'
import xueshengpingjiaList from '../pages/xueshengpingjia/list'
import xueshengpingjiaDetail from '../pages/xueshengpingjia/detail'
import xueshengpingjiaAdd from '../pages/xueshengpingjia/add'
import paixingbangList from '../pages/paixingbang/list'
import paixingbangDetail from '../pages/paixingbang/detail'
import paixingbangAdd from '../pages/paixingbang/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'jiaoshi',
					component: jiaoshiList
				},
				{
					path: 'jiaoshiDetail',
					component: jiaoshiDetail
				},
				{
					path: 'jiaoshiAdd',
					component: jiaoshiAdd
				},
				{
					path: 'suguan',
					component: suguanList
				},
				{
					path: 'suguanDetail',
					component: suguanDetail
				},
				{
					path: 'suguanAdd',
					component: suguanAdd
				},
				{
					path: 'wailairenyuan',
					component: wailairenyuanList
				},
				{
					path: 'wailairenyuanDetail',
					component: wailairenyuanDetail
				},
				{
					path: 'wailairenyuanAdd',
					component: wailairenyuanAdd
				},
				{
					path: 'weixiurenyuan',
					component: weixiurenyuanList
				},
				{
					path: 'weixiurenyuanDetail',
					component: weixiurenyuanDetail
				},
				{
					path: 'weixiurenyuanAdd',
					component: weixiurenyuanAdd
				},
				{
					path: 'xueshengxinxi',
					component: xueshengxinxiList
				},
				{
					path: 'xueshengxinxiDetail',
					component: xueshengxinxiDetail
				},
				{
					path: 'xueshengxinxiAdd',
					component: xueshengxinxiAdd
				},
				{
					path: 'xueshengqiandao',
					component: xueshengqiandaoList
				},
				{
					path: 'xueshengqiandaoDetail',
					component: xueshengqiandaoDetail
				},
				{
					path: 'xueshengqiandaoAdd',
					component: xueshengqiandaoAdd
				},
				{
					path: 'xueshengwupin',
					component: xueshengwupinList
				},
				{
					path: 'xueshengwupinDetail',
					component: xueshengwupinDetail
				},
				{
					path: 'xueshengwupinAdd',
					component: xueshengwupinAdd
				},
				{
					path: 'koulingma',
					component: koulingmaList
				},
				{
					path: 'koulingmaDetail',
					component: koulingmaDetail
				},
				{
					path: 'koulingmaAdd',
					component: koulingmaAdd
				},
				{
					path: 'xueshengjinchusushe',
					component: xueshengjinchususheList
				},
				{
					path: 'xueshengjinchususheDetail',
					component: xueshengjinchususheDetail
				},
				{
					path: 'xueshengjinchususheAdd',
					component: xueshengjinchususheAdd
				},
				{
					path: 'jiaoshijinchusushe',
					component: jiaoshijinchususheList
				},
				{
					path: 'jiaoshijinchususheDetail',
					component: jiaoshijinchususheDetail
				},
				{
					path: 'jiaoshijinchususheAdd',
					component: jiaoshijinchususheAdd
				},
				{
					path: 'shenqingxinxi',
					component: shenqingxinxiList
				},
				{
					path: 'shenqingxinxiDetail',
					component: shenqingxinxiDetail
				},
				{
					path: 'shenqingxinxiAdd',
					component: shenqingxinxiAdd
				},
				{
					path: 'daoyuanqueren',
					component: daoyuanquerenList
				},
				{
					path: 'daoyuanquerenDetail',
					component: daoyuanquerenDetail
				},
				{
					path: 'daoyuanquerenAdd',
					component: daoyuanquerenAdd
				},
				{
					path: 'sushewupin',
					component: sushewupinList
				},
				{
					path: 'sushewupinDetail',
					component: sushewupinDetail
				},
				{
					path: 'sushewupinAdd',
					component: sushewupinAdd
				},
				{
					path: 'gonggongwupin',
					component: gonggongwupinList
				},
				{
					path: 'gonggongwupinDetail',
					component: gonggongwupinDetail
				},
				{
					path: 'gonggongwupinAdd',
					component: gonggongwupinAdd
				},
				{
					path: 'yuyueshiyong',
					component: yuyueshiyongList
				},
				{
					path: 'yuyueshiyongDetail',
					component: yuyueshiyongDetail
				},
				{
					path: 'yuyueshiyongAdd',
					component: yuyueshiyongAdd
				},
				{
					path: 'quxiaoyuyue',
					component: quxiaoyuyueList
				},
				{
					path: 'quxiaoyuyueDetail',
					component: quxiaoyuyueDetail
				},
				{
					path: 'quxiaoyuyueAdd',
					component: quxiaoyuyueAdd
				},
				{
					path: 'shuidianxinxi',
					component: shuidianxinxiList
				},
				{
					path: 'shuidianxinxiDetail',
					component: shuidianxinxiDetail
				},
				{
					path: 'shuidianxinxiAdd',
					component: shuidianxinxiAdd
				},
				{
					path: 'susheweisheng',
					component: susheweishengList
				},
				{
					path: 'susheweishengDetail',
					component: susheweishengDetail
				},
				{
					path: 'susheweishengAdd',
					component: susheweishengAdd
				},
				{
					path: 'wanguiweiguidengji',
					component: wanguiweiguidengjiList
				},
				{
					path: 'wanguiweiguidengjiDetail',
					component: wanguiweiguidengjiDetail
				},
				{
					path: 'wanguiweiguidengjiAdd',
					component: wanguiweiguidengjiAdd
				},
				{
					path: 'shiwuzhaoling',
					component: shiwuzhaolingList
				},
				{
					path: 'shiwuzhaolingDetail',
					component: shiwuzhaolingDetail
				},
				{
					path: 'shiwuzhaolingAdd',
					component: shiwuzhaolingAdd
				},
				{
					path: 'xunwuqishi',
					component: xunwuqishiList
				},
				{
					path: 'xunwuqishiDetail',
					component: xunwuqishiDetail
				},
				{
					path: 'xunwuqishiAdd',
					component: xunwuqishiAdd
				},
				{
					path: 'weijidengji',
					component: weijidengjiList
				},
				{
					path: 'weijidengjiDetail',
					component: weijidengjiDetail
				},
				{
					path: 'weijidengjiAdd',
					component: weijidengjiAdd
				},
				{
					path: 'huanjingxinxi',
					component: huanjingxinxiList
				},
				{
					path: 'huanjingxinxiDetail',
					component: huanjingxinxiDetail
				},
				{
					path: 'huanjingxinxiAdd',
					component: huanjingxinxiAdd
				},
				{
					path: 'tongzhigonggao',
					component: tongzhigonggaoList
				},
				{
					path: 'tongzhigonggaoDetail',
					component: tongzhigonggaoDetail
				},
				{
					path: 'tongzhigonggaoAdd',
					component: tongzhigonggaoAdd
				},
				{
					path: 'xueshengqingjia',
					component: xueshengqingjiaList
				},
				{
					path: 'xueshengqingjiaDetail',
					component: xueshengqingjiaDetail
				},
				{
					path: 'xueshengqingjiaAdd',
					component: xueshengqingjiaAdd
				},
				{
					path: 'genghuansushe',
					component: genghuansusheList
				},
				{
					path: 'genghuansusheDetail',
					component: genghuansusheDetail
				},
				{
					path: 'genghuansusheAdd',
					component: genghuansusheAdd
				},
				{
					path: 'genghuanshenqing',
					component: genghuanshenqingList
				},
				{
					path: 'genghuanshenqingDetail',
					component: genghuanshenqingDetail
				},
				{
					path: 'genghuanshenqingAdd',
					component: genghuanshenqingAdd
				},
				{
					path: 'xueshengbaoxiu',
					component: xueshengbaoxiuList
				},
				{
					path: 'xueshengbaoxiuDetail',
					component: xueshengbaoxiuDetail
				},
				{
					path: 'xueshengbaoxiuAdd',
					component: xueshengbaoxiuAdd
				},
				{
					path: 'baoxiujiedan',
					component: baoxiujiedanList
				},
				{
					path: 'baoxiujiedanDetail',
					component: baoxiujiedanDetail
				},
				{
					path: 'baoxiujiedanAdd',
					component: baoxiujiedanAdd
				},
				{
					path: 'baoxiudingdan',
					component: baoxiudingdanList
				},
				{
					path: 'baoxiudingdanDetail',
					component: baoxiudingdanDetail
				},
				{
					path: 'baoxiudingdanAdd',
					component: baoxiudingdanAdd
				},
				{
					path: 'xueshengpingjia',
					component: xueshengpingjiaList
				},
				{
					path: 'xueshengpingjiaDetail',
					component: xueshengpingjiaDetail
				},
				{
					path: 'xueshengpingjiaAdd',
					component: xueshengpingjiaAdd
				},
				{
					path: 'paixingbang',
					component: paixingbangList
				},
				{
					path: 'paixingbangDetail',
					component: paixingbangDetail
				},
				{
					path: 'paixingbangAdd',
					component: paixingbangAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
