/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.dao;

/**
 *
 * @author Felipe
 */
import java.sql.*;

public class Close {


    public static void closeAll(PreparedStatement prepared, ResultSet resultSet, Connection conn){
        try {
            prepared.close();
            resultSet.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void statementConnectionClose(Statement statement, Connection conn){
        try {
            statement.close();
            conn.close();
            System.out.println("a");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void closeStatements(PreparedStatement prepared, ResultSet resultSet) {
    	 try {
			prepared.close();
			resultSet.close();
			System.out.println("b");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void closePreparedStatement(PreparedStatement prepared) {
    	try {
			prepared.close();
			System.out.println("c");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
    
    public static void closeConnection(Connection conn) {
    	try {
			conn.close();
			System.out.println("d");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
}
