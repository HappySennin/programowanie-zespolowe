import * as types from './types'

export default {
  setReservations({commit, dispatch, state}, { reservations }) {
    commit(types.RESERVATIONS, { reservations })
  }
}
