<template>
  <div>
    <navbar/>
    <div class="detail-card">
      <h2>กิจกรรมของคุณ</h2>
      <router-link to="/adminedit/create">
        <button type="button" class="btn btn-primary">เพิ่มกิจกรรม +</button>
      </router-link>
      <div v-if="loading" class="loading-spinner mt-3 d-flex">
        <!-- Customize your loading spinner here -->
        <div class="spinner"></div>
        <p class="mt-2">Loading...</p>
      </div>
      <div class="row row-cols-2" style="width: 1266px;">
        <div class="col mt-5" v-for="activity in activities" :key="activity.id">
          <div class="card">
            <div @click="detailActivity(activity.idActivity)">
              <img 
                v-for="imagelink in filteredImages(activity.id_img)"
                :key="imagelink.id"
                @click="image(imagelink.id)"
                :src="imagelink.url"
                class="card-img-top"
                alt="..."
              />
            </div>
            <div class="card-body">
              <h5 class="card-title">{{ activity.nameActivity }}</h5>
              <p class="card-text">{{ activity.time_Start }}</p>
              <div class="d-grid gap-2">
                <button class="btn btn-primary" @click="EditActivity(activity.idActivity)" type="button">แก้ไขกิจกรรม</button>
                <button class="btn btn-danger" @click="DeleteActivity(activity.idActivity)" type="button">ลบกิจกรรม</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Swal from 'sweetalert2';

export default {
  name: 'AdminView',
  data() {
    return {
      loading: true,
      activities: [],
      arrImage: [],
      model: {
        id_img: '',
      },
    };
  },
  computed: {
    filteredImages() {
      return (id_img) => this.arrImage.filter(imagelink => imagelink.id === id_img);
    },
  },

  beforeUpdate() {
    this.image();
  },

  beforeCreate() {
    axios.get('http://localhost:8080/api/images').then((response) => {
      this.arrImage = response.data;
      console.log(this.arrImage);
    });

    axios.get('http://localhost:8080/activities/all')
      .then((response) => {
        this.activities = response.data;
        this.loading = false;
      })
      .catch((error) => {
        console.error('Error fetching activities:', error);
        this.loading = false;
      });
  },
  methods: {
    image(id) {
      console.log(id);
    },
    EditActivity(id) {
      this.$router.push({ path: '/adminedit/editactivity/' + id });
    },
    detailActivity(id) {
      this.$router.push({ path: '/activitydetail/' + id });
    },
    DeleteActivity(id) {
      Swal.fire({
        title: 'คุณต้องการลบกิจกรรมใช่ไหม',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes',
        cancelButtonText: 'No',
      }).then((result) => {
        if (result.value) {
          Swal.fire('You clicked Yes!', '', 'ลบกิจกรรมเรียบร้อย');
          axios.delete('http://localhost:8080/activities/delete/' + id)
            .then((response) => {
              this.activities = response.data;
              console.log('API response:', response.data);
              window.location.reload();
            })
            .catch((error) => {
              console.error('Error fetching data from the API:', error);
            });
          console.log(id);
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          Swal.fire('You clicked No!', '', 'error');
        }
      });
    },
  },
};
</script>

<style scoped>
.detail-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 30px;
  background-color: white;
  width: 100%;
  margin-right: 10px;
  border-radius: 12px;
}

.detail-card h2 {
  font-size: 36px;
}

.loading-spinner {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100px; /* Adjust to your preferred height */
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
</style>
