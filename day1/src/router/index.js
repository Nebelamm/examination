import { createRouter, createWebHistory } from 'vue-router'
import SubjectList from "@/views/subject/List"
import Login from "@/views/Login";
import Layout from "@/views/layout/Layout";
const routes = [
  {
    path: '/admin/login',
    name: 'loginView',
    component: Login
  },
  {
    path: '/layout',
    name: 'layoutView',
    component: Layout,
    children: [{
        path: '/subject/list',
        name: 'subjectView',
        component: SubjectList
    }]
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
