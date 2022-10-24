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
        <link href="../assets/css/styles.css" rel="stylesheet" />
        <script src="../assets/js/jquery-3.6.0.min.js"></script>
        <script src="../assets/js/wish.js"></script>
    
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">영화리뷰사이트</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">영화 목록</h1>
                    <p class="lead fw-normal text-white-50 mb-0">20개씩 나눠서 페이징</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                 	<div>
	                 	<c:forEach var="contentVO" items="${pageInfo.pageList}">
	                 		<div class="col mb-5 content">
		                        <div class="card h-100">
		                            <!-- Sale badge 순위-->
		                            <!-- <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div> -->
									<c:set var="url" value="https://image.tmdb.org/t/p/w500/" />
		                            <img class="card-img-top" src=<c:out value="${url}${contentVO.poster_path}" /> 
		                            						alt="#" width="300" height="400" />
		                            <div class="position-absolute wishlist" style="top:0.5rem; right:0.5rem;">
			                            <c:choose>
			                           		<c:when test="${user != null}">
			                           			<c:if test="${contentVO.wish == false}">
									            	<a href="javascript:void(0);" onclick="like_func(this);" class="wish">
														<img src="../assets/images/wish.png" alt="찜하기" width="45" height="45" id="heart_icon" data-content=<c:out value="${contentVO.id }" />>
													</a>
									            </c:if>
									            <c:if test="${contentVO.wish == true}">
									            	<a href="javascript:void(0);" onclick="like_func(this);" class="wish">
														<img src="../assets/images/wish_checked.png" alt="찜하기" width="45" height="45" id="heart_icon" data-content=<c:out value="${contentVO.id }" />>
													</a>
												</c:if>	
			                           		</c:when>
			                           		<c:otherwise>
				                           		<a href="javascript: login_need();" class="wish">
													<img src="../assets/images/wish.png" alt="찜하기" width="45" height="45" id="heart_icon">
												</a>
			                           		</c:otherwise>
			                           	</c:choose>
		                           	</div>
	                 
		                            <!-- Product details-->
		                            <div class="card-body p-4">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder"><c:out value="${contentVO.title }" /></h5>
		                                    <!-- Product reviews 별점-->
		                                    <!-- <div class="d-flex justsify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div> -->
		                                    <!-- Product price-->
		                                    <c:out value="${contentVO.release_date }" /> 
		                                    <c:out value="${contentVO.vote_average }" />
		                     
		                                </div>
		                            </div>
		                            <!-- Product actions 더보기-->
		                            <!-- <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
		                            </div> -->
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
					         
					    <!-- 처음으로 -->
						<a href="${action}?page=1">
								<span>«</span>
						</a>
						
						<!-- 이전버튼 -->
						<c:if test="${page <= 1}">
							<span>이전</span>
						</c:if>
						<c:if test="${page > 1}">
							<a href="${action}?page=${page - 1}">이전</a>
						</c:if>
					                
						<!-- 넘버링버튼 for문 -->
						<c:forEach var="item" varStatus="status" begin="${beginPage}" end="${endPage}" step="1">
							<c:if test="${page == item}">
								${item}
							</c:if>
							<c:if test="${page != item}">
								<a href="${action}?page=${item}">${item}</a>
							</c:if>
						</c:forEach>
					
						<!-- 다음버튼 -->
						<c:if test="${page >= totalPage}">
							<span>다음</span>
						</c:if>
						<c:if test="${page < totalPage}">
							<a href="${action}?page=${page + 1}">다음</a>
						</c:if>
						<!-- 끝으로 -->
						<a href="${action}?page=${totalPage}">
							<span>»</span>
						</a>
					</div>
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

<!-- 
<div class="col mb-5">
    <div class="card h-100">
        주석 Sale badge 순위
        <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
        주석 Product image
        <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
        주석 Product details
        <div class="card-body p-4">
            <div class="text-center">
                주석 Product name
                <h5 class="fw-bolder">Special Item</h5>
                주석 Product reviews 별점
                <div class="d-flex justify-content-center small text-warning mb-2">
                    <div class="bi-star-fill"></div>
                    <div class="bi-star-fill"></div>
                    <div class="bi-star-fill"></div>
                    <div class="bi-star-fill"></div>
                    <div class="bi-star-fill"></div>
                </div>
                주석 Product price
                추가정보 <span class="text-muted text-decoration-line-through">$20.00</span>
                $18.00
            </div>
        </div>
        주석 Product actions 더보기
        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
        </div>
    </div>
</div>
 -->