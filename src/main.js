import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './error-handler.js'
import './warn-handler.js'

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';


import cardactivity from '../src/components/card-activity/card1.vue'
import navbar from '../src/components/navbar.vue'
import catagory from '../src/components/home-com/catagory.vue'



createApp(App).use(store).use(store).use(router).component('cardactivity', cardactivity).component('navbar', navbar).component('catagory',catagory).mount('#app')




