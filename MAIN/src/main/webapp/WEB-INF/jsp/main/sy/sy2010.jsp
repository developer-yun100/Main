<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
	
<script type="text/javascript">
		
$(document).ready(function() {
    
});
		
function systemLogin(){
	
	$("#tableData tr ").one("click", function(event){
	    
		var tdArr = new Array();
		var tr = $(this);
        var td = tr.children();
        
        td.each(function(i){
            tdArr.push(td.eq(i).text());
        });
        
        var userId = td.eq(0).text();
        $("#tableData tr ").off(event);
        $("#userId").val(userId);
        
        var jsonData ={};
    	jsonData["form"] = $('form[name="pageForm"]').serializeObject();
    	
    	$.ajax({
    		url : '/sy/loginCheckSystem.act',
    		type : "post",
    		async : true,
    		dataType : 'json',
    		contentType : "application/json; charset=UTF-8",
    		data : JSON.stringify(jsonData),
    		success : function(response) {
    			var result = JSON.parse(response.data);
    			if(result.data == 0000){
    				alert("해당 아이디로 로그인 되었습니다.");
    				location.href="/sy/index.yh";
    			} else {
    				alert("로그인 실패");
    			}
    		},
    		error : function(request, status, error) {
    			console.log("에러 발생");
    		}
    	});
	});
}
		
</script>
	
<title>사용자 관리</title>
</head>
<body>
<form name="pageForm">
	<input type="hidden" id="userId" name="userId" />
</form>
	<jsp:include page="/common/pageInclude/mainMenu.jsp" flush="false"/>
	
	<div class="pusher">
		<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
		<div class="ui text container">
			<div class="ui sizer vertical segment">
				<div class="ui huge header">사용자 목록</div>
			</div>

			<table class="ui single line table" id="tableData">
				<thead>
					<tr>
						<th>아이디</th>
						<th>닉네임</th>
						<th>이메일</th>
						<th>계정 권한</th>
						<th>사용 유무</th>
						<th>로그인</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="dto" items="${userList}" varStatus="status">
					<tr>
						<td id="userIdv">${dto.userId}</td>
						<td>${dto.nickName}</td>
						<td>${dto.email}</td>
						<td>${dto.authCode}</td>
						<td>${dto.useYn}</td>
						<td><a style="cursor:pointer;" onclick="systemLogin();">${dto.userLogin}</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>


		<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
 	</div>
</body>
</html>