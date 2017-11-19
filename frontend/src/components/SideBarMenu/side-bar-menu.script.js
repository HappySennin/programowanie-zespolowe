import Vue from 'vue'

export default Vue.extend({
  computed: {
    sideBarElements() {
      return this.$store.state.sideBarElements
    },
  }
})
