<%-- 
    Document   : formAlterarLivros
    Created on : 3 de abr. de 2024, 22:18:56
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/formAlterarLivros.css">
        <title>JSP Page</title>
    </head>
    <body>
        

        
        
        
        
    <div class="container mt-4">
        
        <div class="form-section">
            <h3>Insira o Nome</h3>
            <input type="text" id="textoNome" name="textoNome" class="form-control">
            <h3>Insira as Paginas</h3>
            <input type="text" id="textoPaginas" name="textoPaginas" class="form-control">
            <button onclick="adicionar()" class="btn btn-danger">Cadastrar</button>

        </div>

        <div class="form-section">
            <form action="pesquisaAlt" method="get" class="mb-3">
                <input type="submit" value="Livros Alteráveis" class="btn btn-primary">
            </form>
            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>Nome do Livro</th>
                            <th>Páginas</th>
                            <th>Alterar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="livro" items="${livrosDisponiveisMod}">
                                <tr>
                                    <td>${livro.getNome()}</td>
                                    <td>${livro.getPaginas()}</td>
                                    <td>
                                        <form action="alteraLivro" method="post">
                                            <input type="hidden" name="acao" value="AlterarLivro" />
                                            <input type="hidden" name="idLivroMud" value="${livro.getId_livro()}" />

                                            <div class="mb-2">
                                                <input type="radio" id="nomeMudar${livro.getId_livro()}" name="grupo" value="Nome" class="form-check-input">
                                                <label for="nomeMudar${livro.getId_livro()}" class="form-check-label">Mudar Nome</label>
                                            </div>

                                            <div class="mb-2">
                                                <input type="radio" id="paginasMudar${livro.getId_livro()}" name="grupo" value="Paginas" class="form-check-input">
                                                <label for="paginasMudar${livro.getId_livro()}" class="form-check-label">Mudar Páginas</label>
                                            </div>

                                            <input type="submit" value="Modifique" class="btn btn-warning btn-sm">
                                        </form>
                                    </td>
                                    <td class="align-middle text-center">
                                        <form action="excluiLivro" method="post">
                                            <input type="hidden" name="idLivroMud" value="${livro.getId_livro()}" />
                                            <input type="submit" value="Exclua" class="btn btn-danger btn-sm">
                                        </form>
                                    </td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
    <script src="JS/AlterarLivros.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</html>
