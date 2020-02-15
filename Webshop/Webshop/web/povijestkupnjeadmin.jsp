<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<style>
    .kupac{
        padding-left: 0.7rem;
    }
</style>
<div class="kupac">
    <form action="PovijestKupnjeAdminServlet" method="post">
        Odaberite kupca:
        <select name="kupac">
            <option value="0">Svi kupci</option>
            <c:forEach var="k" items="${popiskupaca}">
                <option value="${k.key}">${k.value}</option>
            </c:forEach>
        </select>
        Od: <input type="date" name="datumod" />
        Do: <input type="date" name="datumdo" />
        <input class="btn btn-outline-primary" type="submit" value="Odaberi">
    </form>
</div>
<table class="table table-borderless">
    <thead>
        <tr>
            <th>Kupac</th>
            <th>ID kupca</th>
            <th>Slika proizvoda</th>
            <th>Naziv proizvoda</th>
            <th>Količina</th>
            <th>Cijena</th>
            <th>Datum</th>
            <th>Način plaćanja</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="p" items="${povijest}">
            <tr>
                <td>${p.imekup}</td>
                <td>${p.idkup}</td>
                <td><img src="./slike/${p.idpro}.jpg" height="80px" /></td>
                <td>${p.imepro}</td>
                <td>${p.kol}</td>
                <td align="right">${p.cijena} Kn</td>
                <td>${p.datum}</td> 
                <td align="center">${p.nacin}</td>
            </tr>
        </c:forEach>
        <tr>
            <td>Ukupno:</td> 
            <td align="right">${ukupno} Kn</td>
            <td></td>
        </tr>
    </tbody>
</table>
</body>
</html>

