<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %> 
<table class="table table-borderless">
    <thead>
        <tr>
            <th>Slika</th>
            <th>Naziv proizvoda</th>
            <th>Kolicina</th>
            <th>Cijena</th>
            <th>Datum</th>
            <th>Nacin placanja</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="p" items="${povijest}">
            <tr>
                <td><img src="./slike/${p.idpro}.jpg" height="80px" /></td>
                <td>${p.imepro}</td>
                <td>${p.kol}</td>
                <td align="right">${p.cijena} Kn</td>
                <td>${p.datum}</td> 
                <td>${p.nacin}</td>
                </c:forEach>
                <tr>
                <td colspan="3">Ukupno:</td> 
                <td align="right">${ukupno} Kn</td>
                <td></td>
            </tr>
            
    </tbody>
</table>
</body>
</html>
