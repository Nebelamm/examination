<template>
  <div class="box">
    <el-button type="primary" style="margin-bottom: 10px;" @click="handleAdd">添加</el-button>

    <el-table :data="tableData" v-loading="loading" border style="width: 100%">

      <el-table-column label="考试编号" align="center">
        <template #default="scope">
          {{ scope.row.arrange_id }}
        </template>
      </el-table-column>

      <el-table-column label="考试名称" align="center">
        <template #default="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>

      <el-table-column label="老师编号" align="center">
        <template #default="scope">
          {{ scope.row.teacher_id }}
        </template>
      </el-table-column>

      <el-table-column label="课室" align="center">
        <template #default="scope">
          {{ scope.row.room }}
        </template>
      </el-table-column>

      <el-table-column label="开始时间" align="center">
        <template #default="scope">
          {{ scope.row.time[0] }}
        </template>
      </el-table-column>

      <el-table-column label="结束时间" align="center">
        <template #default="scope">
          {{ scope.row.time[1] }}
        </template>
      </el-table-column>


      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)">
            编辑
          </el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.row.arrange_id)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <el-dialog v-model="dialogExamDataVisible" title="考试信息">
    {{ examData }}
    <el-form :model="examData">

      <el-form-item label="考试名称">
        <el-input v-model="examData.name" autocomplete="off"/>
      </el-form-item>

      <el-form-item label="课室">
        <el-input v-model="examData.room" autocomplete="off"/>
      </el-form-item>

      <el-form-item label="考试时间设定">
        <el-date-picker
            v-model="examData.time"
            type="datetimerange"
            range-separator="To"
            start-placeholder="Start date"
            end-placeholder="End date"
            format="YYYY/MM/DD hh:mm:ss"
            value-format="YYYY-MM-DD HH:mm:ss"
        />
      </el-form-item>

    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogExamDataVisible = false">取消</el-button>
        <el-button type="primary" @click="save">提交</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped>
.box {
  padding: 10px;
}
</style>
<script>
import axios from "axios"
import qs from "qs"

export default {
  name: "List",
  data() {
    return {
      loading: false,
      dialogExamDataVisible: false,
      tableData: [{arrange_id: "text", name: "text", teacher_id: "text", room: "text", time: "text"}],
      examData: {
        arrange_id: null, name: null, teacher_id: null, room: null, time: null,
      }

    }
  },
  methods: {
    loadExamData() {

      axios.get('/edu/students')
          .then((response) => {
            this.tableData = response.data.data;
            this.loading = false;
          }).catch((error) => {
      });
    },

    handleAdd() {

      this.examData = {
        arrange_id: null, name: null, teacher_id: null, room: null, time: null,
      },

          this.dialogExamDataVisible = true;
    },


    handleEdit(row) {
      this.examData = JSON.parse(JSON.stringify(row));
      this.dialogExamDataVisible = true;
    },

    save() {

      if (this.examData.arrange_id) {
        //编辑操作
        axios.post('/edu/students/' +
            this.examData.arrange_id, "name=" + this.examData.name + "&room=" + this.examData.room + "&start_time=" + this.examData.time[0] + "&end_time=" + this.examData.time[1] + "&_method=put").then((response) => {
          if (response.data.code == 200) {
            this.dialogExamDataVisible = false;
            //重新加载学科信息
            this.loadExamData();
          }
        }).catch((error) => {
          console.log(error);
        });
      } else {
        let param = qs.stringify(this.examData);
        axios.post('/edu/students/', param).then((response) => {
          if (response.data.code == 200) {
            this.dialogExamDataVisible = false;
            //重新加载学科信息
            this.loadExamData();
          }
        }).catch((error) => {
          console.log(error);
        });
        this.tableData.push(this.examData)
      }
    },

    handleDelete(arrange_id) {
      //发送delete
      axios.delete('/edu/students/' + arrange_id).then((response) => {
        if (response.data.code == 200) {
          //重新加载学科信息
          this.loadExamData();
        }
      }).catch((error) => {
        console.log(error);
      });
    }
  },
  created() {
    this.loadExamData();
  }
}
</script>