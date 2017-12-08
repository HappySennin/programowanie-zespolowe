import Vue from 'vue'
import Vuex from 'vuex'
import carsData from './modules/cars'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    carsData
  }
})
