import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import ReservationSingleCarCard from './My Reservation  Single Card/reservation-single-card.vue'

export default Vue.extend({
    components: {'reservation-single-car-card': ReservationSingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        cars: 'cars',
        availableCars: "availableCars"
      }),
      ...mapGetters('signIn', {
        userLogged: 'userLogged',
        userLogin: "userLogin",
        userID: "userID",
        token: "token"
      }),
      ...mapGetters('reservations', {
        reservations: 'reservations'
      }),
    },
    methods: {
      ...mapActions('signIn', {
        setUserID: 'setUserID'
      }),
      ...mapActions('carsData', {
        setCars: 'setCars',
        setAvailableCars: 'setAvailableCars'
      }),
      ...mapActions('reservations', {
        setReservations: 'setReservations'
      }),
      getReservationsHistory() {
        var self = this

        this.$http.get('cars')
          .then(response => {
            this.setCars({cars: response.body})
          }, response => {
          });

        this.$http.get(`users/getid/${self.userLogin}`, {headers: {"Content-Type": "application/json",
          "Authorization": self.token}}).then(response => {
          if(response.status === 200) {
            self.setUserID({userID: response.body})
            self.carBooked = true


            this.$http.get(`reservations/user/${response.body}`, {headers: {"Content-Type": "application/json",
              "Authorization": self.token}}).then(response2 => {
              if(response.status === 200) {
                self.setReservations({reservations: response2.body.reverse().map(r => {
                    r["carInfo"] = self.cars.find(e => e.id === r.carId)
                    return r
                  }
                )})
                self.setReservations({reservations: response2.body})
              } else {
                self.centerDialogVisible = true
              }
            }, response => {
              self.centerDialogVisible = true
            });


          } else {
            self.centerDialogVisible = true
          }
        }, response => {
          self.centerDialogVisible = true
        });
      },
    },
    mounted() {
      this.getReservationsHistory()
    }
  }
)
