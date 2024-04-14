/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.get;

import br.com.univates.trabalho.Service.LivroService;
import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.model.dto.NumeroDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Felipe
 */
public class ModificaLivro implements Acao{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();

            NumeroDto livro = (NumeroDto) sessao.getAttribute("id_passar");
            int id_livro = livro.id_Livro();
            String acao = livro.acao();

            LivroService liv = new LivroService();
		
            if(acao.equals("Nome")) {
                String nome = request.getParameter("textoNome");
                liv.alterarNome(id_livro, nome);
            } else if(acao.equals("Paginas")) {
                int num = Integer.parseInt(request.getParameter("textoPaginas"));
                liv.alterarPaginas(id_livro, num);
            }
		
            sessao.removeAttribute("id_passar");
            response.sendRedirect("formPrincipal.jsp");
	}
}
