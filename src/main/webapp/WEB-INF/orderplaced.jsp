<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Customer page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of Fog.
        Role: ${sessionScope.role}

        <p>
        Thank you for your order!

        <!--<form name="return" action="${pageContext.request.contextPath}/fc/customerpage"  method="POST">
            <button class="btn btn-primary" type="submit" value="customerpage">Return</button>
        </form>-->
        </p>

    </jsp:body>

</t:genericpage>

