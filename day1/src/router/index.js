import { createRouter, createWebHistory } from 'vue-router'
import SubjectList from "@/views/subject/List"
const routes = [
  {
    path: '/subject/list',
    name: 'subjectList',
    component: SubjectList
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
