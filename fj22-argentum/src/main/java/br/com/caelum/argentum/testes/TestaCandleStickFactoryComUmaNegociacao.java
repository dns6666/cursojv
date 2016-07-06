package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.CandleStickFactory;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandleStickFactoryComUmaNegociacao {
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);
		
		CandleStickFactory fabrica = new CandleStickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());
	}
}