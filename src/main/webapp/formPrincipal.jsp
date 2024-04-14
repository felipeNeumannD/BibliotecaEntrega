<%-- 
    Document   : formPrincipal
    Created on : 3 de abr. de 2024, 19:11:33
    Author     : Felipe
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/TelaPrincipal.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Biblioteca Online</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" href="formAlterarLivros.jsp" class="btn btn-light">Configurações dos Livros</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="formAlterarUsuario.jsp" class="btn btn-light" >Configurações do Usuário</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Contato</a>
                            </li>
                        </ul>
                        <ul class="navbar-nav ms-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="index.jsp" style="color: white;">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        

        
        <div class="container">

        <h3 class="my-3">Listar minhas reservas</h3>
        <div class="form-input">
            <form action="ListaReserva" method="get">
                <input type="submit" value="Listar Reservas" class="btn btn-success" />
            </form>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Nome do Livro</th>
                        <th>Páginas</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="livro" items="${livros}">
                        <tr>
                            <td>${livro.getNome()}</td>
                            <td>${livro.getPaginas()}</td>
                            <td>
                                <form action="devolver" method="post">
                                    <input type="hidden" name="idLivro2" value="${livro.getId_livro()}" />
                                    <input type="submit" value="Devolução" onclick="this.disabled=true;this.form.submit();" class="btn btn-info btn-sm btn-full-width" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <br>
        <br>
        <br>

        <h3 class="my-3">Listar os livros disponíveis</h3>
        <div class="form-input">
            <form action="listarDisponivel" method="get">
                <input type="submit" value="Listar Livros Disponíveis" class="btn btn-success" />
            </form>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Nome do Livro</th>
                        <th>Páginas</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="livro" items="${livrosDisponiveis}">
                        <tr>
                            <td>${livro.getNome()}</td>
                            <td>${livro.getPaginas()}</td>
                            <td>
                                <form action="alugar" method="post" style="margin: 0;">
                                    <input type="hidden" name="idLivro" value="${livro.getId_livro()}"/>
                                    <input type="submit" value="Alugar" onclick="this.disabled=true;this.form.submit();" class="btn btn-info btn-sm btn-full-width" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <br>
        <br>
        <br>

        <h3 class="my-3">Listar o Histórico de aluguel</h3>
        <div class="form-input">
            <form action="pesquisaHistorico" method="get">
                <input type="submit" class="btn btn-success" value="Pesquisar Histórico" />
            </form>    
        </div>
        <div class="table-responsive">>
            <table class="table table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Nome do Livro</th>
                        <th>Páginas</th>
                        <th>Data de Inicio</th>
                        <th>Data de Fim</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="aluguel" items="${historicoAluguel}">
                        <tr>
                            <td>${aluguel.nome()}</td>
                            <td>${aluguel.paginas()}</td>
                            <td>${aluguel.data_inicial()}</td>
                            <td>${aluguel.data_entrega()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
        <br>
        <br>
    </div>
        

    <footer class="footer text-center">
        Biblioteca Online © 2024
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-qhWB83rGH8DQ1rQi7Y/QzBqXVl+6lK0KDb60KbxYh5sZi33qj7XNLtr3f3JFUx7J" crossorigin="anonymous"></script>
    </body>

    
</html>