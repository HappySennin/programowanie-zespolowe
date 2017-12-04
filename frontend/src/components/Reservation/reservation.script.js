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
  popUp() {
    this.$alert('Reservation confirmed', 'Success', {
      confirmButtonText: 'OK',
  });
  }
},
  data() {
    return {
      value: '',
      value3: [new Date(2017, 10, 10, 10, 10), new Date(2017, 10, 11, 10, 10)],
      value4: ''
    }
  }
  }
)
