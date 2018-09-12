/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uti.dao;

import java.util.ArrayList;
import uti.negocio.basica.Usuario;

/**
 *
 * @author bianca.lins
 */
public class UsuarioDAO {
    /**
     * Insere um registro no BD
     *
     * @param u Objeto contendo todos os dados
     * @throws ConexaoException
     * @throws DAOException
     */
    public void incluir(Usuario u) throws ConexaoException, DAOException;

    /**
     * 
     *
     * @param cpf Identificacao (PK) do registro
     * @throws ConexaoException
     * @throws DAOException
     */
    public void excluir(Integer cpf) throws ConexaoException, DAOException;

    /**
     * Atualiza TODOS os campos de um registro
     *
     * @param u Obejto contendo todos os campos
     * @throws ConexaoException
     * @throws DAOException
     */
    public void alterar(Usuario u) throws ConexaoException, DAOException;

    /**
     * Lista todos os registros da tabela 
     *
     * @return um ArrayList com todos os dados
     * @throws ConexaoException
     * @throws DAOException
     */
    public ArrayList<Usuario> listar() throws ConexaoException, DAOException;
    
    public ArrayList listarTabela() throws ConexaoException, DAOException;
    
    public ArrayList pesquisaTabelaUsuario(String nome) throws ConexaoException, DAOException;

    /**
     * Retorna o objeto com os dados da tabela
     *
     * @param cpf Chave primaria
     * @return
     * @throws ConexaoException
     * @throws DAOException
     */
    public Usuario get(Integer cpf) throws ConexaoException, DAOException;

    /**
     * Faz uma busca pelo valor dogitado no campo NOME
     *
     * @param nome Texto contendo o nome a ser procurado
     * @return
     * @throws ConexaoException
     * @throws DAOException
     */
    public Usuario consultar(String nome) throws ConexaoException, DAOException;

} 

