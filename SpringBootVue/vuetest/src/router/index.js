import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Book from '../views/Book'
import BookManage from '../views/BookManage'
import AddBook from '../views/AddBook'
import App from '../App'
import Index from '../views/Index'
import BookUpdate from '../views/BookUpdate'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '图书管理',
      component: Index,
      redirect: '/BookManage',
      show: true,
      children: [
        {
          path: '/BookManage',
          name: '查询图书',
          component: BookManage
        },
        {
          path: '/AddBook',
          name: '添加图书',
          component: AddBook
        },
        {
          path: '/update',
          component: BookUpdate,
          show: false
        }

      ]
    }

  ]
})
