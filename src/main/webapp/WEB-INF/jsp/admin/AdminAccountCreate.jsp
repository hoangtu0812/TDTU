<%--
  Created by IntelliJ IDEA.
  User: tu.pham
  Date: 30/07/2022
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<c:url value="/admin/create-account"/>" method="post">
        <label for="user-mail">Email:</label>
        <input name="userMail" id="user-mail" type="text"/>
        <label for="user-name" >Full name:</label>
        <input name="userName" id="user-name" type="text"/>
        <label for="user-password">Password:</label>
        <input name="userPassword" id="user-password" type="password"/>
        <label for="user-repassword">Retype Password</label>
        <input name="userRePassword" id="user-repassword" type="password"/>
        <input name="userBirthday" id="user-birthday" type="date"/>
        <label for="user-phone">Phone:</label>
        <input name="userPhone" id="user-phone" type="text"/>
        <label for="user-role">Role:</label>
        <select id="user-role" name="userRole">
            <option value="superadmin">Super Admin</option>
            <option value="admin">Admin</option>
            <option value="staff">Staff</option>
            <option value="user" selected="selected">User</option>
        </select>
        <label for="user-status">Status:</label>
        <select id="user-status" name="userStatus">
            <option value="0" selected="selected">Pending</option>
            <option value="1">Active</option>
            <option value="2">Inactive</option>
            <option value="3">Ban</option>
            <option value="4">Deleted</option>
        </select>
        <input type="submit" value="submit"/>
    </form>
    <div>${message}</div>
</body>
</html>
