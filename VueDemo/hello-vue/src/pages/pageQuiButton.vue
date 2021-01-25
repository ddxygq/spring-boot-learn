//pageQuiButton.vue
<template>
  <div id="pageQuiButton">
    <!--使用-->
    <qui-btn v-on:btnClickEvent="doSth" msg="我可以点击"></qui-btn>
    <qui-btn v-on:btnClickEvent="doSth1" msg="确定" ></qui-btn>
    <qui-btn v-on:btnClickEvent="doSth2" msg="取消" ></qui-btn>
    <qui-btn msg="下载" class="with-icon" v-on:btnClickEvent="doSth3">
      <img slot="icon" class="ico" src="../assets/image/apple.png">
    </qui-btn>
  </div>
</template>
<script>
  import quiBtn from '../components/quiButton.vue'
  export default {
    name: 'pageQuiButton',
    components: {
      'qui-btn': quiBtn
    },
    methods: {
      doSth: function () {
        alert('doSth')
      },
      doSth1: function () {
        alert('doSth1')
      },
      doSth2: function () {
        alert('doSth2')
      },
      doSth3: function () {
        alert('doSth3')
      }
    }
  }
</script>
