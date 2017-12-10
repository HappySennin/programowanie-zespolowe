import * as types from './types'

export default {
  [types.USER_LOGGED]: (state, { userLogged }) => {
    state.userLogged = userLogged;
  }

}
