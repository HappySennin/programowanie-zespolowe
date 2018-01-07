import * as types from './types'

export default {
  setCars({commit, dispatch, state}, { cars }) {
    commit(types.SET_CARS, { cars })
  },
  setAvailableCars({commit, dispatch, state}, { availableCars }) {
    commit(types.SET_AVAILABLE_CARS, { availableCars })
  }
}
