<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>왓플피디아</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="../assets/js/jquery-3.6.0.min.js"></script>
    <script src="../assets/js/modal.js"></script>
    <link rel="stylesheet" href="../assets/css/modalLoginJoin.css">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

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
      
      #my_modal{
   			border-radius:10px;
   			display:none;
   			background-color:#ffffff;
   			outline:none;
   			border:none;
   			overflow:scroll;
   			-ms-overflow-style:none;
   		}

		#my_modal::-webkit-scrollbar { 
		    display: none;
		    width: 0 !important;
		}
		
		.modal_close_btn{
			margin:5px;
		}
    </style>

    <!-- Custom styles for this template -->
    <link href="../assets/css/carousel.css" rel="stylesheet">
	<script src="../assets/js/main_movie.js"></script>
	<script src="../assets/js/jquery-1.12.4.min.js"></script>
    <script src="../assets/js/jquery-ui-1.10.4.custom.min.js"></script>
</head>

<body>
	<%@ include file = "./modalLogin.jsp" %>
	<%@ include file = "./modalJoin.jsp" %>
    
	<div id="my_modal" style="width:600px;height:900px;margin:0;padding:0;">
	    <iframe src="/content" id="content_detail" style="width:620px;height:900px;">대체 내용</iframe>
	    <a class="modal_close_btn"><img src="../assets/images/menu_close.png" alt="닫기" width="30" height="30"></a>
	</div>
    <header>
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
    </header>

    <main>
		
		
        <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">

                <div class="carousel-item active ">
                    <svg class="bd-placeholder-img banner" width="100%" height="100%" preserveAspectRatio="xMidYMid slice" focusable="true"></svg>
                </div>

                <div class="carousel-item">
                    <svg class="bd-placeholder-img banner1" width="100%" height="100%" preserveAspectRatio="xMidYMid slice" focusable="true"></svg>
                </div>

                <div class="carousel-item">
                    <svg class="bd-placeholder-img banner2" width="100%" height="100%" preserveAspectRatio="xMidYMid slice" focusable="true"></svg>
                    <div class="container">
                        <div class="carousel-caption text-end">
                        </div>
                    </div>
                </div>
            </div>

            <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>


        <!-- Marketing messaging and featurettes
      ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->
        <div id="wrap">
            <div class="wrap_index">
				<h2>💛리뷰 랭킹💛</h2>
				<p class="plus_btn">
				<a href="/list"><img src="../assets/images/plus2.png" width="60"title="더보기"></a>
				</p>
			</div>
			<div id="movie_all">
				<ul class="movie_wrap">
					<c:set var="poster" value="https://image.tmdb.org/t/p/w500/" />
					<c:forEach var="contentVO" items="${pageInfo.pageList}" begin="0" end="8">
						<li onclick="get_content(this,${contentVO.id })">
							<a href="#">
								<img src="<c:out value='${poster}${contentVO.poster_path}' />" alt="#" width="300" height="400">
							</a>
						</li>
					</c:forEach>
				</ul>
  			</div>
		</div>
      

        <!-- FOOTER -->

    </main>
	<footer class="py-5 bg-dark">
		<div class="container">
			<p style="text-align: center;">
				<img src="../assets/images/movie-videos-icon.png" style="width:100px;">
			</p>
		</div>
	</footer>

    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>