<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         View Order Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of Fog. Role: ${sessionScope.role}
        </br>
        Here are your orders:
       <c:forEach var="order" items="${requestScope.orderlist}">

           <p>
           <table class="table">
               <thead>
               <tr>
                   <th scope="col">OrderID</th>
                   <th scope="col">Length</th>
                   <th scope="col">Width</th>
                   <th scope="col">Shed</th>
                   <th scope="col">Status</th>
               </tr>
               </thead>
               <tbody>
               <tr>
                   <td>${order.ordreId}</td>
                   <td>${order.length}</td>
                   <td>${order.width}</td>
                   <td>${order.shed}</td>
                   <td>${order.status}</td>
               </tr>
               </tbody>
           </table>
           </p>
       </c:forEach>

        <!--<div class="row mb-3">
            <label class="col-sm-1 col-form-label" for="orderId">Calculate Price</label>
            <div class="col-sm-4">
                <input id="orderId" class="form-control" type="text" name="orderId" value="${param.orderId}" placeholder="Enter order ID">
            </div>
        </div>

        <input class="btn btn-primary" type="submit" type="submit" value="Submit">
        </form>
        <c:forEach items="${requestScope.price}" var="item">
            <p>${item}</p>
        </c:forEach>-->

    </jsp:body>

</t:genericpage>

