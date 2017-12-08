import Vue from 'vue'
import App from './App/app.vue'
import router from './router'
import ElementUI from 'element-ui';
import locale from 'element-ui/lib/locale/lang/en'
import VueResource from 'vue-resource'
import store from './store/index'


Vue.use(VueResource);
Vue.http.options.root = 'http://localhost:8080';
Vue.use(ElementUI, { locale })
Vue.config.lang = 'en';
Vue.config.productionTip = false

const vueInit = () => {
  console.log('Initializing vue components...')
  new Vue({
    el: '#app',
    store,
    router,
    template: '<App/>',
    components: { App }
  })
}

vueInit();

