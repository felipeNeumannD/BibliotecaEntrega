/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.acao.post;

import br.com.univates.trabalho.Service.LivroService;
import br.com.univates.trabalho.Service.PessoaService;
import br.com.univates.trabalho.acao.Acao;
import br.com.univates.trabalho.dao.RepeatedException;
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
public class AlterarPessoa implements Acao{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nome = (String) request.getParameter("nome");
        String email = (String) request.getParameter("email");
        String cpf = (String) request.getParameter("cpf");
        String celular = (String) request.getParameter("celular");
        String senhar = (String) request.getParameter("senhar");

        HttpSession sessao = request.getSession();
        Pessoa pes = (Pessoa) sessao.getAttribute("usuarioLogado");
        int id = pes.getId_pessoa();
                
        Pessoa pessoa = new Pessoa(id, nome, senhar, email, cpf, celular);
        PessoaService pessoaService = new PessoaService();
        try {
            pessoaService.alterarPessoa(pessoa);
        } catch (RepeatedException ex) {
            Logger.getLogger(AlterarPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }


        sessao.removeAttribute("pessoaParaAlterar");
       
        pes.setCelular(celular);
        pes.setCpf(cpf);
        pes.setEmail(email);
        pes.setNome(nome);
        sessao.setAttribute("usuarioLogado", pes);
        
        response.sendRedirect("formPrincipal.jsp");
        
    }
    
}
