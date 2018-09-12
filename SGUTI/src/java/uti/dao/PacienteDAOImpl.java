/*Fazer log de auditoria, grafico das evoluções e controle das prescrições. 
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
import uti.negocio.basica.Paciente;

/**
 *
 * @author Bianca Lins
 */

public class PacienteDAOImpl implements PacienteDAO {

    GerenciadorConexao g;

    public PacienteDAOImpl() {
        g = GerenciadorConexaoImpl.getInstancia();
    }

    @Override
    public void incluir(Paciente p) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        String sql = "INSERT INTO CLIENTE (NOME_CLIENTE,CPF_CLIENTE,TELEFONE_CLIENTE,EMAIL_CLIENTE) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = co.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getCpf());
            pstm.setString(3, p.getTelefone());
            pstm.setString(4, p.getEmail());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public void excluir(Integer id) throws ConexaoException, DAOException {
        Connection c = g.conectar();
        String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE=?";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Paciente p) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        String sql = "UPDATE CLIENTE SET NOME_CLIENTE = ?,CPF_CLIENTE = ?,TELEFONE_CLIENTE = ?,EMAIL_CLIENTE = ? WHERE ID_CLIENTE = ?";
        try {
            PreparedStatement pstm = co.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getCpf());
            pstm.setString(3, p.getTelefone());
            pstm.setString(4, p.getEmail());
            pstm.setInt(5, p.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public ArrayList<Paciente> listar() throws ConexaoException, DAOException {
        Connection co = g.conectar();
        ArrayList<Paciente> lista = new ArrayList();

        String sql = "SELECT ID_CLIENTE,NOME_CLIENTE,CPF_CLIENTE,TELEFONE_CLIENTE,EMAIL_CLIENTE FROM CLIENTE";

        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("ID_CLIENTE"));
                p.setNome(rs.getString("NOME_CLIENTE"));
                p.setCpf(rs.getString("CPF_CLIENTE"));
                p.setTelefone(rs.getString("TELEFONE_CLIENTE"));
                p.setEmail(rs.getString("EMAIL_CLIENTE"));
                lista.add(p);
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

        String sql = "SELECT ID_CLIENTE,NOME_CLIENTE,CPF_CLIENTE,TELEFONE_CLIENTE,EMAIL_CLIENTE FROM CLIENTE";

        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Object[]{rs.getInt("ID_CLIENTE"), rs.getString("NOME_CLIENTE"), rs.getString("CPF_CLIENTE"), rs.getString("TELEFONE_CLIENTE"), rs.getString("EMAIL_CLIENTE")});
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public ArrayList pesquisaTabelaCliente(String nome) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        ArrayList lista = new ArrayList();

        String sql = "SELECT ID_CLIENTE,NOME_CLIENTE,CPF_CLIENTE,TELEFONE_CLIENTE,EMAIL_CLIENTE FROM CLIENTE  WHERE NOME_CLIENTE LIKE '%" + nome + "%'";

        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Object[]{rs.getInt("ID_CLIENTE"), rs.getString("NOME_CLIENTE"), rs.getString("CPF_CLIENTE"), rs.getString("TELEFONE_CLIENTE"), rs.getString("EMAIL_CLIENTE")});
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public Paciente get(Integer id) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        Paciente p = null;

        String sql = "SELECT ID_CLIENTE,NOME_CLIENTE,CPF_CLIENTE,TELEFONE_CLIENTE,EMAIL_CLIENTE FROM CLIENTE WHERE ID_CLIENTE =?";

        try {
            PreparedStatement pstm = co.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                p = new Paciente();
                p.setId(rs.getInt("ID_CLIENTE"));
                p.setNome(rs.getString("NOME_CLIENTE"));
                p.setCpf(rs.getString("CPF_CLIENTE"));
                p.setTelefone(rs.getString("TELEFONE_CLIENTE"));
                p.setEmail(rs.getString("EMAIL_CLIENTE"));
            }
            return p;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public Paciente consultar(String cpf) throws ConexaoException, DAOException {
        Connection co = g.conectar();
        Paciente p = null;

        String sql;
        sql = "SELECT ID_CLIENTE,NOME_CLIENTE,CPF_CLIENTE,TELEFONE_CLIENTE,EMAIL_CLIENTE FROM CLIENTE WHERE CPF_CLIENTE LIKE ?";

        try {
            PreparedStatement pstm = co.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                p = new Paciente();
                p.setId(rs.getInt("ID_CLIENTE"));
                p.setNome(rs.getString("NOME_CLIENTE"));
                p.setCpf(rs.getString("CPF_CLIENTE"));
                p.setTelefone(rs.getString("TELEFONE_CLIENTE"));
                p.setEmail(rs.getString("EMAIL_CLIENTE"));
            }
            return p;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(co);
        }
    }

    @Override
    public void incluir(Paciente p) throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Paciente p) throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList pesquisaTabelaPaciente(String nome) throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

