<%-- 
    Document   : formAlterarUsuario
    Created on : 7 de abr. de 2024, 21:45:07
    Author     : Felipe
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/UserModify.css">
    </head>
    <body>
        <div class="container mt-5">
            <div class="custom-header">
                <h2>Atualizar Informações do Usuário</h2>
            </div>
            <div class="form-container">
                <form id="MostarUsuario" action="MostrarUsuario"  method="get">
                    <c:set var="usuario" value="${pessoaParaAlterar}"/>

                    <div class="mb-3">
                        <label for="nome" class="form-label">Nome:</label>
                        <input type="text" id="nome" name="nome" class="form-control" value="${usuario.getNome()}">
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">E-mail:</label>
                        <input type="email" id="email" name="email" class="form-control" value="${usuario.getEmail()}">
                    </div>

                    <div class="mb-3">
                        <label for="cpf" class="form-label">CPF:</label>
                        <input maxlength="14" type="text" id="cpf" name="cpf" class="form-control" oninput="this.value = formatarCPF(this.value)" value="${usuario.getCpf()}">
                    </div>

                    <div class="mb-3">
                        <label for="celular" class="form-label">Celular:</label>
                        <input maxlength="14" type="text" id="celular" name="celular"  class="form-control" oninput="this.value = formatarCelular(this.value)" value="${usuario.getCelular()}">
                    </div>

                    <div class="mb-3">
                        <label for="senhar" class="form-label">Senha:</label>
                        <input type="password" id="senhar" name="senhar" class="form-control">
                    </div>

                    <div class="submit-btn-container">
                        <button type="submit" class="btn btn-success">Mostrar</button>
                        <button type="button" onclick="alterarPessoa()" class="btn btn-primary">Cadastrar</button>
                    </div>
                </form>
            </div>
        </div>
        
        <script src="JS/AlterarPessoa.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
