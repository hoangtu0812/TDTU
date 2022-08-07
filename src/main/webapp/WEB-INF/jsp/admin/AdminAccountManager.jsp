<%--
  Created by IntelliJ IDEA.
  User: tu.pham
  Date: 30/07/2022
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="<c:url value="/admin/create-account"/>">Create</a>
    <c:if test="${accountList != null}">
        <table>
            <tr>
                <th>Email</th>
                <th>Password</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Phone</th>
                <th>Role</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${accountList}" var="account">
                <tr>
                    <td>${account.userMail}</td>
                    <td>${account.password}</td>
                    <td>${account.name}</td>
                    <td>${account.birthday}</td>
                    <td>${account.phone}</td>
                    <td>${account.role}</td>
                    <td>
                        <c:if test="${account.status == 0}">
                            Pending
                        </c:if>
                        <c:if test="${account.status == 1}">
                            Active
                        </c:if>
                        <c:if test="${account.status == 2}">
                            Inactive
                        </c:if>
                        <c:if test="${account.status == 3}">
                            Banned
                        </c:if>
                        <c:if test="${account.status == 4}">
                            Deleted
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
