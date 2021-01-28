<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
  import NavMenu from './components/common/NavMenu'

  export default {
    name: 'App',
    components: {NavMenu}
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
  }
</style>
