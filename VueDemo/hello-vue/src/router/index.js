import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import about from '@/components/About'
import index from '../pages/index.vue'
import pageQuiButton from '../pages/pageQuiButton'
import pageQuiList from '../pages/pageQuiList'
import quiNav from '../components/quiNav'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/about',
      name: 'about',
      component: about
    },
    {
      path: '/index',
      name: 'index',
      component: index
    },
    {
      path: '/btn',
      name: 'pageQuiButton',
      component: pageQuiButton
    },
    {
      path: '/nav',
      name: 'nav',
      component: quiNav
    },
    {
      path: '/list',
      name: 'pageQuiList',
      component: pageQuiList
    }
  ]
})
