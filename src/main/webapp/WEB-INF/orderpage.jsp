<%--
  Created by IntelliJ IDEA.
  User: Louise-PC
  Date: 11-05-2021
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter your carport measurements</title>
</head>
<body>
<div class="row mb-3">
    <label class="col-sm-1 col-form-label" for="length">Length</label>
    <div class="col-sm-4">
        <input id="length" class="form-control" type="length" name="length"  value="${param.length}"  placeholder="Enter the length">
    </div>
    <div class="row mb-3">
        <label class="col-sm-1 col-form-label" for="width">width</label>
        <div class="col-sm-4">
            <input id="width" class="form-control" type="width" name="width"  value="${param.width}"  placeholder="Enter the width">
        </div>
    </div>
    <input type="checkbox" id="shed" name="shed" value="shed">
    <label for="shed"> Add a shed</label><br>
    <br/>
    <input class="btn btn-primary" type="submit" type="submit" value="Submit">
    </form>
</div>
</body>
</html>
