/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import modelos.Servicos;
import Conexao.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import petshopdocarmino.TelaSeevicos;

/**
 *
 * @author conta
 */
public class ServicosDAO {    

    public void create(Servicos s) throws Exception{
        
        Connection con = Conexao.ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
        stmt = con.prepareStatement("INSERT INTO servicos(nomeServico,quantidadeServico,precoServico) VALUES(?,?,?)");
        stmt.setString(1, s.getNomeServico());
        stmt.setInt(2, s.getQuantidadeServico());
        stmt.setDouble(3, s.getPrecoServico());
        
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo Com Sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar!"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }

    }
    
    
    public List<Servicos> read() throws Exception{
        
        Connection con = Conexao.ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Servicos> servicos = new ArrayList<>();
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM servicos");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Servicos servico = new Servicos();
                
                servico.setIdServico(rs.getInt("idServico"));
                servico.setNomeServico(rs.getString("nomeServico"));
                servico.setQuantidadeServico(rs.getInt("quantidadeServico"));
                servico.setPrecoServico(rs.getDouble("precoServico"));
                servicos.add(servico);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return servicos;
        
    }
    
    
    
    
    
    
    
    
    public void update(Servicos s) throws Exception{
        
        Connection con = Conexao.ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        //ResultSet rs = null;

        try{
        stmt = con.prepareStatement("UPDATE servicos SET nomeServico = ?,quantidadeServico = ?,precoServico = ? WHERE idServico = ?");
        stmt.setString(1, s.getNomeServico());
        stmt.setInt(2, s.getQuantidadeServico());
        stmt.setDouble(3, s.getPrecoServico());
        stmt.setInt(4, s.getIdServico());
        
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!"+ex);
        }finally{
            //ConnectionFactory.closeConnection(con,stmt);
        }

    }
    
    
    public void delete (Servicos s) throws Exception{
        
        Connection con = Conexao.ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        //ResultSet rs = null;

        try{
        stmt = con.prepareStatement("DELETE FROM servicos WHERE idServico = ?");
        stmt.setInt(1, s.getIdServico());
        
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Excluido Com Sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir!"+ex);
        }finally{
            //ConnectionFactory.closeConnection(con,stmt);
        }

    }

    
    
    
    

    
    
    
    
    
}
