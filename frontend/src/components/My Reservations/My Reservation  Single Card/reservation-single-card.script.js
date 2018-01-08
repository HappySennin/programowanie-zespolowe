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
      allPrice: {
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
      reservationFinished: {
        type: Boolean,
        required: true
      },
      reservationId: {
        type: Number,
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
      }),...mapGetters('reservations', {
        reservations: 'reservations'
      }),
    },
  data() {
    return {
      centerDialogVisible: false,
      carBooked: undefined,
      finished: undefined
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
    giveBack() {
      var self = this
      //TODO latitude and longitude are constant, we have to think how to change it
      this.$http.post('reservations/end', {id: self.reservationId, latitude: 51.1, longitude: 17.0}, {headers: {"Content-Type": "application/json",
        "Authorization": self.token}}).then(response2 => {
        if(response2.status === 200) {
          this.finished = true
        } else {
          self.openDialog("Error", "Rent a car failure. Something went wrong")
        }
      }, response2 => {
        self.openDialog("Error", "Rent a car failure. Something went wrong")
      });

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
  mounted() {
      this.carBooked = this.booked
    this.finished = this.reservationFinished
  },
  watch: {
    reservations: function (val) {
      this.finished = val.find(e => e.id === this.reservationId).endDate !== null
      },

  }
  }
)
