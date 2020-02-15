<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="zaglavlje.jsp" %>
<style>
    html,
    body {
        height: 100%;
    }

    body {
        
        display: flex;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 150px;
        background-color: #f1f1f1;
    }

    .form-signin {
        width: 100%;
        max-width: 500px;
        max-height: 500px;
        padding: 15px;
        margin: auto;
    }
    .form-signin .checkbox {
        font-weight: 500;
    }
    .form-signin .form-control {
        position: relative;
        box-sizing: border-box;
        height: auto;
        padding: 10px;
        font-size: 18px;
    }
    .form-signin .form-control:focus {
        z-index: -1;
    }
    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-top-left-radius: 30px;
        border-top-right-radius: 30px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
        border-bottom-right-radius: 30px;
        border-bottom-left-radius: 30px;

    }
    .btn-primary{
        font-size:30px;
        width:200px;
        position:relative;
        left:10px;
    }
    
</style>
</head>
<body class="text-center">
    <form action="LoginServlet" method="post" class="form-signin">
        <h1 class="h2 mb-3 font-weight-normal">Prijavi se</h1>
        <label for="email" class="sr-only">Email</label>
        <input type="email" name="email" class="form-control" placeholder="Email" required autofocus/>
        <label for="lozinka" class="sr-only">Lozinka</label>
        <input type="password" name="lozinka" class="form-control" placeholder="Lozinka" required/>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="zapamti"/> Zapamti me
            </label>
        </div>
        <input class="btn btn-primary" type="submit" value="Prijava"/>
    </form>
    <c:if test="${param.g!=null}">
                <div class="provjera">
                    <p style="color:red">Netocan email ili lozinka</p>
                </div>
            </c:if>
</body>
</html>
