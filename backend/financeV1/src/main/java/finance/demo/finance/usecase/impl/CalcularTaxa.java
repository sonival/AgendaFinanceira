package finance.demo.finance.usecase.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;

import org.hibernate.jdbc.Expectation;
import org.springframework.stereotype.Service;

import finance.demo.finance.enums.TipoTaxa;
import finance.demo.finance.enums.TipoTransferenciaEnum;
import finance.demo.finance.usecase.ICalcularTaxa;
import finance.demo.finance.usecase.ValoreControle;



@Service
public class CalcularTaxa implements ICalcularTaxa {
    private int VALORADCIONAR = 3;
    private int TAXAPERCENTUALMESMODIA = 3;
    private Double TAXAPERCENTUALATE10DIAS = 12D;
    private int UMDIAMILESEGUNDOS = 86400000;
    private List<ControleTaxa> percentuaisValores = new ArrayList<>();

    public CalcularTaxa() {

        this.percentuaisValores.add(new ControleTaxa(TipoTransferenciaEnum.CREDITO,TipoTaxa.A, new ValoreControle(0f, 1000.0f), 0, 1,   3.0D,3.0f));
       
        this.percentuaisValores.add(new ControleTaxa(TipoTransferenciaEnum.CREDITO,TipoTaxa.B,new ValoreControle(1001.0f, 2000.0f), 10, 10,   0D,12.0f));
       
        this.percentuaisValores.add(new ControleTaxa(TipoTransferenciaEnum.CREDITO,TipoTaxa.A, new ValoreControle(2001.0f, Float.MAX_VALUE),1, 10,   3D,12.0f));
        
        this.percentuaisValores.add(new ControleTaxa(TipoTransferenciaEnum.CREDITO, TipoTaxa.C,new ValoreControle(2001.0f, Float.MAX_VALUE), 11,20, 8.2D,0f));

        this.percentuaisValores.add(new ControleTaxa(TipoTransferenciaEnum.CREDITO, TipoTaxa.C,new ValoreControle(2001.0f, Float.MAX_VALUE),21,30, 6.9D,0f));

        this.percentuaisValores.add(new ControleTaxa(TipoTransferenciaEnum.CREDITO, TipoTaxa.C,new ValoreControle(2001.0f, Float.MAX_VALUE),31,40, 4.7D,0f));

        this.percentuaisValores.add(new ControleTaxa(TipoTransferenciaEnum.CREDITO, TipoTaxa.C,new ValoreControle(2001.0f, Float.MAX_VALUE),41,Integer.MAX_VALUE, 1.7D,0f));

      
    }

    @Override
    public Double calcularTaxa(TipoTransferenciaEnum tipoTransf, Date agendamentoData, Double valor) {
        long diasDiferentes = agendamentoData.getTime() - (new Date()).getTime();
        diasDiferentes = diasDiferentes + UMDIAMILESEGUNDOS;
        Long dias = TimeUnit.DAYS.convert(diasDiferentes, TimeUnit.MILLISECONDS);
        Double retornaTaxa = 0D;


        // if (dias == 1) {
        //     retornaTaxa = VALORADCIONAR + calcularPercentual(valor, TAXAPERCENTUALMESMODIA) ;
        // }
        // if(dias ==10){
        //     retornaTaxa = TAXAPERCENTUALATE10DIAS;
        // }

        ControleTaxa controleTaxa = this.percentuaisValores.stream().filter(f->dias >= f.minDias &&  dias<= f.maxDias).findFirst().orElse(null);


        if(controleTaxa !=null ){
            retornaTaxa = (double)controleTaxa.valorSobreTaxa + calcularPercentual(valor, controleTaxa.valorPercentual)  ;
        }

        if(tipoTransf.tipoConta == TipoTransferenciaEnum.DEBITO.tipoConta){
            
            ControleTaxa controleTaxaDebito = this.percentuaisValores.stream().filter(f-> f.valores.getValorMin() <=  valor  && f.valores.getValorMax() >= valor).findFirst().orElse(null);
            
            if(controleTaxaDebito ==null){
                throw new RuntimeException("Nenhuma regra taxa de debito foi localizada");
            }
            
            if(!controleTaxa.tipoTaxa.equals(controleTaxaDebito.tipoTaxa)){
                 throw new RuntimeException("Nao foi localizado taxa para quantidade de dias informado.");
            //    retornaTaxa = controleTaxa.valorSobreTaxa + calcularPercentual(valor, controleTaxa.valorPercentual)  ;
            }

            // boolean taxaValidaParaDebito = controleTaxa.valores.getValorMin()<= valor  && controleTaxa.valores.getValorMax()<= valor;
            
            // if(!taxaValidaParaDebito){
            //     throw new RuntimeException("Nao foi localizada uma taxa validar");
            // }

        }


       
        return retornaTaxa;
    }


    private Double calcularPercentual(double valor, double percentual){
        if(percentual<=0) return 0d;
        
        return ((valor / 100) * percentual);
    }

}
