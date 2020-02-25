import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false
App.mpType = 'app'

const app = new Vue(App)
app.$mount()

// export default {
//     config: {
//       pages: ['pages/logs/main', '^pages/index/main'],
//       window: {
//         backgroundTextStyle: 'light',
//         navigationBarBackgroundColor: '#fff',
//         navigationBarTitleText: 'xxx',
//         navigationBarTextStyle: 'black'
//       }
//     }
//   }