import Vue from 'vue'
import Vuex from 'vuex'
import carsData from './modules/cars'
import signIn from './modules/sign-in'
import reservations from './modules/reservations'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    carsData,
    signIn,
    reservations
  }
})
