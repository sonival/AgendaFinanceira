package finance.demo.finance.usecase.impl;

import finance.demo.finance.enums.TipoTaxa;
import finance.demo.finance.enums.TipoTransferenciaEnum;
import finance.demo.finance.usecase.ValoreControle;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ControleTaxa {
    TipoTransferenciaEnum tipoTransferenciaEnum;
    TipoTaxa tipoTaxa;
    ValoreControle valores;
    Integer minDias;
    Integer maxDias;
    Double valorPercentual;
    Float valorSobreTaxa = 0f;
}
