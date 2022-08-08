package finance.demo.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import finance.demo.finance.model.AgendamentoTransferencia;
import finance.demo.finance.repository.AgendamentoTransferenciaRepository;

@Service
public class AgendamentoTransferenciaService {
    
    @Autowired
    AgendamentoTransferenciaRepository repository;


    public List<AgendamentoTransferencia> retornarTransferenciasAgendadas(){
        return repository.findAll();
    }

}
