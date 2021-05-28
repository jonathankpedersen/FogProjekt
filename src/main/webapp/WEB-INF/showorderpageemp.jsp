<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Show Orders
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of Fog. Here are your orders.
        Role: ${sessionScope.role}
        <form method="post" action="customermateriallist" enctype=text/plain>
       <c:forEach var="order" items="${requestScope.orderlist}">
           <p>
               <INPUT TYPE="radio" name="orderlist" value="${order.ordreId}"/>Order from customer number ${order.kunde_Id}
               <!-- TODO: Det her skal pakkes ind så hver linje har en radioboks, skal pakkes ind i et formtag med action=-->

           </p>
       </c:forEach>
        <INPUT TYPE="submit" VALUE="submit" />
        </form>

        <!--<form name="login" action="${pageContext.request.contextPath}/fc/orderpageemp"  method="POST">
            <button class="btn btn-primary" type="submit" value="orderpage">Orders</button>-->
        </form>
    </jsp:body>

</t:genericpage>

