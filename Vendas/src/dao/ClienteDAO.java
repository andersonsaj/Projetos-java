/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cliente;
import java.sql.Connection;
import jdbc.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import model.WebServiceCep;


/**
 *
 * @author Acer
 */
public class ClienteDAO {
    private Connection conn;
    
    public ClienteDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    public void cadastrarCliente(Cliente obj){
        PreparedStatement st = null;
        try{
          st= conn.prepareStatement( "insert tb_clientes (nome,rg,cpf,email,telefone,celular,cep," +
                  "endereco,numero,complemento,bairro,cidade,estado) " +
                  "values(?,?,?,?,?,?,?,?,?,?,?,?,? )");
          st.setString(1, obj.getNome());
          st.setString(2, obj.getRg());
          st.setString(3, obj.getCpf());
          st.setString(4, obj.getEmail());
          st.setString(5, obj.getTel());
          st.setString(6, obj.getCel());
          st.setString(7, obj.getCep());
          st.setString(8, obj.getEndereco());
          st.setInt(9, obj.getNumero());
          st.setString(10, obj.getComplemento());
          st.setString(11, obj.getBairro());
          st.setString(12, obj.getCidade());
          st.setString(13, obj.getUf());
       
          st.execute();
          JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                  
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }
    }
    
    public void alterarCliente(Cliente obj){
                PreparedStatement st = null;
        try{
          st= conn.prepareStatement( "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?," +
                  "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?");
          st.setString(1, obj.getNome());
          st.setString(2, obj.getRg());
          st.setString(3, obj.getCpf());
          st.setString(4, obj.getEmail());
          st.setString(5, obj.getTel());
          st.setString(6, obj.getCel());
          st.setString(7, obj.getCep());
          st.setString(8, obj.getEndereco());
          st.setInt(9, obj.getNumero());
          st.setString(10, obj.getComplemento());
          st.setString(11, obj.getBairro());
          st.setString(12, obj.getCidade());
          st.setString(13, obj.getUf());
          
          st.setLong(14, obj.getId());
          st.execute();
          JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                  
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }
        
    }
    
    public void excluirCliente(Cliente obj){
                PreparedStatement st = null;
        try{
          st= conn.prepareStatement( "delete from tb_clientes where id=? ");
          st.setLong(1, obj.getId());
   
          st.execute();
          JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
                  
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }
        
        
    }
    private Cliente instCliente(ResultSet rs) throws SQLException{
          Cliente obj = new Cliente();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setRg(rs.getString("rg"));
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));
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
    public java.util.List<Cliente> listarClientes(){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            java.util.List<Cliente> lista = new ArrayList();
            
            st= conn.prepareStatement("select * from tb_clientes");
            rs = st.executeQuery();
            
            while(rs.next()){
                Cliente obj = instCliente(rs);
                lista.add(obj);
            }
            return lista;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro:" + e);
            //return null;
        }
        finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }
    public Cliente consultaPorNome(String nome){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from tb_clientes where nome = ?");
            st.setString(1, nome);
            rs= st.executeQuery();
            
            if(rs.next()){
                Cliente obj = instCliente(rs);
                return obj;
            }
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
        finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }
    public java.util.List<Cliente> buscaClientePorNome(String nome){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            java.util.List<Cliente> lista = new ArrayList();
            
            st= conn.prepareStatement("select * from tb_clientes where nome like ?");
            st.setString(1, nome);
            rs = st.executeQuery();
            
            while(rs.next()){
                Cliente obj = instCliente(rs);
                lista.add(obj);
            }
            return lista;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro:" + e);
            //return null;
        }
        finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }
    public Cliente consultaPorCpf(String cpf){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from tb_clientes where cpf = ?");
            st.setString(1, cpf);
            rs= st.executeQuery();
            
            if(rs.next()){
                Cliente obj = instCliente(rs);
                return obj;
            }
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
        finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }
  
      public Cliente buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Cliente obj = new Cliente();

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
}
