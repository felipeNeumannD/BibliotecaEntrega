/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class ConnectionFactory {

    public Connection conectar(){
        return createDataSource();
    }


    private Connection createDataSource(){
    	try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteca?user=postgres&password=postgres");
            return connection;
	} catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
	}

    }
}
