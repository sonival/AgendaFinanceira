package finance.demo.finance.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finance.demo.finance.dto.request.SolicitarAgendamentoDTO;
import finance.demo.finance.dto.response.AgendamentoResponse;
import finance.demo.finance.model.AgendamentoTransferencia;
import finance.demo.finance.repository.AgendamentoTransferenciaRepository;
import finance.demo.finance.usecase.impl.CalcularTaxa;

@Service
public class AgendamentoTransferenciaService {
    
    @Autowired
    AgendamentoTransferenciaRepository repository;

    @Autowired
    CalcularTaxa calcularTaxa;




    public List<AgendamentoResponse> retornarTransferenciasAgendadas(){
        return repository.findAll().stream().map(m->m.retornaAgendamentoResponse()).collect(Collectors.toList());
    }

    public void salvarAgendamento(SolicitarAgendamentoDTO solicitarAgendamentoDTO){
        AgendamentoTransferencia agendamentoTransferencia = solicitarAgendamentoDTO.convertAgendamentoTransferencia();
        agendamentoTransferencia.setTaxa( calcularTaxa.calcularTaxa(solicitarAgendamentoDTO.getTipoTransf() ,  solicitarAgendamentoDTO.getDataAgendamento(),  (double)solicitarAgendamentoDTO.getValor() )  );
        repository.save(agendamentoTransferencia);
    }

}
