import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../Single Car Card/single-car-card.vue'

export default Vue.extend({
    components: {'single-car-card': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        cars: 'allCategoriesCars'
      }),
    },
    methods: {
      ...mapActions('carsData', {
        setCars: 'setAllCategoriesCars'
      }),
      getCars() {
        if (this.cars.length === 0) {
          this.$http.get(`cars`)
            .then(response => {
              console.log(response)
              this.setCars({allCategoriesCars: response.body})
            }, response => {
              console.log("error callback")
              console.log(response)
            });
        }
      },
    },
    mounted() {
      this.getCars()
    }
  }
)
