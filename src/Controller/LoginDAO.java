/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Conexao.ConnectionFactory;
import modelos.LoginModel;
import java.sql.*;

/**
 *
 * @author conta
 */
public class LoginDAO {
    public boolean Logar(LoginModel login) throws Exception {
        String sql = "Select * From login where username = '" + login.getUsername() + "'";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Boolean retorno = false;
        try{
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery(sql);
            
            if (rset.next()){
                //exite no meu BD
                if (rset.getString("senha").equals(login.getSenha())){
                retorno = true;
                }
            }else {
                // não existe no BD
                retorno = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (rset != null){
                    rset.close();
                }
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return retorno;
    }
}
