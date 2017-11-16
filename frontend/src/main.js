
import Vue from 'vue'
import App from './App/app.vue'
import router from './router'

import {Menu, Submenu, MenuItem, MenuItemGroup, Table, TableColumn, Row, Col, Header, Aside } from 'element-ui'

Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Row)
Vue.use(Col)
Vue.use(Header)
Vue.use(Aside)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
