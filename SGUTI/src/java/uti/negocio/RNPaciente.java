
import java.util.ArrayList;
import uti.negocio.basica.Paciente;

public class RNPaciente {

    private final PacienteDAO dao;
    private Paciente p;

    public RNPaciente() {
        dao = new PacienteDAOImpl();
    }

    public ArrayList preencheTabela() throws ListaException {
        try {
            return dao.listarTabela();
        } catch (DAOException e) {
            throw new ListaException("Erro de SQL");
        } catch (ConexaoException e) {
            throw new ListaException("Erro de BD");
        }
    }

    /**
     * Verifica se todos os campos importantes foram preenchidos
     *
     * @param p Objeto contendo todos os valores informados
     * @throws CampoVazioException Caso algum campo esteja vazio
     */
    public void verificaPreenchimentoPaciente(Paciente p) throws CampoVazioException {
        //verifica preenchimento
        if (p.getNome() == null || p.getNome().trim().isEmpty()) {
            throw new CampoVazioException("Nome vazio");
        }
        if (p.getCpf() == null || p.getCpf().trim().isEmpty()) {
            throw new CampoVazioException("Cpf vazio");
        }
        if (p.getTelefone() == null || p.getTelefone().isEmpty()) {
            throw new CampoVazioException("Telefone invalido");
        }
        if (p.getEmail() == null || p.getEmail().isEmpty()) {
            throw new CampoVazioException("Email inválido");
        }
    }

    public void validaValoresPaciente(Paciente p) throws DadoInvalidoException {
        //valida valores (regras)
        if (p.getNome().length() < 3 || p.getNome().contains("  ")) {
            throw new DadoInvalidoException("erro nome");
        }
        if (p.getNome().indexOf(" ") == 0 || p.getNome().lastIndexOf(" ") == p.getNome().length()) {
            throw new DadoInvalidoException("erro nome");
        }
        if (p.getCpf().length() != 11 || p.getCpf().contains(" ")) {
            throw new DadoInvalidoException("erro cpf");
        }
        if (p.getTelefone().length() < 3 || p.getTelefone().contains("  ")) {
            throw new DadoInvalidoException("erro telefone");
        }
        if (p.getTelefone().indexOf(" ") == 0 || p.getTelefone().lastIndexOf(" ") == p.getTelefone().length()) {
            throw new DadoInvalidoException("erro telefone");
        }
        if (p.getEmail().length() < 3 || p.getEmail().contains("  ")) {
            throw new DadoInvalidoException("erro email");
        }
        if (p.getEmail().indexOf(" ") == 0 || p.getTelefone().lastIndexOf(" ") == p.getTelefone().length()) {
            throw new DadoInvalidoException("erro email");
        }
    }

    public void verificaDuplicacaoPaciente(Paciente p) throws DadoDuplicadoException, VerificaDuplicacaoException {
        //checa duplicacao no bd
        try {
            Paciente x = dao.consultar(p.getCpf());
            if (x != null) {
                throw new DadoDuplicadoException("Já existe um paciente cadastrado nesse CPF!");
            }
        } catch (DAOException e) {
            throw new VerificaDuplicacaoException("Erro de SQLLL");
        } catch (ConexaoException e) {
            throw new VerificaDuplicacaoException("Erro de BD");
        }
    }

    /**
     *
     * @param p
     * @throws GravaException
     */
    public void gravaPaciente(Paciente p) throws GravaException {
        try {
            dao.incluir(p);
        } catch (DAOException e) {
            throw new GravaException("Erro de SQL grava");
        } catch (ConexaoException e) {
            throw new GravaException("Erro de BD");
        }
    }
    
    public void editaPaciente(Paciente p) throws EditaException {
        try {
            dao.alterar(p);
        } catch (DAOException e) {
            throw new EditaException("Erro de SQL edita");
        } catch (ConexaoException e) {
            throw new EditaException("Erro de BD");
        }
    }

    public void excluirPaciente(Integer cod_paciente) throws ExcluirException {
        try {
            dao.excluir(cod_paciente);
        } catch (DAOException e) {
            throw new ExcluirException("erro de SQL");
        } catch (ConexaoException e) {
            throw new ExcluirException("erro de BD");
        }
    }

    public ArrayList pesquisaTabelaPaciente(String nome) throws PesquisaException {
        try {
            return dao.pesquisaTabelaPaciente(nome);
        } catch (ConexaoException ex) {
            throw new PesquisaException("erro do kapeta666");
        } catch (DAOException ex) {
            throw new PesquisaException("erro do kapeta666!");
        }
        
    }

}