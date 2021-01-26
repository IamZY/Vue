import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Book from '../views/Book'
import Page1 from '../views/Page1'
import Page2 from '../views/Page2'
import Page3 from '../views/Page3'
import Page4 from '../views/Page4'
import App from '../App'
import Index from '../views/Index'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '导航1',
      component: Index,
      redirect: '/page1',
      children: [

        {
          path: '/page1',
          name: '导航1',
          component: Page1
        },
        {
          path: '/page2',
          name: '导航2',
          component: Page2
        }

      ]
    },
    {
      path: '/navigation',
      name: '导航2',
      component: Index,
      children: [
        {
          path: '/book',
          name: 'book',
          component: Book
        },

        {
          path: '/page3',
          name: '导航3',
          component: Page3
        },
        {
          path: '/page4',
          name: '导航4',
          component: Page4
        }
      ]
    }
  ]
})
