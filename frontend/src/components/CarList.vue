<template>
  <el-main>
    <el-table :data="tableData">
      <el-table-column prop="carBrand" label="Car Brand" >
      </el-table-column>
      <el-table-column prop="price" label="Price">
      </el-table-column>
      <el-table-column prop="location" label="Location">
      </el-table-column>
    </el-table>
  </el-main>
</template>

<script>
  export default {
    data() {
      const item = {
        carBrand: 'mercedes',
        price: '100$',
        location: 'No. 189, Grove St, Los Angeles'
      };
      return {
        tableData: Array(20).fill(item)
      }
    }

  }
</script>
