import  Vue from 'vue'
import Router from 'vue-router'
import CarList from "../components/CarList/car-list.vue"
import LuxuryCars from '../components/Cars/Luxury/luxury-car.vue'
import SedanCars from '../components/Cars/Sedan/sedan-car.vue'
import SportCars from '../components/Cars/Sport/sport-car.vue'
import SUVCars from '../components/Cars/SUV/suv-car.vue'
import TruckCars from '../components/Cars/Truck/truck-car.vue'
import VanCars from '../components/Cars/Van/van-car.vue'
import SignIn from '../components/Sign in/sign-in.vue'
import Locations from '../components/Locations/locations.vue'
import Registration from '../components/Registration/registration.vue'

Vue.use(Router)

export default new Router({
  routes: [
    { path: '/', component: CarList },
    { path: '/luxury-cars', component: LuxuryCars },
    { path: '/sedan-cars', component: SedanCars },
    { path: '/sport-cars', component: SportCars },
    { path: '/suv-cars', component: SUVCars },
    { path: '/truck-cars', component: TruckCars },
    { path: '/van-cars', component: VanCars },
    { path: '/sign-in', component: SignIn },
    { path: '/locations', component: Locations },
    { path: '/registration', component: Registration },


  ],
  mode: "history"
})
