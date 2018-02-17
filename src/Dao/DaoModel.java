/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Marque;
import Model.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
public class DaoModel {
    BDconnection bd = new BDconnection();

    public boolean ajouterModel(Model m) {
        int a = 0;
        String sql = "INSERT INTO model(IDMODEL, IDMARQUE, NOMMODEL, ANNEEMODEL) VALUES(?,?,?,?)";
        bd.ouvrirConnection();
        PreparedStatement ps;
        try {
            ps = bd.preparerRequette(sql);
            ps.setString(1, m.getIdModel());
            ps.setString(2, m.getIdMarque());
            ps.setString(3, m.getNomModel());
            ps.setString(4, m.getAnnee());
            a = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        bd.fermerConnection();
        return (a != 0);
    }

    public boolean supModel(String id) {
        int a = 0;
        String sql = "DELETE FROM model WHERE IDMODEL=?";
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

    public boolean ModModel(String id, Model m) {
        int a = 0;
        String sql = "UPDATE model SET IDMODEL=?,IDMARQUE=?,NOMMODEL=?,ANNEEMODEL=? WHERE  IDMODEL=?";
        bd.ouvrirConnection();
        PreparedStatement ps;
        try {
            ps = bd.preparerRequette(sql);
            ps.setString(1, m.getIdModel());
            ps.setString(2, m.getIdMarque());
            ps.setString(3, m.getNomModel());
            ps.setString(4, m.getAnnee());
            ps.setString(5, id);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("******" + ex.getMessage() + "*****");
        }
        bd.fermerConnection();
        return (a != 0);
    }

    public List<Model> ListerModel() throws SQLException {
        String sql = "SELECT o.IDMODEL, o.IDMARQUE, o.NOMMODEL, o.ANNEEMODEL,m.NOMMARQUE FROM model o,marque m WHERE o.IDMARQUE =m.IDMARQUE";
        List<Model> ma = new ArrayList<Model>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque mp = new Marque(rs.getString(2), rs.getString(5));
            Model t = new Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), mp);
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public List<Model> ListerModel(String cle) throws SQLException {
        String sql = "SELECT o.IDMODEL, o.IDMARQUE, o.NOMMODEL, o.ANNEEMODEL,m.NOMMARQUE FROM model o,marque m WHERE o.IDMARQUE =m.IDMARQUE AND  IDMODEL=?";
        List<Model> ma = new ArrayList<Model>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque mp = new Marque(rs.getString(2), rs.getString(5));
            Model t = new Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), mp);
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public List<Model> ListerModelNom(String cle) throws SQLException {
        String sql = "SELECT o.IDMODEL, o.IDMARQUE, o.NOMMODEL, o.ANNEEMODEL,m.NOMMARQUE FROM model o,marque m WHERE o.IDMARQUE =m.IDMARQUE And NOMMODEL LIKE ?";
        List<Model> m = new ArrayList<Model>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, "%" + cle + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque a = new Marque(rs.getString(2), rs.getString(5));
            Model t = new Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), a);
            m.add(t);
        }
        bd.fermerConnection();
        return m;
    }

    public List<Model> ListerModeMarque(String cle) throws SQLException {
        String sql = "SELECT o.IDMODEL, o.IDMARQUE, o.NOMMODEL, o.ANNEEMODEL,m.NOMMARQUE FROM model o,marque m WHERE o.IDMARQUE =m.IDMARQUE And m.NOMMARQUE LIKE ?";
        List<Model> m = new ArrayList<Model>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, "%" + cle + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque a = new Marque(rs.getString(2), rs.getString(5));
            Model t = new Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), a);
            m.add(t);
        }
        bd.fermerConnection();
        return m;
    }

    public String dernier() throws SQLException {
        String sql = "select max(IDMODEL) FROM model ";
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
