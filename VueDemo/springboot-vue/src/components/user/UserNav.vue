<template>
  <div class="user-nav">
    <el-menu :default-active="active" router>
      <el-menu-item v-for="(item, i) in userNavs" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: 'UserNav',
    data () {
      return {
        userNavs: [
          {name: '/userInfo', navItem: '信息'},
          {name: '/userArticles', navItem: '文章'}
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
  .user-nav {
    width: 200px;
    display: flex;
  }

  .el-menu-item {
    height: 60px;
    line-height: 60px;
    width: 200px;
    font-size: 18px !important;
  }
</style>
