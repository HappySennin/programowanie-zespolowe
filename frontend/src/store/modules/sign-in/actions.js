import * as types from './types'

export default {
  setLoginMode({commit, dispatch, state}, { userLogged }) {
    commit(types.USER_LOGGED, { userLogged })
  },
  setUserLogin({commit, dispatch, state}, { userLogin }) {
    commit(types.USER_LOGIN, { userLogin })
  },
  setUserToken({commit, dispatch, state}, { token }) {
    commit(types.TOKEN, { token })
  },
  setUserID({commit, dispatch, state}, { userID }) {
    commit(types.USER_ID, { userID })
  },
}
