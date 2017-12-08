import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../../Single Car Card/single-car-card.vue'

export default Vue.extend({
    components: {'single-car-card': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        sedanCars: 'sedanCars'
      }),
    },
    methods: {
      ...mapActions('carsData', {
        setSedanCars: 'setSedanCars'
      }),
      getSedanCars() {
        if (this.sedanCars.length === 0) {
          this.$http.get(`cars/type/sedan`)
            .then(response => {
              console.log(response)
              this.setSedanCars({sedanCars: response.body})
            }, response => {
              console.log("error callback")
              console.log(response)
            });
        }
      },
    },
    mounted() {
      this.getSedanCars()
    }
  }
)
