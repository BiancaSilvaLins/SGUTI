
package uti.negocio.basica;

import java.util.Date;

/**
 *
 * @author bianca.lins
 */
public class Paciente {
    
    private Integer cod_paciente;
    private String nome;
    private Date dt_nasc_paciente;
    private String cpf;
    private boolean sexo;
    private String raca_cor;
    private String nome_mae;
    private String cep;
    private String endereco;
    private Integer numero;
    private String cidade;
    private String uf;
    private String bairro;
    private String telefone_res;
    private String telefone_cel;
    private String rg_paciente;
    private String orgao_emissor;
    private String uf_emissor;
    private Date dt_emissao;
    private boolean tipo_internacao;
    private String clinica;
    private String unidade_internacao;
    private Date dt_internacao;
    private String medico_resp;
    

    public Paciente() {
        
    }

    public Paciente(Integer cod_paciente, String nome, Date dt_nasc_paciente, String cpf, boolean sexo, String raca_cor, String nome_mae, String cep, 
            String endereco, Integer numero, String cidade, String uf, String bairro, String telefone_res, String telefone_cel, String rg_paciente, String orgao_emissor, 
            String uf_emissor, Date dt_emissao, boolean tipo_internacao, String clinica, String unidade_internacao, Date dt_internacao, String medico_resp) {
        this.cod_paciente = cod_paciente;
        this.nome = nome;
        this.dt_nasc_paciente = dt_nasc_paciente;
        this.cpf = cpf;
        this.sexo = sexo;
        this.raca_cor = raca_cor;
        this.nome_mae = nome_mae;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
        this.telefone_res = telefone_res;
        this.telefone_cel = telefone_cel;
        this.rg_paciente = rg_paciente;
        this.orgao_emissor = orgao_emissor;
        this.uf_emissor = uf_emissor;
        this.dt_emissao = dt_emissao;
        this.tipo_internacao = tipo_internacao;
        this.clinica = clinica;
        this.unidade_internacao = unidade_internacao;
        this.dt_internacao = dt_internacao;
        this.medico_resp = medico_resp;
        
    }


    public Integer getCod_paciente() {
        return cod_paciente;
    }

    public void setCod_paciente(Integer cod_paciente) {
        this.cod_paciente = cod_paciente;
    }

    public Date getDt_nasc_paciente() {
        return dt_nasc_paciente;
    }

    public void setDt_nasc_paciente(Date dt_nasc_paciente) {
        this.dt_nasc_paciente = dt_nasc_paciente;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getRaca_cor() {
        return raca_cor;
    }

    public void setRaca_cor(String raca_cor) {
        this.raca_cor = raca_cor;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone_res() {
        return telefone_res;
    }

    public void setTelefone_res(String telefone_res) {
        this.telefone_res = telefone_res;
    }

    public String getTelefone_cel() {
        return telefone_cel;
    }

    public void setTelefone_cel(String telefone_cel) {
        this.telefone_cel = telefone_cel;
    }

    public String getRg_paciente() {
        return rg_paciente;
    }

    public void setRg_paciente(String rg_paciente) {
        this.rg_paciente = rg_paciente;
    }

    public String getOrgao_emissor() {
        return orgao_emissor;
    }

    public void setOrgao_emissor(String orgao_emissor) {
        this.orgao_emissor = orgao_emissor;
    }

    public String getUf_emissor() {
        return uf_emissor;
    }

    public void setUf_emissor(String uf_emissor) {
        this.uf_emissor = uf_emissor;
    }

    public Date getDt_emissao() {
        return dt_emissao;
    }

    public void setDt_emissao(Date dt_emissao) {
        this.dt_emissao = dt_emissao;
    }

    public boolean isTipo_internacao() {
        return tipo_internacao;
    }

    public void setTipo_internacao(boolean tipo_internacao) {
        this.tipo_internacao = tipo_internacao;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getUnidade_internacao() {
        return unidade_internacao;
    }

    public void setUnidade_internacao(String unidade_internacao) {
        this.unidade_internacao = unidade_internacao;
    }

    public Date getDt_internacao() {
        return dt_internacao;
    }

    public void setDt_internacao(Date dt_internacao) {
        this.dt_internacao = dt_internacao;
    }

    public String getMedico_resp() {
        return medico_resp;
    }

    public void setMedico_resp(String medico_resp) {
        this.medico_resp = medico_resp;
    }
}
