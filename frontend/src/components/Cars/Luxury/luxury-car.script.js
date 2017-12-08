import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../../Single Car Card/single-car-card.vue'

export default Vue.extend({
    components: {'single-car-card': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        luxuryCars: 'luxuryCars'
      }),
    },
    methods: {
      ...mapActions('carsData', {
        setLuxuryCars: 'setLuxuryCars'
      }),
      getLuxuryCars() {
        if (this.luxuryCars.length === 0) {
          this.$http.get(`cars/type/luxury`)
            .then(response => {
              console.log(response)
              this.setLuxuryCars({luxuryCars: response.body})
            }, response => {
              console.log("error callback")
              console.log(response)
            });
        }
      },
    },
    mounted() {
      this.getLuxuryCars()
    }
  }
)
