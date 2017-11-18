import  Vue from 'vue'
import Router from 'vue-router'
import CarList from "../components/CarList/car-list.vue"
import Reservation from "../components/Reservation/reservation.vue"


Vue.use(Router)

export default new Router({
  routes: [
    { path: '/', component: CarList },
    { path: '/reservation', component: Reservation }
  ],
  mode: "history"
})
