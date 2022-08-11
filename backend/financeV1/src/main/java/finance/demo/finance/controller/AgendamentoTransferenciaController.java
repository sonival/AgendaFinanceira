package finance.demo.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finance.demo.finance.dto.request.SolicitarAgendamentoDTO;
import finance.demo.finance.dto.response.AgendamentoResponse;
import finance.demo.finance.model.AgendamentoTransferencia;
import finance.demo.finance.service.AgendamentoTransferenciaService;

@RestController
@RequestMapping("/agendamento/transferencia/")
public class AgendamentoTransferenciaController {
    
    @Autowired
    AgendamentoTransferenciaService agendamentoTransferenciaService;

    @GetMapping("/all")
    public List<AgendamentoResponse> getAll(){
        return agendamentoTransferenciaService.retornarTransferenciasAgendadas();
    }

    @PostMapping("/salvarAgendamento")
    public ResponseEntity<Void> salvarAgendamentoTransferencia(@RequestBody SolicitarAgendamentoDTO solicitarAgendamentoDTO){
        agendamentoTransferenciaService.salvarAgendamento(solicitarAgendamentoDTO);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
