<template>
  <aside class="site-sidebar">
    <div class="site-sidebar-inner">
      <el-menu default-active="home"
               :collapse="isCollapse" :collapse-transition=false class="site-sidebar-menu">
        <el-menu-item class="site-sidebar-menu-item" index="home" @click="$router.push({ name: 'home' })">
          <span class="iconfont icon-home">&#xe633;</span><span>首页</span>
        </el-menu-item>
        <el-menu-item class="site-sidebar-menu-item" index="internet" @click="$router.push({ name: 'it/internet' })">
          <span class="iconfont icon-internet">&#xe6f8;</span><span>IT互联网</span>
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
  .site-sidebar{
    .site-sidebar-inner{
      position: absolute;
      left: 0;
      top: 56px;
      bottom: 0;
      width: 15%;
      border-right: 1px solid #f8f7f7;
      .el-menu{
        border-right: none;
      }
      .site-sidebar-menu{
        .site-sidebar-menu-item{
          font-size: 18px;
          font-weight: 400;
          .iconfont{
            margin: auto 10px auto 35px;
            font-size: 20px;
          }
        }
      }
    }
  }
</style>
