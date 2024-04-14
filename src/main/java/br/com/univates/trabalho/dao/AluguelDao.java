/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.dao;

import br.com.univates.trabalho.model.Aluguel;
import br.com.univates.trabalho.model.dto.AluguelPesquisaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class AluguelDao implements Crud<Aluguel>, StatementSetter<PreparedStatement, Aluguel, ResultSet>{
    public AluguelDao(Connection conn){
        this.conn = conn;
    }
    private Connection conn;
    
    
    
    
    
    @Override
    public void adicionar(Aluguel aluguel) {
        String sql = "insert into aluguel (data_inicial, data_entrega, id_pessoa, id_livro) values(?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            adderStatement(statement, aluguel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Aluguel aluguel) {
        String sql = String.format("update aluguel set data_inicial = ?, data_entrega = ?, id_pessoa = ?, id_livro = ? where id_aluguel = %d", aluguel.getId_aluguel());
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            adderStatement(statement, aluguel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(Integer numero) {
        try {
            String sql = String.format("UPDATE livro set ativo = FALSE where id_aluguel = %d", numero);
            Statement statement = conn.createStatement();
            statement.execute(sql);
            Close.statementConnectionClose(statement, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterarFinalData(Aluguel aluguel) {
    	String sql = "update aluguel set data_entrega = ? where id_aluguel = ?";

    	try {
    		PreparedStatement preparedStatement = conn.prepareStatement(sql);
    		preparedStatement.setDate(1, aluguel.getData_entrega());
            preparedStatement.setInt(2, aluguel.getId_aluguel());
            preparedStatement.executeUpdate();
            Close.closePreparedStatement(preparedStatement);
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public Aluguel read(Integer numero) throws NotFoundException {
        String sql = "select * from aluguel where id_aluguel = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            Aluguel aluguel = readerStatement(resultSet);
            Close.closeStatements(preparedStatement, resultSet);
            return aluguel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
 public int buscaIdAtivo(int id_pessoa, int id_livro){
    	
    	try {
    		String sql = "SELECT alg.id_aluguel " +
    	             "FROM aluguel AS alg " +
    	             "JOIN livro AS liv ON alg.id_livro = liv.id_livro " +
    	             "WHERE id_pessoa = ? AND alg.id_livro = ? AND liv.alugado = TRUE AND liv.ativo = TRUE";
        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        	preparedStatement.setInt(1, id_pessoa);
			preparedStatement.setInt(2, id_livro);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        int num = readerStatementId(resultSet);
	        Close.closeStatements(preparedStatement, resultSet);
	    	return num;
		} catch (SQLException e) {
			e.printStackTrace();
			return (Integer) null;
		}
    	
    }

    @Override
    public void adderStatement(PreparedStatement statement, Aluguel aluguel) {
        try{
            statement.setDate(1, aluguel.getData_inicial());
            statement.setDate(2, aluguel.getData_entrega());
            statement.setInt(3, aluguel.getId_pessoa());
            statement.setInt(4, aluguel.getId_livro());
            statement.execute();
            Close.statementConnectionClose(statement, conn);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluguel readerStatement(ResultSet resultSet) {
        try{
            if(resultSet.next()){
                int id_aluguel = resultSet.getInt(1);
                java.sql.Date data_inicial = resultSet.getDate(2);
                java.sql.Date data_entrega = resultSet.getDate(3);
                int id_pessoa = resultSet.getInt(4);
                int id_livro = resultSet.getInt(5);
                Aluguel aluga = new Aluguel(id_aluguel, data_inicial, data_entrega, id_pessoa, id_livro);
                return aluga;
            } else {
            	
            	return null;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
    
    
    
    public int readerStatementId(ResultSet resultSet) {
    	 try{
             if(resultSet.next()){
                 int id_aluguel = resultSet.getInt(1);
                 return id_aluguel;
             } 
         }catch(SQLException e){
             e.getStackTrace();
         }
		return 0;
    }
    
    
    
    
    
    
    public List<AluguelPesquisaDTO> readerStatementPesquisa(ResultSet resultSet) throws SQLException {
    	
    	List<AluguelPesquisaDTO> lista = new ArrayList<>();
    	while(resultSet.next()){
            String nome = resultSet.getString(1);
            int paginas = resultSet.getInt(2);
            String data_inicial =  TimeTransformer.transformaPrograma(resultSet.getDate(3));
            String data_entrega = TimeTransformer.transformaPrograma(resultSet.getDate(4));
            AluguelPesquisaDTO aluga = new AluguelPesquisaDTO(nome, paginas, data_entrega, data_inicial);
            lista.add(aluga);
    	}
            return lista;
    	
    }
    
    

    public List<AluguelPesquisaDTO> historicoAluguelPessao(int id_pessoa) throws SQLException{
    	String sql = "select liv.nome, liv.paginas, alg.data_inicial as Inicio, alg.data_entrega as Fim\r\n"
    			+ "from aluguel as alg\r\n"
    			+ "join livro as liv using(id_livro)\r\n"
    			+ "where id_pessoa = ? and liv.ativo = True and data_entrega is not null";
    	
    	PreparedStatement preparedStatement = conn.prepareStatement(sql);
    	preparedStatement.setInt(1, id_pessoa);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<AluguelPesquisaDTO> lista = readerStatementPesquisa(resultSet);
        Close.closeAll(preparedStatement, resultSet, conn);
		return lista;
    }
    
    
    
    

	@Override
	public Aluguel readEntrada(String email, String senhar) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConn() {
		return conn;
	}
	
	
}