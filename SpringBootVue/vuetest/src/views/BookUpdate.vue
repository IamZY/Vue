<template>
  <div>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="图书编号">
        <el-input v-model="ruleForm.id" readOnly></el-input>
      </el-form-item>

      <el-form-item label="图书名称">
        <el-input v-model="ruleForm.name" ></el-input>
      </el-form-item>

      <el-form-item label="作者">
        <el-input v-model="ruleForm.author" ></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
  export default {
    name: 'BookUpdate',
    data() {
      return {
        ruleForm: {
          id: '',
          name: '',
          author: ''
        },
        rules: {

        }
      };
    },
    methods: {
      test() {
        console.log(this.ruleForm)
      },
      submitForm(formName) {
        const _this = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            const _this = this
            this.$axios.put('http://localhost:8181/book/update',this.ruleForm).then(function (resp) {
              if (resp.data == 'success') {
                _this.$message('修改成功')
                _this.$router.push('/BookManage')
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    created() {
      // alert(this.$route.query.id)
      const _this = this
      this.$axios.get('http://localhost:8181/book/findById/' + this.$route.query.id).then(function (resp) {
        _this.ruleForm = resp.data
      })
    }
  }
</script>

<style scoped>

</style>
