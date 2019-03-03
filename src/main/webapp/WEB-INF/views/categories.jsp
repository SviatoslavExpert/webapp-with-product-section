<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-02-21
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<h1>Categories</h1>
                        <%-- General: Categories --%>
<c:forEach items="${categories}" var="c">  <%-- loop for each --%>
           <%-- a href= - makes it a clickable link --%>         <%-- c.id --%>              <%-- c.categoryName --%>
    <h3>Category name: <a href="<c:url value="/servlet/category?c_id=${c.id}"/>"><c:out value="${c.categoryName}"/></a>
    </h3>
</c:forEach>
</body>
</html>
