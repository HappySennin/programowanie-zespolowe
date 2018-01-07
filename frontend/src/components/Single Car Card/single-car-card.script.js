import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'

export default Vue.extend({
    props: {
      id: {
        type: Number,
        required: true
      },
      brand: {
        type: String,
        required: true
      },
      model: {
        type: String,
        required: true
      },
      type: {
        type: String,
        required: true
      },
      price: {
        type: Number,
        required: true
      },
      image: {
        type: String,
        required: true
      }
      , power: {
        type: String,
        required: true
      },
      booked: {
        type: Boolean,
        required: true
      },
    },
    computed: {
      ...mapGetters('signIn', {
        userLogged: 'userLogged',
        userLogin: "userLogin",
        userID: "userID",
        token: "token"
      }),
      ...mapGetters('carsData', {
        cars: 'cars',
        availableCars: "availableCars"
      }),
    },
  data() {
    return {
      centerDialogVisible: false,
      carBooked: undefined
    };
  },
  methods: {
    ...mapActions('signIn', {
      setUserID: 'setUserID'
    }),
    ...mapActions('carsData', {
      setCars: 'setCars',
      setAvailableCars: 'setAvailableCars'
    }),
    handleRentCar() {
      var self = this

      if(this.booked) {
        this.openDialog("Warning", "Sorry, but this car is not available")
      }
      else if(this.userLogged){
        this.$http.get(`users/getid/${self.userLogin}`, {headers: {"Content-Type": "application/json",
          "Authorization": self.token}}).then(response => {
          if(response.status === 200) {
            self.setUserID({userID: response.body})
            self.carBooked = true
          } else {
            self.centerDialogVisible = true
          }
        }, response => {
          self.centerDialogVisible = true
        });



        self.$http.post('reservations/start', {userId: self.userID, carId: self.id}, {headers: {"Content-Type": "application/json",
          "Authorization": self.token}}).then(response => {
          if(response.status === 200) {

            this.$router.push('/')
            // this.$router.push('/my-reservations')
            self.centerDialogVisible = false
          } else {
            self.openDialog("Error", "Rent a car failure. Something went wrong")
          }
        }, response => {
          self.openDialog("Error", "Rent a car failure. Something went wrong")
        });


      } else {
        self.centerDialogVisible = true
      }
    },
    openDialog(title, msg) {
      this.$alert(msg, title, {
        confirmButtonText: 'OK'
      })
    },
    moveToSignIn() {
      this.centerDialogVisible = false
      this.$router.push('/sign-in')
    }
  },
  watch: {
    centerDialogVisible: function (val) {
      this.centerDialogVisible = val
    }
  },
  mounted() {
      this.carBooked = this.booked
  }
  }
)
