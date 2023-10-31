import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import FollowingView from '../views/FollowView.vue'
import calendarView from '../views/Calendar.vue' 
import ProfileView from '../views/Profile.vue'
import CreateView from '../views/Create.vue'
import AdminEditView from '../views/AdminEdit.vue'
import EditActivityView from '../views/EditActivity.vue'
import ActivityDetailView from '../views/ActivityDetails.vue'
import testView from '../views/test.vue'
import CatagoryView from '../views/CatagortView.vue'
import LoginView from '../views/LoginView.vue'
import TestProfileView from '../views/testProfile.vue'



const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/following',
    name: 'following',
    component: FollowingView
  },
  {
  path: '/calendar',
  name: 'calendar',
  component: calendarView
},
{
  path: '/user/:id', 
  name: 'userProfile',
  component: ProfileView, 
},
{
  path: '/adminedit/create',
  name: 'create',
  component: CreateView
},{
  path: '/adminedit',
  name: 'adminedit',
  component: AdminEditView
},{
  path: '/adminedit/editactivity/:id',
  name: 'editactivity',
  component: EditActivityView
},{
  path: '/activitydetail/:id',
  name: 'activitydetail',
  component: ActivityDetailView
},{
  path: '/test',
  name: 'test',
  component: testView
},{
  path: '/catagory',
  name: 'catagory',
  component: CatagoryView
},
 { path: '/login',
  name: 'login',
  component: LoginView
},{
  path:'/testprofile',
  name:'testprofile',
  component: TestProfileView
}
]



const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
