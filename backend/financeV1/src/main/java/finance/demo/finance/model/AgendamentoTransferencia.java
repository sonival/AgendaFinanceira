package finance.demo.finance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import finance.demo.finance.dto.response.AgendamentoResponse;
import finance.demo.finance.enums.TipoTransferenciaEnum;
import lombok.Data;

@Data
@Entity
@Table(name="AGENDAMENTO_TRANSFERENCIA")
public class AgendamentoTransferencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    Double contaorigem;
    Double contadestino;
    int tipotransacao;
    Double taxa;
    Float valor;
    Date dataagendamento;
    Date datatransferencia;

    public AgendamentoResponse retornaAgendamentoResponse(){
        AgendamentoResponse rs =  new AgendamentoResponse();
        rs.setContaDestino(this.contadestino.toString());
        rs.setContaOrigem(this.contaorigem.toString());
        rs.setValor(this.valor.toString());
        rs.setDataAgendamento(this.dataagendamento.toString());
        rs.setDataTransferencia(this.datatransferencia.toString());
        return rs;
    }
}
