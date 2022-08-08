package finance.demo.finance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    Double taxa;
    Date dataagendamento;
    Date datatransferencia;


}
