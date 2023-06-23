/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package petshopdocarmino;
import Controller.LoginDAO;
import modelos.LoginModel;

/**
 *
 * @author conta
 */
public class PetShopDoCarmino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        //Rolou isso na aula ao vivo
/*      login janela = new login();
        janela.setVisible(true);
*/

        LoginDAO testelogin = new LoginDAO();
        LoginModel login = new LoginModel();
        login.setUsername("Daniel");
        login.setSenha("123");
        
        if (testelogin.Logar(login) ) {
            System.out.println("Dados Corretos");
        }else {
            System.out.println("Dados Incorretos");
        }

    }
    
}
