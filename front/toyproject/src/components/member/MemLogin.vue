<template>
    <div style="text-align:center">
        <div>
            ID: <input type="text" id="id" v-model="id" placeholder="아이디를 입력해주세요"><br/>
            PWD: <input type="text" id="pwd" v-model="pwd" placeholder="비밀번호를 입력해주세요"><br/>
        </div>
        <div>
            <button v-on:click="login">로그인</button>
        </div>
        <p>아직회원이 없으신가요? <a href="/join">여기를 클릭하세요</a></p>
    </div>
    </template>
    <script>
    export default{
        name:'MemLogin',
    
        data(){
            return{
                id:'',
                pwd:'',
            }
        },
        methods:{
            login(){
                const self = this;
                self.$axios.get('http://localhost:8082/cmember/' + self.id + '/' + self.pwd)
                .then(function(response){
                if(response.status == 200){
                    if(response.data.dto == null){
                        alert('로그인 실패');
                    }else{
                        alert('로그인 성공')
                        self.$router.push('/');
                    }   
                }
            })
            },
        }
    }
    </script>
    <style scoped>
    
    </style>