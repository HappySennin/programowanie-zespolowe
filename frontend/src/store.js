import Vue from 'vue'
import Vuex from 'vuex'
import _ from 'lodash';

Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
    storeTest: "testRow",
    carTypes:[{type: 'Sedan'}, {type: 'SUV'}, {type: 'Van'}, {type: 'Sport Car'}, {type: 'Luxury car'}, {type: 'Truck'}],
    cars: _.map(Array(20).fill({
      carBrand: 'mercedes',
      price: '100$',
      location: 'No. 189, Grove St, Los Angeles'
    }), function(element, i) {
      return _.extend({}, element, {id: i});
    }),
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
