<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../include/header.jsp"%>
<div class="main-panel">
	<div class="content">
		<div class="page-inner">
					<div class="page-header">
						<h4 class="page-title">DataTables.Net</h4>
						<ul class="breadcrumbs">
							<li class="nav-home">
								<a href="#">
									<i class="flaticon-home"></i>
								</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="#">Tables</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="#">Datatables</a>
							</li>
						</ul>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Basic</h4>
								</div>
								<div class="card-body">
									<div>
										<table>
											<thead>
											<tr>
												<th>#번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th>작성일</th>
												<th>수정일</th>
											</tr>
											</thead>
											
											<c:forEach items="${list}" var="board">
            <tr>
              <td><c:out value="${board.bno}" /></td>
               <td>
                  <a class='move' href='<c:out value="${board.bno}"/>'>
                  <c:out value="${board.title}" />   <b>[  <c:out value="${board.replyCnt}" />  ]</b>
                  </a>
              <td><c:out value="${board.writer}" /></td>
              <td><fmt:formatDate pattern="yyyy-MM-dd"
                  value="${board.regdate}" /></td>
              <td><fmt:formatDate pattern="yyyy-MM-dd"
                  value="${board.updateDate}" /></td>
            </tr>
          </c:forEach>
											
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	</div>

<%@include file="../include/footer.jsp"%> 