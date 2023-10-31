<template>
  <div class="Newcard" :style="{width:widthcard}" >
    <img :src="ImgcardActivity" class="imageStyle" style="width:100%"  alt="">
    <div class="description" :style="DescriptionStyle">
        <h1 :style="HeadTextStyles" >{{NameOfActivity}}</h1>
        <div class="date_card">
            <img src="../../assets/card-activity/calendar-card.svg" :style="CalendarWidth"  alt="">
            <p :style="TextStyles">{{DateOfActivity}}</p></div>
    </div>
  </div>
</template>

<script>

import cardsongkran from '../../assets/card-activity/image-card1.jpg'

export default {
    name: 'card1View', 
    data(){
        return{
           
        
        }
    },

    props:{
        HeadTextStyles:{
            type: String,
            default: 'font-size: 32px; font-weight: 800;'
        },
        TextStyles:{
            type: String,
            default: 'font-size: 24px; font-weight: 400; margin:0;'
        },
        CalendarWidth:{
            type: String,
            default: '40px'
        },
        DescriptionStyle:{
            type: String,
            default: 'background: rgba(0, 0, 0, 0.60); color: white; position: absolute; bottom: 0; padding: 15px 10px 10px 50px; width: 100%; border-radius: 0px 0px 12px 12px;'
        },
        ImgcardActivity:{
            type: String,
            default: cardsongkran
        },
        widthcard:{
            type: String,
            default: '875px'
        },
        NameOfActivity:{
            type: String,
            default: 'ปลูกป่าชายเลน'
         
        },
        DateOfActivity:{
            type: String,
            default: '19 สิงหาคม 2566'
          
        }
    }

   

   
}
</script>

<style scoped>

    .imageStyle{
        border-radius: 12px;
    }

    .Newcard{
       position: relative;
    }

    .description h1{
        font-size: 32px;
        font-weight: 800;
    }

    .description p{
        font-size: 24px;
        font-weight: 400;
    }

    .description{
        width: 90%;
        background: rgba(0, 0, 0, 0.60);
        color: white;
        position: absolute;
        bottom: 0; 
        padding: 5px 10px 10px 50px;
        width: 100%;
        border-radius: 0px 0px 12px 12px;
    }

    .date_card{
        display: flex;
        align-items: center;
    }

    .date_card img{
        width: 40px;
        margin-right: 10px;
    }
</style>