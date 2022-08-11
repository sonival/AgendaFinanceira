package finance.demo.finance.dto.request;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import finance.demo.finance.Utils.CustomDateDeserializer;
import finance.demo.finance.Utils.CustomDateSerializer;
import finance.demo.finance.enums.TipoTransferenciaEnum;
import finance.demo.finance.model.AgendamentoTransferencia;
import lombok.AllArgsConstructor;
import lombok.Data;

public class SolicitarAgendamentoDTO {

    @JsonProperty("contaOrigem")
    String contaOrigem;

    @JsonProperty("contaDestino")
    String contaDestino;

    @JsonProperty("dataAgendamento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonSerialize(using = CustomDateSerializer.class)
    Date dataAgendamento;

    Float valor;
    @JsonProperty("tipoTransferencia")
    TipoTransferenciaEnum tipoTransf;

    public TipoTransferenciaEnum getTipoTransf() {
        return this.tipoTransf;
    }

    public void setTipoTransf(TipoTransferenciaEnum tipoTransf) {
        this.tipoTransf = tipoTransf;
    }

    public String getContaOrigem() {
        return this.contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return this.contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Date getDataAgendamento() {
        return this.dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public AgendamentoTransferencia convertAgendamentoTransferencia() {
        AgendamentoTransferencia agendamentoTransferencia = new AgendamentoTransferencia();
        agendamentoTransferencia.setContaorigem(Double.valueOf(this.contaOrigem));
        agendamentoTransferencia.setContadestino(Double.valueOf(this.contaDestino));
        agendamentoTransferencia.setDatatransferencia(new Date());
        agendamentoTransferencia.setDataagendamento(this.dataAgendamento);
        agendamentoTransferencia.setTaxa(0d);
        agendamentoTransferencia.setTipotransacao(this.tipoTransf.tipoConta);
        agendamentoTransferencia.setValor(this.valor);
        return agendamentoTransferencia;
    }

}
