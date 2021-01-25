<template xmlns:v-on="http://www.w3.org/1999/xhtml">
  <button class="qui-btn" v-on:click="btnClickEvent">
    <slot name="icon"></slot>
    <span>{{msg}}</span>
  </button>
</template>

<script>
  export default {
    props: {
      msg: {
        default: '下载'
      }
    },
    methods: {
      btnClickEvent: function () {
        alert('先弹出默认的方案')
        this.$emit('btnClickEvent')
      }
    }
  }
</script>
<style scoped>
  @import './css/reset.import.css';
  @import './css/qui-btn.import.css';
</style>
