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
                Employee result page for viewing orders
            </div>

            Current orders:
            <br/>
            <input class="btn btn-primary" type="submit" type="submit" value="Submit">Material List
            </form>


        </div>

    </jsp:body>
</t:genericpage>