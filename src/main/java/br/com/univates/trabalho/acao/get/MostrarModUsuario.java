/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.get;

import br.com.univates.trabalho.Service.PessoaService;
import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.dao.NotFoundException;
import br.com.univates.trabalho.model.Pessoa;
import jakarta.servlet.RequestDispatcher;
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
public class MostrarModUsuario implements Acao{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        Pessoa p = (Pessoa) sessao.getAttribute("usuarioLogado");
        int id = p.getId_pessoa();
        
        try {
            PessoaService pessoaService = new PessoaService();
            Pessoa pes = pessoaService.procurar(id);
            sessao.setAttribute("pessoaParaAlterar", pes);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/formAlterarUsuario.jsp");
            response.sendRedirect("formAlterarUsuario.jsp");
        } catch (NotFoundException ex) {
            Logger.getLogger(MostrarModUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
