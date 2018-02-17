/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Model.Facture;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFacture {
    BDconnection bd = new BDconnection();
    PreparedStatement ps = null;

    public boolean ajouteFact(Facture fact) {
        int b = 0;

        String req2 = "INSERT INTO facture(IDFACT,IDCONT,DATEFACT,MONTAFATCT) VALUES (?,?,?,?)";
        bd.ouvrirConnection();
        ps = bd.preparerRequette(req2);
        try {

            ps.setString(1, fact.getIdfact());
            ps.setString(2, fact.getIdcont());
            ps.setString(3, fact.getDate());
            ps.setString(4, fact.getMontafatct());


            b = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }


        bd.fermerConnection();
        return b != 0;
    }

    public boolean modifierVh(String faca, Facture fac) {
        int a = 0;
        String req = "UPDATE facture SET IDFACT=?,IDCONT=?,DATEFACT=?,MONTAFATCT=?  WHERE IDFACT=?";

        bd.ouvrirConnection();

        ps = bd.preparerRequette(req);
        try {
            ps.setString(1, fac.getIdfact());
            ps.setString(2, fac.getIdcont());
            ps.setString(3, fac.getDate());
            ps.setString(4, fac.getMontafatct());
            ps.setString(5, faca);

            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean supprimer(String cle) {
        int a = 0;
        String req = "DELETE FROM facture WHERE IDFACT=?";

        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);

        try {
            ps.setString(1, cle);
            a = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }

        bd.fermerConnection();
        return a != 0;
    }


    public List<Facture> ListerTou() {
        List<Facture> ls = null;
        try {
            String sql = "SELECT * FROM facture ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Facture>();
            while (rs.next()) {
                rs.getString(1);
                Facture art = new Facture(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                ls.add(art);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Facture> Listerp(String cle) {
        List<Facture> ls = null;
        try {
            String sql = "SELECT * FROM facture  WHERE IDFACT=?";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Facture>();
            while (rs.next()) {
                rs.getString(1);
                Facture art = new Facture(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                ls.add(art);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

}
