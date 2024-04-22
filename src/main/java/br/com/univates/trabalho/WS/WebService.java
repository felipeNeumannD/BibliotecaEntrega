/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.WS;

import br.com.univates.trabalho.Service.PessoaService;
import br.com.univates.trabalho.dao.NotFoundException;
import br.com.univates.trabalho.dao.RepeatedException;
import br.com.univates.trabalho.model.Pessoa;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
@Path("contato")
public class WebService {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of test1
     */
    public WebService() {
    }
    
    @GET
    //@Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String getJson() {
        return "MEU PRIMEIRO WS";
    }
    
    @GET
    @Produces("application/json")
    @Path("contatoDeTodos")
    public String GetContatoSimples() {
        try {
            PessoaService pes = new PessoaService();
            List<Pessoa> todos = pes.verTodos();
            Gson g = new Gson();
            //return contato.toString();
            return g.toJson(todos);
        } catch (SQLException ex) {
            return "erro";
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("contaId/{id}")
    public String getContatoByID(@PathParam("id") int id) {
        try {
            PessoaService pes = new PessoaService();
            Pessoa pessoa = pes.procurar(id);
            Gson g = new Gson();
            
            return g.toJson(pessoa);
        } catch (NotFoundException ex) {
            return "Erro";
        }

    }
    
    @DELETE
    @Path("excluir/{id}")
    public String excluir(@PathParam("id") int id) {
        
        PessoaService pesquisa = new PessoaService();
        pesquisa.excluir(id);
        return "Excluído";
    }
    
    @POST
    @Consumes("application/json")
    @Path("inserir")
    public String inserir(String conteudo) {
        try {
            Gson g = new Gson();
            Type contatoType = new TypeToken<Pessoa>() {
            }.getType();
            Pessoa u = g.fromJson(conteudo, contatoType);
            PessoaService pes = new PessoaService();
            pes.adicionar(u);
            
            return "Usuário criado";
        } catch (SQLException ex) {
            return "Erro sql";
        } catch (RepeatedException ex) {
            return "Erro usuário repetido";
        }
    }
    
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public String alterar(String conteudo) {
        try {
            Gson g = new Gson();
            Pessoa u = (Pessoa) g.fromJson(conteudo, Pessoa.class);
            PessoaService pes = new PessoaService();
            pes.alterarPessoa(u);
            return "Alterado";
        } catch (RepeatedException ex) {
            return "Erro";
        }
    }
    
    
}
