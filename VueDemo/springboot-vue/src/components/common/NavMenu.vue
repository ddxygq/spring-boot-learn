<template>
  <div id="navMenu">
    <el-menu :default-active="active" router mode="horizontal" id="navMenu">
      <el-menu-item v-for="(item, i) in navList" :key="i" :index="item.name">
        {{item.navItem}}
      </el-menu-item>
    </el-menu>
  </div>
</template>


<script>
  export default {
    name: 'NavMenu',
    data() {
      return {
        navList: [
          {name: '/index', navItem: '首页'},
          {name: '/users', navItem: '发现'},
          {name: '/about', navItem: 'About'},
          {name: '/write', navItem: 'Write'}
        ]
      }
    },
    computed: {
      active() {
        var routePath = this.$route.path
        var x = routePath.indexOf('/', 1)
        if (x != -1) {
          return routePath.substring(0, x)
        } else {
          return routePath
        }

      }
    }
  }
</script>

<style scoped>
  .el-menu {
    margin-left: 200px;
  }
  .el-menu-item{
    height: 60px;
    line-height: 60px;
    display: inline-block;
    font-size: 16px !important;
  }
</style>
