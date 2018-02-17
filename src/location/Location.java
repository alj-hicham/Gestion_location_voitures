/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package location;

import View.Login;


/**
 * @author Amine Smaki
 */
public class Location {
    public Location() throws Exception {
        super();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //Conex conn=new Conex();
        // MySqlConnection conn=new MySqlConnection();
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);


    }
}