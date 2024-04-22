/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.Service;

import br.com.univates.trabalho.dao.ConnectionFactory;
import br.com.univates.trabalho.dao.NotFoundException;
import br.com.univates.trabalho.dao.PessoaDao;
import br.com.univates.trabalho.dao.RepeatedException;
import br.com.univates.trabalho.model.Pessoa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class PessoaService {

    private PessoaDao dao;
    private ConnectionFactory connection;

    public PessoaService(){
        this.connection = new ConnectionFactory();
        this.dao = new PessoaDao(connection.conectar());
    }

    public void excluir(int id){
        try{
            dao.excluir(id);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

//    public void alterarEmail(int id, String modificacao){
//        try{
//            Pessoa pessoa = dao.read(id);
//            pessoa.setEmail(modificacao);
//            dao.alterar(pessoa);
//        }catch(RuntimeException | NotFoundException e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void alterarNome(int id, String modificacao){
//        try {
//            Pessoa pessoa = dao.read(id);
//            pessoa.setNome(modificacao);
//            dao.alterar(pessoa);
//        }catch(NotFoundException e){
//            System.out.println(e.getMessage());
//        }
//    }
    public void alterarSenha(int id, String modificacao) throws RepeatedException{
        try {
            Pessoa pessoa = dao.read(id);
            pessoa.setSenhar(modificacao);
            dao.alterar(pessoa);
        }catch(NotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void alterarPessoa(Pessoa pessoa) throws RepeatedException{
        dao.alterar(pessoa);
    }

    public void adicionar(Pessoa pessoa) throws SQLException, RepeatedException{
    	dao.adicionar(pessoa);
    }
    
    public Pessoa procurar(int id) throws NotFoundException{
        Pessoa pessoa = dao.Newread(id);
        return pessoa;
    }
    
    
    public Pessoa validarUsuario(String email, String senha) throws NotFoundException {
    	Pessoa pessoad = dao.readEntrada(email, senha);
    	return pessoad;
    }
    
    public List<Pessoa> verTodos() throws SQLException{
        List<Pessoa> pessoas = dao.todos();
        return pessoas;
    }


}
