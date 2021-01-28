// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import mavonEditor from "mavon-editor";
import "mavon-editor/dist/css/index.css";

Vue.use(ElementUi)
Vue.use(mavonEditor)

var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8043/api'

Vue.prototype.$axios = axios
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
