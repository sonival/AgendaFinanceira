package finance.demo.finance.usecase;

import java.util.Date;

import finance.demo.finance.enums.TipoTransferenciaEnum;

public interface ICalcularTaxa {
    Double calcularTaxa(TipoTransferenciaEnum tipoTransf, Date agendamentoData, Double   valor );
}
