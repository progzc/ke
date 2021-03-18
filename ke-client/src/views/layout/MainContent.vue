<template>
  <main class="site-content">
    <div class="site-content-inner">
      <router-view/>
    </div>
  </main>
</template>

<script type="text/ecmascript-6">
export default {
  name: 'MainContent',
  methods: {

  }
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>
  .site-content{
    .site-content-inner{
      position: absolute;
      right: 0;
      top: 56px;
      bottom: 0;
      width: 85%;
    }
  }
</style>
