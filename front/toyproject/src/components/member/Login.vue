<template>
    아이디:<input type="text" value="아이디">
    비밀번호:<input type="password" value="비밀번호">
    이름:<input type="text" value="이름">
    이메일:<input type="text" value="이메일">
</template>
  
  <script>
  
  export default {
    name: "MemLogin",
    data() {
      const sysdate = new Date();
  
      return {
        items: [],
        totalItems: 0, // 전체 항목 수
        sysdate: sysdate
      };
    },
    mounted() {
      
    },
    methods: {
      
    }
  }
  </script>
  
  <style></style>  