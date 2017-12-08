import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../../Single Car Card/single-car-card.vue'

export default Vue.extend({
    components: {'single-car-card': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        suvCars: 'suvCars'
      }),
    },
    methods: {
      ...mapActions('carsData', {
        setSuvCars: 'setSuvCars'
      }),
      getSuvCars() {
        if (this.suvCars.length === 0) {
          this.$http.get(`cars/type/suv`)
            .then(response => {
              console.log(response)
              this.setSuvCars({suvCars: response.body})
            }, response => {
              console.log("error callback")
              console.log(response)
            });
        }
      },
    },
    mounted() {
      this.getSuvCars()
    }
  }
)
