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
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.ItemVenda;
import model.Produto;

public class ItemVendaDAO {
    
    private Connection conn;
    
    public ItemVendaDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastraItem(ItemVenda obj){
        PreparedStatement st = null;
        try {
            st= conn.prepareStatement("insert into tb_itensvendas ( venda_id,produto_id,qtd,subtotal)"
                    + " values (?,?,?,?)");
            
            st.setLong(1,obj.getVenda().getId());
            st.setLong(2,obj.getProduto().getId());
            st.setInt(3,obj.getQtd());
            st.setDouble(4,obj.getSubtotal());
            
            st.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:" +e);
        }finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeConnection(conn);
        }
    }
    public List<ItemVenda> listarItensPorVenda(Long venda_id){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            List<ItemVenda> list = new ArrayList<>();
            st = conn.prepareStatement("select p.descricao,i.qtd,p.preco,i.subtotal from tb_itensvendas i "
                    + "inner join tb_produtos p on (i.produto_id = p.id) where i.venda_id =?");
            st.setLong(1, venda_id);
            
            rs = st.executeQuery();
            while(rs.next()){
                ItemVenda obj = new ItemVenda();
                Produto objp = new Produto();
                
                objp.setDescricao(rs.getString("p.descricao"));
                obj.setQtd(rs.getInt("i.qtd"));
                objp.setPreco(rs.getDouble("p.preco"));
                obj.setSubtotal(rs.getDouble("i.subtotal"));
               
                obj.setProduto(objp);
                
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:" + e);
        }finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
            ConnectionFactory.closeConnection(conn);
        }
        return null;
    }
}
