<template>
  <aside class="site-sidebar">
    <div class="site-sidebar-inner">
      <el-menu default-active="home"
               :collapse="isCollapse" :collapse-transition=false class="site-sidebar__menu">
        <el-menu-item index="home" @click="$router.push({ name: 'home' })">
          <span class="iconfont icon-home">&#xea44;</span><span slot="home">首页</span>
        </el-menu-item>
        <el-menu-item index="internet" @click="$router.push({ name: 'it/internet' })">
          <span class="iconfont icon-internet">&#xe6f8;</span><span slot="internet">IT互联网</span>
        </el-menu-item>
      </el-menu>
    </div>
  </aside>
</template>

<script type="text/ecmascript-6">
export default {
  name: 'MainSidebar',
  data () {
    return {
      isCollapse: false
    }
  },
  created () {
  },
  mounted () {
  },
  methods: {
  }
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>

</style>
