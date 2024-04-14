/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.dao;

import br.com.univates.trabalho.model.Aluguel;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Felipe
 */
public class DevolucaoService {
	public DevolucaoService(AluguelDao aluguel) {
		this.aluguelDao = aluguel;
	}
	
	private AluguelDao aluguelDao;
	
	
	
	
	public void aluguelCloser(int id_livro, int id_pessoa) {
		try {
			fecharAluguel(id_livro, id_pessoa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Close.closeConnection(aluguelDao.getConn());
		}
	}

	
	 public void fecharAluguel(int id_livro, int id_pessoa) throws SQLException {
	    	LocalDate currentDate = LocalDate.now();
	    	java.sql.Date hoje = new java.sql.Date(currentDate.getYear() - 1900, currentDate.getMonthValue() - 1, currentDate.getDayOfMonth());
	    	int id_aluguel = aluguelDao.buscaIdAtivo(id_pessoa, id_livro);
	    	alterarDataEntrega(id_aluguel, hoje);
	    }
	 
	 public void alterarDataEntrega(int id_aluguel, java.sql.Date data){
	        try {
	            Aluguel ler = aluguelDao.read(id_aluguel);
	            ler.setData_entrega(data);
	            aluguelDao.alterarFinalData(ler);
	        } catch (NotFoundException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
}
