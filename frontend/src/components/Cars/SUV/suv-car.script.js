import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../../Single Car Card/single-car-card.vue'

export default Vue.extend({
    components: {'single-car-card': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        cars: 'cars'
      }),
    },
    methods: {
      ...mapActions('carsData', {
        setCars: 'setCars'
      }),
      getCars() {
        this.$http.get(`cars`)
          .then(response => {
            this.setCars({cars: response.body})
          }, response => {
          });
      },
    },
  data() {
    return {
      suvCars: []
    }
  },
  mounted() {
    this.getCars()
  },
  watch: {
    cars: function (val) {
      this.suvCars = this.cars.filter(c =>   c.typeName === 'SUV')
    }
  }
  }
)
