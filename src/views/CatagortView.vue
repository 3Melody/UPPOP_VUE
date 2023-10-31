<template>
  <div>
    <navbar />
    <div v-if="loading" class="loading-spinner">
      <div class="spinner"></div>
    </div>
    <div v-else class="content d-flex justify-content-center mt-5" >
      <div class="bg-white p-4"  style="width: 800px ;">
        <div class="d-flex justify-content-between">
          <h2 class="fw-bold">หมวดหมู่</h2>
          <div class="dropdown">
            <button
              type="button"
              class="btn btn-primary dropdown-toggle"
              data-bs-toggle="dropdown"
              data-bs-display="static"
              aria-expanded="false"
            >
              {{ selectedCategory ? selectedCategory : "เลือกหมวดหมู่" }}
            </button>
            <ul class="dropdown-menu dropdown-menu-lg-end">
              <li>
                <button
                  class="dropdown-item"
                  type="button"
                  @click="selectCategory('ทั้งหมด')"
                >
                  ทั้งหมด
                </button>
              </li>
              <li>
                <button
                  class="dropdown-item"
                  type="button"
                  @click="selectCategory('ม.พะเยา')"
                >
                  ม.พะเยา
                </button>
              </li>
              <li>
                <button
                  class="dropdown-item"
                  type="button"
                  @click="selectCategory('คณะ')"
                >
                  คณะ
                </button>
              </li>
              <li>
                <button
                  class="dropdown-item"
                  type="button"
                  @click="selectCategory('ชมรม')"
                >
                  ชมรม
                </button>
              </li>
              <li>
                <button
                  class="dropdown-item"
                  type="button"
                  @click="selectCategory('จิตอาสา')"
                >
                  จิตอาสา
                </button>
              </li>
            </ul>
          </div>
        </div>
        <div>
          <ul>
            <cardactivity
              @click="detailActivity(activity.idActivity)"
              v-for="activity in filteredActivities"
              :key="activity.id"
              :ImgcardActivity="activity.ImgcardActivity"
              :NameOfActivity="activity.nameActivity"
              :DateOfActivity="activity.date_Start"
              class="mt-3"
              style="width: 100%"
            />
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import navbar from "@/components/navbar.vue";
import axios from "axios";

export default {
  components: { navbar },
  data() {
    return {
      arrImage: [],
      loading: true,
      selectedCategory: null,
      activities: [], // Initialize activities as an empty array
    };
  },
  mounted() {
    this.fetchActivities();
    axios.get("http://localhost:8080/api/images").then((response) => {
      this.arrImage = response.data;
      console.log(this.arrImage);
    });
  },
  methods: {
    detailActivity(idActivity) {
      this.$router.push({ path: "/activitydetail/" + idActivity });
    },
    fetchActivities() {
      axios
        .get("http://localhost:8080/activities/all")
        .then((response) => {
          this.activities = response.data.map((activity) => {
            // Find the corresponding image URL in arrImage based on id_img
            const image = this.arrImage.find(
              (img) => img.id === activity.id_img
            );
            if (image) {
              // Assign the image URL to the activity
              activity.ImgcardActivity = image.url;
            }
            return activity;
          });
          this.loading = false;
        })
        .catch((error) => {
          console.error("Error fetching activities:", error);
          this.loading = false;
        });
    },
    selectCategory(category) {
      if (category === "ทั้งหมด") {
        this.selectedCategory = null; // Reset the filter to show all activities
      } else {
        this.selectedCategory = category;
      }
    },
  },
  computed: {
    filteredActivities() {
      if (this.selectedCategory) {
        return this.activities.filter(
          (activity) => activity.category === this.selectedCategory
        );
      }
      return this.activities;
    },
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
</style>
