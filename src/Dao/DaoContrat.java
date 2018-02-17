/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Client;
import Model.Contrat;
import Model.Marque;
import Model.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author azzus
 */
public class DaoContrat {

    BDconnection bd = new BDconnection();
    PreparedStatement ps = null;

    public boolean ajouteCont(Contrat cont) {
        int a = 0;
        String req = "INSERT INTO contrat(IDCONT,IDUTIL,CIN,MATRVH,DATEDEBUT,DATEFIN,DUREE,GPS,SIGEBEBE,CHAINESNAIGE) VALUES (?,?,?,?,?,?,?,?,?,?)";

        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);
        try {

            ps.setString(1, cont.getIdCont());
            ps.setString(2, cont.getIdutil());
            ps.setString(3, cont.getCin());
            ps.setString(4, cont.getMatrVh());
            ps.setString(5, cont.getDateDebut());
            ps.setString(6, cont.getDateFin());
            ps.setInt(7, cont.getDuree());
            ps.setBoolean(8, cont.isGps());
            ps.setBoolean(9, cont.isSiegebebe());
            ps.setBoolean(10, cont.isChainesnaige());

            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }

        bd.fermerConnection();
        return a != 0;
    }

    public boolean modifiercont(String conta, Contrat cont) {
        int a = 0;
        String req = "UPDATE  contrat SET IDCONT=?,IDUTIL=?,CIN=?,MATRVH=?,DATEDEBUT=?,DATEFIN=?,DUREE=?,GPS=?,SIGEBEBE=?,CHAINESNAIGE=? WHERE IDCONT=?";

        bd.ouvrirConnection();

        ps = bd.preparerRequette(req);
        try {
            ps.setString(1, cont.getIdCont());
            ps.setString(2, cont.getIdutil());
            ps.setString(3, cont.getCin());
            ps.setString(4, cont.getMatrVh());
            ps.setString(5, cont.getDateDebut());
            ps.setString(6, cont.getDateFin());
            ps.setInt(7, cont.getDuree());
            ps.setBoolean(8, cont.isGps());
            ps.setBoolean(9, cont.isSiegebebe());
            ps.setBoolean(10, cont.isChainesnaige());
            ps.setString(11, conta);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean supprimer(String cle) {
        int a = 0;
        String req = "DELETE FROM CONTRAT WHERE IDCONT=?";

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

    public List<Contrat> ListerTou() {
        List<Contrat> ls = null;
        try {
            String sql = "SELECT * FROM contrat ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Contrat>();
            while (rs.next()) {
                rs.getString(1);
                Contrat cont = new Contrat();
                cont.setIdCont(rs.getString(1));
                cont.setIdutil(rs.getString(2));
                cont.setCin(rs.getString(3));
                cont.setMatrVh(rs.getString(4));
                cont.setDateDebut(rs.getString(5));
                cont.setDateFin(rs.getString(6));
                cont.setDuree(rs.getInt(7));
                cont.setGps(rs.getBoolean(8));
                cont.setSiegebebe(rs.getBoolean(9));
                cont.setChainesnaige(rs.getBoolean(10));
                ls.add(cont);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Contrat> ListerTouparID(String cle) {
        List<Contrat> ls = null;
        try {
            String sql = "SELECT * FROM contrat  WHERE IDCONT=?";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Contrat>();
            while (rs.next()) {
                rs.getString(1);
                Contrat cont = new Contrat();
                cont.setIdCont(rs.getString(1));
                cont.setIdutil(rs.getString(2));
                cont.setCin(rs.getString(3));
                cont.setMatrVh(rs.getString(4));
                cont.setDateDebut(rs.getString(5));
                cont.setDateFin(rs.getString(6));
                cont.setDuree(rs.getInt(7));
                cont.setGps(rs.getBoolean(8));
                cont.setSiegebebe(rs.getBoolean(9));
                cont.setChainesnaige(rs.getBoolean(10));
                ls.add(cont);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Contrat> ListerDetail() {
        List<Contrat> ls = null;
        try {
            String sql = "SELECT c.IDCONT, c.IDUTIL, c.CIN,l.NOMCLI,l.PRENCLI, "
                    + "c.MATRVH,m.NOMMODEL,r.NOMMARQUE, c.DATEDEBUT, c.DATEFIN,"
                    + " c.DUREE, c.GPS, c.SIGEBEBE, c.CHAINESNAIGE FROM contrat c,"
                    + "Client l,vehicule v ,model m , marque r WHERE c.CIN=l.CIN "
                    + "And v.MATRVH=c.MATRVH and m.IDMODEL= v.MODVH and r.IDMARQUE=v.MARQUEVH";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Contrat>();
            while (rs.next()) {

                Contrat cont = new Contrat();
                Model mod = new Model();
                Marque mar = new Marque();
                Client cli = new Client();

                cont.setIdCont(rs.getString(1));
                cont.setIdutil(rs.getString(2));
                cont.setCin(rs.getString(3));
                cli.setNOMCLI(rs.getString(4));
                cli.setPRENCLI(rs.getString(5));
                cont.setMatrVh(rs.getString(6));
                mod.setNomModel(rs.getString(7));
                mar.setNimMarque(rs.getString(8));
                cont.setDateDebut(rs.getString(9));
                cont.setDateFin(rs.getString(10));
                cont.setDuree(rs.getInt(11));
                cont.setGps(rs.getBoolean(12));
                cont.setSiegebebe(rs.getBoolean(13));
                cont.setChainesnaige(rs.getBoolean(14));

                cont.setCl(cli);
                cont.setMar(mar);
                cont.setMod(mod);

                ls.add(cont);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Contrat> ListerDetail(String cle) {
        List<Contrat> ls = null;
        try {
            String sql = "SELECT c.IDCONT, c.IDUTIL, c.CIN,l.NOMCLI,l.PRENCLI, "
                    + "c.MATRVH,m.NOMMODEL,r.NOMMARQUE, c.DATEDEBUT, c.DATEFIN,"
                    + " c.DUREE, c.GPS, c.SIGEBEBE, c.CHAINESNAIGE FROM contrat c,"
                    + "Client l,vehicule v ,model m , marque r WHERE c.CIN=l.CIN "
                    + "And v.MATRVH=c.MATRVH and m.IDMODEL= v.MODVH and r.IDMARQUE=v.MARQUEVH AND c.IDCONT=?";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Contrat>();
            while (rs.next()) {

                Contrat cont = new Contrat();
                Model mod = new Model();
                Marque mar = new Marque();
                Client cli = new Client();

                cont.setIdCont(rs.getString(1));
                cont.setIdutil(rs.getString(2));
                cont.setCin(rs.getString(3));
                cli.setNOMCLI(rs.getString(4));
                cli.setPRENCLI(rs.getString(5));
                cont.setMatrVh(rs.getString(6));
                mod.setNomModel(rs.getString(7));
                mar.setNimMarque(rs.getString(8));
                cont.setDateDebut(rs.getString(9));
                cont.setDateFin(rs.getString(10));
                cont.setDuree(rs.getInt(11));
                cont.setGps(rs.getBoolean(12));
                cont.setSiegebebe(rs.getBoolean(13));
                cont.setChainesnaige(rs.getBoolean(14));

                cont.setCl(cli);
                cont.setMar(mar);
                cont.setMod(mod);

                ls.add(cont);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Contrat> ListerDetailCin(String cle) {
        List<Contrat> ls = null;
        try {
            String sql = "SELECT c.IDCONT, c.IDUTIL, c.CIN,l.NOMCLI,l.PRENCLI, "
                    + "c.MATRVH,m.NOMMODEL,r.NOMMARQUE, c.DATEDEBUT, c.DATEFIN,"
                    + " c.DUREE, c.GPS, c.SIGEBEBE, c.CHAINESNAIGE FROM contrat c,"
                    + "Client l,vehicule v ,model m , marque r WHERE c.CIN=l.CIN "
                    + "And v.MATRVH=c.MATRVH and m.IDMODEL= v.MODVH and r.IDMARQUE=v.MARQUEVH AND c.CIN=? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Contrat>();
            while (rs.next()) {

                Contrat cont = new Contrat();
                Model mod = new Model();
                Marque mar = new Marque();
                Client cli = new Client();

                cont.setIdCont(rs.getString(1));
                cont.setIdutil(rs.getString(2));
                cont.setCin(rs.getString(3));
                cli.setNOMCLI(rs.getString(4));
                cli.setPRENCLI(rs.getString(5));
                cont.setMatrVh(rs.getString(6));
                mod.setNomModel(rs.getString(7));
                mar.setNimMarque(rs.getString(8));
                cont.setDateDebut(rs.getString(9));
                cont.setDateFin(rs.getString(10));
                cont.setDuree(rs.getInt(11));
                cont.setGps(rs.getBoolean(12));
                cont.setSiegebebe(rs.getBoolean(13));
                cont.setChainesnaige(rs.getBoolean(14));

                cont.setCl(cli);
                cont.setMar(mar);
                cont.setMod(mod);

                ls.add(cont);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Contrat> ListerDetailVh(String cle) {
        List<Contrat> ls = null;
        try {
            String sql = "SELECT c.IDCONT, c.IDUTIL, c.CIN,l.NOMCLI,l.PRENCLI, "
                    + "c.MATRVH,m.NOMMODEL,r.NOMMARQUE, c.DATEDEBUT, c.DATEFIN,"
                    + " c.DUREE, c.GPS, c.SIGEBEBE, c.CHAINESNAIGE FROM contrat c,"
                    + "Client l,vehicule v ,model m , marque r WHERE c.CIN=l.CIN "
                    + "And v.MATRVH=c.MATRVH and m.IDMODEL= v.MODVH and r.IDMARQUE=v.MARQUEVH AND c.MATRVH=? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Contrat>();
            while (rs.next()) {

                Contrat cont = new Contrat();
                Model mod = new Model();
                Marque mar = new Marque();
                Client cli = new Client();

                cont.setIdCont(rs.getString(1));
                cont.setIdutil(rs.getString(2));
                cont.setCin(rs.getString(3));
                cli.setNOMCLI(rs.getString(4));
                cli.setPRENCLI(rs.getString(5));
                cont.setMatrVh(rs.getString(6));
                mod.setNomModel(rs.getString(7));
                mar.setNimMarque(rs.getString(8));
                cont.setDateDebut(rs.getString(9));
                cont.setDateFin(rs.getString(10));
                cont.setDuree(rs.getInt(11));
                cont.setGps(rs.getBoolean(12));
                cont.setSiegebebe(rs.getBoolean(13));
                cont.setChainesnaige(rs.getBoolean(14));

                cont.setCl(cli);
                cont.setMar(mar);
                cont.setMod(mod);

                ls.add(cont);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Contrat> ListerDetailDateD(String cle, String cle1) {
        List<Contrat> ls = null;
        try {
            String sql = "SELECT c.IDCONT, c.IDUTIL, c.CIN,l.NOMCLI,l.PRENCLI, "
                    + "c.MATRVH,m.NOMMODEL,r.NOMMARQUE, c.DATEDEBUT, c.DATEFIN,"
                    + " c.DUREE, c.GPS, c.SIGEBEBE, c.CHAINESNAIGE FROM contrat c,"
                    + "Client l,vehicule v ,model m , marque r WHERE c.CIN=l.CIN "
                    + "And v.MATRVH=c.MATRVH and m.IDMODEL= v.MODVH "
                    + "and r.IDMARQUE=v.MARQUEVH AND c.DATEDEBUT BETWEEN ? AND ? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ps.setString(2, cle1);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Contrat>();
            while (rs.next()) {

                Contrat cont = new Contrat();
                Model mod = new Model();
                Marque mar = new Marque();
                Client cli = new Client();

                cont.setIdCont(rs.getString(1));
                cont.setIdutil(rs.getString(2));
                cont.setCin(rs.getString(3));
                cli.setNOMCLI(rs.getString(4));
                cli.setPRENCLI(rs.getString(5));
                cont.setMatrVh(rs.getString(6));
                mod.setNomModel(rs.getString(7));
                mar.setNimMarque(rs.getString(8));
                cont.setDateDebut(rs.getString(9));
                cont.setDateFin(rs.getString(10));
                cont.setDuree(rs.getInt(11));
                cont.setGps(rs.getBoolean(12));
                cont.setSiegebebe(rs.getBoolean(13));
                cont.setChainesnaige(rs.getBoolean(14));

                cont.setCl(cli);
                cont.setMar(mar);
                cont.setMod(mod);

                ls.add(cont);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Contrat> ListerDetailDateF(String cle, String cle1) {
        List<Contrat> ls = null;
        try {
            String sql = "SELECT c.IDCONT, c.IDUTIL, c.CIN,l.NOMCLI,l.PRENCLI, "
                    + "c.MATRVH,m.NOMMODEL,r.NOMMARQUE, c.DATEDEBUT, c.DATEFIN,"
                    + " c.DUREE, c.GPS, c.SIGEBEBE, c.CHAINESNAIGE FROM contrat c,"
                    + "Client l,vehicule v ,model m , marque r WHERE c.CIN=l.CIN "
                    + "And v.MATRVH=c.MATRVH and m.IDMODEL= v.MODVH "
                    + "and r.IDMARQUE=v.MARQUEVH AND c.DATEFIN BETWEEN ? AND ?";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ps.setString(2, cle1);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Contrat>();
            while (rs.next()) {

                Contrat cont = new Contrat();
                Model mod = new Model();
                Marque mar = new Marque();
                Client cli = new Client();

                cont.setIdCont(rs.getString(1));
                cont.setIdutil(rs.getString(2));
                cont.setCin(rs.getString(3));
                cli.setNOMCLI(rs.getString(4));
                cli.setPRENCLI(rs.getString(5));
                cont.setMatrVh(rs.getString(6));
                mod.setNomModel(rs.getString(7));
                mar.setNimMarque(rs.getString(8));
                cont.setDateDebut(rs.getString(9));
                cont.setDateFin(rs.getString(10));
                cont.setDuree(rs.getInt(11));
                cont.setGps(rs.getBoolean(12));
                cont.setSiegebebe(rs.getBoolean(13));
                cont.setChainesnaige(rs.getBoolean(14));

                cont.setCl(cli);
                cont.setMar(mar);
                cont.setMod(mod);

                ls.add(cont);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public String dernier() throws SQLException {
        String sql = "select max(IDCONT) FROM contrat ";
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
