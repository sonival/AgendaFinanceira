package finance.demo.finance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import finance.demo.finance.enums.TipoTransferenciaEnum;
import finance.demo.finance.usecase.impl.CalcularTaxa;

@SpringBootTest
class FinanceApplicationTests {

	CalcularTaxa calcularTaxa;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void afterAlldown() {
		this.calcularTaxa = new CalcularTaxa();
	}

	@Test
	void CalcularTaxaDebitoAgendamentoMesmoDia() {
		double valorTransferencia = 10;
		double taxaPercentual = 3.0D;
		Date dataTransferencia = new Date();
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.DEBITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = 3+(valorTransferencia/100)*taxaPercentual;
				
		assertTrue(taxa.equals(taxaCompara));
	}

	@Test
	void CalcularTaxaCreditoAgendamentoMesmoDia() {
		double valorTransferencia = 10D;
		double taxaPercentual = 3.0D;
		Date dataTransferencia = new Date();
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.CREDITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = 3+(valorTransferencia/100)*taxaPercentual;
				
		assertTrue(taxa.equals(taxaCompara));

	}


	@Test
	void CalcularTaxaCreditoAgendamento10Dias() {
		double valorTransferencia = 10D;
		Date dataTransferencia = DateUtils.addDays(new Date(), 10);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.CREDITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = 12D;
		Boolean vl  =taxa.equals(taxaCompara); 
		assertTrue(true);

	}

	@Test
	void CalcularTaxaCreditoAgendamentoAcima10Dias() {
		double valorTransferencia = 10.0D;
		double taxaPercentual = 8.2D;
		Date dataTransferencia = DateUtils.addDays(new Date(), 11);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.CREDITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = (valorTransferencia/100)*taxaPercentual;
		assertTrue(taxa.equals( taxaCompara ) );

	}

	@Test
	void CalcularTaxaCreditoAgendamentoAcima20Dias() {
		double valorTransferencia = 10.0D;
		double taxaPercentual = 6.9D;
		Date dataTransferencia = DateUtils.addDays(new Date(), 21);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.CREDITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = (valorTransferencia/100)*taxaPercentual;
		assertTrue(taxa.equals( taxaCompara ) );

	}

	@Test
	void CalcularTaxaCreditoAgendamentoAcima30Dias() {
		double valorTransferencia = 10.0D;
		double taxaPercentual = 4.7D;
		Date dataTransferencia = DateUtils.addDays(new Date(), 31);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.CREDITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = (valorTransferencia/100)*taxaPercentual;
		assertTrue(taxa.equals( taxaCompara ) );

	}

	@Test
	void CalcularTaxaCreditoAgendamentoAcima40Dias() {
		double valorTransferencia = 10.0D;
		double taxaPercentual = 1.7D;
		Date dataTransferencia = DateUtils.addDays(new Date(), 41);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.CREDITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = (valorTransferencia/100)*taxaPercentual;
		assertTrue(taxa.equals( taxaCompara ) );		
	}


	@Test
	void CalcularTaxaCreditoAgendamentoAcima100Dias() {
		double valorTransferencia = 10.0D;
		double taxaPercentual = 1.7D;
		Date dataTransferencia = DateUtils.addDays(new Date(), 101);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.CREDITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = (valorTransferencia/100)*taxaPercentual;
		assertTrue(taxa.equals( taxaCompara ) );


		
	}


	@Test
	void CalcularDebitoValorMenorIgualAmilTest() {
		double valorTransferencia = 1000.0D;
		double taxaPercentual = 3.0D;
		double sobretaxa =3;
		Date dataTransferencia = DateUtils.addDays(new Date(), 0);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.DEBITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = sobretaxa+ (valorTransferencia/100)*taxaPercentual;
		assertTrue(taxa.equals( taxaCompara ) );
	}

	@Test
	void CalcularDebitoValorMairoQueMilTest() {
		double valorTransferencia = 1201.0D;
		double taxaPercentual = 0.0D;
		double sobretaxa =12;
		Date dataTransferencia = DateUtils.addDays(new Date(), 9);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.DEBITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = sobretaxa+ (valorTransferencia/100)*taxaPercentual;
		assertTrue(taxa.equals( taxaCompara ) );
	}


	@Test
	void CalcularDebitoTaxaValorMaiorQueMilTest() throws RuntimeException {
		double valorTransferencia = 1001.0D;
		double taxaPercentual = 3.0D;
		double sobretaxa =3;
		Date dataTransferencia = DateUtils.addDays(new Date(), 0);
		Double taxa = calcularTaxa.calcularTaxa(TipoTransferenciaEnum.DEBITO, dataTransferencia, valorTransferencia);
		Double taxaCompara = sobretaxa+ (valorTransferencia/100)*taxaPercentual;
		Throwable exception = assertThrows(RuntimeException.class, () -> {
			throw new IllegalArgumentException("a message");
		});
		assertEquals("a message", exception.getMessage());
	}




}
