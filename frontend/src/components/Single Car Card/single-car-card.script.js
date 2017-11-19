import Vue from 'vue'
import {mapGetters} from 'vuex'

export default Vue.extend({
  props: ['brand', 'year', 'type', 'dayPrice'],
    computed: {
      ...mapGetters({
        testGetter: 'testGetter',
        cars: 'cars',
        carTypes: 'carTypes'
      })
    },
  }
)
