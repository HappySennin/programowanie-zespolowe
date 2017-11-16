import Vue from 'vue'
import {mapGetters} from 'vuex'

export default Vue.extend({
  data() {
    const item = {
      carBrand: 'mercedes',
      price: '100$',
      location: 'No. 189, Grove St, Los Angeles'
    };
    return {
      tableData: Array(20).fill(item)
    }
  },
  computed: {
    ...mapGetters({
        testGetter: 'testGetter'
                 })
    }
  }
)
