// 팝업 옵션
var op1 = "width=650px, height=700px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";
var op2 = "width=1400px, height=1400px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";


$.fn.serializeObject = function(){
   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};