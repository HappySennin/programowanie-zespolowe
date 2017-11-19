import Vue from 'vue'
import {mapGetters} from 'vuex'
import SingleCarCard from '../Single Car Card/single-car-card.vue'

export default Vue.extend({
  components: {'single-car-card': SingleCarCard},
  computed: {
    ...mapGetters({
        testGetter: 'testGetter',
        cars: 'cars'
                 })
    }
  }
)
