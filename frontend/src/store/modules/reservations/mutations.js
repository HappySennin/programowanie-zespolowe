import * as types from './types'

export default {
  [types.RESERVATIONS]: (state, { reservations }) => {
    state.reservations = reservations;
  },
}
