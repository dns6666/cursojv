package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickTest {

	@Test (expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		Candlestick candle = new Candlestick(40.5, 30.6, 41.6, 32.5, 1300.0, Calendar.getInstance());
		
		Assert.assertEquals(candle.getMaximo()<candle.getMinimo(), candle.getMaximo()>candle.getMinimo());
	}
	
}
