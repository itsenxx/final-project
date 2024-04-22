<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<link rel="stylesheet" href="/resources/css/com.css"/>

<div id="box">
            <h1>채용관리</h1>
  <table class="responsive-table">
    <div>
        <thead>
          <tr>
            <th scope="col">Join ID</th>
            <th scope="col">Join Name</th>
            <th scope="col">Content</th>
            <th scope="col">File 1</th>
            <th scope="col">File 2</th>
          </tr>
        </thead>
        <tbody>
              <c:forEach items="${comList}" var="com">
                  <tr>
                    <th scope="row">${com.joinId}</th>
                    <td data-title="Released">${com.joinName}</td>
                    <td data-title="Studio">${com.content}</td>
                    <td data-title="Worldwide Gross" data-type="currency"><a href="download/${com.file1}">${com.file1 == 'void' ? 'No file' : com.file1}</a></td>
                    <td data-title="Domestic Gross" data-type="currency"><a href="download/${com.file2}">${com.file2 == 'void' ? 'No file' : com.file2}</a></td>
                  </tr>
              </c:forEach>
        </tbody>
    </div>
  </table>

  <%@ include file="/WEB-INF/views/includes/footer.jsp"%>



