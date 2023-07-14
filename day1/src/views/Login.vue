<template>
  <div class="login-wrap">
    <el-form class="login-container" :model="teacher">
      <h1 class="title">用户登陆</h1>
      <el-form-item >
        <el-input type="text" v-model="teacher.name"  placeholder="用户账号" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="password" v-model="teacher.password" placeholder="用户密码" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="doLogin" style="width: 100%;">登陆</el-button>
      </el-form-item>
      <el-row style="text-align: center;margin-top: -10px;">
        <el-link type="primary" @click="doRegister">注册账号</el-link>
        <el-link type="primary" @click="">忘记密码</el-link>
      </el-row>
    </el-form>
  </div>
</template>

<script>

import qs from "qs";
import axios from "axios";

export default{
  name:'Login',
  data:function(){
    return {
      teacher:{
        name:'',
        password:''
      }
    }
  },
  methods:{
    doLogin:function(){
      let param = qs.stringify(this.teacher);
      axios.post('/edu/admin/login',param).then((response)=>{
        if(response.data.code == 200){
          console.log("login success")

        }
      }).catch((error)=>{
        console.log(error);
      });

    },
    doRegister:function(){
    }
  }
}
</script>

<style scoped>
.login-wrap {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  padding-top: 10%;
  background-color: #112346;
}

.login-container {
  border-radius: 10px;
  margin: 0px auto;
  width: 350px;
  padding: 30px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  text-align: left;
  box-shadow: 0 0 20px 2px rgba(0, 0, 0, 0.1);
}

.title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>