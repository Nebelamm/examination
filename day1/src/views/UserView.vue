<template>

  <table border width="80%" style="margin: 0px auto">
    <tr>
      <th>id</th>
      <th>name</th>
      <th>操作</th>
    </tr>

    <template v-for="user in dataList">
      <tr>
        <td>{{user.id}}</td>
        <td>{{user.name}}</td>
        <td>
          <a href="" @click.prevent="jumpDetail(user.id)">详情</a>
        </td>
      </tr>

    </template>

  </table>

</template>

<script>
import axios from "axios"
export default {
  name: "UserView",
  data(){
    return{
      users:[{
        id:1,
        name:"zs"
      },{
        id:2,
        name:"ls"
      }],
      dataList:[]
    }
  },
  methods:{
    jumpDetail(userId){
      this.$router.push({"path":"/user/"+userId,})
    },
    loadInfo(){
      axios.get('/xx/subjects')
          .then((respnse)=>{
            console.log(respnse.data.data);
            this.dataList = respnse.data.data;
          })
          .catch((error)=>{
            console.log(error);
          });
      console.log("end....")
    }
  },
  created() {
    this.loadInfo();
  }
}
</script>

<style scoped>

</style>