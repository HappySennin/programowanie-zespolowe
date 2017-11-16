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
  data() {
    return {
      value: '',
      value3: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
      value4: ''
    }
  }
  }
)
