<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>영화 목록</title>
       <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../assets/css/contentList.css" rel="stylesheet" />
        <link href="../assets/css/contentList_add.css" rel="stylesheet" />
        <link href="../assets/css/wish.css" rel="stylesheet" />
        <link rel="stylesheet" href="../assets/css/modalLoginJoin.css">
        <script src="../assets/js/jquery-3.6.0.min.js"></script>
        <script src="../assets/js/wish.js"></script>
    	<script src="../assets/js/modal.js"></script>
    	<style>
    	
    		#my_modal{
    			border-radius:10px;
    			overflow:hidden;
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
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">영화 목록</h1>
                    <p class="lead fw-normal text-white-50 mb-0"> &quot;${pageInfo.totalContent }&quot;개의 영화</p>
                </div>
            </div>
        </header>
        
        <%@ include file = "./modalLogin.jsp" %>
		<%@ include file = "./modalJoin.jsp" %>
		
        <div id="my_modal" style="width:600px;height:900px;margin:0;padding:0;">
		    <iframe src="/content" id="content_detail" style="width:620px;height:900px;">대체 내용</iframe>
		    <a class="modal_close_btn"><img src="../assets/images/menu_close.png" alt="닫기" width="30" height="30"></a>
		</div>
        
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                 	<c:forEach var="contentVO" items="${pageInfo.pageList}">
                 		<div class="col mb-5 content">
	                       <%--  <div class="card h-100 movie_wrap" onclick="location.href='/content?id=${contentVO.id}'">
								<c:set var="url" value="https://image.tmdb.org/t/p/w500/" /> --%>
							<div class="card h-100 movie_wrap" onclick="get_content(this,${contentVO.id })">
								
	                           	
	                           	<c:set var="url" value="https://image.tmdb.org/t/p/w500/" />
	                            <p><img class="card-img-top" src=<c:out value="${url}${contentVO.poster_path}" /> 
	                            						alt="${contentVO.title }" width="300" height="400" /></p>
	                            <div class="plus"><p><img src="../assets/images/plus.png" alt="#" width="64" height="64"></p></div>
	                            
								<div class="position-absolute wishlist" style="top:0.5rem; right:0.5rem;">
		                            <c:choose>
		                           		<c:when test="${user != null}">
		                           			<c:if test="${contentVO.wish == false}">
								            	<div onclick="like_func(event, this, 'wish');" class="wish" data-controller="wish">
													<img src="../assets/images/wish.png" alt="찜하기" width="45" height="45" id="heart_icon" data-content=<c:out value="${contentVO.id }" />>
												</div>
								            </c:if>
								            <c:if test="${contentVO.wish == true}">
								            	<div onclick="like_func(event, this, 'wish');" class="wish" data-controller="wish">
													<img src="../assets/images/wish_checked.png" alt="찜하기" width="45" height="45" id="heart_icon" data-content=<c:out value="${contentVO.id }" />>
												</div>
											</c:if>	
		                           		</c:when>
		                           		<c:otherwise>
			                           		<div onclick="login_need(event);" class="wish">
												<img src="../assets/images/wish.png" alt="찜하기" width="45" height="45" id="heart_icon">
											</div>
		                           		</c:otherwise>
		                           	</c:choose>
	                           	</div>
	                            
	                            <div class="card-body p-4">
	                                <div class="text-center">
	                                    <h5 class="fw-bolder movie_idx" title="<c:out value="${contentVO.title }" />"><c:out value="${contentVO.title }" /></h5>
	                                    <div class="movie_date">
	                                    	<fmt:setLocale value="en_US"></fmt:setLocale>
	                                    	<fmt:formatDate pattern=" MMM, yyyy" value="${contentVO.release_date }" />
										</div>
	                                    <%-- <div class="movie_average"><c:out value="${contentVO.vote_average }" /></div> --%>
	                                	
	                                </div>
	                                
	                            </div>
	                        </div>
	                    </div>
				    </c:forEach>  
				   
                </div>
                <div id="pagination">
					<!-- 변수 매핑 -->
					<c:set var="action" value="/list" />
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
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
