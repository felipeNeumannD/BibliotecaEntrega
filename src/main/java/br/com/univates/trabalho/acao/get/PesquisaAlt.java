/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.get;

import br.com.univates.trabalho.Service.LivroService;
import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.model.Livro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class PesquisaAlt implements Acao {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroService service = new LivroService();
            try {
		List<Livro> livros = service.livrosNaoAlugados();
		request.setAttribute("livrosDisponiveisMod", livros);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/formAlterarLivros.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
		e.printStackTrace();
            }
    }
}
