/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import jdbc.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Fornecedor;
import model.WebServiceCep;


/**
 *
 * @author Acer
 */
public class FornecedorDAO {
    private Connection conn;
    
    public FornecedorDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    public void cadastrarFornecedor(Fornecedor obj){
        PreparedStatement st = null;
        try{
          st= conn.prepareStatement( "insert tb_fornecedores (nome,cnpj,email,telefone,celular,cep," +
                  "endereco,numero,complemento,bairro,cidade,estado) " +
                  "values(?,?,?,?,?,?,?,?,?,?,?,? )");
          st.setString(1, obj.getNome());
          st.setString(2, obj.getCnpj());
          st.setString(3, obj.getEmail());
          st.setString(4, obj.getTel());
          st.setString(5, obj.getCel());
          st.setString(6, obj.getCep());
          st.setString(7, obj.getEndereco());
          st.setInt(8, obj.getNumero());
          st.setString(9, obj.getComplemento());
          st.setString(10, obj.getBairro());
          st.setString(11, obj.getCidade());
          st.setString(12, obj.getUf());
       
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
    
    public void alterarFornecedor(Fornecedor obj){
                PreparedStatement st = null;
        try{
          st= conn.prepareStatement( "update tb_fornecedores set nome=?,cnpj=?,email=?,telefone=?,celular=?,cep=?," +
                  "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?");
          st.setString(1, obj.getNome());
          st.setString(2, obj.getCnpj());
          st.setString(3, obj.getEmail());
          st.setString(4, obj.getTel());
          st.setString(5, obj.getCel());
          st.setString(6, obj.getCep());
          st.setString(7, obj.getEndereco());
          st.setInt(8, obj.getNumero());
          st.setString(9, obj.getComplemento());
          st.setString(10, obj.getBairro());
          st.setString(11, obj.getCidade());
          st.setString(12, obj.getUf());
          
          st.setLong(13, obj.getId());
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
    
    public void excluirFornecedor(Fornecedor obj){
                PreparedStatement st = null;
        try{
          st= conn.prepareStatement( "delete from tb_fornecedores where id=? ");
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
    private Fornecedor instFornecedor(ResultSet rs) throws SQLException{
          Fornecedor obj = new Fornecedor();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCnpj(rs.getString("cnpj"));
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
    public java.util.List<Fornecedor> listarFornecedores(){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            java.util.List<Fornecedor> lista = new ArrayList();
            
            st= conn.prepareStatement("select * from tb_fornecedores");
            rs = st.executeQuery();
            
            while(rs.next()){
                Fornecedor obj = instFornecedor(rs);
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
    public Fornecedor consultaPorNome(String nome){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from tb_fornecedores where nome = ?");
            st.setString(1, nome);
            rs= st.executeQuery();
            
            if(rs.next()){
                Fornecedor obj = instFornecedor(rs);
                return obj;
            }
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
        }
        finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }
    public java.util.List<Fornecedor> buscaFornecedorPorNome(String nome){
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            java.util.List<Fornecedor> lista = new ArrayList();
            
            st= conn.prepareStatement("select * from tb_fornecedores where nome like ?");
            st.setString(1, nome);
            rs = st.executeQuery();
            
            while(rs.next()){
                Fornecedor obj = instFornecedor(rs);
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
      public Fornecedor buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Fornecedor obj = new Fornecedor();

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
