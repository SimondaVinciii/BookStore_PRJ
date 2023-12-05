<%-- 
    Document   : search
    Created on : Jun 5, 2023, 5:11:33 PM
    Author     : ANDIM
--%>

<%--<%@page import="java.util.List"%>
<%@page import="thinhhq.registration.RegistrationDTO"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USER.fullname}
        </font>
        <h1> Search Page </h1>
        <form action="DispatchServlet" method="POST">
            Search Value <input type="text" name="txtSearchValue" 
                                value="${param.txtSearchValue}" /> <br>
            <!--giữ giá trị trên thanh search sau khi nhấn nút Search-->
            <input type="submit" value="Search" name="btAction" />
            <input type="submit" value="LogOut" name="btAction" />
        </form> <br>
        <c:set var="searchValue" value ="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_RESULT}"/>

                <c:if test ="${not empty result}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>username</th>
                                <th>password</th>
                                <th>Full name</th>
                                <th>Role</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${result}" var="dto" varStatus="counter">

                            <form action="DispatchServlet" method="POST">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${dto.username}
                                        <input type="hidden" name="txtUserName" value="${dto.username}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtPassword" value="${dto.password}" />
                                    </td>
                                    <td>
                                        ${dto.fullname}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="checkRole" value="ON" 
                                               <c:if test ="${dto.role}">
                                                   checked="checked"
                                               </c:if>
                                               />
                                    </td>
                                    <td>
                                        <c:url var="deleteLink" value="DispatchServlet">
                                            <c:param name="btAction" value="delete"/>
                                            <c:param name="pk" value="${dto.username}"/>
                                            <c:param name="lastSearchValue" value="${searchValue}"/>
                                        </c:url>
                                        <a href="${deleteLink}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update" name="btAction"/>
                                        <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                    </td>
                                </tr>
                            </form>

                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty result}">
                <h2>No record is matched!!!
                </h2>
            </c:if>
    </c:if>
    <%--<%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie newestCookie = cookies[cookies.length - 1];
            String username = newestCookie.getName();
    %>
    <font color="red">
    Welcome, <%= username%>
    </font>   
    <%
        }
    %>
    <h1> Search Page </h1>
    <form action="DispatchServlet" method="POST">
        Search Value <input type="text" name="txtSearchValue" value="<%= request.getParameter("txtSearchValue")%>" /> <br>
        <!--giữ giá trị trên thanh search sau khi nhấn nút Search-->
        <input type="submit" value="Search" name="btAction" />
    </form>
    <br/>
    <%
        String searchValue = request.getParameter("txtSearchValue");

            if (searchValue != null) {
                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCH_RESULT"); // ép kiểu mới làm đc
                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Full Name</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody> 
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                        String urlRewriting = "DispatchServlet"
                                + "?btAction=delete"
                                + "&pk=" + dto.getUsername()
                                + "&lastSearchValue=" + searchValue;
                %>
            <form action="DispatchServlet">
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= dto.getUsername()%>
                        <input type="hidden" name="txtUserName" value="<%= dto.getUsername()%>"/> 
                    </td>
                    <td>
                        <input type="text" name="txtPassword" value="<%= dto.getPassword()%>"/>
                    </td>
                    <td>
                        <%= dto.getFullname()%> 
                    </td>
                    <td>
                        <input type="checkbox" name="checkRole" value="ADMIN" 
                               <%
                                   if (dto.isRole()) {
                               %>
                               checked="checked"
                               <%
                                   }
                               %>  
                               />
                    </td>
                    <td>
                        <a href="<%= urlRewriting%>">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="lastSearchValue" value="<%= searchValue%>"/>
                        <input type="submit" value="Update" name="btAction"/>
                    </td>
                </tr>
            </form>

            <%
                }
          
        </tbody>
    </table>
    <%
    } else { // tách giữa code html và java để thông báo ra màn hình rằng ko tìm thấy (scriplets-fragment code)
    %>
    <h2>Cannot find!</h2>
    <%
            }
        }// ngăn user truy cập trực tiếp trang search thông qua url mà ko vào login 
    %>
          %>--%>
</body>
</html>
