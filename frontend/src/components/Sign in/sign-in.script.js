import Vue from 'vue'
import {mapActions} from 'vuex'

export default Vue.extend({
  data() {
    return {
      active: 0,
      type: "",
      input: "",
      login: '',
      password: '',
      placeholder: 'Login'
    };
  },

  methods: {...mapActions('signIn', {
    setLoginMode: 'setLoginMode',
    setUserLogin: 'setUserLogin',
    setUserToken: 'setUserToken',
  }),
    next() {
      if(this.active === 0) {
        this.handleUserLogin()
      } else if (this.active === 1) {
        this.handleUserPassword()
      }
    },
    open(title, msg) {
      this.$alert(msg, title, {
        confirmButtonText: 'OK'
      })
    },
    handleUserLogin() {
      if(true) {
        // if(this.validLogin()) {
        this.placeholder = 'Password'
        this.active++;
        this.login = this.input
        this.input = ''
        this.type = 'password'
      } else {
        this.input = ''
        this.open("Invalid Login", "Login must contain minimum eight characters or numbers")
      }
    },
    handleUserPassword() {
      this.password = this.input
      // if (this.validPassword()) {
        if (true) {
        var self = this;
        this.$http.post('login', {login: self.login, password: self.password}, {headers: {"Content-Type": "application/json"}}).then(response => {

          // console.log("SIGN IN USER RESPONSE: ")
          // console.log(response)
          if(response.status === 200 && response.ok === true) {
            self.setLoginMode({userLogged: true})
            self.setUserLogin({userLogin: self.login})
            self.setUserToken({token: response.headers.map.authorization[0]})
            self.$router.push('/')
            self.open("Sign in", "User logged successfully !")
          } else {
            self.handleLoginFailure()
          }
        }, response => {
          this.handleLoginFailure()
        });
      } else {
        this.handleLoginFailure()
        this.setLoginMode({userLogged: false})
      }
    },
    handleLoginFailure() {
      this.open("Log in failure", "")
      this.active = 0;
      this.input = ''
      this.type = ''
      this.placeholder = 'Login'
    },
    validLogin(){
      //Minimum eight characters only characters and numbers
      return this.input.match(/^[A-Za-z\d]{8,15}$/);
    },
    validPassword(){
      //Minimum eight characters, at least one letter, one number and one special character
      // return this.input.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,28}$/);
      return this.validLogin()
    }
  }
})
