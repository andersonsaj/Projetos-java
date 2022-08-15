/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Venda;
import java.util.List;
import model.Cliente;
public class VendaDAO {
    
    private Connection conn;
    
    public VendaDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    public void cadastraVenda(Venda obj){
                PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into tb_vendas (cliente_id,data_venda,total_venda,Observacoes)"
                    + " values(?,?,?,?) ");

            st.setLong(1, obj.getCliente().getId());
            st.setTimestamp(2, new java.sql.Timestamp( obj.getDataVenda().getTime()));
            st.setDouble(3, obj.getTotalVenda());
            st.setString(4, obj.getObs());

            st.execute();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        } finally {
            ConnectionFactory.closeStatement(st);
          //  ConnectionFactory.closeConnection(conn);
        }
    }
    public Long retornaUltimaVenda(){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Long idvenda = null;
            st = conn.prepareStatement("select max(id) id from tb_vendas");
            rs= st.executeQuery();

            if(rs.next()){
                Venda venda = new Venda();
                venda.setId(rs.getLong("id"));
                idvenda = venda.getId();
            }
            return idvenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    }
    public List<Venda> listarHistoricoVendas(String dataInicial, String dataFim){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            List<Venda> list = new ArrayList<>();
            st = conn.prepareStatement("select v.id, v.data_venda,c.nome,v.total_venda,v.observacoes from tb_vendas v "
                    + "inner join tb_clientes c on (v.cliente_id = c.id) where v.data_venda BETWEEN ? and ?");
            st.setString(1, dataInicial);
            st.setString(2, dataFim);
            
            rs = st.executeQuery();
            while(rs.next()){
                Venda obj = new Venda();
                Cliente objc = new Cliente();
                
                obj.setId(rs.getLong("v.id"));
                obj.setDataVenda(new java.util.Date(rs.getTimestamp("v.data_venda").getTime()));
                objc.setNome(rs.getString("c.nome"));
                obj.setTotalVenda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("v.observacoes"));
                obj.setCliente(objc);
                
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
    public double retornaTotalVendaPorData(String data_venda){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            double totalVenda = 0.0;
            st = conn.prepareStatement("select sum(total_venda) as total from tb_vendas where data_venda like ?");
            
            st.setString(1,data_venda);
            rs= st.executeQuery();

            if(rs.next()){
                totalVenda = rs.getDouble("total");
            }
            return totalVenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    }
}
