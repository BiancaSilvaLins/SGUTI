/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uti.negocio.basica;

import java.text.DateFormat;




/**
 *
 * @author bianca.lins
 */
public class Prescricao {
    private int cd_prescricao;
    private String medicacao;
    private double dose_medicacao;
    private String procedimento;
    private DateFormat dataHoraProcedimento;

    public int getCd_prescricao() {
        return cd_prescricao;
    }

    public void setCd_prescricao(int cd_prescricao) {
        this.cd_prescricao = cd_prescricao;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public double getDose_medicacao() {
        return dose_medicacao;
    }

    public void setDose_medicacao(double dose_medicacao) {
        this.dose_medicacao = dose_medicacao;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public DateFormat getDataHoraProcedimento() {
        return dataHoraProcedimento;
    }

    public void setDataHoraProcedimento(DateFormat dataHoraProcedimento) {
        this.dataHoraProcedimento = dataHoraProcedimento;
    }    
}
