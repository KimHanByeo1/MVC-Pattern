<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

  
 

<nav class="navbar navbar-expand-xl bg-pink py-3 py-lg-0 px-lg-5" style="background-color: #FDCDCD;">
  <div class="container-fluid">
   <a class="navbar-brand" href="#">
      <img src="./images/HeaderLogo2.png" style="padding-right: 60px; padding-left: 40px;height:60px"></img>
    </a>
    <a class="navbar-brand" href="managerMain.do">ALLways</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="managerMain.do">MAIN</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="MorderStatus.do">주문 현황 관리</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           상품관리
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="Mlist.do">옵션 리스트 관리</a></li>
            <li><a class="dropdown-item" href="searchCake.do">케이크 관리</a></li>
            <li><a class="dropdown-item" href="searchGoods.do">추가 상품 관리</a></li>
          </ul>
        </li>
          <li class="nav-item">
          <a class="nav-link" href="searchReview.do">리뷰 관리</a>
        </li>
      </ul>
      
    </div>
  </div>
</nav>
