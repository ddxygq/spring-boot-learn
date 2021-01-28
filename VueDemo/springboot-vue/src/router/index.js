import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'default',
      redirect: '/home',
      component: Home
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'index',
          component: () => import('../components/home/Index')
        },
        {
          path: '/users',
          name: 'users',
          component: () => import('../components/User2')
        },
        {
          path: '/about',
          name: 'about',
          component: () => import('../components/common/about')
        },
        {
          path: '/write',
          name: 'Write',
          component: () => import('../components/article/ActicleEditor')
        }
      ]
    }
  ]
})
