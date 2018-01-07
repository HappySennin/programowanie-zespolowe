import Vue from 'vue'
import {mapGetters, mapActions} from 'vuex'
import SingleCarCard from '../Single Car Card/single-car-card.vue'

export default Vue.extend({
  components: {'SingleCarCard': SingleCarCard},
    computed: {
      ...mapGetters('carsData', {
        availableCars: 'availableCars'
      }),
    },
  methods: {
    ...mapActions('carsData', {
      setAvailableCars: 'setAvailableCars'
    }),
    foo(car){
      this.car = car
      this.centerDialogVisible = true
      console.log("click on marker")
    },
    getCars() {
      var self = this
        this.$http.get(`cars/available`)
          .then(response => {
            response.body.forEach(c => {
              self.renameObjectKey(c.localization, "latitude", "lat");
              self.renameObjectKey(c.localization, "longitude", "lng")
            })
            this.setAvailableCars({availableCars: response.body})
          }, response => {
          });
    },
    renameObjectKey(o, old_key, new_key) {
      if (old_key !== new_key) {
        Object.defineProperty(o, new_key,
          Object.getOwnPropertyDescriptor(o, old_key));
        delete o[old_key];
      }
    }
  },
  data () {
    return {
      center: {lat: 51.1, lng: 17.0},
      centerDialogVisible: false,
      car: {}
    }
  },
  mounted() {
    this.getCars()
  }
  }
)
