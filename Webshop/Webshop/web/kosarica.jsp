<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>

<style>
    .radio{
        position:relative;
        font-size: 30px;

    }
    .radio {
        display: block;
        position: relative;
        padding-left: 35px;
        margin-bottom: 12px;
        cursor: pointer;
        font-size: 22px;
    }
    .btn-primary{
        position:relative;
        font-size: 28px;
        right: -30px;
    }
    h1{
        position:relative;
        font-size: 30px;
        right: -30px;
    }
    .table{
        position:relative;
        font-size: 20px;
        right: -30px;
    }
    p{
        position:relative;
        font-size:20px;
        left:30px;
    }
</style>
<h1>Sadržaj vaše košarice</h1>
<table class="table table-borderless">
    <thead>
        <tr>
            <th>Slika</th>
            <th>Naziv</th>
            <th>Količina</th>
            <th>Cijena</th>
            <th>Akcija</th>
        </tr>
    </thead>

    <c:forEach var="l" items="${lista}">
        <tr>
            <td><img src="./slike/${l.id}.jpg" height="70px" /></td>
            <td>${l.ime}</td>
            <td>
                <form action="IzmjenaKosariceServlet?id=${l.id}" method="post">
                    <input type="number" min="1" max="${l.kolicina}"
                           value="${l.ukosarici}" name="novakol" />
                    <input type="submit" value="promjeni" />
                </form>
            </td>
            <td align="right">${l.cijena} Kn</td>
            <td><a class="btn btn-danger btn-lg" href="BrisiIzKosariceServlet?id=${l.id}" role="button">Briši</a></td>
    
    </tr>
</c:forEach>
<tr>
    <td colspan="3">Ukupno:</td>
    <td align="right"><b>${ukupno} Kn</b></td>
</tr>
</table>



<c:if test="${prijavljen==null}">
    <p>
        Morate se prijaviti kako bi obavili kupnju!</p>
    </c:if>
    <c:if test="${prijavljen!=null}">
    <div class="radio">
        <form action="KupiServlet" method="post">
            <input type="radio" name="nacinkupnje" id="rb1" checked="checked" value="online" />
            <label for="rb1">online - karticom</label><br/>
            <input type="radio" name="nacinkupnje" id="rb2" value="gotovina" />
            <label for="rb2">pouzećem - gotovina</label><br/>
            <input class="btn btn-primary" type="submit" value="Kupi">
        </form>
    </div>    
</form>
</c:if>     
</body>
</html>
