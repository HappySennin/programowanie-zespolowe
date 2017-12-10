import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'

export default Vue.extend({
  computed: {
    ...mapGetters('signIn', {
      userLogged: 'userLogged'
    }),
  },
  methods: {
    ...mapActions('signIn', {
      setLoginMode: 'setLoginMode'
    }),
    signOutUser() {
      this.setLoginMode({userLogged: false})
    }
  }
})
