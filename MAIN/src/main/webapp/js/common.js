// 팝업 옵션
var op1 = "width=650px, height=700px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";
var op2 = "width=1400px, height=1400px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";
var op3 = "width=550px, height=550px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";
var op4 = "width=800px, height=700px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50";


// form -> json
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

// formData JSON table
function searchData(jsonData, url){
	
	$.ajax({
		url : url,
		type : "post",
		async : true,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(jsonData),
		success : function(response) {
			var result = JSON.parse(response.data);
			var arr = result.data;
			$('#tableData > tbody > tr').remove();
			$.each(arr, function(index, item){
				var row;
				row += '<tr onclick="pageLocation('+"'"+ item.chId +"'"+');">';
				row += '<td>' + item.chOpenName +'</td>';
				row += '<td>' + item.chName +'</td>';
				row += '<td class="right aligned">' + item.chUserCount +'</td>';
				row += "</tr>";
				$("#tableData > tbody:last").append(row);
			});
						
		},
		error : function(request, status, error) {
			console.log("일시적인 장애로 인한 처리불가");
		}
	});
	
}



// 로그인
function loginpop(){
	window.open("/sy/sy1011pop.yh", "로그인", op3);
}

// 로그아웃
function logout(){
	
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
	
    $.ajax({
		url : '/sy/logoutCheck.act',
		type : "post",
		async : true,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(jsonData),
		success : function(response) {
			var result = JSON.parse(response.data);
			if(result.data == 0000){
				alert("로그아웃 했습니다.");
				location.reload();
			} else {
				alert("일시적인 장애로 인한 처리불가");
			}
			
		},
		error : function(request, status, error) {
			console.log("일시적인 장애로 인한 처리불가");
		}
	});
}




