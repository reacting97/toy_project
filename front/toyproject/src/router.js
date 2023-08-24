import { createWebHistory, createRouter } from "vue-router";
import Home from "./components/Home.vue"
import Join from './components/member/MemJoin.vue'
import Login from './components/member/MemLogin.vue'

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/join",
    name: "MemJoin",
    component: Join,
  },
  {
    path: "/login",
    name: "MemLogin",
    component: Login,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;