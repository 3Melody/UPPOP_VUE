<template>
  <div>
    <navbar />
    <div v-if="loading" class="loading-spinner">
      <div class="spinner"></div>
    </div>
    <div v-else class="content">
      <div class="activity-detail">
        <div @click="addimage"
          class="add-cover text-light bg-custom"
          :style="{ backgroundImage: 'url(' + coverActivity + ')' }"
        >
          <img src="../assets/create/add-image.svg" alt="" />
          <h4>เพิ่มหน้าปก</h4>
        </div>
        <div style="background-color: white; padding: 20px 10px">
          <div class="detail-content">
            <div class="left-text">
              <h5>ชื่อกิจกรรม</h5>
              <h5>หมวดหมู่</h5>
            </div>
            <div class="right-text">
              <input
                type="text"
                v-model="this.model.newActivity.nameActivity"
                class="width"
              />

              <div class="dropdown width">
                <button
                  class="btn btn-outline-success dropdown-toggle width"
                  type="button"
                  id="dropdownMenuButton1"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  {{ this.model.newActivity.category }}
                </button>
                <ul
                  class="dropdown-menu width"
                  aria-labelledby="dropdownMenuButton1"
                >
                  <li>
                    <a
                      class="dropdown-item width"
                      @click="updatecatagory"
                      href="#"
                      >{{ categorytext[1] }}</a
                    >
                  </li>
                  <li>
                    <a
                      class="dropdown-item width"
                      @click="updatecatagory"
                      href="#"
                      >{{ categorytext[2] }}</a
                    >
                  </li>
                  <li>
                    <a
                      class="dropdown-item width"
                      @click="updatecatagory"
                      href="#"
                      >{{ categorytext[3] }}</a
                    >
                  </li>
                  <li>
                    <a
                      class="dropdown-item width"
                      @click="updatecatagory"
                      href="#"
                      >{{ categorytext[4] }}</a
                    >
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div v-if="imageClick">
            <div
              class="show-image bg-dark rounded-3 p-4 position-absolute top-0 start-50 translate-middle-x"
              style="top: 0; left: 250px"
            >
              <div class="d-flex justify-content-end">
                <button class="btn btn-danger" @click="closeImg">x</button>
              </div>
              <div class="row row-cols-3 mt-3">
                <div
                  v-for="imagesrc in urlimage"
                  class="col mt-2"
                  :key="imagesrc.id"
                >
                  <img
                    :src="imagesrc.url"
                    @click="imageurl(imagesrc.url, imagesrc.id)"
                    style="width: 100%; cursor: pointer"
                    alt=""
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="calendar-add" style="margin: 30px 0">
            <h5>เลือกช่วงเวลากิจกรรม</h5>
            <div class="detail-date">
              <div class="start-date">
                <h4 class="text-success">ช่วงเริ่มกิจกรรม</h4>
                <div class="add-date">
                  <p>ใส่วัน/เดือน/ปี</p>
                  <input
                    v-model="this.model.newActivity.date_Start"
                    type="date"
                    id="start-date"
                  />
                </div>
                <div class="add-time">
                  <p>ใส่เวลา</p>
                  <input
                    v-model="this.model.newActivity.time_Start"
                    type="time"
                    id="start-time"
                  />
                </div>
              </div>
              <div class="end-date">
                <h4 class="text-danger">ช่วงจบกิจกรรม</h4>
                <div class="add-date">
                  <p>ใส่วัน/เดือน/ปี</p>
                  <input
                    v-model="this.model.newActivity.date_end"
                    type="date"
                    id="end-date"
                  />
                </div>
                <div class="add-time">
                  <p>ใส่เวลา</p>
                  <input
                    v-model="this.model.newActivity.time_end"
                    type="time"
                    id="end-time"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="location d-flex">
            <h5 class="left-text">สถานที่จัดกิจกรรม</h5>
            <input
              v-model="this.model.newActivity.location"
              type="text"
              class="width right-text"
            />
          </div>
          <div class="description d-flex">
            <h5 class="left-text">รายละเอียด</h5>
            <input
              type="text"
              v-model="this.details"
              class="width right-text"
            />
            <button class="btn btn-primary sava-detail" @click="saveDetails">
              เพิ่ม
            </button>
          </div>
          <div>
            <ul class="list-group list-group-numbered mt-3">
              <li
                class="mb-2 d-flex justify-content-between list-group-item"
                v-for="item in this.model.newActivity.detail"
                :key="item"
              >
                {{ item }}
                <button
                  class="btn btn-danger justify-content-end"
                  @click="deleteDetail(index)"
                >
                  ลบ
                </button>
              </li>
            </ul>
          </div>
          <div class="d-grid gap-2 mt-5">
            <button @click="SaveData" class="btn btn-success" type="button">
              แก้ไขกิจกรรม
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Swal from "sweetalert2";

export default {
  name: "EditActivityView",

  data() {
    return {
      coverActivity: "",
      imageClick: false,
      loading: true,
      categorytext: ["เลือกหมวดหมู่", "ม.พะเยา", "คณะ", "ชมรม", "จิตอาสา"],
      details: "",
      activities: [],
      model: {
        newActivity: {
          nameActivity: "",
          category: "",
          date_Start: "",
          time_Start: "",
          date_end: "",
          time_end: "",
          location: "",
          id_img: "",
          detail: [],
        },
      },
    };
  },

  methods: {
    closeImg() {
      this.imageClick = false;
    },
    addimage() {
      this.imageClick = true;
    },
    imageurl(url, id) {
      console.log(url);
      this.imageClick = false;
      this.coverActivity = url;
      this.model.newActivity.id_img = id;
      console.log(id)
    },
    deleteDetail(index) {
      this.model.newActivity.detail.splice(index, 1);
    },
    getActivitiesdetail(id) {
      axios.get("http://localhost:8080/activities/" + id).then((response) => {
        this.activities = response.data;
        this.model.newActivity.nameActivity = this.activities.nameActivity;
        this.model.newActivity.category = this.activities.category;
        this.model.newActivity.date_Start = this.activities.date_Start;
        this.model.newActivity.time_Start = this.activities.time_Start;
        this.model.newActivity.date_end = this.activities.date_end;
        this.model.newActivity.time_end = this.activities.time_end;
        this.model.newActivity.location = this.activities.location;
        this.model.newActivity.detail = this.activities.detail;
        this.model.newActivity.id_img = this.activities.id_img;
        this.loading = false;
     
      });
    },

    getDatacover(id) {
      axios.get("http://localhost:8080/api/images/"+id).then((response) => {
        this.datacover = response.data;
        this.coverActivity = this.datacover.url;
        console.log(this.coverActivity)
      });
    },

    saveDetails() {
      if (this.details.trim() !== "") {
        this.model.newActivity.detail.push(this.details);
        this.details = "";
      }
    },
    SaveData() {
      Swal.fire({
        title: "คุณต้องการแก้ไขกิจกรรมใช่ไหม",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: "Yes",
        cancelButtonText: "No",
      }).then((result) => {
        if (result.value) {
          Swal.fire("You clicked Yes!", "", "แก้ไขกิจกรรมเรียบร้อย");
          axios
            .put(
              "http://localhost:8080/activities/update/" +
                this.$route.params.id,
              this.model.newActivity
            )
            .then((response) => {
              this.newActivity = response.data;
              console.log("API response:", response.data);
              this.model.newActivity = {
                nameActivity: this.newActivity.nameActivity,
                category: this.newActivity.category,
                startDate: this.newActivity.date_Start,
                startTime: this.newActivity.time_Start,
                endDate: this.newActivity.date_end,
                endTime: this.newActivity.time_end,
                location: this.newActivity.location,
                detail: this.newActivity.detail,
                id_img: this.newActivity.id_img,
              };
              this.$router.push({ path: "/adminedit" });
            })
            .catch((error) => {
              console.error("API error:", error);
            });
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          Swal.fire("You clicked No!", "", "error");
        }
      });
    },
    updatecatagory(e) {
      e.preventDefault(); // Prevent the default behavior of the anchor tag
      this.categorytext[0] = e.target.text;
      this.model.newActivity.category = e.target.text;
    },
    
  },

   beforeUpdate() {
    this.getDatacover(this.model.newActivity.id_img)
    },

  mounted() {
    
    axios.get('http://localhost:8080/api/images').then((response) => {
     this.datacover = response.data;
    }).catch((error) => {
      console.error('API error:', error);
    });

    axios.get("http://localhost:8080/activities/all").then((response) => {
      this.activities = response.data;
     
    });
    
    

    this.getActivitiesdetail(this.$route.params.id);

    axios
      .get("http://localhost:8080/api/images")
      .then((response) => {
        this.imageUrl = response.data;
        this.urlimage = this.imageUrl;
      
      })
      .catch((error) => {
        console.error("API error:", error);
      });
    },
   
};
</script>

<style scoped>
.loading-spinner {
  display: flex;
  align-items: center;
  justify-content: center;
  /* Adjust to your preferred height */
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
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
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
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
.add-date {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.add-date p {
  margin: 0;
  margin-right: 10px;
}

.add-time p {
  margin: 0;
  margin-right: 10px;
}

.description {
  position: relative;
}

.sava-detail {
  position: absolute;
  right: 0;
}

.detail-date {
  display: flex;
  justify-content: space-around;
}

.activity-detail input {
  border-radius: 6px;
  border: 1px solid #777;
  padding: 5px;
}

.start-date {
  width: 40%;
}
.end-date {
  width: 40%;
}

.detail-date input {
  width: 70%;
}

.detail-date h4 {
  text-align: center;
  margin: 20px 0;
}

.add-time {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.content {
  display: flex;
  justify-content: center;
}

.width {
  width: 100%;
}

.left-text {
  width: 30%;
}

.left-text h5 {
  margin-bottom: 20px;
}

.activity-detail {
  width: 900px;
  margin-top: 20px;
}

.detail-content {
  display: flex;
}

.right-text {
  width: 100%;
}

.right-text input,
div {
  margin-bottom: 8px;
}

.add-cover {
  width: 100%;
  height: 300px;
  border-radius: 12px 12px 0px 0px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.main-content {
  width: 900px;
}
.bg-custom {
  background: #7c7c7c;
}
</style>
