package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

	@Test
	public void dataNegociacaoEhImutavel() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao n = new Negociacao(10, 5, c);

		n.getData().set(Calendar.DAY_OF_MONTH, 20);

		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));

	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}

	@Test
	public void mesmoMilissegundoEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}

	@Test
	public void comHorarioDiferentesEhNoMesmoDia() {
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}

	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		Calendar dia1 = new GregorianCalendar(2011, 10, 05);
		Calendar dia2 = new GregorianCalendar(2011, 12, 05);

		Negociacao negociacao = new Negociacao(40.0, 100, dia1);
		Assert.assertFalse(negociacao.isMesmoDia(dia2));
	}

	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
		Calendar ano1 = new GregorianCalendar(2011, 10, 05);
		Calendar ano2 = new GregorianCalendar(2012, 10, 05);

		Negociacao negociacao = new Negociacao(40.0, 100, ano1);
		Assert.assertFalse(negociacao.isMesmoDia(ano2));
	}
	
}
