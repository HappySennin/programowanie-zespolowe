<template>
  <div id="app">
    <el-row>
      <el-col :span="24">
        <el-header >
          <img src="./assets/dummy-logo.png" />
        </el-header>
      </el-col>
    </el-row>

    <el-row style="width:90%; margin:auto">
    <el-col :span="4">
      <SideBarMenu/>
    </el-col>
    <el-col :span="20">
      <CarList/>
    </el-col>
    </el-row>

  </div>
</template>

<script>
import ElHeader from "../node_modules/element-ui/packages/header/src/main.vue";
import SideBarMenu from "./components/SideBarMenu.vue";
import CarList from "./components/CarList.vue";

export default {
  components: {ElHeader, SideBarMenu, CarList}
}
</script>

<style scoped>

  #app {
    @import url("//unpkg.com/element-ui@2.0.3/lib/theme-chalk/index.css");
  }
  .el-header img {
    margin-top:10px; height:50px; margin-left: 10%
  }
</style>
