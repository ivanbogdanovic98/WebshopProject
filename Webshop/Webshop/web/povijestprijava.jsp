<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
    <table class="table table-borderless">
        <thead>
            <tr>
                <th>Datum</th>
                <th>Email</th>
                <th>Ime</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${prijave}">
                <tr>
                    <td>${p.datum}></td>
                    <td>${p.email}</td>
                    <td>${p.ime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>