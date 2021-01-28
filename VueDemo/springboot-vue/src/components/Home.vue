<template>
  <div class="app-layout">
    <div class="home-header">
      <div class="header-main">
        <div class="logo-wrapper">
          <div class="header-logo"></div>
          <span>hhg</span>
        </div>
        <nav-menu></nav-menu>
        <div class="header-user"></div>
      </div>
    </div>

    <div class="home-container">
      <!-- 二级路由插槽 -->
      <router-view/>
    </div>

    <home-footer></home-footer>
  </div>
</template>

<script>
  import NavMenu from '@/components/common/NavMenu'
  import HomeFooter from '@/components/common/Footer'

  export default {
    name: 'home',
    components: {HomeFooter, NavMenu}
  }
</script>

<style>
  .home-header {
    margin-bottom: 30px;
  }

  .header-main {
    width: 75%;
    margin: 0 auto;
    padding: 0;
    display: flex;
  }

  .logo-wrapper {
    display: flex;
  }

  .header-logo{
    height: 60px;
    width: 60px;
    background-image: url("../assets/LOGO.jpg");
    background-size: 60px;
    margin-right: 10px;
  }

  .logo-wrapper span {
    font-size: 20px;
    line-height: 60px;
  }

  .home-container {
    width: 75%;
    margin: 0 auto;
  }
</style>
