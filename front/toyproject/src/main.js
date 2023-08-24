import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import axios from 'axios'

const app = createApp(App).use(router); // vue 객체 생성
app.config.globalProperties.$axios = axios; // 비동기 요청 객체
app.mount('#app');
