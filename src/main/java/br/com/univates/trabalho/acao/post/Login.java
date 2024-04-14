/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.post;

import br.com.univates.trabalho.Service.PessoaService;
import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.controller.Controller;
import br.com.univates.trabalho.dao.NotFoundException;
import br.com.univates.trabalho.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class Login implements Acao{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            PessoaService pessoaService = new PessoaService();
            
            try {
                Pessoa pessoa = pessoaService.validarUsuario(email, senha);
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuarioLogado", pessoa);
                response.sendRedirect("formPrincipal.jsp");
            } catch (NotFoundException ex) {
                response.sendRedirect("index.jsp?erro=true");
            }
    }
    
}
