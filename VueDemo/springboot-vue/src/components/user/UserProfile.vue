<template>
  <div class="layout-user">
    <user-nav></user-nav>
    <div class="user-main">
      <router-view/>
    </div>
  </div>
</template>

<script>
  import UserNav from '../../components/user/UserNav'

  export default {
    name: 'user-profile',
    components: {UserNav}
  }
</script>

<style scoped>
  .layout-user {
    display: flex;
  }

  .user-main {
    width: 100%;
    padding: 10px 20px;
  }
</style>
