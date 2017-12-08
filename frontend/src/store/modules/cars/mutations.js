import * as types from './types'

export default {
  [types.SET_LUXURY_CARS]: (state, { luxuryCars }) => {
    state.cars.luxury = luxuryCars;
  },
  [types.SET_SEDAN_CARS]: (state, { sedanCars }) => {
    state.cars.sedan = sedanCars;
  },
  [types.SET_SPORT_CARS]: (state, { sportCars }) => {
    state.cars.sportCar = sportCars;
  },
  [types.SET_SUV_CARS]: (state, { suvCars }) => {
    state.cars.suv = suvCars;
  },
  [types.SET_TRUCK_CARS]: (state, { truckCars }) => {
    state.cars.truck = truckCars;
  },
  [types.SET_VAN_CARS]: (state, { vanCars }) => {
    state.cars.van = vanCars;
  },
  [types.SET_ALL_CATEGORIES_CARS]: (state, { allCategoriesCars }) => {
    state.allCategoriesCars = allCategoriesCars;
  },

}
