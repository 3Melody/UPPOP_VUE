<template>
    <div>
        <div class="main-content">
        <div class="leftchild">
            <div class="backgroud-logo">
                <div class="logo">
                    <img class="logo" src="../assets/login/login-logo-uppop.png" alt="logo UPPOP">
                </div>
            </div>
        </div>
        <div class="rightchild bg-white"> <!--login-->
            <div class="text-welcome">
                <h3> 
                    <b>ยินดีต้อนรับเข้าสู่ UP POP!</b>
                </h3>
                <p class="gray-text">เข้าสู่ระบบบัญชีผู้ใช้ของคุณ</p>
            </div>
           
                <form @submit.prevent="login">
      <label for="username">ชื่อผู้ใช้</label>
      <input type="text" id="username" name="username" v-model="username" required>

      <label for="password">รหัสผ่าน</label>
      <input type="password" id="password" name="password" v-model="password" required>

      
        
          <div class="d-flex justify-content-end">
              <p class="gray-text">ลืมรหัสผ่าน</p>
          </div>
    

      <div class="d-grid gap-1">
          <button class="btn btn-custom d-flex justify-content-center align-items-center p-3 " @click="login()" type="submit">
            <img class="logo-login" src="../assets/login/login-icon-from.png" alt="login logo">
            <h5 style="margin: 0; margin-left: 5px; font-weight: bold;">เข้าสู่ระบบ</h5>
          </button>
          <div v-if="loginError" class="gray-text justify-content-start pt-3" style="color:red">
      {{ loginError }}
        </div>
      </div>
    </form>

   
    </div>
    </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'LoginView',
    data() {
        return {
            username: '',
            password: '',
            loginError: '',
            TypeUser: '',
            
        };
    },
    methods: {

  async login() {
    try {
      const response = await axios.post('http://localhost:8080/persons/login', {
        username: this.username,
        password: this.password,
      });

      if (response.status === 200) {
        
        const responseText = response.data; // Assuming the response is a string
        const userIdMatch = responseText.match(/User ID: (\d+)/);
        

        if (userIdMatch) {
          const userId = userIdMatch[1];
          this.userId = response.data.userId;
          this.$store.state.StoreUserId = userId;
          await axios.get('http://localhost:8080/persons/'+ userId).then((response) => {
              this.Persondata = response.data;
              this.$store.state.StoreTypeUser = this.Persondata.typeUser;
            console.log(this.$store.state.StoreTypeUser);
          });
          this.$router.push({ path: `/` });
        } else {
          console.log('Login successful, but user ID not found in response.');
        }
      } else {
        console.log('Login failed.');
        this.loginError = '* ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง';
     
      }
    } catch (error) {
      console.error('An error occurred:', error);
      this.loginError = '* ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง';
      
    }
  },
},
};
</script>

<style scoped>
body {
    margin: 0;
    padding: 0;
}
h3{
    font-size: xx-large;
}


.btn-custom{
    background-color: #01919C;
    color: white;
}

.btn-custom:hover{
    background-color: #00646b;
    color: white;
}
.gray-text {
    color: #878787;
    font-size: large;
}

.main-content {
    display: flex;
}

.leftchild {
    flex: 3; 
    height: 100vh; /* ให้ความสูงของ .leftchild เต็มหน้าจอของผู้ใช้ (100vh) */
    background: center/cover no-repeat url('../assets/login/backgroudlogo-uppop.png');
    display: flex;
    justify-content: center; /* จัดตำแหน่งรูปพื้นหลังให้อยู่กึงกลางแนวตั้งและนอน */
    align-items: center; /* จัดตำแหน่งรูปพื้นหลังให้อยู่กึงกลางแนวตั้งและนอน */
}

.backgroud-logo {
    text-align: center; /* จัดตำแหน่งข้อความและโลโก้ในส่วนซ้ายให้อยู่กึงกลางแนวตั้งและนอน */
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 45vh; /* ทำให้พื้นหลังรองรับหน้าจอ */
    max-height: 100%;
}

.logo {
    display: grid;
    place-content: center;
    width: 35vh;
    height: 25vh;
}

.rightchild {
    flex : 5;
    height: 100vh; /* ให้ความสูงของ .rightchild เต็มหน้าจอของผู้ใช้ (100vh) */
    /* border: 1px solid green; */
    display: grid;
    place-content: center;
}

.text-welcome {
 
    margin-bottom: 5vh;
}

.details-login {
    padding: 0;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 1vh; /* ระยะห่างด้านบนของรายละเอียดการเข้าสู่ระบบ */
}
.details-login label {
    display: flex;
    align-items: center;
    font-size: large;
}

.buttonlogin {
    width: 100%;
    background-color: #01919C;
    display: flex;
    justify-content: center;
    align-items: center;
    border: none;
    border-radius: 5px;

}
.buttontext{
    color: #FFFFFF;
    font-size: large;
    
}

.logo-login {
    width: 5vh;
    height: 5vh;
}

form {
    width: 78vh; /* กำหนดความกว้างสูงสุดของแบบฟอร์ม */
  
    background-color: #fff; /* สีพื้นหลังแบบฟอร์ม */
}

label, input {
    display: block;
    font-size: larger;
    color: #000000;
    margin-bottom:20px ;
}
input {
    border: 2px solid #01919C;
    border-radius: 5px;
    padding: 10px;
    

    
    width: 100%;
}

</style>