package finance.demo.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finance.demo.finance.model.AgendamentoTransferencia;
import finance.demo.finance.service.AgendamentoTransferenciaService;

@RestController
@RequestMapping("/agendamento/transferencia/")
public class AgendamentoTransferenciaController {
    
    @Autowired
    AgendamentoTransferenciaService agendamentoTransferenciaService;

    @GetMapping("/all")
    private List<AgendamentoTransferencia> getAll(){
        return agendamentoTransferenciaService.retornarTransferenciasAgendadas();
    }

}
