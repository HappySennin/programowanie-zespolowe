import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../../Single Car Card/single-car-card.vue'

export default Vue.extend({
    components: {'single-car-card': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        vanCars: 'vanCars'
      }),
    },
    methods: {
      ...mapActions('carsData', {
        setVanCars: 'setVanCars'
      }),
      getVanCars() {
        if (this.vanCars.length === 0) {
          this.$http.get(`cars/type/van`)
            .then(response => {
              console.log(response)
              this.setVanCars({vanCars: response.body})
            }, response => {
              console.log("error callback")
              console.log(response)
            });
        }
      },
    },
    mounted() {
      this.getVanCars()
    }
  }
)
