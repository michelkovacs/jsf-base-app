package br.com.caelum.financas.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;

@Named
@ApplicationScoped
public class EstatisticasBean {

	@Inject					
	private EntityManager manager;
	private Statistics estatisticas;
	
	public Statistics getEstatisticas() {
			return estatisticas;
	}

	public void gera() {
		Session session = this.manager.unwrap(Session.class);
		// crie um atributo e getter com o nome estatisticas para Statistics
		this.estatisticas = session.getSessionFactory().getStatistics();
		
		System.out.println("Gerando est�tisitcas");
	}
	
	public void liga() {
		this.estatisticas.setStatisticsEnabled(true);
		
	}
	
	public void desliga() {
		this.estatisticas.setStatisticsEnabled(false);
	}
	
	public boolean estaLigado() {
		return this.estatisticas.isStatisticsEnabled();
	}
}
