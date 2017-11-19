import Vue from 'vue'
import {mapGetters} from 'vuex'
import SingleCarCard from '../../Single Car Card/single-car-card.vue'
import _ from 'lodash'

export default Vue.extend({
  components: {'single-car-card': SingleCarCard},
  computed: {
    ...mapGetters({
        testGetter: 'testGetter',
        cars: 'cars'
                 }),
    filteredCars() {
      return _.filter(this.cars, { 'type': 'Truck'});
    }
    }
  }
)
