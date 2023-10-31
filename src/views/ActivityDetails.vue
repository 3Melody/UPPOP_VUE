<template>
    <div>
      <navbar />
      <div v-if="loading" class="loading-spinner" >
      <div class="spinner"></div>
    </div>
      <div  v-else class="activitydetails ">
        <div class="content mb-3">
          <img :src="coverimage" alt="" />
          <div class="p-3">
            <div class="d-flex justify-content-between mb-3">
              <div>
                <h1 class="colorHead">{{ model.name }}</h1>
                <h6>{{ model.catagory }}</h6>
              </div>
              <div>
                <button class="btn btn-custom">ติดตาม</button>
              </div>
            </div>
            <div class="mb-3">
              <h3 class="colorHead">ช่วงเวลากิจกรรม</h3>
              <div>
                <h5>วันที่ {{ formattedDate(model.startDate) }} เวลา {{ model.startTime }}</h5>
                <h5>วันที่ {{ formattedDate(model.endDate) }} เวลา {{ model.endTime }}</h5>
              </div>
            </div>
            <div class="mb-3">
              <h3 class="colorHead">สถานที่จัดกิจกรรม</h3>
              <h6>{{ model.location }}</h6>
            </div>
            <div class="mb-3">
              <h3 class="colorHead">รายละเอียดกิจกรรม</h3>
              <ul>
                <li v-for="item in model.detail" :key="item">{{ item }}</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
 
  import axios from 'axios';
  import { format } from 'date-fns';

  
  export default {
    name: 'ActivityDetailsView',
    data() {
    return {
      arrImage: [],
      loading: true,
      coverimage: '', // Define coverimage as an empty string
      model: {
        name: '',
        catagory: '',
        startDate: '',
        startTime: '',
        endDate: '',
        endTime: '',
        location: '',
        detail: [],
      },
    };
  },
    computed: {
      formattedDate() {
        return (date) => {
          if (!date) return '';
          return format(new Date(date), 'dd-MM-yyyy');
        };
      },
    },
    mounted() {
  axios.get('http://localhost:8080/api/images').then((response) => {
    this.arrImage = response.data;
    console.log(this.arrImage);
  });

  axios
    .get('http://localhost:8080/activities/' + this.$route.params.id)
    .then((response) => {
      this.activities = response.data;
      this.model = {
        name: this.activities.nameActivity,
        catagory: this.activities.category,
        startDate: this.activities.date_Start,
        startTime: this.activities.time_Start,
        endDate: this.activities.date_end,
        endTime: this.activities.time_end,
        location: this.activities.location,
        detail: this.activities.detail,
      };

      // Find the image URL based on id_img
      const matchingImage = this.arrImage.find(
        (image) => image.id === this.activities.id_img
      );

      if (matchingImage) {
        this.coverimage = matchingImage.url; // Set the image URL
      }

      console.log(this.activities);
      this.loading = false;
    })
    .catch((error) => {
      console.error('Error fetching activities:', error);
      this.loading = false;
    });
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
  .activitydetails {
    display: flex;
    justify-content: center;
    margin: 20px;
  }
  .content {
    width: 900px;
    background-color: white;
  }
  .content img {
    width: 100%;
    height: 300px;
    object-fit: cover;
  }
  .btn-custom {
    background-color: #01919C;
    color: white;
  }
  .btn-custom:hover {
    background-color: #00646b;
    color: white;
  }

  .colorHead {
    color: #01919C;
  }
  </style>
  