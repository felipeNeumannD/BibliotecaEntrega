<%-- 
    Document   : formAlterandoPage
    Created on : 4 de abr. de 2024, 16:04:59
    Author     : Felipe
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/AlterandoPage.css">
</head>
<body>
    <div class="form-container">
        <div class="form-box">
            <c:if test="${acaoInterna.equals('Nome')}">
                <h3>Adicione o novo nome</h3>
                <input type="text" name="textoNome" id="textoNome" class="form-control">
                <button onclick="modificar()" class="btn btn-primary">Mudar</button>
            </c:if>
            
            <c:if test="${acaoInterna.equals('Paginas')}">
                <h3>Adicione a nova quantidade de páginas</h3>
                <input type="text" name="textoPaginas" id="textoPaginas" class="form-control">
                <button onclick="modificar()" class="btn btn-primary">Mudar</button>
            </c:if>
        </div>
    </div>
    <script src="JS/AlterarPage.js"></script>
</body>
</html>
