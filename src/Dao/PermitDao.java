/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Permit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amine Smaki
 */
public class PermitDao {
    BDconnection bd = new BDconnection();

    public boolean ajouter(Permit p) {
        int a = 0;
        String sql = "INSERT INTO `permit` (`NUMPT`, `CATPT`) VALUES (?,?)";
        bd.ouvrirConnection();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(sql);
        try {

            ps.setString(1, p.getNUMPT());
            ps.setString(2, p.getCATPT());

            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        bd.fermerConnection();

        return (a != 0);
    }

    public boolean modifier(String NUMPT, Permit p) {
        int a = 0;
        String req = "UPDATE Permit SET NUMPT=?, CATPT=? WHERE NUMPT=?";

        bd.ouvrirConnection();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(req);
        try {
            ps.setString(1, p.getNUMPT());
            ps.setString(2, p.getCATPT());
            ps.setString(3, NUMPT);


            a = ps.executeUpdate();

            bd.fermerConnection();


        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a != 0;
    }


    public ArrayList<Permit> Lister() {
        String sql = "SELECT * FROM `permit`";
        bd.ouvrirConnection();
        ArrayList<Permit> Permits = new ArrayList<Permit>();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(sql);

        try {
            //ps.setString(1,v);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String NUMPT = rs.getString(1);
                String CATPT = rs.getString(2);

                Permit de = new Permit(NUMPT, CATPT);
                Permits.add(de);

            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Permits;
    }

    public List<Permit> ListerP(String cle) throws SQLException {
        String sql = "SELECT * FROM permit WHERE NUMPT=?";
        List<Permit> ma = new ArrayList<Permit>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Permit t = new Permit(rs.getString(1), rs.getString(2));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public boolean supprimer(String c) {
        int a = 0;
        String req = "DELETE FROM permit WHERE NUMPT=?";

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
}

