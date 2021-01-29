<template>
  <div class="app-layout">

    <!-- 头部导航 -->
    <div class="home-header">
      <div class="header-main">
        <div class="logo-wrapper">
          <div class="header-logo"></div>
          <span>hhg</span>
        </div>
        <nav-menu></nav-menu>
        <header-user></header-user>
      </div>
    </div>

    <!-- 中间内容 -->
    <div class="home-container">
      <!-- 二级路由插槽 -->
      <router-view/>
    </div>

    <!-- 底部 -->
    <home-footer></home-footer>
  </div>
</template>

<script>
  import NavMenu from '@/components/common/NavMenu'
  import HomeFooter from '@/components/common/Footer'
  import HeaderUser from '@/components/user/HeaderUser'

  export default {
    name: 'home',
    components: {HomeFooter, NavMenu, HeaderUser}
  }
</script>

<style>
  .home-header {
    margin-bottom: 30px;
    box-shadow: 0px 2px 0px #eee;
  }

  .header-main {
    width: 75%;
    margin: 0 auto;
    padding: 0;
    position: relative;
    display: flex;
  }

  .logo-wrapper {
    display: flex;
  }

  .header-logo{
    height: 50px;
    width: 50px;
    background-image: url("../assets/LOGO.jpg");
    background-size: 60px;
    margin-top: 5px;
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
