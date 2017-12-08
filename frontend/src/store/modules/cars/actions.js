import * as types from './types'

export default {
  setLuxuryCars({commit, dispatch, state}, { luxuryCars }) {
    commit(types.SET_LUXURY_CARS, { luxuryCars })
  },
  setSedanCars({commit, dispatch, state}, { sedanCars }) {
    commit(types.SET_SEDAN_CARS, { sedanCars })
  },
  setSportCars({commit, dispatch, state}, { sportCars }) {
    commit(types.SET_SPORT_CARS, { sportCars })
  },
  setSuvCars({commit, dispatch, state}, { suvCars }) {
    commit(types.SET_SUV_CARS, { suvCars })
  },
  setTruckCars({commit, dispatch, state}, { truckCars }) {
    commit(types.SET_TRUCK_CARS, { truckCars })
  },
  setVanCars({commit, dispatch, state}, { vanCars }) {
    commit(types.SET_VAN_CARS, { vanCars })
  },
  setAllCategoriesCars({commit, dispatch, state}, { allCategoriesCars }) {
    commit(types.SET_ALL_CATEGORIES_CARS, { allCategoriesCars })
  }
}
