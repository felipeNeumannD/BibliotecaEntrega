<%-- 
    Document   : count.jsp
    Created on : 3 de abr. de 2024, 19:24:08
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Cadastro de Usuário</h2>
        <br>
        <br>
        
        <div class="container mt-5">

            <form>
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" class="form-control">
                </div>

                <div class="form-group">
                    <label for="email">E-mail:</label>
                    <input type="email" id="email" name="email" class="form-control">
                </div>

                <div class="form-group">
                    <label for="cpf">CPF:</label>
                    <input maxlength="14" type="text" id="cpf" name="cpf" class="form-control" oninput="this.value = formatarCPF(this.value)">
                </div>

                <div class="form-group">
                    <label for="celular">Celular:</label>
                    <input maxlength="14" type="text" id="celular" name="celular" class="form-control" oninput="this.value = formatarCelular(this.value)">
                </div>

                <div class="form-group">
                    <label for="senhar">Senha:</label>
                    <input type="password" id="senhar" name="senhar" class="form-control">
                </div>

                <button type="button" onclick="adicionarPessoa()" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
        
        <script src="JS/criarConta.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
