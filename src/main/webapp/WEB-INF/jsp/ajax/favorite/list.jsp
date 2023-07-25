<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1 class="text-left font-weight-bold">즐겨찾기 목록</h1>
		
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="favorite" items="${favoriteList }">
					<tr>
						<td>${favorite.id }</td>
						<td>${favorite.name }</td>
						<td>${favorite.url }</td>
						<td><button type="button" class="btn btn-danger btn-sm delete-btn" data-favorite-id="${favorite.id }">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	 <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

		
		<script>
			$(document).ready(function(){
				$(".delete-btn").on("click",function(){
					// 삭제 대상의 id 값
					let id = $(this).data("favorite-id");
					
					$.ajax({
						type:"get"
						,url:"/ajax/favorite/delete"
						,data:{"id":id}
						,success:function(data){
							// 성공 : {"result" : "success"}
							// 싶래 : {"result" : "fail"}
							if(data.result == "success"){
								location.reload();
							}else{
								alert("삭제 실패");
							}
						}
						, error:function(){
							alert("삭제 에러");
						}
					});
				});
			});
		</script>
</body>
</html>