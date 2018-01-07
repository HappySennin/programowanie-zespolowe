import * as types from './types'

export default {
  [types.SET_CARS]: (state, { cars }) => {
    state.cars = cars;
  },
  [types.SET_AVAILABLE_CARS]: (state, { availableCars }) => {
    state.availableCars = availableCars;
  },

}
