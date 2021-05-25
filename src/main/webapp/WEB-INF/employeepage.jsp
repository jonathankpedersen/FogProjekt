<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Employee Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a EMPLOYEE.
        <p>

        <form name="login" action="${pageContext.request.contextPath}/fc/customermateriallist"  method="POST">
            <button class="btn btn-primary" type="submit" value="customermateriallist">Materials</button>
        </form>
        </p>
        <p>
        <form name="login" action="${pageContext.request.contextPath}/fc/listorderpageemp"  method="POST">
            <button class="btn btn-primary" type="submit" value="showorderpage">Orders</button>
        </form>
        </p>
        <p>
        <form name="login" action="${pageContext.request.contextPath}/fc/orderpageemp"  method="POST">
            <button class="btn btn-primary" type="submit" value="orderpage">Orders</button>
        </form>

        </p>

    </jsp:body>
</t:genericpage>
