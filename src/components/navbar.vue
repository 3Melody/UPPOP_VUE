<template>
   
        <div class="m-0 p-0">
            <div class="navbar">
                <router-link to="/">
                    <img src="../assets/navbar/logouppop.svg" alt="">
                </router-link>
                    <div style="margin-left:180px">
                   <router-link to="/"><img  :src="home"></router-link>
                    <router-link to="/calendar"><img class="calendar" :src="calendar" alt=""></router-link>
                    <router-link to="/following"><img   :src="following" alt=""></router-link>
                </div>
                <div class="right-nav">
                    <router-link to="/adminedit" v-if="checkType(this.$store.state.StoreTypeUser)">
                        <button class="btn btn-custom mx-3">
                            EDIT
                            <img src="../assets/navbar/Edit.svg" alt="">
                        </button>
                    </router-link>
                    <img src="../assets/navbar/bell.svg" alt="">
                    <router-link class="no-underline" :to="'/user/' + this.$store.state.StoreUserId"> 
                        <div class="profile">
                            <img :class="profileimg" :src="imagesrc" alt="">
                            <h3 :class="fontcolor">บัญชีของฉัน</h3>
                        </div>
                    </router-link>
                </div>
            </div>
        </div>
    
</template>


<script>

import home from '../assets/navbar/home.svg';
import calendar from '../assets/navbar/calendar.svg';
import following from '../assets/navbar/star.svg';



export default {
  
   name: 'NavbarView',
   data(){
       return{
        
        imagesrc: 'https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8fDA%3D&w=1000&q=80',
        profileimg: 'profile-img',
        fontcolor: 'font-color', 
        userId: this.$route.params.userId,
        
        }
        
       },

      props:{
        home:{
            type: String,
            default: home
        },
        calendar:{
            type: String,
            default: calendar
        },
        following:{
            type: String,
            default: following
        },
      },
      methods: {
        checkType(typeUser){
            if(typeUser == "Admin"){
                return true;
            }else{
                return false;
            }
        }
      },
      beforeUpdate() {
        this.checkType();
      },
       
   }


   


</script>



<style scoped>
.no-underline {
  text-decoration: none; /* Removes the underline */
}
    .navbar{
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 16px;
        background-color: white;
    }

    .font-color{
        color: #01919C;
        margin: 0;
    }

    .right-nav{
        display: flex;
        align-items: center;
    }
    
    .profile{
        outline: 1px solid #777;
        padding: 6px 12px;
        border-radius: 12px;
        
    }

    .right-nav div{
        display: flex;
        align-items: center;
        margin-left:15px ;
    }

    .right-nav h3{
        font-size: 16px;
        font-weight: 400;
    }

    .calendar{
        margin: 0 75px;
    }

    .profile-img{
        width: 26.25px;
        height: 26.25px;
        flex-shrink: 0;
        border-radius: 50%;
        margin-right: 10px;
    }

    .container{
        position: relative;
        margin: 0;
        padding: 0;
    }

    .btn-custom {
    background-color: #01919C; 
    color: #fff; 
    border-color: #01919C; 
}

.btn-custom:hover {
    background-color: #006c73; 
    border-color: #006c73; 
    color: #fff; 
}



</style>