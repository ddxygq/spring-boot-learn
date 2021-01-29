<template>

  <!-- 头像 -->
  <div class="user-login">
    <span>{{user.userName}}</span>
    <a :href="UserProfile"><img src="../../assets/LOGO.jpg"></a>
  </div>

</template>

<script>
  export default {
    name: 'header-user',
    data() {
      return {
        user: {
          'userName': 'hhg'
        }
      }
    }
  }
</script>

<style scoped>
  .user-login {
    position: absolute;
    height: 60px;
    line-height: 60px;
    right: 0;
    display: flex;
  }

  img {
    margin: 10px 5px;
    width: 40px;
    width: 40px;
  }
</style>
