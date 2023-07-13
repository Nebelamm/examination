<template>
  <div class="container">
    <el-row style="margin-bottom: 10px">
      <el-button type="primary" @click="handleAdd">添加</el-button>
    </el-row>


    <el-table :data="tableData" border>

      <el-table-column label="id" width="180">
        <template #default="scope">
          {{scope.row.id}}
        </template>
      </el-table-column>


      <el-table-column label="名字" width="180">
        <template #default="scope">
          {{scope.row.name}}
        </template>
      </el-table-column>


      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <el-dialog v-model="dialogSubjectVisible" title="保存学科">
    {{subject}}
    <el-form :model="subject">
      <el-form-item label="名字">
        <el-input v-model="subject.name" autocomplete="off" />
      </el-form-item>

    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogSubjectVisible = false">关闭</el-button>
        <el-button type="primary" @click="save">保存</el-button>
      </span>
    </template>
  </el-dialog>



</template>

<script>
import axios from "axios";
import qs from "qs"
export default {
  name: "List",
  data(){
    return {
      tableData:[],
      dialogSubjectVisible:false,
      subject:{
        id:null,
        name:null
      }
    }
  },
  methods:{
    loadSubject(){
      axios.get('/edu/subjects')
          .then((respnse)=>{
            this.tableData = respnse.data.data;
          })
          .catch((error)=>{
          });
    },

    handleAdd(){
      this.subject={
        id:null,
        name:null
      },
          this.dialogSubjectVisible=true;
    },

    handleEdit(row){
      this.subject=JSON.parse(JSON.stringify(row));
      this.dialogSubjectVisible=true;
    },

    save(){
      if(this.subject.id){
        //编辑操作
        axios.post('/edu/subjects/'+this.subject.id,"name="+this.subject.name+"&_method=put").then((response)=>{

          if(response.data.code == 200){
            this.dialogSubjectVisible=false;
            //重新加载学科信息
            this.loadSubject();
          }
        }).catch((error)=>{
          console.log(error);
        });
      }else{
        let param = qs.stringify(this.subject);
        axios.post('/edu/subjects',param).then((response)=>{
          if(response.data.code == 200){
            this.dialogSubjectVisible=false;
            //重新加载学科信息
            this.loadSubject();
          }
        }).catch((error)=>{
          console.log(error);
        });
      }
    },

    handleDelete(id){
      //发送delete
      axios.delete('/edu/subjects/'+id).then((response)=>{
        if(response.data.code == 200){
          //重新加载学科信息
          this.loadSubject();
        }
      }).catch((error)=>{
        console.log(error);
      });
    }

  },
  created() {
    this.loadSubject();
  }
}
</script>

<style scoped>
.container{
  padding: 20px;
}

</style>