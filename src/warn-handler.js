import Vue from 'vue'; // นำเข้า Vue

if (typeof Vue !== 'undefined') {
    Vue.config.warnHandler = function (msg, vm, trace) {
      // ทำอะไรกับ warnings ตามที่คุณต้องการ
      // ตัวอย่าง: แสดง warning ไปที่ console
      console.warn('Custom Warning Handler:', msg, trace);
    };
  }