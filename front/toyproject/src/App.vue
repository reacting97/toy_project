<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">학교민원</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a v-if="loginId==null" class="nav-link active" aria-current="page" @click="login">Login</a>
          <a v-else v-on:click="logout" class="nav-link active" aria-current="page">logout</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/addCom">민원작성</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<router-view></router-view>
</template>

<script>

export default{
  name: 'App',
  data () {
    return {
      name:'aaa',
      loginId: ''
    }
  },
  methods:{
    login() {
      this.$router.push('/login');
    },
    goToHome() {
      this.$router.push('/');
    },
    logout() {
      sessionStorage.removeItem('loginId')
      this.loginId = null; // loginId를 업데이트
      location.reload()
    }
  },
  computed:{
    
  },
  created: function () {//이 컴포넌트가 시작될때 실행되는 함수
    this.loginId = sessionStorage.getItem('loginId')
  }
}
</script>
<style scoped>
.name{
  color: red;
}
</style>
