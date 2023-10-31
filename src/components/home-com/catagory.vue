<template>
  <div class="mt-3 bg-white p-4">
    <div class="d-flex justify-content-between align-items-center">
      <h2 class="fw-bold">หมวดหมู่</h2>
      <router-link to="/catagory"
        ><h5 class="text-primary">ดูทั้งหมด</h5></router-link
      >
    </div>
    <div class="d-flex justify-content-between mt-4" >
      <div>
          <div class="text-center ">
            <div class="border border-secondary rounded-3 center width">
              <img src="../../assets/catagory/UP.svg" class="image" alt="" />
            </div>
            <h3 class="mt-3">ม.พะเยา</h3>
          </div>
      </div>
      <div>
        <div class="text-center ">
            <div class="border border-secondary rounded-3 center width">
              <img class="image" src="../../assets/catagory/major.svg" alt="" />
            </div>
            <h3 class=" mt-3">คณะ</h3>
       </div>
      </div>
      <div>
        <div class="text-center ">
            <div class="border border-secondary rounded-3 center width">
              <img class="image" src="../../assets/catagory/club.svg" alt="" />
            </div>
            <h3 class=" mt-3">ชมรม</h3>
        </div>
      </div>
      <div>
        <div class="text-center ">
            <div class="border border-secondary rounded-3 center width">
              <img class="image" src="../../assets/catagory/Volunteer.svg" alt="" />
            </div>
            <h3 class=" mt-3">จิตอาสา</h3>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "catagoryComView",
};
</script>

<style scoped>
.center {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 200px;
  height: 200px;
}

.width {
  width: 100%;
  height: 30vh;
}

.image {
  width: 100%;
  padding: 20px;
}
</style>
