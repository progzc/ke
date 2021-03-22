import Vue from 'vue'
import VueRouter from 'vue-router'
import { executeGetSysMenuNav } from 'network/api/route'

Vue.use(VueRouter)

// 解决ElementUI导航栏中的vue-router在3.0版本以上重复点菜单报错问题
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

const _import = require('./_import_' + process.env.NODE_ENV) // 智能懒加载：开发环境不采用懒加载，生产环境采用懒加载
// 配置全局路由
const globalRoutes = [
  { path: '/404', component: _import('common/404'), name: '404', meta: { title: '404未找到' } }
]
// 配置主路由
const mainRoutes = {
  path: '/',
  component: _import('Main'),
  name: 'Main',
  redirect: { name: 'home' },
  meta: { title: '主入口整体布局' },
  children: [
    { path: 'home', component: _import('common/home'), name: 'home', meta: { title: '首页' } }
  ],
  // 设置路由前置守卫
  beforeEnter (to, from, next) {
    // 不进行登录校验，直接放行
    next()
  }
}

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL, // 路由跳转时的基路径
  routes: globalRoutes.concat(mainRoutes), // 合并全局路由和主路由
  scrollBehavior: () => ({ y: 0 }), // 每次访问滚动条都置零1
  isAddDynamicMenuRoutes: false // 是否已添加动态菜单路由
})

// 设置全局前置守卫
router.beforeEach((to, from, next) => {
  // 如果动态路由已加载或当前访问路由是全局路由，则直接加载
  if (router.options.isAddDynamicMenuRoutes || isGlobalRoute(to)) {
    next()
  } else {
    executeGetSysMenuNav().then(data => {
      if (data && data.code === 200) {
        addDynamicMenuRoutes(data.menuList)
        router.options.isAddDynamicMenuRoutes = true
        sessionStorage.setItem('menuList', JSON.stringify(data.menuList || []))
        // ...是es6中的扩展运算符，可以将数组转换为函数的参数，...to确保addRoutes已完成
        // 若replace设置为true，那么导航不会留下history记录，点击浏览器回退按钮不会再回到这个路由
        next({ ...to, replace: false })
      } else {
        sessionStorage.setItem('menuList', '[]')
        next()
      }
    })
  }
})

/**
 * 判断当前路由是否是全局路由
 * @param route
 * @returns {boolean}
 */
function isGlobalRoute (route) {
  for (let i = 0; i < globalRoutes.length; i++) {
    if (route.path === globalRoutes[i].path) {
      return true
    }
  }
  return false
}

/**
 * 添加动态路由
 * @param menuList
 * @param routes
 */
function addDynamicMenuRoutes (menuList = [], routes = []) {
  let temp = []
  for (let i = 0; i < menuList.length; i++) {
    if (menuList[i].list && menuList[i].list.length >= 1) {
      temp = temp.concat(menuList[i].list)
    }
    if (menuList[i].url && /\S/.test(menuList[i].url)) { // 若url不为空
      // 替换url开头的"/"替换为""
      menuList[i].url = menuList[i].url.replace(/^\//, '')
      const route = {
        path: menuList[i].url,
        component: null,
        name: menuList[i].url,
        meta: {
          menuId: menuList[i].id,
          title: menuList[i].name,
          isDynamic: true, // 动态菜单
          isTab: true, // 是否通过tab展示内容 （true: 是, false: 否）
          iframeUrl: ''// 是否通过iframe嵌套展示内容（'以http[s]://开头': 是, '': 否）
        }
      }
      try {
        route.component = _import(`content/${menuList[i].component}`) || null
      } catch (e) { }
      routes.push(route)
    }
  }
  if (temp.length >= 1) {
    addDynamicMenuRoutes(temp, routes)
  } else {
    mainRoutes.name = 'main-dynamic'
    mainRoutes.children = routes
    router.addRoutes([
      mainRoutes,
      { path: '*', redirect: { name: '404' } }
    ])
    sessionStorage.setItem('dynamicMenuRoutes', JSON.stringify(mainRoutes.children || []))
    console.log('\n')
    console.log('%c!<-------------------- 动态(菜单)路由 s -------------------->', 'color:blue')
    console.log(mainRoutes.children)
    console.log('%c!<-------------------- 动态(菜单)路由 e -------------------->', 'color:blue')
  }
}

export default router
