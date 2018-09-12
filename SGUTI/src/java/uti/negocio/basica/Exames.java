/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uti.negocio.basica;

import java.text.DateFormat;

/**
 *
 * @author Bianca Lins
 */
public class Exames {
    private int cd_exames;
    private boolean tipo;
    private DateFormat dataHoraSolicitacao;
    private DateFormat  dataHoraRealizacao;

    public int getCd_exames() {
        return cd_exames;
    }

    public void setCd_exames(int cd_exames) {
        this.cd_exames = cd_exames;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public DateFormat getDataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    public void setDataHoraSolicitacao(DateFormat dataHoraSolicitacao) {
        this.dataHoraSolicitacao = dataHoraSolicitacao;
    }

    public DateFormat getDataHoraRealizacao() {
        return dataHoraRealizacao;
    }

    public void setDataHoraRealizacao(DateFormat dataHoraRealizacao) {
        this.dataHoraRealizacao = dataHoraRealizacao;
    }
    
    
}
