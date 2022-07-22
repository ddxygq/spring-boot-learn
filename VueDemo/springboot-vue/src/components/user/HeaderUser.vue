<template>

  <!-- 头像 -->
  <a href="http://localhost:8080/#/profile">
    <div class="user-login">
      <span>{{user.userName}}</span>
      <img src="../../assets/LOGO.jpg">
    </div>
  </a>

</template>

<script>
    export default {
        name: 'header-user',
        data() {
            return {
                user: {
                    'userName': 'hhg'
                },
                domain: 'http://localhost:8080/#/profile'
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

  .user-login span {
    line-height: 60px;
  }

  img {
    margin: 10px 5px;
    width: 40px;
    width: 40px;
  }
</style>
