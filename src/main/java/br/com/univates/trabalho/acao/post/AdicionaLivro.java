/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.post;

import br.com.univates.trabalho.Service.LivroService;
import br.com.univates.trabalho.acao.Acao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Felipe
 */
public class AdicionaLivro implements Acao {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nome = (String) request.getParameter("nome");
	String paginas =  (String) request.getParameter("paginas");
	LivroService liv = new LivroService();
	liv.adicionar(nome, Integer.parseInt(paginas));
        response.sendRedirect("formPrincipal.jsp");
    }
    
}
