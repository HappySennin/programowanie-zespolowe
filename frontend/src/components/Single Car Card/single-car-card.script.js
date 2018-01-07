import Vue from 'vue'
import {mapGetters} from 'vuex'

export default Vue.extend({
    props: {
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
      }
    },
    computed: {
      ...mapGetters({
        testGetter: 'testGetter',
        cars: 'cars',
        carTypes: 'carTypes'
      })
    },
  methods: {
    handleRentCar() {
      console.log("here will be request to server about this car availability")
    }
  }
  }
)
