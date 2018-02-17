/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.user;
import View.Choix;
import ViewUser.Choix1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Amine Smaki
 */
public class UserDao {
    BDconnection bd = new BDconnection();

    DaoRevsion r = new DaoRevsion();
    Date d = new Date();

    public boolean VerifierUser(String Un, String Pass) {

        String sql = "SELECT `IDUTIL`, `NONUTIL`, `PASSUTIL`,`ROLE` FROM `UTILSATEUR` WHERE NONUTIL='" + Un + "' and PASSUTIL='" + Pass + "'";

        boolean IsValid = false;
        bd.ouvrirConnection();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                IsValid = true;
                String role = rs.getString("ROLE");
                if (role.equals("Admin")) {
                    try {
                        r.listerpan(d);
                    } catch (Exception e) {
                        System.err.println(e);
                    }

                    Choix b = new Choix();
                    b.setVisible(true);
                    Choix.Admin.setText(rs.getString(2));
                    Choix.jLabel3.setText(rs.getString(1));

                } else {
                    try {
                        r.listerpan(d);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    Choix1 n = new Choix1();
                    n.setVisible(true);
                    Choix1.jLabel1.setText(rs.getString(1));
                    Choix1.jLabel4.setText(rs.getString(2));
                }
            }
        } catch (Exception ex) {
        } finally {
            bd.fermerConnection();
        }
        return IsValid;
    }


    public boolean ajouter(user U) {
        int a = 0;
        String sql = "INSERT INTO `utilsateur` (`IDUTIL`, `NONUTIL`, `PASSUTIL`, `ROLE`) VALUES (?,?,?,?)";
        bd.ouvrirConnection();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(sql);
        try {
            ps.setString(1, U.getIDUTIL());
            ps.setString(2, U.getNONUTIL());
            ps.setString(3, U.getPASSUTIL());
            ps.setString(4, U.getROLE());
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        bd.fermerConnection();

        return (a != 0);
    }

    public ArrayList<user> Lister() {
        String sql = "SELECT * FROM `utilsateur`";
        bd.ouvrirConnection();
        ArrayList<user> users = new ArrayList<user>();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(sql);

        try {
            //ps.setString(1,v);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String IDUTIL = rs.getString(1);
                String NONUTIL = rs.getString(2);
                String PASSUTIL = rs.getString(3);
                String ROLE = rs.getString(4);
                user de = new user(IDUTIL, NONUTIL, PASSUTIL, ROLE);
                users.add(de);

            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }

    public List<user> ListerP(String cle) throws SQLException {
        String sql = "SELECT * FROM utilsateur WHERE IDUTIL=?";
        List<user> ma = new ArrayList<user>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user t = new user(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public List<user> ListerN(String cle) throws SQLException {
        String sql = "SELECT * FROM utilsateur WHERE NONUTIL=?";
        List<user> ma = new ArrayList<user>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user t = new user(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public List<user> ListerR(String cle) throws SQLException {
        String sql = "SELECT * FROM utilsateur WHERE ROLE=?";
        List<user> ma = new ArrayList<user>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user t = new user(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public boolean supprimer(String c) {
        int a = 0;
        String req = "DELETE FROM utilsateur WHERE IDUTIL=?";

        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(req);

        try {
            ps.setString(1, c);
            a = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        bd.fermerConnection();

        return a != 0;
    }

    public boolean modifier(String IDUTIL, user u) {
        int a = 0;
        String req = "UPDATE UTILSATEUR SET IDUTIL=?, NONUTIL=?,PASSUTIL=?,ROLE=? WHERE IDUTIL=?";

        bd.ouvrirConnection();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(req);
        try {
            ps.setString(1, u.getIDUTIL());
            ps.setString(2, u.getNONUTIL());
            ps.setString(3, u.getPASSUTIL());
            ps.setString(4, u.getROLE());
            ps.setString(5, IDUTIL);


            a = ps.executeUpdate();

            bd.fermerConnection();


        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a != 0;
    }

}
