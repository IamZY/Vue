<template>
  <div>
    <table>
      <tr>
        <td>编号</td>
        <td>图书名称</td>
        <td>作者</td>
      </tr>
      <tr v-for="item in books">
        <td>{{item.id}}</td>
        <td>{{item.name}}</td>
        <td>{{item.author}}</td>
      </tr>
    </table>
    {{msg}}
  </div>
</template>


<script>
  export default {
    name: "Book",
    data() {
      return {
        msg: 'Hello Vue',
        books: [
          {
            id: 1,
            name: 'Java零基础实战',
            author: 'ntuzy'
          },
          {
            id: 2,
            name: 'Vue零基础实战',
            author: 'zhangsan'
          },
          {
            id: 3,
            name: 'Spring零基础实战',
            author: 'lisi'
          },
        ]
      }
    },
    created() {
      const _this = this
      this.$axios.get('http://localhost:8181/book/list').then(function (resp) {
        _this.books=resp.data
      })
    }
  }
</script>

<style scoped>

</style>
