/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Revsion;
import Model.Vehicule;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Lenovo
 */
public class DaoRevsion {

    BDconnection bd = new BDconnection();
    PreparedStatement ps = null;
    DaoVehicule dv = new DaoVehicule();

    public boolean ajouterRev(Revsion r) {
        int a = 0;
        String req = "INSERT INTO revtion(IDREV,DATEFINAS,DATEVIST,KMTVID) VALUES (?,?,?,?)";

        bd.ouvrirConnection();

        ps = bd.preparerRequette(req);
        try {

            ps.setString(1, r.getIdRev());
            ps.setDate(2, new java.sql.Date(r.getDateFinas().getTime()));
            ps.setDate(3, new java.sql.Date(r.getDateVist().getTime()));
            ps.setInt(4, r.getVid());

            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean modifierRv(String cle, Revsion r) {
        int a = 0;

        String req = " UPDATE revtion SET IDREV=?,DATEFINAS=?,DATEVIST=?,KMTVID=? WHERE IDREV=?";
        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);
        try {

            ps.setString(1, r.getIdRev());
            ps.setDate(2, new java.sql.Date(r.getDateFinas().getTime()));
            ps.setDate(3, new java.sql.Date(r.getDateVist().getTime()));
            ps.setInt(4, r.getVid());
            ps.setString(5, cle);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean modifierVist(String cle, Date d) {
        int a = 0;

        String req = " UPDATE revtion SET DATEVIST=?WHERE IDREV=?";
        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);
        try {

            ps.setDate(1, new java.sql.Date(d.getTime()));

            ps.setString(2, cle);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean modifierAs(String cle, Date d) {
        int a = 0;

        String req = " UPDATE revtion SET DATEFINAS=?WHERE IDREV=?";
        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);
        try {
            ps.setDate(1, new java.sql.Date(d.getTime()));
            ps.setString(2, cle);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean modifierKMT(String cle, int i) {
        int a = 0;

        String req = " UPDATE revtion SET KMTVID=KMTVID+? WHERE IDREV=?";
        bd.ouvrirConnection();
        ps = bd.preparerRequette(req);
        try {
            ps.setInt(1, i);
            ps.setString(2, cle);
            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean supprimerRv(String cle) {
        int a = 0;
        String req = "DELETE FROM revtion WHERE  IDREV=?";

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

    public List<Revsion> listerTou() {
        List<Revsion> ls = null;
        try {
            String sql = "SELECT * FROM revtion r,vehicule v WHERE r.IDREV=v.IDREV ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {
                Revsion rev = new Revsion();
                rev.setIdRev(rs.getString(1));
                rev.setDateFinas(rs.getDate(2));
                rev.setDateVist(rs.getDate(3));
                rev.setVid(rs.getInt(4));
                Vehicule v = new Vehicule();
                v.setMatrVh(rs.getString(5));
                rev.setV(v);
                ls.add(rev);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Revsion> listerId(String cle) {
        List<Revsion> ls = null;
        try {
            String sql = "SELECT * FROM revtion  WHERE   IDREV=? ";
            bd.ouvrirConnection();
            PreparedStatement ps;

            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {

                Revsion rev = new Revsion(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4));
                ls.add(rev);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Revsion> listerIdDe(String cle) {
        List<Revsion> ls = null;
        try {
            String sql = "SELECT * FROM revtion r,vehicule v WHERE r.IDREV=v.IDREV AND r.IDREV=? ";
            bd.ouvrirConnection();
            PreparedStatement ps;

            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {

                Revsion rev = new Revsion();
                rev.setIdRev(rs.getString(1));
                rev.setDateFinas(rs.getDate(2));
                rev.setDateVist(rs.getDate(3));
                rev.setVid(rs.getInt(4));
                Vehicule v = new Vehicule();
                v.setMatrVh(rs.getString(5));
                rev.setV(v);
                ls.add(rev);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Revsion> listerIDMatr(String cle) {
        List<Revsion> ls = null;
        try {
            String sql = "SELECT * FROM revtion r,vehicule v WHERE r.IDREV=v.IDREV AND MATRVH=? ";
            bd.ouvrirConnection();
            PreparedStatement ps;

            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {

                Revsion rev = new Revsion();
                rev.setIdRev(rs.getString(1));
                rev.setDateFinas(rs.getDate(2));
                rev.setDateVist(rs.getDate(3));
                rev.setVid(rs.getInt(4));
                Vehicule v = new Vehicule();
                v.setMatrVh(rs.getString(5));
                rev.setV(v);
                ls.add(rev);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Revsion> RechercherAS(Date cle, Date cle1) {
        List<Revsion> ls = null;
        try {
            String sql = "SELECT * FROM revtion r,vehicule v WHERE r.IDREV=v.IDREV AND DATEFINAS BETWEEN ? and ? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setDate(1, new java.sql.Date(cle.getTime()));
            ps.setDate(2, new java.sql.Date(cle1.getTime()));
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {
                Revsion rev = new Revsion();
                rev.setIdRev(rs.getString(1));
                rev.setDateFinas(rs.getDate(2));
                rev.setDateVist(rs.getDate(3));
                rev.setVid(rs.getInt(4));
                Vehicule v = new Vehicule();
                v.setMatrVh(rs.getString(5));
                rev.setV(v);
                ls.add(rev);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Revsion> RechercherVi(Date cle, Date cle1) {
        List<Revsion> ls = null;
        try {
            String sql = "SELECT * FROM revtion r,vehicule v WHERE r.IDREV=v.IDREV AND DATEVIST BETWEEN ? and ? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setDate(1, new java.sql.Date(cle.getTime()));
            ps.setDate(2, new java.sql.Date(cle1.getTime()));
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {

                Revsion rev = new Revsion();
                rev.setIdRev(rs.getString(1));
                rev.setDateFinas(rs.getDate(2));
                rev.setDateVist(rs.getDate(3));
                rev.setVid(rs.getInt(4));
                Vehicule v = new Vehicule();
                v.setMatrVh(rs.getString(5));
                rev.setV(v);
                ls.add(rev);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Revsion> RechercherVd() {
        List<Revsion> ls = null;
        try {
            String sql = "SELECT * FROM revtion r,vehicule v WHERE r.IDREV=v.IDREV AND KMTVID-KMT>500";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);

            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {

                Revsion rev = new Revsion();
                rev.setIdRev(rs.getString(1));
                rev.setDateFinas(rs.getDate(2));
                rev.setDateVist(rs.getDate(3));
                rev.setVid(rs.getInt(4));
                Vehicule v = new Vehicule();
                v.setMatrVh(rs.getString(5));
                rev.setV(v);

                ls.add(rev);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public String dernier() throws SQLException {
        String sql = "select max(IDREV) FROM revtion ";
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

    public List<Revsion> listerRevA(Date e) {
        List<Revsion> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV ,r.DATEFINAS FROM vehicule v ,revtion r WHERE r.IDREV=v.IDREV AND ? >= r.DATEFINAS ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setDate(1, new java.sql.Date(e.getTime()));
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {

                Vehicule vh = new Vehicule();
                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                Revsion ro = new Revsion(null, rs.getDate("DATEFINAS"), null, 0);
                ro.setV(vh);
                dv.Nodisponible(rs.getString("MATRVH"));
                ls.add(ro);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;

    }

    public List<Revsion> listerRevVis(Date e) {
        List<Revsion> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV ,r.DATEVIST FROM vehicule v ,revtion r WHERE r.IDREV=v.IDREV AND ? >= r.DATEVIST";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setDate(1, new java.sql.Date(e.getTime()));
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {

                Vehicule vh = new Vehicule();
                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                Revsion ro2 = new Revsion();
                ro2.setDateVist(rs.getDate("DATEVIST"));
                ro2.setV(vh);
                dv.Nodisponible(rs.getString("MATRVH"));
                ls.add(ro2);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;

    }

    public List<Revsion> listerRevKmt() {
        List<Revsion> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV ,r.KMTVID FROM vehicule v ,revtion r WHERE r.IDREV=v.IDREV And v.KMT > r.KMTVID ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);

            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Revsion>();
            while (rs.next()) {

                Vehicule vh = new Vehicule();
                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                Revsion ro1 = new Revsion(null, null, null, rs.getInt("KMTVID"));
                ro1.setV(vh);
                dv.Nodisponible(rs.getString("MATRVH"));
                ls.add(ro1);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;

    }

    public void listerpan(Date e) {

        try {

            String sql = "SELECT v.MATRVH, v.IDREV FROM vehicule v ,revtion r WHERE r.IDREV=v.IDREV AND ( ? >= r.DATEFINAS or ? >= r.DATEVIST or v.KMT > r.KMTVID)";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setDate(1, new java.sql.Date(e.getTime()));
            ps.setDate(2, new java.sql.Date(e.getTime()));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dv.Nodisponible(rs.getString("MATRVH"));
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();

    }

    public boolean listerpan(Date e, String mat) {
        boolean a = false;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV FROM vehicule v ,revtion r WHERE r.IDREV=v.IDREV AND ( ? >= r.DATEFINAS or ? >= r.DATEVIST or v.KMT > r.KMTVID) AND  v.MATRVH=? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setDate(1, new java.sql.Date(e.getTime()));
            ps.setDate(2, new java.sql.Date(e.getTime()));
            ps.setString(3, mat);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dv.Nodisponible(rs.getString("MATRVH"));
                a = true;
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a;
    }

    public boolean RechercherVi(String cle, String cle1, String cle2) {
        boolean a = false;
        try {
            String sql = "SELECT * FROM revtion r,vehicule v WHERE r.IDREV=v.IDREV AND MATRVH=? AND ((DATEVIST BETWEEN ? and ?) OR (DATEFINAS BETWEEN ? and ?)) ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ps.setString(2, cle1);
            ps.setString(3, cle2);
            ps.setString(4, cle1);
            ps.setString(5, cle2);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                a = true;
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a;
    }
}
