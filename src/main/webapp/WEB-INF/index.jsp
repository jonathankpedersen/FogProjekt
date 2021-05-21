<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Fog</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                Welcome to Fog, here you can buy a carport.
            </div>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since you are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since you
                    are logged in as a customer</p>
                <!--<p><a href="fc/customerpage">Customer Page</a>-->
            <form name="login" action="${pageContext.request.contextPath}/fc/customerpage"  method="POST">
                <button class="btn btn-primary" type="submit" value="customerpage">Customer Page</button>
            </form>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>