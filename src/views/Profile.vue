<template>
  <div>
    <navbar/>
    <div v-if="loading" class="loading-spinner" style="height: 100vh;">
      <div class="spinner"></div>
    </div>
        <div v-else class="be-content">
            <div class="content-profile">
                <div class="profile-head">
                    <img :src="coverimg" class="coversize" alt="">
                    <div class="profile-img">
                        <img :src="imagesrc" class="imagesrc" alt="">
                        <h3 class="mt-3">{{name}}</h3>
                    </div>
                </div>
                <div class="detail">
                    <div class="head-detail">
                        <h3>ชื่อผู้ใช้</h3>
                        <h3>ชื่อ - นาสกุล</h3>
                        <h3>ตำแหน่ง</h3>
                        <h3>สังกัด/คณะ</h3>
                        <h3>อีเมล</h3>
                    </div>
                    <div class="body-detail">
                        <h3>{{ username }}</h3>
                        <h3>{{ name }}</h3>
                        <h3>{{ position }}</h3>
                        <h3>{{ major }}</h3>
                        <h3>{{ email }}</h3>
                    </div>
                </div>
                <button class="d-grid gap-2 col-6 mx-auto btn btn-danger" @click="logout">ออกจากระบบ</button>
            </div>
        </div>
  </div>
</template>

<script>
import axios from "axios";
import Swal from "sweetalert2";

export default {
  name: "ProfileView",
  data() {
    return {
      loading: true,
      imagesrc: "https://img.freepik.com/premium-photo/number-1-white-background-golden-3d-rendered-number-with-gloss-metal-texture_154981-6778.jpg",
      coverimg: "https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg",
      username: "",
      name: "",
      position: "",
      major: "",
      email: "",
    };
  },
  mounted() {
    this.loadData(); // Load data when the component is mounted
  },
  methods: {
    logout() {
      Swal.fire({
        title: 'คุณต้องการออกจากระบบใช่ไหม',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes',
        cancelButtonText: 'No',
      }).then((result) => {
        if (result.value) {
          Swal.fire('You clicked Yes!', '', 'ออกจากระบบเรียบร้อย');
          this.$router.push("/login");
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          Swal.fire('You clicked No!', '', 'error');
        }
      });
     
    },
    loadData() {
      const userId = this.$route.params.id;

      if (!userId) {
        console.error("รูปแบบ URL ไม่ถูกต้อง หากหน้านี้ต้องมีพารามิเตอร์ id");
        return; // Stop the function if userId is not defined
      }

      axios
        .get(`http://localhost:8080/persons/${userId}`)
        .then((response) => {
          this.loading = false;
          this.username = response.data.username;
          this.name = response.data.firstName + " " + response.data.lastName;
          this.position = response.data.typeUser;
          this.major = response.data.faculty;
          this.email = response.data.email;
        })
        .catch((error) => {
          console.error("ข้อผิดพลาดในการดึงข้อมูลจาก API:", error);
          this.loading = false;
        });
    },
  },
  beforeRouteUpdate(to, next) {
    // Before route update, load data again
    this.loadData();

    // Move next() inside the success callback
    next();
  },
};
</script>



<style scoped>

.loading-spinner {
  display: flex;
  align-items: center;
  justify-content: center;

}

.spinner {
  border: 4px solid rgba(0, 0, 0, 0.3);
  border-top: 4px solid #3498db; /* Customize the spinner color */
  border-radius: 50%;
  width: 40px; /* Adjust the size of the spinner */
  height: 40px;
  animation: spin 2s linear infinite; /* Add a CSS animation */
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
    .imagesrc{
        width: 150px;
        height: 150px;
        border-radius: 50%;
        border: 5px solid white;
        margin-right:20px ;
    }

    .profile-img{
        position: absolute;
        display: flex;
        align-items: center;
        bottom: -100px;
        left: 100px;
        color: #01919C;
       
    }

    .profile-head{
        position: relative;
    }

    .content-profile{
        width: 800px;
        height: 934px;
        flex-shrink: 0;
        border-radius: 12px;
        background: white;
    }

    
    .be-content{
        display: flex;
        justify-content: center;
        margin-top:30px ;
    }

    .coversize{
        
        width: 100%;
        border-radius: 12px 12px 0px 0px;
    }

    .detail{
        display: flex;
        padding: 20px;
        margin-top: 150px;
    }

    
    .detail div h3{
        font-size: 24px;
        font-weight: 400;
        margin-bottom: 30px;
       
    }


    .body-detail{
        margin-left:150px ;
        color: #01919C;
    }
    
</style>