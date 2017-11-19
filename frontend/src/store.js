import Vue from 'vue'
import Vuex from 'vuex'
import _ from 'lodash';

Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
    storeTest: "testRow",
    carTypes:[{type: 'Sedan'}, {type: 'SUV'}, {type: 'Van'}, {type: 'Sport Car'}, {type: 'Luxury car'}, {type: 'Truck'}],
    cars: [
      {brand: "KIA Optima", type: "Sedan", year: 2015, dayPrice: 100},
      {brand: "KIA Optima", type: "Sedan", year: 2015, dayPrice: 100},
      {brand: "KIA Optima", type: "Sedan", year: 2015, dayPrice: 100},
      {brand: "KIA Stinger", type: "Sedan", year: 2017, dayPrice: 200},
      {brand: "KIA Stinger", type: "Sedan", year: 2017, dayPrice: 200},
      {brand: "KIA Stinger", type: "Sedan", year: 2017, dayPrice: 200},
      {brand: "Mercedes‑Maybach", type: "Luxury", year: 2016, dayPrice: 400},
      {brand: "Mercedes‑Maybach", type: "Luxury", year: 2017, dayPrice: 400},
      {brand: "Volkswagen Tiguan", type: "SUV", year: 2015, dayPrice: 150},
      {brand: "Volkswagen Tiguan", type: "SUV", year: 2014, dayPrice: 150},
      {brand: "Volkswagen Tiguan", type: "SUV", year: 2014, dayPrice: 150},
      {brand: "Volkswagen Tiguan", type: "SUV", year: 2014, dayPrice: 150},
      {brand: "Mercedes Cargo Van", type: "Van", year: 2013, dayPrice: 170},
      {brand: "Mercedes Cargo Van", type: "Van", year: 2012, dayPrice: 170},
      {brand: "Mercedes Cargo Van", type: "Van", year: 2015, dayPrice: 200},
      {brand: "Audi R8 Coupe Trims", type: "Sport", year: 2017, dayPrice: 1000},
      {brand: "Dodge RAM 3500 BIG HORN", type: "Truck", year: 2017, dayPrice: 500},
      {brand: "Dodge RAM 3500 BIG HORN", type: "Truck", year: 2017, dayPrice: 500}

    ],
    currentTab: 'CarList'
  },
  getters: {
    testGetter(state) {
      return state.storeTest
    },
    cars(state) {
      return state.cars
    },
    carTypes(state) {
      return state.carTypes
    },
    currentTab(state) {
      return state.currentTab
    }
  }
})
