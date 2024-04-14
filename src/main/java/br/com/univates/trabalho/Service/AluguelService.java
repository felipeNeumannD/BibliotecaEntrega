/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.Service;

import br.com.univates.trabalho.dao.AluguelDao;
import br.com.univates.trabalho.dao.ConnectionFactory;
import br.com.univates.trabalho.dao.DevolucaoService;
import br.com.univates.trabalho.dao.NotFoundException;
import br.com.univates.trabalho.model.Aluguel;
import br.com.univates.trabalho.model.dto.AluguelPesquisaDTO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class AluguelService {
    private AluguelDao aluguelDao;
    private ConnectionFactory connection;
    
    
    
    public AluguelService() {
    	 this.connection = new ConnectionFactory();
         this.aluguelDao = new AluguelDao(connection.conectar());
    }

    public void excluir(int id){
        aluguelDao.excluir(id);
    }
    
    
    public List<AluguelPesquisaDTO> livrosHistorico(int id_pessoa) throws SQLException{
		return aluguelDao.historicoAluguelPessao(id_pessoa);
    }
    
    
    public void adicionarAluguel(int id_pessoa, int id_livro) {
    	LocalDate currentDate = LocalDate.now();
    	Aluguel alg = new Aluguel(new java.sql.Date(currentDate.getYear()- 1900, currentDate.getMonthValue() - 1, currentDate.getDayOfMonth()), null, id_pessoa, id_livro);
    	aluguelDao.adicionar(alg);
    }
    
    public void devolucao(int id_livro, int id_pessoa) {
    	DevolucaoService dev = new DevolucaoService(aluguelDao);
    	dev.aluguelCloser(id_livro, id_pessoa);
    	
    }
    

    public void alterarDataInicial(int id, Date data){
        try {
            Aluguel ler = aluguelDao.read(id);
            // fazer um try catch
            ler.setData_inicial(data);
            aluguelDao.alterar(ler);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void alterarIdPessoa(int id, int idPessoa){
        try {
            Aluguel ler = aluguelDao.read(id);
            ler.setId_pessoa(idPessoa);
            aluguelDao.alterar(ler);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarIdLivro(int id, int idLivro){
        try {
            Aluguel ler = aluguelDao.read(id);
            ler.setId_livro(idLivro);
            aluguelDao.alterar(ler);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
