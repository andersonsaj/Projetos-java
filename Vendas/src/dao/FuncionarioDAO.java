/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gui.FrmLogin;
import gui.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Funcionario;
import model.WebServiceCep;

public class FuncionarioDAO {

    private Connection conn;

    public FuncionarioDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void cadastrarFuncionario(Funcionario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,"
                    + "endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, obj.getNome());
            st.setString(2, obj.getRg());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getSenha());
            st.setString(6, obj.getCargo());
            st.setString(7, obj.getNivelAcesso());
            st.setString(8, obj.getTel());
            st.setString(9, obj.getCel());
            st.setString(10, obj.getCep());
            st.setString(11, obj.getEndereco());
            st.setInt(12, obj.getNumero());
            st.setString(13, obj.getComplemento());
            st.setString(14, obj.getBairro());
            st.setString(15, obj.getCidade());
            st.setString(16, obj.getUf());

            st.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }
    }

    public void alterarFuncionario(Funcionario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,"
                    + "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?");
            st.setString(1, obj.getNome());
            st.setString(2, obj.getRg());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getSenha());
            st.setString(6, obj.getCargo());
            st.setString(7, obj.getNivelAcesso());
            st.setString(8, obj.getTel());
            st.setString(9, obj.getCel());
            st.setString(10, obj.getCep());
            st.setString(11, obj.getEndereco());
            st.setInt(12, obj.getNumero());
            st.setString(13, obj.getComplemento());
            st.setString(14, obj.getBairro());
            st.setString(15, obj.getCidade());
            st.setString(16, obj.getUf());

            st.setLong(17, obj.getId());
            st.execute();
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }

    }

    private Funcionario instFuncionario(ResultSet rs) throws SQLException {
        Funcionario obj = new Funcionario();
        obj.setId(rs.getLong("id"));
        obj.setNome(rs.getString("nome"));
        obj.setRg(rs.getString("rg"));
        obj.setCpf(rs.getString("cpf"));
        obj.setEmail(rs.getString("email"));
        obj.setSenha(rs.getString("senha"));
        obj.setCargo(rs.getString("cargo"));
        obj.setNivelAcesso(rs.getString("nivel_acesso"));
        obj.setTel(rs.getString("telefone"));
        obj.setCel(rs.getString("celular"));
        obj.setCep(rs.getString("cep"));
        obj.setEndereco(rs.getString("endereco"));
        obj.setNumero(rs.getInt("numero"));
        obj.setComplemento(rs.getString("complemento"));
        obj.setBairro(rs.getString("bairro"));
        obj.setCidade(rs.getString("cidade"));
        obj.setUf(rs.getString("estado"));
        return obj;
    }

    public void excluirFuncionario(Funcionario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("delete from tb_funcionarios where id=? ");
            st.setLong(1, obj.getId());

            st.execute();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }

    }

    public java.util.List<Funcionario> listarFuncionarios() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            java.util.List<Funcionario> lista = new ArrayList();

            st = conn.prepareStatement("select * from tb_funcionarios");
            rs = st.executeQuery();

            while (rs.next()) {
                Funcionario obj = instFuncionario(rs);

                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
            //return null;
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }

    public Funcionario consultaPorNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from tb_funcionarios where nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                Funcionario obj = instFuncionario(rs);
                return obj;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }

    public java.util.List<Funcionario> buscaFuncionarioPorNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            java.util.List<Funcionario> lista = new ArrayList();

            st = conn.prepareStatement("select * from tb_funcionarios where nome like ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            while (rs.next()) {
                Funcionario obj = instFuncionario(rs);
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
            //return null;
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }

    public Funcionario buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Funcionario obj = new Funcionario();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }
    }

    public void efetuaLogin(String email, String senha) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select* from tb_funcionarios where email =? and senha=?");
            st.setString(1, email);
            st.setString(2, senha);

            rs = st.executeQuery();

            if (rs.next()) {
                if (rs.getString("nivel_acesso").equals("Administrador")) {
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                    FrmMenu tela = new FrmMenu();
                    tela.setUsuario(rs.getString("nome"));
                    tela.setVisible(true);
                } else if (rs.getString("nivel_acesso").equals("Usuário")) {
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                    FrmMenu tela = new FrmMenu();
                    tela.setUsuario(rs.getString("nome"));
                    //Desabilitrar os menus
                    tela.menuPosicao.setEnabled(false);
                    tela.menuControleVendas.setVisible(false);
                    tela.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos");
                new FrmLogin().setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }
}
