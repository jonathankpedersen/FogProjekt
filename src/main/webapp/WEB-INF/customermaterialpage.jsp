<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Material Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as an employee of Fog, and looking at orders.${requestScope.order.ordreId}
        Role: ${sessionScope.role}
        <p>
        <c:forEach var="orderItem" items="${requestScope.orderItems}">
            <p>
                    ${orderItem.ordreId}_${orderItem.description}_${orderItem.amount}_${orderItem.price}
            </p>
        </c:forEach>
<!--TODO: Hent ordreId fra requestobjektet.
        Det vil sige: google jsp retrieve value from radio button
        requestobjekt mister information?-->

        </p>
    </jsp:body>

</t:genericpage>

