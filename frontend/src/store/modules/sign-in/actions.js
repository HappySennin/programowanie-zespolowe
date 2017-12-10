import * as types from './types'

export default {
  setLoginMode({commit, dispatch, state}, { userLogged }) {
    commit(types.USER_LOGGED, { userLogged })
  }
}
