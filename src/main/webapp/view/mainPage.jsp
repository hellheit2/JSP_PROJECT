<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>왓플피디아</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="../assets/js/modal.js"></script>
    <link rel="stylesheet" href="../assets/css/modal_test.css">
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
    </style>

    <!-- Custom styles for this template -->
    <link href="../assets/css/carousel.css" rel="stylesheet">
	
</head>

<body>
	<%@ include file = "./modalLogin.jsp" %>
	<%@ include file = "./modalJoin.jsp" %>
    
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">영화리뷰사이트</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="#">영화</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="#">TV</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                        <c:if test="${empty user}">
                        	<input type="button" value="로그인" class="login1" onclick="modalClick(this);" id="login">
                        	<input type="button" value="회원가입" class="login2" onclick="modalClick(this);" id="join">
                        </c:if>
                         <c:if test="${not empty user}">
                        	<input type="button" value="로그아웃" class="login1" onclick="modalClick(this);" id="logout">
                        	<input type="button" value="마이페이지" class="login2" onclick="modalClick(this);" id="myPage">
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
            <h2>💛리뷰 랭킹💛</h2>
            <p class="plus_btn"><a href="/board">+더보기</a></p>
            <div class="movie_container">
            	<div class="movie1">
	            	<c:forEach var="contentVO" items="${contentList}" begin="0" end="10">
					    <div class="movie_poster">
					        <div class="movie_wrap">
					        	<c:set var="url" value="https://image.tmdb.org/t/p/w500/" />
					            <a href="#"><img src="<c:out value='${url}${contentVO.poster_path}' />" alt="#" width="288" height="400"></a>
					            <div class="plus"><p><img src="../assets/images/plus.png" alt="#" width="64" height="64"></p></div>
					        </div>
					        <div class="movie_ex1">
					            <div class="movie_idx" title="<c:out value="${contentVO.title }" />">
					            	<c:out value="${contentVO.title }" />
					            </div>
				 	            <div class="movie_date"><c:out value="${contentVO.release_date }" /></div>
					            <div class="movie_review"><c:out value="${contentVO.vote_average }" /></div>
					        </div>
					    </div>
				    </c:forEach>
				    <script>
						var dateList = document.getElementsByClassName('movie_date');
						Array.from(dateList).forEach(function(date){
							date.innerHTML = date.innerHTML.slice(-4);	
						});
					</script>
				</div>
            </div>
        </div>

        <!-- FOOTER -->

    </main>


    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>