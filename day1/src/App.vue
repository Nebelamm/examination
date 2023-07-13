<template>
  <el-container class="layout-container-demo" style="height: 100%">
    <el-aside width="200px">
      <el-scrollbar>
        <div class="logo">
          东软考试管理系统
        </div>
        <el-menu
            active-text-color="#ffd04b"
            background-color="#545c64"
            class="el-menu-vertical-demo"
            default-active="2"
            text-color="#fff"
            :router="true"
            @open="handleOpen"
            @close="handleClose">

          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>基础管理</span>
            </template>
            <el-menu-item index="1-1">员工管理</el-menu-item>
            <el-menu-item index="1-2">考生管理</el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="2">
            <template #title>
              <el-icon><location /></el-icon>
              <span>题库中心</span>
            </template>
            <el-menu-item index="/subject/list">学科管理</el-menu-item>
            <el-menu-item index="/question/list">题库管理</el-menu-item>
          </el-sub-menu>

          <el-sub-menu index="3">
            <template #title>
              <el-icon><location /></el-icon>
              <span>考试中心</span>
            </template>
            <el-menu-item index="/examination/list">考试管理</el-menu-item>
            <el-menu-item index="/answer/list">阅卷管理</el-menu-item>
          </el-sub-menu>

          <el-menu-item index="4">
            <el-icon><setting /></el-icon>
            <span>Navigator Four</span>
          </el-menu-item>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px;line-height: 56px;" height="56px">
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 8px;"><setting
            /></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>View</el-dropdown-item>
                <el-dropdown-item>Add</el-dropdown-item>
                <el-dropdown-item>Delete</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <span>Tom</span>
        </div>
      </el-header>

      <el-main>
        <el-scrollbar>
          <router-view></router-view>
        </el-scrollbar>
      </el-main>
    </el-container>
  </el-container>
</template>


<script>
import { Menu as IconMenu, Message, Setting,Location } from '@element-plus/icons-vue'
export default {
  name: "App",
  components:{
    IconMenu,
    Message,
    Setting,
    Location
  }
}
</script>

<style scoped>

.layout-container-demo .el-header {
  position: relative;
  background-color: #545c64;
  color: #fff;
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: #545c64;
  height: 100%;
}

.layout-container-demo .el-aside .logo {
  height:56px;
  line-height:56px;
  text-align:center;
  color:#fff;
}

.layout-container-demo .el-aside .logo:hover{
  background-color: rgb(67, 74, 80);
}


.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
</style>

<style>
#app{
  height: 100%;
}
</style>