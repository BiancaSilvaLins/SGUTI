/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uti.negocio.basica.Usuario;

/**
 *
 * @author bianca.lins
 */
public class UsuarioDAOImpl implements UsuarioDAO{
    
 GerenciadorConexao g;

    public UsuarioDAOImpl() {
        g = GerenciadorConexaoImpl.getInstancia();
    }

    @Override
    public void incluir(Usuario u) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        String sql = "INSERT INTO USUARIO (CPF_USUARIO,NOME_USUARIO,SEXO_USUARIO,TELEFONE_USUARIO,EMAIL_USUARIO) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = co.prepareStatement(sql);
            pstm.setString(1, u.getCpf());
            pstm.setString(2, u.getNome());
            pstm.setBoolean(3, u.getSexo());
            pstm.setString(4, u.getTelefone());
            pstm.setString(5, u.getEmail());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public void excluir(String cpf) throws ConexaoException, DAOException {
        Connection c = g.conectar();
        String sql = "DELETE FROM cpf WHERE CPF_USUARIO=?";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Usuario u) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        String sql = "UPDATE USUARIO SET NOME_USUARIO = ?,SEXO_USUARIO = ?,TELEFONE_USUARIO = ?,EMAIL_USUARIO = ? WHERE CPF_USUARIO = ?";
        try {
            PreparedStatement pstm = co.prepareStatement(sql);
            pstm.setString(1, u.getNome());
            pstm.setBoolean(2, u.getSexo());
            pstm.setString(3, u.getTelefone());
            pstm.setString(4, u.getEmail());
            pstm.setString(5, u.getCpf());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public ArrayList<Usuario> listar() throws ConexaoException, DAOException {
        Connection co = g.conectar();
        ArrayList<Usuario> lista = new ArrayList();

        String sql = "SELECT CPF_USUARIO,NOME_USUARIO,SEXO_USUARIO,TELEFONE_USUARIO,EMAIL_USUARIO FROM USUARIO";

        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setCpf(rs.getString("CPF_USUARIO"));
                u.setNome(rs.getString("NOME_USUARIO"));
                u.setSexo(rs.getBoolean("SEXO_USUARIO"));
                u.setTelefone(rs.getString("TELEFONE_USUARIO"));
                u.setEmail(rs.getString("EMAIL_USUARIO"));
                lista.add(u);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public ArrayList listarTabela() throws ConexaoException, DAOException {
        Connection co = g.conectar();
        ArrayList lista = new ArrayList();

        String sql = "SELECT CPF_USUARIO,NOME_USUARIO,SEXO_USUARIO,TELEFONE_USUARIO,EMAIL_USUARIO FROM USUARIO";

        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Object[]{rs.getString("CPF_USUARIO"), rs.getString("NOME_USUARIO"), rs.getBoolean("SEXO_USUARIO"), rs.getString("TELEFONE_USUARIO"), rs.getString("EMAIL_USUARIO")});
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public ArrayList pesquisaTabelaUsuario(String nome) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        ArrayList lista = new ArrayList();

        String sql = "SELECT CPF_USUARIO,NOME_USUARIO,SEXO_USUARIO,TELEFONE_USUARIO,EMAIL_USUARIO FROM USUARIO  WHERE NOME_USUARIO LIKE '%" + nome + "%'";

        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Object[]{rs.getString("CPF_USUARIO"), rs.getString("NOME_USUARIO"), rs.getBoolean("SEXO_USUARIO"), rs.getString("TELEFONE_USUARIO"), rs.getString("EMAIL_USUARIO")});
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public Usuario get(String cpf) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        Usuario u = null;

        String sql = "SELECT CPF_USUARIO,NOME_USUARIO,SEXO_USUARIO,TELEFONE_USUARIO,EMAIL_USUARIO FROM USUARIO WHERE CPF_USUARIO =?";

        try {
            PreparedStatement pstm = co.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setCpf(rs.getString("CPF_USUARIO"));
                u.setNome(rs.getString("NOME_USUARIO"));
                u.setSexo(rs.getBoolean("SEXO_USUARIO"));
                u.setTelefone(rs.getString("TELEFONE_USUARIO"));
                u.setEmail(rs.getString("EMAIL_USUARIO"));
            }
            return u;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public Usuario consultar(String cpf) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        Usuario u = null;

        String sql;
        sql = "SELECT CPF_USUARIO,NOME_USUARIO,SEXO_USUARIO,TELEFONE_USUARIO,EMAIL_USUARIO FROM USUARIO WHERE CPF_USUARIO LIKE ?";

        try {
            PreparedStatement pstm = co.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setCpf(rs.getString("ID_CLIENTE"));
                u.setNome(rs.getString("NOME_CLIENTE"));
                u.setSexo(rs.getBoolean("SEXO_CLIENTE"));
                u.setTelefone(rs.getString("TELEFONE_CLIENTE"));
                u.setEmail(rs.getString("EMAIL_CLIENTE"));
            }
            return u;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public void incluir(Usuario u) throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Usuario u) throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList pesquisaTabelaUsuario(String nome) throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
