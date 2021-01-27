<template>
  <div>
    <nav-menu></nav-menu>

    <!-- 二级路由插槽 -->
    <router-view/>
  </div>
</template>

<script>
  import NavMenu from '@/components/common/NavMenu'

  export default {
    name: 'home',
    components: {NavMenu}
  }
</script>
