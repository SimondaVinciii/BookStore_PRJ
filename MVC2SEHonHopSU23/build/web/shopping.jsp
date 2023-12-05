<%-- 
    Document   : shopping.jsp
    Created on : Jul 12, 2023, 10:47:23 AM
    Author     : ANDIM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1 style="color: blue">Welcome to Adides'Store</h1>
        <h2>List of our Product</h2>
        <form action="DispatchServlet" method="POST">
            Search <input type="text" name="searchProduct" value="${param.searchProduct}" />
            <input type="submit" value="SearchProduct" name="btActtion" />
        </form>

        <c:set var="searchProductValue" value="${param.searchProduct}"/>
        <c:if test="${ empty searchProductValue}">
            <c:set var="allList" value="${requestScope.ALL_P}"/>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Sku</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${allList}" var="pro" varStatus="counter"/>
                        <tr>
                            <th>${counter.count}</th>
                            <th>${pro.sku}</th>
                            <th>${pro.name}</th>
                            <th>${pro.quantity}</th>
                            <th>${pro.price}</th>
                            <th>${pro.status}</th>
                        </tr>
                            
                    </tbody>
                </table>
            
        </c:if>
</html>
