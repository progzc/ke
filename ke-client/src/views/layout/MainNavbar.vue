<template>
  <nav class="site-navbar">
    <div class="site-navbar-header">
      <h1 class="site-navbar-brand" @click="$router.push({ name: 'home' })">
        <span class="iconfont icon-ke">&#xea44;</span>
        <a class="site-navbar-brand-name" href="javascript:;">Monitor System for Ke of QQ</a>
      </h1>
    </div>
  </nav>
</template>

<script type="text/ecmascript-6">
export default {
  name: 'MainNavbar'
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>
  .site-navbar{
    .site-navbar-header{
      .site-navbar-brand{
        background-color: #263238;
        margin: 0;
        height: 56px;
        line-height: 56px;
        .icon-ke{
          color: #fffffb;
          font-size: 26px;
          margin: auto 10px;
        }
        .site-navbar-brand-name{
          color: #fffffb;
          text-decoration: none;
          &:hover{
            text-decoration: none;
          }
        }
      }
    }
  }
</style>
