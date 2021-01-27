<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="id"
        label="编号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        label="书名"
        width="120">
      </el-table-column>
      <el-table-column
        prop="author"
        label="作者"
        width="120">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="5"
      :total="total"
      @current-change="page"
    >
    </el-pagination>
  </div>
</template>

<script>
  export default {
    name: 'Page1',
    methods: {
      handleClick(row) {
        console.log(row);
      },
      page(currentPage) {
        const _this = this
        this.$axios.get('http://localhost:8181/book/list/'+currentPage+'/5').then(function (resp) {
          console.log(resp)
          _this.tableData = resp.data.content
          _this.total = resp.data.totalElements
        })
      }
    },
    created() {
      const _this = this
      this.$axios.get('http://localhost:8181/book/list/1/5').then(function (resp) {
        console.log(resp)
        _this.tableData = resp.data.content
        _this.total = resp.data.totalElements
      })
    },
    data() {
      return {
        total:null,
        tableData: [{
          id: '1',
          name: '解忧杂货店',
          author: '东野圭吾'
        }, {
          id: '2',
          name: '追风筝的人',
          author: '卡勒德·胡赛尼'
        }, {
          id: '3',
          name: '人间失格',
          author: '太宰治'
        }, {
          id: '4',
          name: '这就是二十四节气',
          author: '高春香'
        }]
      }
    }
  }
</script>
