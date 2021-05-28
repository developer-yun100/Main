// 팝업 옵션
var op1 = "width=650px, height=700px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";
var op2 = "width=1400px, height=1400px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";
var op3 = "width=550px, height=550px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";

$.fn.serializeObject = function(){
   var obj = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (obj[this.name]) {
           if (!obj[this.name].push) {
        	   obj[this.name] = [obj[this.name]];
           }
           obj[this.name].push(this.value || '');
       } else {
    	   obj[this.name] = this.value || '';
       }
   });
   return obj;
};