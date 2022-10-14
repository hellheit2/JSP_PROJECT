<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
    <meta charset="UTF-8">
    <title>왓플피디아</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="../assets/css/layout.css">
    <link rel="stylesheet" href="../assets/css/modal_test.css">
	<script src="../assetsjs/jquery-3.6.0.min.js"></script>
	<script src="../assetsjs/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="../assets/js/modal.js"></script>
</head>
<body>
	<%@ include file = "./modalLogin.jsp" %>
	<%@ include file = "./modalJoin.jsp" %>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <div id="wrap">
        <header id="top">
            <h1><a href="index.html"><img src="../assets/images/img.jpg" alt="영화" width="200" height="58"></a></h1>
            
            <p class="search_btn">
                <input type="search" placeholder="검색어를 입력하세요.."><a href="#"><img src="../assets/images/search.png" alt="#" width="G9" width="27" height="27"></a>
            </p>
            
            <p class="quick">
                <ul class="q_join_wrap">
			        <li><button onclick="modalClick(this)" id="login">모달 로그인</button></li> 
			        <li><button onclick="modalClick(this)" id="join">모달 회원가입</button></li>
			    </ul><!--join-->
            </p>






            <a class="btn btn-primary" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample">
                Link with href
              </a>
              
              <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
                <div class="offcanvas-header">
                  <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                  <div>
                    Some text as placeholder. In real life you can have the elements you have chosen. Like, text, images, lists, etc.
                  </div>
                  <div class="dropdown mt-3">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown">
                      Dropdown button
                    </button>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#">Action</a></li>
                      <li><a class="dropdown-item" href="#">Another action</a></li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                  </div>
                </div>
              </div>

            <nav id="main_menu">
                <ul>
                    <li><a href="#">영화</a></li>
                    <li><a href="#">TV</a></li>
                    <li><a href="#">책</a></li>
                    
                </ul>
            </nav>
        </header><!--헤더 끝~~-->
        <div id="main_img">
            <p><img src="images/movie1.jpg" alt="#" width="1280" height="720"></p>
            
      
        </div>
        <c:foreach >
            
        </c:foreach>
        <aside id="banner">
            <h3>영화랭킹</h3>
            <ul>
                <li>
                    <img src="images/movie_image (1).jpg" alt="#" width="300" height="400">
                    <p>제목1</p>
                </li>
                <li>
                    <img src="images/movie_image (2).jpg" alt="#" width="300" height="400">
                    <p>제목1</p>
                </li>
                <li>
                    <img src="images/movie_image.jpg" alt="#" width="300" height="400">
                    <p>제목1</p>
                </li>
                <li>
                    <img src="images/movie_image.jpg" alt="#" width="300" height="400">
                    <p>제목1</p>
                </li>
                <li><a href="#" class="view">+더보기</a></li>
            </ul>
        </aside>
        
    </div>
    <footer id="bottom">
        <address>
푸터 영역입니다~~~~~~~~~~~~
        </address>
    </footer>
</body>
</html>