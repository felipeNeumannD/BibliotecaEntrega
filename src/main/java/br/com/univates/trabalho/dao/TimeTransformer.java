/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.trabalho.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Felipe
 */
public class TimeTransformer {
	public static String transformaPrograma(java.sql.Date data) {
		java.time.LocalDate dataLocalDate = data.toLocalDate();
		
		int dia = dataLocalDate.getDayOfMonth();
        int mes = dataLocalDate.getMonthValue() - 1;
        int ano = dataLocalDate.getYear() - 1900;

		Date dataNova = new Date(ano, mes, dia);
		
		SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoDesejado.format(data);

		return dataFormatada;

	}
}
