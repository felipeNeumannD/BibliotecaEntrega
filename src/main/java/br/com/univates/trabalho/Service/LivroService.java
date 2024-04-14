/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.Service;

import br.com.univates.trabalho.dao.ConnectionFactory;
import br.com.univates.trabalho.dao.LivroDao;
import br.com.univates.trabalho.dao.NotFoundException;
import br.com.univates.trabalho.model.Livro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class LivroService {
    private LivroDao livro;
	private ConnectionFactory connection;
    public LivroService() {
    	this.connection = new ConnectionFactory();
        this.livro = new LivroDao(connection.conectar());
    }


    public void excluir(int id){
        livro.excluir(id);
    }
    
    public void adicionar(String nome, int paginas) {
    	
    	Livro liv= new Livro(nome, paginas, false);
    	livro.adicionar(liv);
    }

    public void alterarNome(int id, String modificacao){
        try {
            Livro ler = livro.read(id);
            ler.setNome(modificacao);
            livro.alterar(ler);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarPaginas(int id, int modificacao){
        try {
            Livro ler = livro.read(id);
            ler.setPaginas(modificacao);
            livro.alterar(ler);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    
    
    public List<Livro> livrosUsuario(int idPessoa) throws SQLException{
		return livro.minhaReserva(idPessoa);
    }
    
    public List<Livro> livrosNaoAlugados() throws SQLException{
		return livro.naoReservados();
    }

}
