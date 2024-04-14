/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.model;

/**
 *
 * @author Felipe
 */
public class Livro {
    public Livro(int id_livro, String nome, int paginas, boolean alugado){
    	this.id_livro = id_livro;
        this.nome = nome;
        this.paginas = paginas;
        this.alugado = alugado;
    }
    
    public Livro(String nome, int paginas, boolean alugado){
        this.nome = nome;
        this.paginas = paginas;
        this.alugado = alugado;
    }
    
    
    private int id_livro;
    private String nome;
    private int paginas;
    private boolean alugado;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public int getId_livro() {
        return id_livro;
    }
}
