<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="author" content="Ivan Bogdanovic">
        <title>Webshop - Sknil</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <style>
            .kosarica{
                padding-right:1rem;
                padding-top:0.5rem;
            }
            body {
                padding-top: 5rem;               
                height: 100%;
                margin: 0;
                background-attachment: fixed;
            }
            .badge1{
                position:relative;
                left:-17px;
                top:-15px;
            }
            .prijavljen{
                color:white;
                padding-right: 2rem;
            }
            .navbar-brand{
                transition: 1s;
                opacity: 1;
            }
            .navbar-brand:hover {
                transition: 0.8s;
                opacity: 0.5;
            }
            .provjera{
                position:absolute;
                left:600px;
                top:500px;
                font-size: 25px;

            }
            .prijava{
                position:relative;
                left:-15px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="IndexServlet">Webshop - Sknil</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <c:if test="${kategorije!=null}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Kategorije</a>
                            <div class="dropdown-menu" aria-labelledby="dropdown01">
                                <c:forEach var="k" items="${kategorije}">
                                    <a class="dropdown-item" href="IndexServlet?idkat=${k.id}">${k.ime}</a>
                                </c:forEach>
                            </div>
                        </li>
                    </c:if>
                </ul>

                <c:if test="${prijavljen==null}">
                    <div class="prijava">
                        <a class="btn btn-dark" href="login.jsp" role="button">Prijava</a>
                    </div>
                </c:if>

                <c:if test="${prijavljen!=null}">
                    <div class="prijavljen">
                        ${prijavljen.ime}, prijavljeni ste kao
                        <c:if test="${prijavljen.uloga==1}">Administrator</c:if>
                        <c:if test="${prijavljen.uloga==2}">Kupac</c:if>
                        </div>
                        <div class="kupac">
                        <c:if test="${prijavljen.uloga==2}">
                            <a class="btn btn-dark" href="PovijestKupnjeServlet" role="button">Povijest kupnje</a>
                            <a class="btn btn-dark" href="PromjenaLozinkeServlet" role="button">Promjena lozinke</a>
                        </c:if>
                    </div>                        
                    <c:if test="${prijavljen.uloga==1}">
                        <div class="registracija">
                            <a class="btn btn-dark" href="PovijestKupnjeAdminServlet" role="button">Povijest kupnje</a>
                            <a class="btn btn-dark" href="PovijestPrijavaServlet" role="button">Povijest prijava</a>
                        </div>
                    </c:if>
                    <a class="btn btn-dark" href="LogoutServlet" role="button">Odjava</a>
                </c:if>                      

                <div class="kosarica">
                    <c:if test="${bsuk>0}">
                        <a href="KosaricaServlet" > 
                        </c:if>
                        <img src="./slike/kosarica.svg" 
                             height="35px"/><c:if test="${bsuk>0}"></a></div><div class="badge1"><span class="badge badge-pill badge-light">${bsuk}</span></div>
                        </c:if>
            </div>
        </nav>