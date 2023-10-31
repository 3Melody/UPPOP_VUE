<template>
    <div class="homefollowing-view">
        <h1>กำลังติดตาม</h1>
        <cardactivity :HeadTextStyles="headTextStyle" :TextStyles="textStyle" :CalendarWidth="calendarWidth" :DescriptionStyle="descriptionStyle"
        :ImgcardActivity="ImgcardActivity1"
        :widthcard="widthcard"
        :NameOfActivity="NameOfActivity1"
        :DateOfActivity="DateOfActivity1"
        />
        <cardactivity :HeadTextStyles="headTextStyle" :TextStyles="textStyle" :CalendarWidth="calendarWidth" :DescriptionStyle="descriptionStyle"
        :ImgcardActivity="ImgcardActivity2"
        :widthcard="widthcard"
        :NameOfActivity="NameOfActivity2"
        :DateOfActivity="DateOfActivity2"
        />
    </div>
</template>


<script >



export default {
    name: 'HomefollowingView',
    data(){
        return{
            headTextStyle: 'font-size: 14px; font-weight: 800;',
            textStyle: 'font-size: 12px; font-weight: 400; margin:0;',
            calendarWidth: 'width: 20px;',
            descriptionStyle: 'padding: 15px 10px 19px 15px',
            ImgcardActivity1: 'https://cdn.pic.in.th/file/picinth/11c094cc0e2e513ec.jpeg',
            widthcard: '100%',
            NameOfActivity1: 'ปลูกป่าชายเลน',
            DateOfActivity1: '19 สิงหาคม 2566',
            ImgcardActivity2:'https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8fDA%3D&w=1000&q=80',
            NameOfActivity2: 'กิจกรรมถ่ายรูป',
            DateOfActivity2: '20 ธันวาคม 2566',

            
        }
    }

}
</script>

<style scoped>

    .homefollowing-view{
        background-color: white;
        padding: 30px;
        width: 340px;
        border-radius: 12px;
       
        
    }

    .homefollowing-view h1{
        font-size: 32px;
        color: #878787;
    }

    .homefollowing-view div{
        margin-top: 20px;
    }
    
</style>