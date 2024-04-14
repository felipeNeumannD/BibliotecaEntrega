/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.post;

import br.com.univates.trabalho.Service.PessoaService;
import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.dao.RepeatedException;
import br.com.univates.trabalho.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class CriarConta implements Acao{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PessoaService pes = new PessoaService();
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senhar");
            String cpf = request.getParameter("cpf");
            String celular= request.getParameter("celular");
		
            PessoaService pessoaService = new PessoaService();
            try {
                pessoaService.adicionar(new Pessoa(0, nome, senha, email, cpf, celular));
                response.sendRedirect("index.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (RepeatedException ex) {
                response.sendRedirect("index.jsp?erro1=true");
        }
    }
    
}
