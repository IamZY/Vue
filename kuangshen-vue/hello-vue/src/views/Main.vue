<template>
  <el-menu :default-openeds="['1']">
    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right:15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>

      <el-main>
        <router-view/>
      </el-main>

    </el-container>
  </el-menu>
</template>

<script>
  export default {
    name: "Main"
  }
</script>

<style scoped lang="scss">
  .el-header {
    background-color: #048bd1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>

