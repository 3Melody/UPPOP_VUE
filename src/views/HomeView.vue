<template>
    <div>
        <Navbar :home="home"/>
    </div>
        <div  class="main">
            <div  class="home-view ">
                <div class="main-content">
                    <div class="me-3" style="width: 122vh; margin-left: 150px;">
                        <commingsoon/>
                        <div style="width: 122vh"><catagory/></div>
                    </div>
                    <div  style="margin-right: 150px;">
                        <homefollowing/>
                        <div class="d-flex flex-column align-items-center  pt-3" style="width: 340px;">
                            <img src="../assets/ads/ads1.png" alt="">
                            <img class="ps-5" src="../assets/ads/ads2.png" alt="">
                            <img style="width: 250px;" src="../assets/ads/ads3.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>

    
</template>

<script>
import Navbar from '@/components/navbar.vue'
import afterhome from '../assets/navbar/afterhome.svg'

import commingsoon from '../components/home-com/comingsoon.vue'
import homefollowing from '../components/home-com/homefollowing.vue'
import catagory from '../components/home-com/catagory.vue'

export default {
    name: 'HomeView',
    
    components: {
        commingsoon,
        homefollowing,
        Navbar,
        catagory,
    },

    data() {
        return {
            home: afterhome,
        }
    },
    mounted() {
           
    
    },
}

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
    

    body{
        background: #F5F5F5;
    }

    .home-view{
        padding: 20px;
        width: 1500px;
    }

    .main-content{
        display: flex;
        justify-content: space-between;
    }
</style>