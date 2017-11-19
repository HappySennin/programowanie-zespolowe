import Vue from 'vue'
import App from './App/app.vue'
import router from './router'
import {store} from './store'
import ElementUI from 'element-ui';
import locale from 'element-ui/lib/locale/lang/en'


Vue.use(ElementUI, { locale })
Vue.config.lang = 'en';


Vue.config.productionTip = false

new Vue({
  el: '#app',
  store,
  router,
  template: '<App/>',
  components: { App }
})
