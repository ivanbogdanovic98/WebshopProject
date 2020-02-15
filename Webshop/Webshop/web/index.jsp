<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<style>

</style>


<main role="main" class="spremnik">

    <table class="table table-borderless">
        <thead>
            <tr>
                <th style="text-align:center;width:120px">Slika</th>
                <th>Kategorija</th>
                <th>Proizvodac</th>
                <th style="text-align:center;width:220px">Model</th>
                <th style="text-align:center">Cijena</th>
                <th>Akcija</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <c:forEach var="p" items="${proizvodi}">
                <tr>
                    <td align="center"><img src="./slike/${p.id}.jpg" height="80px" /></td>
                    <td>${p.ime}</td>
                    <td>${p.proizvodac}</td>
                    <td>${p.model}</td>
                    <td align="center">${p.cijenaispis} Kn</td>
                    <td>
                        <form action="DodajUKosaricuServlet" method="post">
                            <input class="btn btn-outline-primary" type="number" min="1" max="${p.kolicina}" 
                                   value="1" name="kol">
                            <input type="hidden" name="pid" value="${p.id}" />
                            <input class="btn btn-primary" type="submit" value="Dodaj"/>
                        </form>  
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</main>
</body>
</html>