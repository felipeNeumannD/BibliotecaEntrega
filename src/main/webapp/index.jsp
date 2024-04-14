<%-- 
    Document   : formLogin.jsp
    Created on : 3 de abr. de 2024, 16:29:46
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Login.css">
        
    </head>
    <body class="text-center">

    <div class="container">
        <form class="form-signin" action="login" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Faça o seu Login</h1>
            <input type="email" id="inputEmail" name="email" class="form-control mb-3" placeholder="Endereço de email" required autofocus>
            <input type="password" id="inputPassword" name="senha" class="form-control mb-3" placeholder="Senha" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2023</p>
        </form>

        <div class="text-center">
            <a href="createCount.jsp" class="mt-3 d-block">Criar usuário</a>
        </div>
    </div>
        
        
        
    <script>
        if (new URLSearchParams(window.location.search).has('erro')) {
            alert('Email ou senha inválidos.');
        }
        if (new URLSearchParams(window.location.search).has('erro1')) {
            alert('Email ou CPF já está em uso.');
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
