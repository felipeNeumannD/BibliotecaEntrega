/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.get;

import br.com.univates.trabalho.Service.LivroService;
import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.model.Livro;
import br.com.univates.trabalho.model.Pessoa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ListaReserva implements Acao {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroService service = new LivroService();
            try{
                HttpSession session = request.getSession();
                Pessoa pessoa = (Pessoa) session.getAttribute("usuarioLogado");
                List<Livro> livros = service.livrosUsuario(pessoa.getId_pessoa());
                request.setAttribute("livros", livros);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/formPrincipal.jsp");
                dispatcher.forward(request, response);
            }catch (SQLException e) {
		e.printStackTrace();
            }
    }
    
}
