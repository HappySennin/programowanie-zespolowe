import Vue from 'vue'
import SideBarMenu from '@/components/SideBarMenu'

describe('SideBarMenu.vue', () => {
  it('should render correct contents', () => {
    const Constructor = Vue.extend(SideBarMenu)
    const vm = new Constructor().$mount()
    expect(vm.$el.querySelector('.el-aside .el-menu .el-menu-item').textContent)
      .to.equal('Sedan')
  })
})
