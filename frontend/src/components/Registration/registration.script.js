import Vue from 'vue'
import {mapActions} from 'vuex'

export default Vue.extend({
  data() {
    return {
      login: '',
      password: '',
    };
  },

  methods: {...mapActions('signIn', {
    setLoginMode: 'setLoginMode'
  }),
    open(title, msg) {
      this.$alert(msg, title, {
        confirmButtonText: 'OK'
      })
    },
    register() {
    if(!this.validLogin()) {
      this.open("Invalid Login", "Login must contain minimum eight characters or numbers")
    } else if (!this.validPassword()) {
      // this.open("Invalid Password", "Password must contain minimum eight characters, at least one letter, one number and one special character")
      this.open("Invalid password", "Password must contain minimum eight characters or numbers")
    } else {
      var self = this;
      this.$http.post('users/sign-up', {login: self.login, password: self.password}, {headers: {"Content-Type": "application/json"}}).then(response => {

        if(response.status === 200 && response.body === true) {
          self.open("Registration successful", "")
          self.login = ""
          self.password = ""
          this.$router.push('/sign-in')
        } else {
          self.open("Registration failed", "This login is used by other user. Please try again with other login")
        }
      }, response => {
        self.open("Registration failed", "This login is used by other user. Please try again with other login")
      });
    }
    },

    validLogin(){
      //Minimum eight characters only characters and numbers
      return this.login.match(/^[A-Za-z\d]{8,15}$/);
    },
    validPassword(){
      //Minimum eight characters, at least one letter, one number and one special character
      // return this.password.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,28}$/);
      //Minimum eight characters only characters and numbers
      return this.login.match(/^[A-Za-z\d]{8,15}$/);
    }
  }
})
