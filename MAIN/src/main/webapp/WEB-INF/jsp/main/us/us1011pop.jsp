<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
<title>쪽지목록</title>
</head>
<body>
	<br />
	<div class="ui text container">
		<div class="ui one column grid">
			<div class="column">
				<h3 class="ui header">
					쪽지목록
					<div class="sub header">쪽지함</div>
				</h3>
			</div>
			<div class="column">
				<table class="ui celled padded table">
					<thead>
						<tr>
							<th>제목</th>
							<th>작성자</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width:300px;">쪽지 입니다.</td>
							<td>시스템관리자</td>
							<td>2021-06-16 오전 07:40 </td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th colspan="5">
								<div class="ui right floated pagination menu">
									<a class="icon item"> 
										<i class="left chevron icon"></i>
									</a> 
									<a class="item">1</a> 
									<a class="item">2</a> 
									<a class="item">3</a>
									<a class="item">4</a> 
									<a class="icon item"> 
										<i class="right chevron icon"></i>
									</a>
								</div>
							</th>
						</tr>
					</tfoot>
				</table>
			</div>
			
		</div>
	</div>


</body>
</html>