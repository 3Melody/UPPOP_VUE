<template>
    <div>
      <h2>Profile</h2>
      <div>
        <h3>User Information</h3>
        <p><strong>Username:</strong> {{ user.username }}</p>
        <p><strong>Name:</strong> {{ user.name }}</p>
        <p><strong>Email:</strong> {{ user.email }}</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "ProfileView",
    computed: {
      user() {
        return this.$store.state.user; // ดึงข้อมูลผู้ใช้จาก Vuex หรือ Local Storage
      },
    },
  };
  </script>
  