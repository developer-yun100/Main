<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
<script type="text/javascript">
	function comment(){
		
		var commentv = $("#commentv").val();
		if(commentv == null || commentv == ""){
			alert("댓글을 입력 해 주세요.");
			return false;
		}
		$("#deComment").val(commentv);
		
		var jsonData ={};
	    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
		
	    $.ajax({
			url : '/bo/commentInsert.act',
			type : "post",
			async : true,
			dataType : 'json',
			contentType : "application/json; charset=UTF-8",
			data : JSON.stringify(jsonData),
			success : function(response) {
				var result = JSON.parse(response.data);
				if(result.data == 0000){
					alert("댓글이 정상적으로 입력 되었습니다.");
					location.reload();
				} else {
					alert("일시적인 장애로 인한 처리불가");
				}
				
				/* for (var i = 0; i< result.length; i++) {
				    console.log(result[i]);
				}  */
				
			},
			error : function(request, status, error) {
				console.log("일시적인 장애로 인한 처리불가");
			}
		});
	}

</script>

<title>게시글 상세</title>
</head>
<body>
<form name="pageForm">
	<input type="hidden" id="deComment" name="deComment" />
	<input type="hidden" id="chDeId" name="chDeId" value="${channelDetatilData.chDeId}" />
	<input type="hidden" id="regUserId" name="regUserId" value="${sessionScope.S_USERINFO.userId}"/>
	<input type="hidden" id="regNickName" name="regNickName" value="${sessionScope.S_USERINFO.nickName}"/>
</form>
	<jsp:include page="/common/pageInclude/mainMenu.jsp" flush="false"/>
	<div class="pusher">
		<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
		<div class="ui text container">
			<h2 class="ui dividing header">${channelDetatilData.title}</h2>
		  	<p>
		  		${channelDetatilData.content}
		  	</p>
			
			
			
			<br />
			<br />
			<br />
			<br />
			<c:if test="${not empty sessionScope.S_USERINFO.userId and sessionScope.S_USERINFO.userId ne ''}">
				<h2 class="ui dividing header">댓글입력</h2>
				<form class="ui reply form">
					<div class="field">
						<textarea id="commentv"></textarea>
					</div>
				</form>
				<br />
				<button class="ui primary button" onclick="comment();">댓글쓰기</button>
			</c:if>
			<!-- 댓글 라인 <c:url value=''/>  -->
					<div class="ui minimal comments">
						<h3 class="ui dividing header">댓글</h3>
						<c:forEach var="dto" items="${commentList}" varStatus="status">
						<div class="comment">
							<a class="avatar"> <img src="<c:url value='${dto.profileImg}'/>" style="width:30px; height:30px;"/></a>
							<div class="content">
								<a class="author">${dto.regNickName}</a>
								<div class="metadata">
									<span class="date">${dto.regDate}</span>
								</div>
								<div class="text">${dto.deComment}</div>
							</div>
						</div>
						</c:forEach>
					</div>
	
			<%-- <c:forEach var="dto" items="${commentList}" varStatus="status">
						<div class="comment">
							<a class="avatar"> <img src="<c:url value='${dto.profileImg}'/>" /></a>
							<div class="content">
								<a class="author">${dto.regNickName}</a>
								<div class="metadata">
									<span class="date">${dto.regDate}</span>
								</div>
								<div class="text">
									<p>${dto.deComment}</p>
								</div>
							</div>
							<!-- 대댓글  -->
							<div class="comments">
								<div class="comment">
									<a class="avatar"> <img src="<c:url value=''/>" /></a>
									<div class="content">
										<a class="author">닉네임</a>
										<div class="metadata">
											<span class="date">댓글 적은 날짜</span>
										</div>
										<div class="text">댓글의 댓글</div>
									</div>
								</div>
							</div>
							<!-- 대댓글  -->
						</div>
					</c:forEach> --%>
			<!-- 댓글 라인  -->
		</div>
		
	  
	  
		<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	</div>
</body>
</html>