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
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
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
      deleteBook(row) {
        const _this = this
        this.$axios.delete('http://localhost:8181/book/deleteById/' + row.id).then(function (resp) {
          _this.$message('修改成功')
          //_this.$router.push('/BookManage')
          window.location.reload()
        })
      },
      edit(row) {
        // row.id
        this.$router.push({
          path: '/update',
          query: {
            id: row.id
          }
        })
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
