import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/components/member/Login.vue'

const routes = [
    {
      path: '/',
      name: 'Login',
      component: HomeView
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
  })
  
  export default router