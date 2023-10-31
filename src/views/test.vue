<template>
  <div>
    <h2>Login</h2>
    <form @submit.prevent="login">
      <input type="text" v-model="username" placeholder="Username" required>
      <input type="password" v-model="password" placeholder="Password" required>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "LoginView",
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    login() {
      // ทำการ Login และเรียก API ข้อมูลบุคคล
      this.$axios
        .post("https://example.com/api/login", {
          username: this.username,
          password: this.password,
        })
        .then((response) => {
          if (response.data.success) {
            // บันทึกข้อมูลผู้ใช้ลง Vuex หรือ Local Storage ตามที่คุณต้องการ
            this.$store.commit("setUser", response.data.user);

            // นำผู้ใช้ไปหน้าอื่น ในที่นี้คือหน้า Profile.vue
            this.$router.push("/profile");
          } else {
            alert("เข้าสู่ระบบไม่สำเร็จ");
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>
