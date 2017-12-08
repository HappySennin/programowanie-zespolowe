import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../../Single Car Card/single-car-card.vue'

export default Vue.extend({
    components: {'single-car-card': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        sportCars: 'sportCars'
      }),
    },
    methods: {
      ...mapActions('carsData', {
        setSportCars: 'setSportCars'
      }),
      getSportCars() {
        if (this.sportCars.length === 0) {
          this.$http.get(`cars/type/sport`)
            .then(response => {
              console.log(response)
              this.setSportCars({sportCars: response.body})
            }, response => {
              console.log("error callback")
              console.log(response)
            });
        }
      },
    },
    mounted() {
      this.getSportCars()
    }
  }
)
