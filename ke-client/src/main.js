import Vue from 'vue'
import App from '@/App.vue'
import router from '@/router'
import store from '@/store'
import VueCookie from 'vue-cookie' // 导入vue-cookie插件

import ElementUI from 'element-ui' // 导入ElementUI
import 'element-ui/lib/theme-chalk/index.css' // 导入ElementUI全局样式
import 'common/scss/index.scss' // 导入全局样式文件src/common/scss/index.scss

Vue.use(VueCookie)
Vue.use(ElementUI, { size: 'small', zIndex: 3000 })
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
