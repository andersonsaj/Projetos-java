/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Fornecedor;
import model.Produto;

public class ProdutoDAO {

    private Connection conn;

    public ProdutoDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void cadastrarProduto(Produto obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into tb_produtos (descricao,preco,qtd_estoque,for_id)"
                    + " values(?,?,?,?) ");

            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQtdEstoque());
            st.setLong(4, obj.getFornecedor().getId());

            st.execute();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }
    }

    public void alterarProduto(Produto obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("update tb_produtos set descricao=?,preco=?,qtd_estoque=?,for_id=? where id=?");

            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQtdEstoque());
            st.setLong(4, obj.getFornecedor().getId());
            st.setLong(5, obj.getId());
            st.execute();
            JOptionPane.showMessageDialog(null, "Produto atualizado com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }
    }

    public void excluirProduto(Produto obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("delete from tb_produtos where id=?");
            st.setLong(1, obj.getId());
            st.execute();
            JOptionPane.showMessageDialog(null, "Produto excluído com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        }
    }

    private Produto instProduto(ResultSet rs) throws SQLException {
        Produto obj = new Produto();
        obj.setId(rs.getLong("p.id"));
        obj.setDescricao(rs.getString("p.descricao"));
        obj.setPreco(rs.getDouble("p.preco"));
        obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));

        return obj;
    }

    public java.util.List<Produto> listarProduto() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            java.util.List<Produto> list = new ArrayList<>();
            st = conn.prepareStatement("select p.id,p.descricao,p.preco,p.qtd_estoque"
                    + ",f.nome from tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id)");
            rs = st.executeQuery();
            while (rs.next()) {
                Produto obj = instProduto(rs);
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }

    public java.util.List<Produto> buscaProdutoPorNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            java.util.List<Produto> list = new ArrayList<>();
            st = conn.prepareStatement("select p.id,p.descricao,p.preco,p.qtd_estoque"
                    + ",f.nome from tb_produtos as p inner join tb_fornecedores as f "
                    + "on (p.for_id = f.id) where p.descricao like ?");
            st.setString(1, nome);
            rs = st.executeQuery();
            while (rs.next()) {
                Produto obj = instProduto(rs);
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }

    public Produto consultaProdutoPorNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("select p.id,p.descricao,p.preco,p.qtd_estoque"
                    + ",f.nome from tb_produtos as p inner join tb_fornecedores as f "
                    + "on (p.for_id = f.id) where p.descricao = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            Produto obj = new Produto();
            Fornecedor f = new Fornecedor();
            if (rs.next()) {
                obj = instProduto(rs);
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);

            }
            return obj;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }

    public Produto consultaProdutoPorCodigo(int cod) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("select * from tb_produtos as p where p.id = ?");
            st.setInt(1, cod);
            rs = st.executeQuery();

            Produto obj = new Produto();

            if (rs.next()) {
                obj = instProduto(rs);
            }
            return obj;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }
    
    public void baixaEstoque(Long id, int qtd_atualizada){
        PreparedStatement st = null;
        try {
            st =conn.prepareStatement("update tb_produtos set qtd_estoque = ? where id=?");
            st.setInt(1, qtd_atualizada );
            st.setLong(2,id);
            
            st.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }finally{
            ConnectionFactory.closeStatement(st);
         //   ConnectionFactory.closeConnection(conn);
        }
    }
    public int retornaEstoqueAtual(Long id){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            int qtd_estoque = 0;
            st = conn.prepareStatement("select qtd_estoque from tb_produtos where id = ?");
            st.setLong(1, id);
            
            rs = st.executeQuery();
            if(rs.next()){
                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
            return qtd_estoque;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
          //  ConnectionFactory.closeConnection(conn);
        }
    }
}
