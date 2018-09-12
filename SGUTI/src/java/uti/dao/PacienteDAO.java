/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uti.dao;

import java.util.ArrayList;
import uti.negocio.basica.Paciente;

/**
 *
 * @author Bianca Lins
 */

public interface PacienteDAO {

    /**
     * Insere um registro no BD
     *
     * @param p Objeto contendo todos os dados
     * @throws ConexaoException
     * @throws DAOException
     */
    public void incluir(Paciente p) throws ConexaoException, DAOException;

    /**
     * 
     *
     * @param cod_paciente Identificacao (PK) do registro
     * @throws ConexaoException
     * @throws DAOException
     */
    public void excluir(Integer cod_paciente) throws ConexaoException, DAOException;

    /**
     * Atualiza TODOS os campos de um registro
     *
     * @param p Obejto contendo todos os campos
     * @throws ConexaoException
     * @throws DAOException
     */
    public void alterar(Paciente p) throws ConexaoException, DAOException;

    /**
     * Lista todos os registros da tabela 
     *
     * @return um ArrayList com todos os dados
     * @throws ConexaoException
     * @throws DAOException
     */
    public ArrayList<Paciente> listar() throws ConexaoException, DAOException;
    
    public ArrayList listarTabela() throws ConexaoException, DAOException;
    
    public ArrayList pesquisaTabelaPaciente(String nome) throws ConexaoException, DAOException;

    /**
     * Retorna o objeto com os dados da tabela
     *
     * @param cod_paciente Chave primaria
     * @return
     * @throws ConexaoException
     * @throws DAOException
     */
    public Paciente get(Integer cod_paciente) throws ConexaoException, DAOException;

    /**
     * Faz uma busca pelo valor dogitado no campo NOME
     *
     * @param nome Texto contendo o nome a ser procurado
     * @return
     * @throws ConexaoException
     * @throws DAOException
     */
    public Paciente consultar(String nome) throws ConexaoException, DAOException;

}
