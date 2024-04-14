/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.model;

import java.sql.Date;

/**
 *
 * @author Felipe
 */

public class Aluguel {

    private int id_aluguel;
    private java.sql.Date data_inicial;
    private java.sql.Date data_entrega;
    private int id_pessoa;
    private int id_livro;
    public Aluguel(int id_aluguel, java.sql.Date data_inicial, java.sql.Date data_entrega, int id_pessoa, int id_livro){
        this.id_aluguel = id_aluguel;
        this.data_entrega = data_entrega;
        this.data_inicial = data_inicial;
        this.id_livro = id_livro;
        this.id_pessoa = id_pessoa;
    }
    
    public Aluguel( java.sql.Date data_inicial, java.sql.Date data_entrega, int id_pessoa, int id_livro){
        this.data_entrega = data_entrega;
        this.data_inicial = data_inicial;
        this.id_livro = id_livro;
        this.id_pessoa = id_pessoa;
    }
    
    

    public Date getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(java.sql.Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(java.sql.Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public int getId_aluguel() {
        return id_aluguel;
    }
}
