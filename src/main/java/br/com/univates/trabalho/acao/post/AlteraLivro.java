/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.post;

import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.model.dto.NumeroDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Felipe
 */
public class AlteraLivro implements Acao {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acaoInterna = (String) request.getParameter("grupo");
            String id_livro = request.getParameter("idLivroMud");
		
            HttpSession sessao = request.getSession();
            sessao.setAttribute("id_passar", new NumeroDto(Integer.parseInt(id_livro), acaoInterna));
            request.setAttribute("acaoInterna", acaoInterna);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/formAlterandoPage.jsp");
            dispatcher.forward(request, response);
    }
    
}
