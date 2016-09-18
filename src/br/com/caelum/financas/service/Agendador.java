package br.com.caelum.financas.service;

import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Startup
public class Agendador {
	
	@Resource
	TimerService timerService;

	private static int totalCriado;
	
	public	void	agenda(String	expressaoMinutos,	String	expressaoSegundos)	{
		ScheduleExpression	expression	=	new	ScheduleExpression();
		expression.hour("*");
		expression.minute(expressaoMinutos);
		expression.second(expressaoSegundos);
		TimerConfig	config	=	new	TimerConfig();
		config.setInfo(expression.toString());																				
		config.setPersistent(false);
		this.timerService.createCalendarTimer(expression,	config);
		System.out.println("Agendamento:	"	+	expression);
	}
	
	@Timeout	
	public	void	verificacaoPeriodicaSeHaNovasContas(Timer	timer)	{	
		System.out.println(timer.getInfo());
		//aqui	poderiamos	acessar	o	banco	de	dados	
		//com	JPA	para	verificar	as	contas	periodicamente																				
	}

	public void executa() {
		System.out.printf("%d instancias criadas %n", totalCriado);

		// simulando demora de 4s na execucao
		try {
			System.out.printf("Executando %s %n", this);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}

}
