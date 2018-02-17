/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amine Smaki
 */
public class ClientDao {
    BDconnection bd = new BDconnection();
    PreparedStatement ps = null;

    public boolean ajouter(Client c) {
        int a = 0;
        String req = "INSERT INTO `client` (`CIN`, `NUMPT`,`NOMCLI`, `PRENCLI`, `DATENAIS`, `VILLENAIS`, `ADRES`, `TEL1`, `TEL2`, `IMGCLI`) VALUES (?, ?,?, ?, ?, ?,?,?,?,?)";

        bd.ouvrirConnection();

        ps = bd.preparerRequette(req);
        try {
            ps.setString(1, c.getCIN());
            ps.setString(2, c.getNUMPT());
            ps.setString(3, c.getNOMCLI());
            ps.setString(4, c.getPRENCLI());
            ps.setString(5, c.getDATENAIS());
            ps.setString(6, c.getVILLENAIS());
            ps.setString(7, c.getADRES());
            ps.setString(8, c.getTEL1());
            ps.setString(9, c.getTEL2());
            ps.setString(10, c.getIMGCLI());

            a = ps.executeUpdate();

            bd.fermerConnection();


        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a != 0;
    }

    //lister
    public ArrayList<Client> Lister() {
        String sql = "SELECT * FROM `client`";
        bd.ouvrirConnection();
        ArrayList<Client> client = new ArrayList<Client>();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(sql);

        try {
            //ps.setString(1,v);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String CIN = rs.getString(1);
                String NUMPT = rs.getString(2);
                String NOMCLI = rs.getString(3);
                String PRENCLI = rs.getString(4);
                String DATENAIS = rs.getString(5);
                String VILLENAIS = rs.getString(6);
                String ADRES = rs.getString(7);
                String TEL1 = rs.getString(8);
                String TEL2 = rs.getString(9);
                String IMGCLI = rs.getString(10);
                Client r = new Client(CIN, NUMPT, NOMCLI, PRENCLI, DATENAIS, VILLENAIS, ADRES, TEL1, TEL2, IMGCLI);
                client.add(r);

            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return client;
    }

    public List<Client> Listeer() throws SQLException {
        String sql = "SELECT * FROM `client` ";
        List<Client> ma = new ArrayList<Client>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //Client t = new Client(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
            Client t = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(8));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    //lister avec parameter
    public ArrayList<Client> Listter(String a) {
        String sql = "SELECT * FROM `client` where CIN=?";
        bd.ouvrirConnection();
        ArrayList<Client> client = new ArrayList<Client>();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(sql);

        try {
            ps.setString(1, a);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String CIN = rs.getString(1);
                String NUMPT = rs.getString(2);
                String NOMCLI = rs.getString(3);
                String PRENCLI = rs.getString(4);
                String DATENAIS = rs.getString(5);
                String VILLENAIS = rs.getString(6);
                String ADRES = rs.getString(7);
                String TEL1 = rs.getString(8);
                String TEL2 = rs.getString(9);
                String IMGCLI = rs.getString(10);
                Client r = new Client(CIN, NUMPT, NOMCLI, PRENCLI, DATENAIS, VILLENAIS, ADRES, TEL1, TEL2, IMGCLI);
                client.add(r);

            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return client;
    }

    //supprimer
    public boolean supprimer(String c) {
        int a = 0;
        String req = "DELETE FROM client WHERE CIN=?";

        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);

        try {
            ps.setString(1, c);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        bd.fermerConnection();
        return a != 0;
    }

    public boolean supprimerr(String c) {
        int a = 0;
        String req = "DELETE FROM client WHERE CIN=?";

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

    public boolean modifier(String CIN, Client c) {
        int a = 0;
        String req = "UPDATE client SET CIN=?, NUMPT=?, NOMCLI=?, PRENCLI=?, DATENAIS=?, VILLENAIS=?,TEL1=?,TEL2=?,IMGCLI=? WHERE CIN=?";

        bd.ouvrirConnection();

        ps = bd.preparerRequette(req);
        try {
            ps.setString(1, c.getCIN());
            ps.setString(2, c.getNUMPT());
            ps.setString(3, c.getNOMCLI());
            ps.setString(4, c.getPRENCLI());
            ps.setString(5, c.getDATENAIS());
            ps.setString(6, c.getVILLENAIS());
            ps.setString(7, c.getTEL1());
            ps.setString(8, c.getTEL2());
            ps.setString(9, c.getIMGCLI());
            ps.setString(10, CIN);
            a = ps.executeUpdate();

            bd.fermerConnection();


        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a != 0;
    }

    public boolean modifierr(String CIN, Client c) {
        int a = 0;
        String req = "UPDATE client SET CIN=?, NUMPT=?, NOMCLI=?, PRENCLI=?, DATENAIS=?, VILLENAIS=?,TEL1=?,TEL2=?,IMGCLI=? WHERE CIN=?";

        bd.ouvrirConnection();
        PreparedStatement ps = null;
        ps = bd.preparerRequette(req);
        try {
            ps.setString(1, c.getCIN());
            ps.setString(2, c.getNUMPT());
            ps.setString(3, c.getNOMCLI());
            ps.setString(4, c.getPRENCLI());
            ps.setString(5, c.getDATENAIS());
            ps.setString(6, c.getVILLENAIS());
            ps.setString(7, c.getTEL1());
            ps.setString(8, c.getTEL2());
            ps.setString(9, c.getIMGCLI());
            ps.setString(10, CIN);


            a = ps.executeUpdate();

            bd.fermerConnection();


        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a != 0;
    }

    public List<Client> ListerP(String cle) throws SQLException {
        String sql = "SELECT * FROM client WHERE CIN=?";
        // String sql ="SELECT CIN,NUMPT,NOMCLI,PRENCLI,DATENAIS,VILLENAIS,TEL1,TEL2 FROM client WHERE CIN=?";
        List<Client> ma = new ArrayList<Client>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Client t = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }


    public List<Client> ListerN(String cle) throws SQLException {
        String sql = "SELECT * FROM client WHERE NUMPT=?";
        List<Client> ma = new ArrayList<Client>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Client t = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }

    public List<Client> ListerNM(String cle) throws SQLException {
        String sql = "SELECT * FROM client WHERE NOMCLI=?";
        List<Client> ma = new ArrayList<Client>();
        bd.ouvrirConnection();
        PreparedStatement ps;
        ps = bd.preparerRequette(sql);
        ps.setString(1, cle);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Client t = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            ma.add(t);
        }
        bd.fermerConnection();
        return ma;
    }
}
