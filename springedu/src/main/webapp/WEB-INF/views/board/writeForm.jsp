<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 공통 모듈 -->
<%@ include file="/WEB-INF/views/include/common.jsp" %>
<title>게시글</title>
<link rel="stylesheet" href="${contextPath }/css/board/board.css">
<link rel="stylesheet" href="${contextPath }/css/board/writeForm.css">
<script defer src="${contextPath }/js/board/writeForm.js"></script>
<style>
  /* 메뉴 영역 */
  nav{}
  nav > .container-n{ height:50px; background-color: #9e00c5; }
  nav > .container-n > ul{ display:flex; list-style-type: none; height:50px; width:500px; margin: 0px auto; line-height: 50px; }
  nav > .container-n > ul > li { width:100px; text-align: center; font-size:0.8rem; }
  nav > .container-n > ul > li > a{ color:white; text-decoration: none; font-weight: bold; }
  nav > .container-n > ul > li > a:hover{ text-decoration: underline; }

</style>
</head>
<body>
	<!-- 최상위메뉴 -->
	<%@ include file="../include/uppermost.jsp" %>

  <!-- header -->
  <%--@ include file="/header.jsp" --%>

  <!-- 메뉴 -->
  <%@ include file="../include/menu.jsp" %>
	  
	<main>
		<div class="container">
			<div class="content">
				<form id="writeForm"
				      method="post"
				      action="${contextPath }/board/write"
				      enctype="multipart/form-data">
      <legend>게시글 작성</legend>
      <ul>
        <li>
          <label for="boardCategoryVO.cid">분류</label
          ><select name="" id="">
            <option value="1001">SPRING</option>
            <option value="1002">DATABASE</option>
            <option value="1003">JAVA</option>
          </select>
        </li>
        <li>
          <label for="btitle">제목</label
          ><input type="text" name="btitle" id="btitle" />
        </li>
        <li>
          <label for="bid">작성자</label
          ><input type="text" name="bid" id="bid" />
        </li>
        <li>
          <label for="bcontent">내용</label
          ><textarea
            name="bcontent"
            id="bcontent"
            cols="30"
            rows="10"
          ></textarea>
        </li>
        <li>
          <label for="">첨부</label><input type="file" name="files" id="files" multiple />
        </li>
        <li>
          <button id="writeBtn" type="button" class="btn btn-outline-success">
            등록
          </button>
          <button id="cancelBtn" type="button" class="btn btn-outline-danger">
            취소
          </button>
          <button id="listBtn" type="button" class="btn btn-outline-primary">
            목록
          </button>
        </li>
      </ul>
    </form>
  <!-- 푸터 -->
  <%@ include file="../include/footer.jsp" %>  
</body>
</html>  