package finance.demo.finance.usecase;

import java.util.Date;

import finance.demo.finance.enums.TipoTransferenciaEnum;

public interface ICaclular {
    Float calcularAgendamento(TipoTransferenciaEnum tipoTransf, Float valor, Date DataAgendamento);
}
