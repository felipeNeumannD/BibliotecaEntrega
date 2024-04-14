/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.dao;

import br.com.univates.trabalho.model.Livro;
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

public class LivroDao implements Crud<Livro>, StatementSetter<PreparedStatement, Livro, ResultSet>{

    public LivroDao(Connection conn){
        this.conn = conn;
    }
    private Connection conn;

    @Override
    public void adicionar(Livro livro) {
        String sql = "insert into livro (nome, paginas, alugado) values(?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            adderStatement(statement, livro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    

    @Override
    public void alterar( Livro livro) {
        String sql = String.format("update livro set nome = ?, paginas = ? where id_livro = %d", livro.getId_livro());
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            adderStatementAlterate(statement, livro);
            Close.statementConnectionClose(statement, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void adderStatementAlterate(PreparedStatement statement, Livro livro) {
        try{
            statement.setString(1, livro.getNome());
            statement.setInt(2, livro.getPaginas());
            statement.execute();
            Close.statementConnectionClose(statement, conn);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(Integer numero) {
        try {
            String sql = String.format("UPDATE livro set ativo = False where id_livro = %d", numero);
            Statement statement = conn.createStatement();
            statement.execute(sql);
            Close.statementConnectionClose(statement, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Livro read(Integer numero) throws NotFoundException {
        String sql = "select * from livro where id_livro = ? and ativo = True";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            Livro liv = readerStatementLivro(resultSet);
            Close.closeStatements(preparedStatement, resultSet);
            return liv;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void adderStatement(PreparedStatement statement, Livro livro) {
        try{
            statement.setString(1, livro.getNome());
            statement.setInt(2, livro.getPaginas());
            statement.setBoolean(3, livro.isAlugado());
            statement.execute();
            Close.statementConnectionClose(statement, conn);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
    public Livro readerStatementLivro(ResultSet resultSet) {
        try {
        	Livro liv = null;
            if(resultSet.next()){
            	int id_livro = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                int paginas = resultSet.getInt(3);
                boolean alugado = resultSet.getBoolean(4);
                Livro livro = new Livro(id_livro, nome, paginas, alugado);
                liv = livro;
            } 
            return liv;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
	public List<Livro> readerStatement(ResultSet resultSet) {
        try {
        	List<Livro> livros = new ArrayList<>();
            while(resultSet.next()){
                int id_livro = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                int paginas = resultSet.getInt(3);
                boolean alugado = resultSet.getBoolean(4);
                Livro livro = new Livro(id_livro, nome, paginas, alugado);
                livros.add(livro);
            } 
            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Livro> minhaReserva(int idPessoa) throws SQLException{
    	String sql = "select id_livro, lv.nome, lv.paginas, lv.alugado from aluguel join livro as lv using(id_livro)\r\n"
    			+ "where id_pessoa = ? and lv.ativo = True and lv.alugado = True and data_entrega is null";
    	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, idPessoa);
        ResultSet resultSet = preparedStatement.executeQuery();
		List<Livro> livros = readerStatement(resultSet);
		Close.closeAll(preparedStatement, resultSet, conn);
		return livros;
    }
    
    public List<Livro> naoReservados() throws SQLException{
    	String sql = "select * from livro where alugado = False and ativo = True";
    	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
		List<Livro> livros = readerStatement(resultSet);
		Close.closeAll(preparedStatement, resultSet, conn);
		return livros;
    }
    
    
    
    
    
    

	@Override
	public Livro readEntrada(String email, String senhar) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
