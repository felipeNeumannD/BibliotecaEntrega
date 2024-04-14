/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Felipe
 */


import br.com.univates.trabalho.model.Pessoa;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDao implements Crud<Pessoa>, StatementSetter<PreparedStatement, Pessoa, ResultSet>{

    public PessoaDao(Connection conn){
        this.conn = conn;
    }

    private Connection conn;

    @Override
    public void adicionar(Pessoa pessoa) throws SQLException, RepeatedException {
        String sql = "insert into pessoa (nome, senhar, email, cpf, celular) values(?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        adderStatementPlus(statement, pessoa);
        Close.closeConnection(conn);

    }
    @Override
    public void alterar(Pessoa pessoa) throws RepeatedException {
        String sql = String.format("update pessoa set nome = ?, senhar = ?, email = ?, cpf = ?, celular = ?  where id_pessoa = %d and ativo = True", pessoa.getId_pessoa());
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            adderStatementPlus(statement, pessoa);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void excluir(Integer numero) {
        try {
            String sql = String.format("update pessoa set ativo = False where id_pessoa = %d", numero);
            Statement statement = conn.createStatement();
            statement.execute(sql);
            Close.statementConnectionClose(statement, conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    

    @Override
    public Pessoa read(Integer numero) throws NotFoundException {
        String sql = "select * from pessoa where id_pessoa = ? and ativo = True";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            Pessoa pes = readerStatement(resultSet);
            Close.closeAll(preparedStatement, resultSet, conn);
            return pes;

        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    @Override
    public Pessoa readEntrada(String email, String senha) throws NotFoundException {
    	String sql = "select * from pessoa where email = ? and senhar = ? and ativo = True";
    	try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            Pessoa pes = readerStatement(resultSet);
            Close.closeAll(preparedStatement, resultSet, conn);
            
            if(pes!=null) {
            	return pes;
            }else {
            	throw new NotFoundException();
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void adderStatementPlus(PreparedStatement statement, Pessoa pessoa) throws RepeatedException{
        try {
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getSenhar());
            statement.setString(3, pessoa.getEmail());
            statement.setString(4, pessoa.getCpf());
            statement.setString(5, pessoa.getCelular());
            statement.execute();
            Close.statementConnectionClose(statement, conn);
        } catch (SQLException ex) {
            throw new RepeatedException();
        }
        
    }


    @Override
    public void adderStatement(PreparedStatement statement, Pessoa pessoa) throws SQLException {
    	statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getSenhar());
        statement.setString(3, pessoa.getEmail());
        statement.execute();
        Close.statementConnectionClose(statement, conn);
    }

    @Override
    public Pessoa readerStatement(ResultSet resultSet) throws NotFoundException {
        try {
            if(resultSet.next()){
                int id_pessoa = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String senhar = resultSet.getString(3);
                String email =  resultSet.getString(4);
                Pessoa pessoa = new Pessoa(id_pessoa, nome, senhar, email);
                return pessoa;
            } else {
                throw new NotFoundException();
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
    
    public Pessoa Newread(Integer numero) throws NotFoundException {
        String sql = "select nome, senhar, email, cpf, celular from pessoa where id_pessoa = ? and ativo = True";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            Pessoa pes = readerStatementPlus(resultSet);
            Close.closeAll(preparedStatement, resultSet, conn);
            return pes;

        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public Pessoa readerStatementPlus(ResultSet resultSet) {
        try {
            if(resultSet.next()){
                String nome = resultSet.getString(1);
                String senhar = resultSet.getString(2);
                String email =  resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String celular = resultSet.getString(5);
                Pessoa pessoa = new Pessoa(0, nome, senhar, email, cpf, celular);
                return pessoa;
            } else {
                throw new NotFoundException();
            }
        } catch (SQLException | NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
	
}

