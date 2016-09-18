package br.com.caelum.financas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cacheable
@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private Integer versao;
	
	@NotNull
	@Pattern(regexp="[A-Z].*")
	private String titular;
	private String agencia;
	private String numero;
	private String banco;

	@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
	@OneToMany(mappedBy="conta")
	//@LazyCollection(LazyCollectionOption.EXTRA)//anotacao do hibernate especifica,
	//faz com que ao adicionar um elemento na lista, nao seja buscada a lista inteira
	//apenas é executado o insert para os novos elementos
	//ao utilizar o size() é feito um count no banco ao inves de buscar toda a lista
	private List<Movimentacao> movimentacoes;
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
