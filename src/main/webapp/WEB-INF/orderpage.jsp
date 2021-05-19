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
         Order page
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

<head>
    <title>Enter your carport measurements</title>
</head>
<jsp:body>
<div class="row mb-3">
    <label class="col-sm-1 col-form-label" for="length">Length</label>
    <div class="col-sm-4">
        <select id="length" type="length" name="length">
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
        <%--<input id="length" class="form-control" type="length" name="length"  value="${param.length}"  placeholder="Enter the length">--%>
    </div>
    <div class="row mb-3">
        <label class="col-sm-1 col-form-label" for="width">width</label>
        <div class="col-sm-4">
            <select id="width" type="width" name="width">
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
            </select>
    <%--<input id="width" class="form-control" type="width" name="width"  value="${param.width}"  placeholder="Enter the width">--%>
</div>
</div>
<input type="checkbox" id="shed" name="shed" value="shed">
<label for="shed"> Add a shed</label><br>
<br/>
<input class="btn btn-primary" type="submit" type="submit" value="Submit">
</form>
</div>
</jsp:body>
</t:genericpage>
