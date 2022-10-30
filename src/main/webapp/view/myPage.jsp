<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>마이페이지</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">


    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/">

    

    <!-- Bootstrap core CSS -->
	<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			user-select: none;
		}
		
		@media (min-width: 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
		.page_wrap > ul, 
		.page_wrap > li {
			margin:0;
			padding:0;
			list-style:none;
		}
		.page_wrap > li{
			display:inline-block;
			width:30px;
			height:30px;
			margin: 0 3px;	
		}
		
		.page_wrap > .skip{
			width:50px;
		}
		.page_wrap > li > a{
			text-decoration:none;
			color:#999999;
		}
		.page_wrap > li > span{
			display:inline-block;
			text-decoration:none;
			width:30px;
			height:30px;
			line-height:30px;
			background-color:#999999;
			border-radius:50%;
			color:#ffffff;
			font-weight:bold;
			text-align:center;
		}
    </style>

   
   	<!-- Custom styles for this template -->
   	<link href="../assets/css/mypage.css" rel="stylesheet">
</head>
<body>
    
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="#!">영화리뷰사이트</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/home">Home</a></li>
				    <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
				</ul>
			    <form class="d-flex">
					<c:if test="${empty user }">
						<button class="btn btn-outline-dark login1" type="button" onclick="modalClick(this);" id="login">
						    로그인
						</button>
						<button class="btn btn-outline-dark login2" type="button" onclick="modalClick(this);" id="join">
						    회원가입
						</button>
					</c:if>
					<c:if test="${not empty user }">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
							<li class="nav-item dropdown">
						        <a class="nav-link dropdown-toggle" id="navbarDropdown" 
						        	href="#" role="button" data-bs-toggle="dropdown" 
						        	aria-expanded="false">${user.id} 님</a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item" href="javascript:void(0)" onclick='location.href="/logout";' id="logout">로그아웃</a></li>
									<li><hr class="dropdown-divider" /></li>
									<li><a class="dropdown-item" href="#!">마이페이지</a></li>
								</ul>
					    	</li>
						</ul>
					</c:if>
			    </form>
			</div>
		</div>
	</nav>

<div class="container-fluid">
	<div class="row">
		<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
			<div class="position-sticky pt-3">
				<ul class="nav flex-column">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="/home">
							<span data-feather="home">Home</span> 
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">
							 <span data-feather="heart">찜목록</span>
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">
							<span data-feather="star">내가 쓴 리뷰</span>
						</a>
					</li>
				</ul>
			</div>
		</nav>

		<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 ">
			<div class="mypg_wrap" style="width:900px;">
				<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">마이 페이지</h1>
			        <div class="btn-toolbar mb-2 mb-md-0">
			            <a href="#" class="setting">
			            	<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" f class="bi bi-gear-fill" viewBox="0 0 16 16">
			            		<path d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 1 0-5.86 2.929 2.929 0 0 1 0 5.858z"/>
			            	</svg>
			          	</a>
			        </div>
				</div>
				<div class="user_banner" style="width:900px;">
					<img src="../assets/images/mypage.jpg" alt="#" width="900" height="300">
					<p class="user_img" style="width:100px;float:left;">
						<img src="../assets/images/user.png" alt="" width="100" height="100">
					</p>
					<h4 class="user_id" style="margin-left:20px;width:200px;height:100px;float:left;line-height:100px;">
						${user.id } 님의 페이지
					</h4>
				</div>
	
	
				<h2 style="width:900px;clear:both;">My Wish List</h2>
				<div class="table-responsive" style="width:900px;">
					<table class="table table-striped table-sm ">
						<thead>
				            <tr>
								<th scope="col">번호</th>
								<th scope="col">영화제목</th>
								<th scope="col">개봉일</th>
								<th scope="col">평점</th>
			            	</tr>
						</thead>
						<tbody>
							<c:set var="url" value="https://image.tmdb.org/t/p/w45/" />
							<c:forEach var="contentVO" items="${pageInfo.pageList}">
								<tr class="tr" style="line-height:80px;">
									<td class="td_1"><img src=<c:out value="${url}${contentVO.poster_path}" />  alt="#" width="50"> </td>
									<td>${contentVO.title }</td>
									<td>
	                                    <fmt:formatDate pattern="yyyy.MM.dd" value="${contentVO.release_date }" />
									</td>
									<td>
										<fmt:formatNumber value="${contentVO.vote_average }" pattern=".0" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				 <div id="pagination">
					<!-- 변수 매핑 -->
					<c:set var="action" value="/mypage" />
					<c:set var="page" value="${pageInfo.currentPage}" />
					<c:set var="beginPage" value="${pageInfo.startPage}" />
					<c:set var="endPage" value="${pageInfo.endPage}" />
					<c:set var="totalPage" value="${pageInfo.totalPage}" />
				    
				    <ul class="page_wrap">
				    	<!-- 처음으로 -->
					    <c:if test="${page != 1 }">
					    	<li class="skip"><a href="${action}?page=1">처음</a></li>
					    </c:if>
					    <!-- 이전버튼 -->
						<c:if test="${pageInfo.showPrev}">
							<li class="skip"><a href="${action}?page=${page - 1}">이전</a></li>
						</c:if>
					                
						<!-- 넘버링버튼 for문 -->
						<c:forEach var="item" varStatus="status" begin="${beginPage}" end="${endPage}" step="1">
							<c:if test="${page == item}">
								<li><span>${item}</span></li>
							</c:if>
							<c:if test="${page != item}">
								<li><a href="${action}?page=${item}">${item}</a></li>
							</c:if>
						</c:forEach>
					
						<!-- 다음버튼 -->
						<c:if test="${pageInfo.showNext}">
							<li class="skip"><a href="${action}?page=${endPage + 1}">다음</a></li>
						</c:if>
					
						<!-- 끝으로 -->
						<c:if test="${page != totalPage }">
							<li class="skip"><a href="${action}?page=${totalPage}">끝</a></li>
						</c:if>	
				    </ul>     
				</div>
            </div>
			</div>
    	</main>
	</div>
</div>
	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

	<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="../assets/js/dashboard.js"></script>
</body>
</html>
