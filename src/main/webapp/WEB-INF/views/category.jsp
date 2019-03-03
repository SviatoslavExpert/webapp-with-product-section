<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-02-21
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
      <%-- category inside categories section --%>
    <h3>Category name: <c:out value="${category.categoryName}"/></h3>
    <p>Description: <c:out value="${category.description}"/></p>
    <c:forEach items="${category.products}" var="p">
         <%--  address of a jsp page is formed here --%>
    <p>Products: <a href="<c:url value="/servlet/product?p_id=${p.id}"/>"><c:out value="${p.productName}"/></a></p>

</c:forEach>
</body>
</html>
