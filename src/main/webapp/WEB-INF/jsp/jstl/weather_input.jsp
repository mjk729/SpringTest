<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 추가</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link rel="stylesheet" href="/jstl/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<section class="contents d-flex">
			<nav class="main-menu">
				<div class="d-flex mt-2 justify-content-center">
					<div class="col-2">
						<img width="25" src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Emblem_of_the_Government_of_the_Republic_of_Korea.svg/800px-Emblem_of_the_Government_of_the_Republic_of_Korea.svg.png" >
					</div>
					<h4 class="text-white col-7">기상청</h4>
				</div>
		<ul class="nav flex-column">
					<li class="nav-item"><a href="/jstl/weather/list" class="nav-link text-white">날씨</a></li>
					<li class="nav-item"><a href="/jstl/weather/input" class="nav-link text-white">날씨입력</a></li>
					<li class="nav-item"><a href="#" class="nav-link text-white">테마날씨</a></li>
					<li class="nav-item"><a href="#" class="nav-link text-white">관측기후</a></li>
				</ul>
			</nav>
			<article class="main-contents p-4">
				<h3 class="ml-4 mt-5">날씨 입력</h3>
				<form method="get" action="/jstl/weather/add">
	                <div class="d-flex justify-content-between ml-3 mt-5">
	                    <div class="d-flex align-items-center">
	                        <label class="input-lable">날짜</label> 
	                        <input type="text" class="form-control" id="date" name="date">
	                    </div>
	                    <div class="d-flex align-items-center">
	                        <label class="input-lable">날씨</label> 
	                        <select class="form-control" name="weather">
	                            <option>맑음</option>
	                            <option>구름조금</option>
	                            <option>흐림</option>
	                            <option>비</option>
	                        </select>
	                    </div>
	
	                    <div class="d-flex align-items-center">
	                        <label class="input-lable">미세먼지</label> 
	                        <select class="form-control" name="microDust">
	                            <option>좋음</option>
	                            <option>보통</option>
	                            <option>나쁨</option>
	                            <option>최악</option>
	                        </select>
	                    </div>
	                </div>
	
	                <div class="d-flex justify-content-between mt-5">
	                    <div class="d-flex align-items-center">
	                        <label class="col-3">기온</label> 
	                        <div class="input-group">
	                            <input type="text" class="form-control" name="temperatures">
	                            <div class="input-group-append">
	                                <span class="input-group-text">℃</span>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="d-flex align-items-center">
	                        <label class="col-4">강수량</label> 
	                        <div class="input-group">
	                            <input type="text" class="form-control" name="precipitation">
	                                <div class="input-group-append">
	                                    <span class="input-group-text">mm</span>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="d-flex align-items-center">
	                        <label class="col-3">풍속</label> 
	                        <div class="input-group">
	                            <input type="text" class="form-control" name="windSpeed"> 
	                                <div class="input-group-append">
	                                    <span class="input-group-text">km/h</span>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="text-right mt-4 mb-5">
	                    <button type="submit" class="btn btn-success">저장</button>
	                </div>
				</form>
			</article>
		</section>
		<footer class="d-flex">
			<div class="logo mt-3 ml-4">
				 <img width="120" src="https://www.weather.go.kr/w/resources/image/foot_logo.png">	
			</div>
			<div class="copyright">
				<div class="text-secondary small">
				(07062) 서울시 동작구 여의대방로16길 61  <br>
               Copyright@2023 KMA. All Rights RESERVED.</div>
			</div>
		</footer>
	</div>
	
	<script>
		$("#date").datepicker({
			dateFormat:"yy년 mm월 dd일"
		});
	
	</script>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>