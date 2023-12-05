<%-- 
    Document   : viewCart
    Created on : Jun 19, 2023, 1:36:44 PM
    Author     : ANDIM
--%>

<%--@page import="java.util.Map"%>
<%@page import="Cart.CartObj"--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <h1>Java Book Store</h1>
        <h2>Your Cart includes </h2>

        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">



            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <form action="DispatchServlet">
                    <c:forEach var="item" items="${cart.items}" varStatus="counter">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${item.key}
                            </td>
                            <td>
                                ${item.value}
                            </td>
                            <td>
                                <input type="checkbox" name="checkItem" value="${item.key}" />
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="3">
                            <a href="shopping.html">Add more Items to your Cart</a> 
                        </td>
                        <td>
                            <input type="submit" value="Remove Selected Items" name="btAction" />
                        </td>
                    </tr>
                    </tbody>
            </table>
        </form>
    </c:if><br/>
    <form action="DispatchServlet">
        <input type="submit" value="Check Out" name="btAction" />
    </form>      
    <c:if test="${empty cart}">
        <h2>
            Cart does not exits!!!
        </h2>
    </c:if>
    <%--
    <h1>Java Book Store</h1>
    <%
        //1. Cust goes his/her carts's place
        if (session != null) {
            //2. Cust take his/her cart
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart != null) {
                //3. Cust gets items
                Map<String, Integer> items = cart.getItems();
                if (items != null) {
                    //4. Cust picks all items up
    %>
    <h2>Your cart includes</h2>
    <form action="DispatchServlet">
    <table border="1">
        <thead>
            <tr>
                <th>NO.</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Action</th>

                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for(String key : items.keySet()){
                        %>
                    <tr>
                        <td>
                            <%= ++count %>
                        </td>
                        <td>
                            <%= key %>
                            <input type="hidden" name="txtNameBook" value="<%= key %>" />
                        </td>
                        <td>
                            <%= items.get(key) %>
                        </td>
                        <td>
                            <input type="checkbox" name="chkItem" value="ON" />
                            <input type="hidden" name="txtNameBook" value="" />
                        </td>

                </tr>    
                        
                <%        
                    }// traverse each item
                %>
                 <tr>
                     <td colspan="3"><a href="shopping.html">Add more items to Your Cart</a></td>
                     <td>
                         <input type="submit" value="Remove Selected Items" name="btAction" />
                         
                     </td>

                </tr>
            </tbody>
        </table>
        </form>         



        <%
                        return;
                    }//end items have existed
                }// cart has existed
            }//end seesion has existed
%>
        <h2>
            No cart is existed!!!
        </h2>
    --%>
</body>
</html>
