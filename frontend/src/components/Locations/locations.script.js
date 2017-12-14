import Vue from 'vue'
import {mapGetters} from 'vuex'

export default Vue.extend({
    computed: {
      ...mapGetters({
        testGetter: 'testGetter',
        cars: 'cars',
        carTypes: 'carTypes'
      })
    },
  methods: {
    foo() {
      console.log("")
    }
  },
  data () {
    return {
      center: {lat: 51.0, lng: 17.0},
      markers: [{
        position: {lat: 51.1, lng: 17.0}
      }, {
        position: {lat: 51.1, lng:17.3}
      },
        {
          position: {lat: 51.0, lng:17.0}
        }]
    }
  }
  }
)
