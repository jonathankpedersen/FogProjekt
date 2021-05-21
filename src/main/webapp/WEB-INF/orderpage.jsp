<%--
  Created by IntelliJ IDEA.
  User: Louise-PC
  Date: 11-05-2021
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Order Page
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
Hello, this is the orderpage, here you can order a carport. Please enter measures in cm.

        <div style="margin-top: 5em;">
            <form name="order" action="${pageContext.request.contextPath}/fc/orderpage" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="length">Length</label>
                    <div class="col-sm-4">
                        <input id="length" class="form-control" type="text" name="length" value="${param.length}" placeholder="Enter length">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="width">Width</label>
                    <div class="col-sm-4">
                        <input id="width" class="form-control" type="text" name="width" value="${param.width}" placeholder="Enter width">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="shed">Shed</label>
                    <div class="col-sm-4">
                        <input id="shed" class="form-control" type="text" name="shed" value="${param.shed}" placeholder="Add a shed?">
                    </div>

                </div>

                <input class="btn btn-primary" type="submit" type="submit" value="Submit">
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
</jsp:body>


</t:genericpage>
