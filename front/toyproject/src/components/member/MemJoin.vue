<template>
<div style="text-align:center">
    <div>
        ID: <input type="text" id="id" v-model="id" placeholder="아이디를 입력해주세요"><button v-on:click="idcheck(id)">ID중복체크</button><br/>
        PWD: <input type="text" id="pwd" v-model="pwd" placeholder="비밀번호를 입력해주세요"><br/>
        NICKNAME: <input type="text" id="name" v-model="name" placeholder="닉네임을 입력해주세요"><br/>
        EMAIL: <input type="text" id="email" v-model="email" placeholder="이메일을 입력해주세요"><br/>
    </div>
    <div>
        <button v-if="idchecknum==1" v-on:click="join">회원가입</button>
    </div>
</div>
</template>
<script>
export default{
    name:'MemLogin',

    data(){
        return{
            id:'',
            pwd:'',
            name:'',
            email:'',
            idchecknum:0
        }
    },
    methods:{
        join(){
            let formData = new FormData();
            formData.append('id', this.id);
            formData.append('pwd', this.pwd);
            formData.append('name', this.name);
            formData.append('email', this.email);
            const self = this;
            self.$axios.post('http://localhost:8082/cmember', formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then(function(response){
            if(response.status == 200){
                alert('추가성공')
                self.$router.push('/');
            }else{
                alert('추가실패')
            }
        })
        },
        idcheck(id){
            const self = this;
            self.$axios.get('http://localhost:8082/cmember/' + id)
            .then(function(response){
                if(response.status == 200){
                    if(response.data.dto == null){
                        alert('중복된 ID가 없습니다.')
                        self.idchecknum = 1;
                    }else{
                        alert('ID중복')
                        self.idchecknum = 0;
                    }
                }
            })
        }
    }
}
</script>
<style scoped>

</style>