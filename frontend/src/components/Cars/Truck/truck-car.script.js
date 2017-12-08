import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../../Single Car Card/single-car-card.vue'

export default Vue.extend({
    components: {'single-car-card': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        truckCars: 'truckCars'
      }),
    },
    methods: {
      ...mapActions('carsData', {
        setTruckCars: 'setTruckCars'
      }),
      getTruckCars() {
        if (this.truckCars.length === 0) {
          this.$http.get(`cars/type/truck`)
            .then(response => {
              console.log(response)
              this.setTruckCars({truckCars: response.body})
            }, response => {
              console.log("error callback")
              console.log(response)
            });
        }
      },
    },
    mounted() {
      this.getTruckCars()
    }
  }
)
