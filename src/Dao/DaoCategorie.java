/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Categorie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author soufyane
 */
public class DaoCategorie {
    BDconnection bd = new BDconnection();
    PreparedStatement ps = null;

    public boolean ajouterCa(Categorie ca) {
        int a = 0;
        String req = "INSERT INTO categorie(IDCAT,NOMCAT) VALUES(?,?)";
        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);
        try {
            ps.setInt(1, ca.getIdCat());
            ps.setString(2, ca.getNomCat());
            a = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean modifierCa(int cle, Categorie ca) {
        int a = 0;
        String req = "UPDATE  categorie SET IDCAT=?,NOMCAT=? WHERE IDCAT=?";
        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);
        try {
            ps.setInt(1, ca.getIdCat());
            ps.setString(2, ca.getNomCat());
            ps.setInt(3, cle);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean supprimer(int cle) {
        int a = 0;
        String req = "DELETE FROM categorie WHERE IDCAT=?";
        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);
        try {
            ps.setInt(1, cle);
            a = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public List<Categorie> lister() {
        List<Categorie> ls = null;
        try {
            String sql = "SELECT * FROM categorie  ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Categorie>();
            while (rs.next()) {
                rs.getString(1);
                Categorie ca = new Categorie(rs.getInt(1), rs.getString(2));
                ls.add(ca);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Categorie> listerIdCat(String cle) {
        List<Categorie> ls = null;
        try {
            String sql = "SELECT * FROM categorie  WHERE  IDCAT=?";
            bd.ouvrirConnection();
            PreparedStatement ps;

            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Categorie>();
            while (rs.next()) {
                rs.getString(1);
                Categorie ca = new Categorie(rs.getInt(1), rs.getString(2));
                ls.add(ca);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Categorie> ListerNomCat(String cle) {
        List<Categorie> ls = null;

        try {
            String sql = "SELECT * FROM `categorie` WHERE NOMCAT LIKE ?";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Categorie>();
            while (rs.next()) {
                Categorie ca = new Categorie(rs.getInt(1), rs.getString(2));
                ls.add(ca);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public String dernier() throws SQLException {
        String sql = "select max(IDCAT) FROM categorie ";
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

