import * as types from './types'

export default {
  [types.USER_LOGGED]: (state, { userLogged }) => {
    state.userLogged = userLogged;
  },
  [types.USER_LOGIN]: (state, { userLogin }) => {
    state.userLogin = userLogin;
  },
  [types.TOKEN]: (state, { token }) => {
    state.token = token;
  },
  [types.USER_ID]: (state, { userID }) => {
    state.userID = userID;
  }

}
