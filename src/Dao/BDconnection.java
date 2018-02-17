
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDconnection {
    //gestionlocation
    public String user = "root", pw = "", url = "jdbc:mysql://localhost:3306/ayoub";
    Connection con = null;
    PreparedStatement ps = null;

    public void ouvrirConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pw);
        } catch (ClassNotFoundException exp) {
            System.out.println(exp);
        } catch (SQLException sqlExp) {
            System.out.println(sqlExp);
        } finally {
        }
    }

    PreparedStatement preparerRequette(String req) {
        try {
            ps = con.prepareStatement(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ps;
    }

    public void fermerConnection() {
        try {
            con.close();
        } catch (SQLException sqlExp) {
            System.out.println(sqlExp);
        } finally {

        }
    }

}