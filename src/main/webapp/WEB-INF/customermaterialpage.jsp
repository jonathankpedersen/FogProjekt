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
                    <!--OrderID: ${orderItem.ordreId}  Description: ${orderItem.description}  Amount: ${orderItem.amount}  Price: ${orderItem.price}
                -->
            <table class="table">
            <thead>
            <tr>
                <th scope="col">OrderID</th>
                <th scope="col">Description</th>
                <th scope="col">Amount</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${orderItem.ordreId}</td>
                <td>${orderItem.description}</td>
                <td>${orderItem.amount}</td>
                <td>${orderItem.price}</td>
            </tr>
            </tbody>
        </table>

            </p>
        </c:forEach>
<!--TODO: Hent ordreId fra requestobjektet.
        Det vil sige: google jsp retrieve value from radio button
        requestobjekt mister information?-->

        </p>
    </jsp:body>

</t:genericpage>

