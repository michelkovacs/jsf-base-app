package br.com.caelum.financas.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

@Named
@RequestScoped
public class CacheBean {
	
	private Integer id;
	private Conta conta;
	@Inject
	ContaDao dao;
	
	@Inject
	private EntityManager manager;
	
	public void pesquisar() {
		this.conta = this.manager.find(Conta.class, id);
		this.conta = this.manager.find(Conta.class, id);
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Conta getConta() {
		return conta;
	}
}