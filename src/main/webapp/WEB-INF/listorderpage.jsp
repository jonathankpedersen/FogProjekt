<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Customer Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of Fog. Here are your orders.
        Role: ${sessionScope.role}
       <c:forEach var="order" items="${requestScope.orderlist}">
           <p>

               ${order}
           </p>
       </c:forEach>

    </jsp:body>

</t:genericpage>

