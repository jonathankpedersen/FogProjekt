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
            <form name="order" action="${pageContext.request.contextPath}/fc/listorderpage" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="length">Length</label>
                    <div class="col-sm-4">
                        <select name="length" id="length">
                            <option value="240">240cm</option>
                            <option value="270">270cm</option>
                            <option value="300">300cm</option>
                            <option value="330">330cm</option>
                            <option value="360">360cm</option>
                            <option value="390">390cm</option>
                            <option value="420">420cm</option>
                            <option value="450">450cm</option>
                            <option value="480">480cm</option>
                            <option value="510">510cm</option>
                            <option value="540">540cm</option>
                            <option value="570">570cm</option>
                            <option value="600">600cm</option>
                            <option value="630">630cm</option>
                            <option value="660">660cm</option>
                            <option value="690">690cm</option>
                            <option value="720">720cm</option>
                            <option value="750">750cm</option>
                            <option value="780">780cm</option>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="width">Width</label>
                    <div class="col-sm-4">
                        <select name="width" id="width">
                            <option value="240">240cm</option>
                            <option value="270">270cm</option>
                            <option value="300">300cm</option>
                            <option value="330">330cm</option>
                            <option value="360">360cm</option>
                            <option value="390">390cm</option>
                            <option value="420">420cm</option>
                            <option value="450">450cm</option>
                            <option value="480">480cm</option>
                            <option value="510">510cm</option>
                            <option value="540">540cm</option>
                            <option value="570">570cm</option>
                            <option value="600">600cm</option>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="shed">Shed</label>
                    <div class="col-sm-4">
                        <input id="shed" class="form-control" type="text" name="shed" value="${param.shed}" placeholder="Add a shed?">
                    </div>

                </div>

                <input class="btn btn-primary" type="submit" value="Submit">
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
</jsp:body>


</t:genericpage>
