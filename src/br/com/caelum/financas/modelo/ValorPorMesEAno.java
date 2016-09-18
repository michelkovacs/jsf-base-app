package br.com.caelum.financas.modelo;

import java.math.BigDecimal;

public class ValorPorMesEAno {

	private int mes;

	private int ano;

	private BigDecimal valor;

	public ValorPorMesEAno(int mes, int ano, BigDecimal valor) {

		this.mes = mes;

		this.ano = ano;

		this.valor = valor;

	}

	public BigDecimal getValor() {

		return this.valor;

	}

	public int getMes() {

		return this.mes;

	}

	public int getAno() {

		return this.ano;

	}

}