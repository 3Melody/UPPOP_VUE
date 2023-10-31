<template>
  <div class="splide">
    <div class="splide__track">
      <ul class="splide__list">
        <li class="splide__slide">
          <cardactivity @click="enterActivity1()"
            :HeadTextStyles="headTextStyle"
            :TextStyles="textStyle"
            :CalendarWidth="calendarWidth"
            :DescriptionStyle="descriptionStyle"
            :ImgcardActivity="getActivityImage(1)"
            :widthcard="widthcard"
            :NameOfActivity="NameOfActivity1"
            :DateOfActivity="DateOfActivity1"
          />
        </li>
        <li class="splide__slide">
          <cardactivity @click="enterActivity2()"
            :HeadTextStyles="headTextStyle"
            :TextStyles="textStyle"
            :CalendarWidth="calendarWidth"
            :DescriptionStyle="descriptionStyle"
            :ImgcardActivity="getActivityImage(2)"
            :widthcard="widthcard"
            :NameOfActivity="NameOfActivity2"
            :DateOfActivity="DateOfActivity2"
          />
        </li>
        <li class="splide__slide">
          <cardactivity @click="enterActivity3()"
            :HeadTextStyles="headTextStyle"
            :TextStyles="textStyle"
            :CalendarWidth="calendarWidth"
            :DescriptionStyle="descriptionStyle"
            :ImgcardActivity="getActivityImage(3)"
            :widthcard="widthcard"
            :NameOfActivity="NameOfActivity3"
            :DateOfActivity="DateOfActivity3"
          />
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import Splide from "@splidejs/splide";
import "@splidejs/splide/dist/css/splide.min.css";
import axios from "axios";
export default {
  name: "comingsoonView",
 data() {
  return {
    arrImage: [],
    slides: [],
    widthcard: "100%",
    ImgcardActivity1: '', // Initialize with an empty string or a default image URL
    ImgcardActivity2: '', // Initialize with an empty string or a default image URL
    ImgcardActivity3: '', // Initialize with an empty string or a default image URL
    NameOfActivity1: '',
    NameOfActivity2: '',
    NameOfActivity3: '',
    DateOfActivity1: '',
    DateOfActivity2: '',
    DateOfActivity3: '',
  };
},
  mounted() {
    axios.get("http://localhost:8080/activities/all").then((response) => {
      this.slides = response.data;
      this.NameOfActivity1 = this.slides[0].nameActivity;
      this.NameOfActivity2 = this.slides[1].nameActivity;
      this.NameOfActivity3 = this.slides[2].nameActivity;
      this.DateOfActivity1 = this.slides[0].date_Start;
      this.DateOfActivity2 = this.slides[1].date_Start;
      this.DateOfActivity3 = this.slides[2].date_Start;


      axios.get("http://localhost:8080/api/images").then((response) => {
        this.arrImage = response.data;

        // Iterate through the slides to set ImgcardActivity based on matching id_img
        this.slides.forEach((slide, index) => {
          const matchingImage = this.arrImage.find(img => img.id === slide.id_img);
          if (matchingImage) {
            this[`ImgcardActivity${index + 1}`] = matchingImage.url;
          }
        });

        const splide = new Splide(".splide", {
          type: "loop",
          perPage: 1,
          autoplay: true,
        });

        splide.mount();
      });
    });
  },
  methods: {
    enterActivity1(){
      this.$router.push({ path: "/activitydetail/" + this.slides[0].idActivity });
    },
    enterActivity2(){
      this.$router.push({ path: "/activitydetail/" + this.slides[1].idActivity });
    },
    enterActivity3(){
      this.$router.push({ path: "/activitydetail/" + this.slides[2].idActivity });
    },

    getActivityImage(index) {
      return this[`ImgcardActivity${index}`];
    }
  }
};
</script>

<style scoped>
.comingsoon-view {
  padding: 30px;
  background-color: white;
  width: 100%;
  margin-right: 10px;
  border-radius: 12px;
}

.comingsoon-view h1 {
  font-size: 36px;
}
</style>
