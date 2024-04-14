/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.post;

import br.com.univates.trabalho.Service.AluguelService;
import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Felipe
 */
public class Alugar implements Acao{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
            Pessoa pes = (Pessoa) sessao.getAttribute("usuarioLogado");
            String doc = (String) request.getParameter("idLivro");
            
            int id = Integer.parseInt(doc);
            AluguelService service = new AluguelService();
            service.adicionarAluguel(pes.getId_pessoa(), id);
            response.sendRedirect("formPrincipal.jsp");
    }
    
}
