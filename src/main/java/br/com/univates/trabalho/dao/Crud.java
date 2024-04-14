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

public interface Crud <T>{
    void adicionar(T conta) throws SQLException, RepeatedException;
    void alterar( T alt) throws RepeatedException;
    void excluir(Integer numero);
    T read(Integer numero) throws NotFoundException;
    T readEntrada(String email, String senhar) throws NotFoundException;


}
