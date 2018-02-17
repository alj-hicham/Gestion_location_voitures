/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Marque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
public class DaoMarque {

    BDconnection bd = new BDconnection();

    public boolean ajouterMarque(Marque m) {
        int a = 0;
        String sql = "INSERT INTO marque(IDMARQUE, NOMMARQUE) VALUES(?,?)";
        bd.ouvrirConnection();
        PreparedStatement ps;
        try {
            ps = bd.preparerRequette(sql);
            ps.setString(1, m.getIdMarque());
            ps.setString(2, m.getNimMarque());
            a = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        bd.fermerConnection();
        return (a != 0);
    }

    public boolean supMarque(String id) {
        int a = 0;
        String sql = "DELETE FROM marque WHERE IDMARQUE=?";
        bd.ouvrirConnection();
        PreparedStatement ps;
        try {
            ps = bd.preparerRequette(sql);
            ps.setString(1, id);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("******" + ex.getMessage() + "*****");
        }
        bd.fermerConnection();
        return (a != 0);
    }

    public boolean ModMarque(String id, Marque m) {
        int a = 0;
        String sql = "UPDATE marque SET NOMMARQUE=? WHERE IDMARQUE=?";
        bd.ouvrirConnection();
        PreparedStatement ps;
        try {
            ps = bd.preparerRequette(sql);
            ps.setString(1, m.getNimMarque());
            ps.setString(2, id);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("******" + ex.getMessage() + "*****");
        }
        bd.fermerConnection();
        return (a != 0);
    }

    public List<Marque> ListerMarque() throws SQLException {
        String sql = "SELECT * FROM marque";
        List<Marque> ma = new ArrayList<Marque>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque t = new Marque(rs.getString(1), rs.getString(2));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public List<Marque> ListerMarque(String cle) throws SQLException {
        String sql = "SELECT * FROM marque WHERE IDMARQUE=?";
        List<Marque> ma = new ArrayList<Marque>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque t = new Marque(rs.getString(1), rs.getString(2));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public List<Marque> ListerMarqueNom(String cle) throws SQLException {
        String sql = "SELECT * FROM marque WHERE NOMMARQUE LIKE ?";
        List<Marque> ma = new ArrayList<Marque>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, "%" + cle + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque t = new Marque(rs.getString(1), rs.getString(2));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public String dernier() throws SQLException {
        String sql = "select max(IDMARQUE) FROM marque ";
        String s = null;
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            s = rs.getString(1);
        }
        bd.fermerConnection();
        return s;
    }
}
