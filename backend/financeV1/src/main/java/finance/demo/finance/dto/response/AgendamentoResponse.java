package finance.demo.finance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoResponse {
    String contaOrigem;
    String contaDestino;
    String valor;
    String dataAgendamento;
    String dataTransferencia;
    
    
}
