/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.univates.trabalho.dao;

/**
 *
 * @author Felipe
 */
import java.sql.SQLException;
import java.sql.Statement;

public interface StatementSetter <T , V , R>{
	 void adderStatement(T statement, V domain) throws SQLException;
    <V> V readerStatement(R resultSet) throws NotFoundException;
}
