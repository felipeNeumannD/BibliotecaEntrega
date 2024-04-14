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
public class ExcluiLivro implements Acao {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroService livroServico = new LivroService();
        String fir = (String)request.getParameter("idLivroMud");
        int num = Integer.parseInt(fir);
        livroServico.excluir(num);
        response.sendRedirect("formPrincipal.jsp");
    }
    
}
