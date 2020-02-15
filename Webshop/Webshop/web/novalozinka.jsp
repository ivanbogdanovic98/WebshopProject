<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<!DOCTYPE html>
<style>
    html,
    body {
        height: 100%;
    }

    body {   
        display: flex;
        align-items: center;
        padding-top: 40px;
        padding-left: 480px;
        padding-bottom: 150px;
        background-color: #f1f1f1;
    }

    .form-control {
        width: 100%;
        width: 500px;
        height: 500px;
        padding: 150px;
        margin: auto;
    }
    .form-control {
        position: relative;
        box-sizing: border-box;
        height: auto;
        padding: 1px;
        font-size: 28px;
    }
    .form-control:focus {
        z-index: -1;
    }

    input[type="password"] {
        margin-bottom: 0;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
        border-bottom-left-radius: 0;
        border-bottom-right-radius: 0;
    }
    .bttn{
        margin-top: 0;
        width:500px;
        font-size:50px;        
    }
    .provjera{
        margin-top: 5px;
    }
</style>
<body class="text-center">
    
    <c:if test="${paramg==null}">
    <form action="PromjenaLozinkeServlet" method="post" onsubmit="return provjeri()">
        <h1 class="h2 mb-3 font-weight-normal">Promjena lozinke</h1>
        <label for="lozinka" class="sr-only">Lozinka</label>
        <input type="password" name="lozinka" class="form-control" placeholder="Lozinka" required autofocus/>
        <label for="novalozinka1" class="sr-only">Nova lozinka</label>
        <input type="password" name="novalozinka" class="form-control" placeholder="Upisi novu lozinku" required/>
        <label for="novalozinka" class="sr-only">Nova lozinka</label>
        <input type="password" name="novalozinka1" class="form-control" placeholder="Upisi novu lozinku" required/>
        <div class="bttn">
            <input class="btn btn-dark btn-lg" type="submit" value="Promjeni"/>
        </div>
    </c:if>
        <c:if test="${param.g==2}">
            <div class="provjera1">
        <p style="color:red">Unesena lozinka nije tocna</p>
            </div>
    </c:if>
    </form>
    <script>
        function provjeri(){
            var forma = document.forms[0];            
            
            if(forma.novalozinka.value===forma.novalozinka1.value){
                if (forma.novalozinka.value===forma.lozinka.value) {
                    alert("Nova lozinka mora biti drugacije od stare");
                    return false;
                }
                else return true;
            }else{
                alert("Nove lozinke moraju biti iste");
                return false;
            }
        }
    </script>
</body>
</html>