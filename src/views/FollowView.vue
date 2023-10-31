<template>
    <Navbar :following="following"/>
    <div class="newcontent">
        <div class="calendar-view" >
                <div class="mt-3" style="display: flex; justify-content: center; align-items: center;"  >
                    <img :src="follow" alt="" >
                </div>
        </div>
    </div>
</template>

<script>

import following from '../assets/navbar/afterstar.svg'
import follow from '../assets/following/follow.png'
import Navbar from '@/components/navbar.vue'
export default {
    name: 'FollowView',
    components: {
        Navbar,
    },
    data() {
        return {
            following: following,
            follow: follow,
        }
    },
}
</script>

<style>

</style>