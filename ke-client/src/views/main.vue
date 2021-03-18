<template>
  <div class="site-wrapper">
      <main-navbar></main-navbar>
      <main-sidebar></main-sidebar>
      <div class="site-content-wrapper">
        <main-content></main-content>
      </div>
  </div>
</template>

<script type="text/ecmascript-6">
import MainNavbar from 'views/layout/MainNavbar'
import MainSidebar from 'views/layout/MainSidebar'
import MainContent from 'views/layout/MainContent'

export default {
  name: 'main',
  components: {
    'main-navbar': MainNavbar,
    'main-sidebar': MainSidebar,
    'main-content': MainContent
  }
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>

</style>
