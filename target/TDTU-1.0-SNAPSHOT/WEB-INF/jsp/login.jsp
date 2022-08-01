<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/15/2022
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="Đăng nhập"/>
</c:import>
<div class="login">

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="user-mail">Email:</label>
        <input type="text" id="user-mail" name="userMail"/>
        <label for="user-password">Password:</label>
        <input type="password" id="user-password" name="userPassword"/>
        <input type="submit" id="submit" name="submit"/>
    </form>
</div>
<c:import url="footer.jsp"/>

