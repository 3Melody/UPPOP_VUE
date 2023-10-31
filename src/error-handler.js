
import Vue from 'vue'; // นำเข้า Vue

if (typeof Vue !== 'undefined') {
    Vue.config.errorHandler = function (err, vm, info) {
      // ทำอะไรกับ errors ตามที่คุณต้องการ
      // ตัวอย่าง: แสดง error ไปที่ console
      console.error('Custom Error Handler:', err, info);
    };
  }