<template>
    <Navbar class="" :calendar="calendar"/>
    <div class="newcontent mt-4">
        <div class="calendar-view d-flex justify-content-center align-items-center"  >
            <div class="p-4 rounded-3" style="background-color: white; height: 100%; ">
                <img :src="leftCalendar" alt="">
                <img :src="rightCalendar" alt="">
            </div>
        </div>
    </div>
</template>

<script>

import calendar from '../assets/navbar/aftercalendar.svg'
import leftCalendar from '../assets/calendar/Main.svg'
import rightCalendar from '../assets/calendar/Sidebar.svg'


import Navbar from '@/components/navbar.vue'
export default {
    name: 'calendarView',
    components: {
        Navbar,
    },
    data() {
        return {
            calendar: calendar,
            leftCalendar: leftCalendar,
            rightCalendar: rightCalendar,
        }
    },
   
}
</script>

<style>

</style>