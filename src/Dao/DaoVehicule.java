/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Categorie;
import Model.Marque;
import Model.Model;
import Model.Vehicule;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
public class DaoVehicule {

    BDconnection bd = new BDconnection();
    PreparedStatement ps = null;

    public boolean ajouterVh(Vehicule vh) {
        int a = 0;
        String req = "INSERT INTO vehicule(MATRVH,IDREV,IDCAT,DATACHAT,PRIXACHAT,KMT,MARQUEVH,MODVH,AC,NBPORT,NBPASSAGER,BOITVITESSE,PRIXJOURVH,IMGVH,STATUTVH) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        bd.ouvrirConnection();

        ps = bd.preparerRequette(req);
        try {

            ps.setString(1, vh.getMatrVh());
            ps.setString(2, vh.getIdRev());
            ps.setInt(3, vh.getIdCat());
            ps.setDate(4, new java.sql.Date(vh.getDateAchat().getTime()));
            ps.setDouble(5, vh.getPrixAchat());
            ps.setInt(6, vh.getKms());
            ps.setString(7, vh.getMarquVh());
            ps.setString(8, vh.getModVh());
            ps.setString(9, vh.getAc());
            ps.setInt(10, vh.getNbPort());
            ps.setInt(11, vh.getNbPasssager());
            ps.setString(12, vh.getBoitevitesse());
            ps.setDouble(13, vh.getPrixJourVh());
            ps.setString(14, vh.getImagVh());
            ps.setBoolean(15, vh.isStatutVh());

            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean modifierVh(String Matr, Vehicule vh) {
        int a = 0;
        String req = "UPDATE vehicule SET MATRVH=?,IDREV=?,IDCAT=?,DATACHAT=?,PRIXACHAT=?,KMT=?,MARQUEVH=?,MODVH=?,AC=?,NBPORT=?,NBPASSAGER=?,BOITVITESSE=?,PRIXJOURVH=?,IMGVH=?,STATUTVH=? WHERE MATRVH=?";

        bd.ouvrirConnection();

        ps = bd.preparerRequette(req);
        try {
            ps.setString(1, vh.getMatrVh());
            ps.setString(2, vh.getIdRev());
            ps.setInt(3, vh.getIdCat());
            ps.setDate(4, new java.sql.Date(vh.getDateAchat().getTime()));
            ps.setDouble(5, vh.getPrixAchat());
            ps.setInt(6, vh.getKms());
            ps.setString(7, vh.getMarquVh());
            ps.setString(8, vh.getModVh());
            ps.setString(9, vh.getAc());
            ps.setInt(10, vh.getNbPort());
            ps.setInt(11, vh.getNbPasssager());
            ps.setString(12, vh.getBoitevitesse());
            ps.setDouble(13, vh.getPrixJourVh());
            ps.setString(14, vh.getImagVh());
            ps.setBoolean(15, vh.isStatutVh());
            ps.setString(16, Matr);

            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean disponible(String cle) {
        int a = 0;
        String req = "UPDATE vehicule SET STATUTVH=true WHERE MATRVH=?";

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

    public boolean disponibleKmt(String cle, int km) {
        int a = 0;
        String req = "UPDATE vehicule SET STATUTVH=true,KMT=? WHERE MATRVH=?";

        bd.ouvrirConnection();

        ps = bd.preparerRequette(req);
        try {
            ps.setInt(1, km);
            ps.setString(2, cle);

            a = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return a != 0;
    }

    public boolean Nodisponible(String cle) {
        int a = 0;
        String req = "UPDATE vehicule SET STATUTVH=False WHERE MATRVH=?";

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

    public boolean supprimer(String cle) {
        int a = 0;
        String req = "DELETE FROM vehicule WHERE MATRVH=?";

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

    public List<Vehicule> listerDetail() {
        List<Vehicule> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV, v.IDCAT, v.DATACHAT, v.PRIXACHAT, v.KMT,v.MARQUEVH,v.MODVH,v.AC,v.NBPORT,v.NBPASSAGER,v.BOITVITESSE, v.PRIXJOURVH, v.IMGVH, v.STATUTVH,c.NOMCAT,l.NOMMODEL,l.ANNEEMODEL,m.NOMMARQUE FROM vehicule v,categorie c,Model l,marque m WHERE c.IDCAT=v.IDCAT AND v.MODVH =l.IDMODEL AND v.MARQUEVH=m.IDMARQUE ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);

            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Vehicule>();
            while (rs.next()) {

                Categorie cat = new Categorie(1, rs.getString("NOMCAT"));

                Marque mar = new Marque(rs.getString("MARQUEVH"), rs.getString("NOMMARQUE"));

                Model mo = new Model(rs.getString("MODVH"), rs.getString("MARQUEVH"), rs.getString("NOMMODEL"), rs.getString("ANNEEMODEL"));

                Vehicule vh = new Vehicule();

                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                vh.setIdCat(rs.getInt("IDCAT"));
                vh.setDateAchat(rs.getDate("DATACHAT"));
                vh.setPrixAchat(rs.getDouble("PRIXACHAT"));
                vh.setKms(rs.getInt("KMT"));
                vh.setMarquVh(rs.getString("MARQUEVH"));
                vh.setModVh(rs.getString("MODVH"));
                vh.setAc(rs.getString("AC"));
                vh.setNbPort(rs.getInt("NBPORT"));
                vh.setNbPasssager(rs.getInt("NBPASSAGER"));
                vh.setBoitevitesse(rs.getString("BOITVITESSE"));
                vh.setPrixJourVh(rs.getDouble("PRIXJOURVH"));
                vh.setImagVh(rs.getString("IMGVH"));
                vh.setStatutVh(rs.getBoolean("STATUTVH"));
                vh.setCat(cat);
                vh.setMo(mo);
                vh.setMa(mar);

                ls.add(vh);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Vehicule> listerDetailCat(String cle) {
        List<Vehicule> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV, v.IDCAT, v.DATACHAT, v.PRIXACHAT, v.KMT,v.MARQUEVH,v.MODVH,v.AC,v.NBPORT,v.NBPASSAGER,v.BOITVITESSE, v.PRIXJOURVH, v.IMGVH, v.STATUTVH,c.NOMCAT,l.NOMMODEL,l.ANNEEMODEL,m.NOMMARQUE FROM vehicule v,categorie c,Model l,marque m WHERE c.IDCAT=v.IDCAT AND v.MODVH =l.IDMODEL AND v.MARQUEVH=m.IDMARQUE AND c.NOMCAT LIKE ? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, "%" + cle + "%");
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Vehicule>();
            while (rs.next()) {

                Categorie cat = new Categorie(1, rs.getString("NOMCAT"));

                Marque mar = new Marque(rs.getString("MARQUEVH"), rs.getString("NOMMARQUE"));

                Model mo = new Model(rs.getString("MODVH"), rs.getString("MARQUEVH"), rs.getString("NOMMODEL"), rs.getString("ANNEEMODEL"));

                Vehicule vh = new Vehicule();

                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                vh.setIdCat(rs.getInt("IDCAT"));
                vh.setDateAchat(rs.getDate("DATACHAT"));
                vh.setPrixAchat(rs.getDouble("PRIXACHAT"));
                vh.setKms(rs.getInt("KMT"));
                vh.setMarquVh(rs.getString("MARQUEVH"));
                vh.setModVh(rs.getString("MODVH"));
                vh.setAc(rs.getString("AC"));
                vh.setNbPort(rs.getInt("NBPORT"));
                vh.setNbPasssager(rs.getInt("NBPASSAGER"));
                vh.setBoitevitesse(rs.getString("BOITVITESSE"));
                vh.setPrixJourVh(rs.getDouble("PRIXJOURVH"));
                vh.setImagVh(rs.getString("IMGVH"));
                vh.setStatutVh(rs.getBoolean("STATUTVH"));
                vh.setCat(cat);
                vh.setMo(mo);
                vh.setMa(mar);

                ls.add(vh);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;

    }

    public List<Vehicule> listerDetailModel(String cle) {
        List<Vehicule> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV, v.IDCAT, v.DATACHAT, v.PRIXACHAT, v.KMT,v.MARQUEVH,v.MODVH,v.AC,v.NBPORT,v.NBPASSAGER,v.BOITVITESSE, v.PRIXJOURVH, v.IMGVH, v.STATUTVH,c.NOMCAT,l.NOMMODEL,l.ANNEEMODEL,m.NOMMARQUE FROM vehicule v,categorie c,Model l,marque m WHERE c.IDCAT=v.IDCAT AND v.MODVH =l.IDMODEL AND v.MARQUEVH=m.IDMARQUE AND l.NOMMODEL LIKE ? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, "%" + cle + "%");
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Vehicule>();
            while (rs.next()) {

                Categorie cat = new Categorie(1, rs.getString("NOMCAT"));

                Marque mar = new Marque(rs.getString("MARQUEVH"), rs.getString("NOMMARQUE"));

                Model mo = new Model(rs.getString("MODVH"), rs.getString("MARQUEVH"), rs.getString("NOMMODEL"), rs.getString("ANNEEMODEL"));

                Vehicule vh = new Vehicule();

                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                vh.setIdCat(rs.getInt("IDCAT"));
                vh.setDateAchat(rs.getDate("DATACHAT"));
                vh.setPrixAchat(rs.getDouble("PRIXACHAT"));
                vh.setKms(rs.getInt("KMT"));
                vh.setMarquVh(rs.getString("MARQUEVH"));
                vh.setModVh(rs.getString("MODVH"));
                vh.setAc(rs.getString("AC"));
                vh.setNbPort(rs.getInt("NBPORT"));
                vh.setNbPasssager(rs.getInt("NBPASSAGER"));
                vh.setBoitevitesse(rs.getString("BOITVITESSE"));
                vh.setPrixJourVh(rs.getDouble("PRIXJOURVH"));
                vh.setImagVh(rs.getString("IMGVH"));
                vh.setStatutVh(rs.getBoolean("STATUTVH"));
                vh.setCat(cat);
                vh.setMo(mo);
                vh.setMa(mar);

                ls.add(vh);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Vehicule> listerDetailMarque(String cle) {
        List<Vehicule> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV, v.IDCAT, v.DATACHAT, v.PRIXACHAT, v.KMT,v.MARQUEVH,v.MODVH,v.AC,v.NBPORT,v.NBPASSAGER,v.BOITVITESSE, v.PRIXJOURVH, v.IMGVH, v.STATUTVH,c.NOMCAT,l.NOMMODEL,l.ANNEEMODEL,m.NOMMARQUE FROM vehicule v,categorie c,Model l,marque m WHERE c.IDCAT=v.IDCAT AND v.MODVH =l.IDMODEL AND v.MARQUEVH=m.IDMARQUE AND m.NOMMARQUE LIKE ? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, "%" + cle + "%");
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Vehicule>();
            while (rs.next()) {

                Categorie cat = new Categorie(1, rs.getString("NOMCAT"));

                Marque mar = new Marque(rs.getString("MARQUEVH"), rs.getString("NOMMARQUE"));

                Model mo = new Model(rs.getString("MODVH"), rs.getString("MARQUEVH"), rs.getString("NOMMODEL"), rs.getString("ANNEEMODEL"));

                Vehicule vh = new Vehicule();

                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                vh.setIdCat(rs.getInt("IDCAT"));
                vh.setDateAchat(rs.getDate("DATACHAT"));
                vh.setPrixAchat(rs.getDouble("PRIXACHAT"));
                vh.setKms(rs.getInt("KMT"));
                vh.setMarquVh(rs.getString("MARQUEVH"));
                vh.setModVh(rs.getString("MODVH"));
                vh.setAc(rs.getString("AC"));
                vh.setNbPort(rs.getInt("NBPORT"));
                vh.setNbPasssager(rs.getInt("NBPASSAGER"));
                vh.setBoitevitesse(rs.getString("BOITVITESSE"));
                vh.setPrixJourVh(rs.getDouble("PRIXJOURVH"));
                vh.setImagVh(rs.getString("IMGVH"));
                vh.setStatutVh(rs.getBoolean("STATUTVH"));
                vh.setCat(cat);
                vh.setMo(mo);
                vh.setMa(mar);

                ls.add(vh);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Vehicule> listerDetailMtr(String cle) {
        List<Vehicule> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV, v.IDCAT, v.DATACHAT, v.PRIXACHAT, v.KMT,v.MARQUEVH,v.MODVH,v.AC,v.NBPORT,v.NBPASSAGER,v.BOITVITESSE, v.PRIXJOURVH, v.IMGVH, v.STATUTVH,c.NOMCAT,l.NOMMODEL,l.ANNEEMODEL,m.NOMMARQUE FROM vehicule v,categorie c,Model l,marque m WHERE c.IDCAT=v.IDCAT AND v.MODVH =l.IDMODEL AND v.MARQUEVH=m.IDMARQUE AND  v.MATRVH LIKE ? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setString(1, cle);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Vehicule>();
            while (rs.next()) {

                Categorie cat = new Categorie(1, rs.getString("NOMCAT"));

                Marque mar = new Marque(rs.getString("MARQUEVH"), rs.getString("NOMMARQUE"));

                Model mo = new Model(rs.getString("MODVH"), rs.getString("MARQUEVH"), rs.getString("NOMMODEL"), rs.getString("ANNEEMODEL"));

                Vehicule vh = new Vehicule();

                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                vh.setIdCat(rs.getInt("IDCAT"));
                vh.setDateAchat(rs.getDate("DATACHAT"));
                vh.setPrixAchat(rs.getDouble("PRIXACHAT"));
                vh.setKms(rs.getInt("KMT"));
                vh.setMarquVh(rs.getString("MARQUEVH"));
                vh.setModVh(rs.getString("MODVH"));
                vh.setAc(rs.getString("AC"));
                vh.setNbPort(rs.getInt("NBPORT"));
                vh.setNbPasssager(rs.getInt("NBPASSAGER"));
                vh.setBoitevitesse(rs.getString("BOITVITESSE"));
                vh.setPrixJourVh(rs.getDouble("PRIXJOURVH"));
                vh.setImagVh(rs.getString("IMGVH"));
                vh.setStatutVh(rs.getBoolean("STATUTVH"));
                vh.setCat(cat);
                vh.setMo(mo);
                vh.setMa(mar);

                ls.add(vh);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Vehicule> listerVhDi() {
        List<Vehicule> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV, v.IDCAT, v.DATACHAT, v.PRIXACHAT, v.KMT,v.MARQUEVH,v.MODVH,v.AC,v.NBPORT,v.NBPASSAGER,v.BOITVITESSE, v.PRIXJOURVH, v.IMGVH, v.STATUTVH,c.NOMCAT,l.NOMMODEL,l.ANNEEMODEL,m.NOMMARQUE FROM vehicule v,categorie c,Model l,marque m WHERE c.IDCAT=v.IDCAT AND v.MODVH =l.IDMODEL AND v.MARQUEVH=m.IDMARQUE AND  v.STATUTVH =True ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Vehicule>();
            while (rs.next()) {

                Categorie cat = new Categorie(1, rs.getString("NOMCAT"));

                Marque mar = new Marque(rs.getString("MARQUEVH"), rs.getString("NOMMARQUE"));

                Model mo = new Model(rs.getString("MODVH"), rs.getString("MARQUEVH"), rs.getString("NOMMODEL"), rs.getString("ANNEEMODEL"));

                Vehicule vh = new Vehicule();

                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                vh.setIdCat(rs.getInt("IDCAT"));
                vh.setDateAchat(rs.getDate("DATACHAT"));
                vh.setPrixAchat(rs.getDouble("PRIXACHAT"));
                vh.setKms(rs.getInt("KMT"));
                vh.setMarquVh(rs.getString("MARQUEVH"));
                vh.setModVh(rs.getString("MODVH"));
                vh.setAc(rs.getString("AC"));
                vh.setNbPort(rs.getInt("NBPORT"));
                vh.setNbPasssager(rs.getInt("NBPASSAGER"));
                vh.setBoitevitesse(rs.getString("BOITVITESSE"));
                vh.setPrixJourVh(rs.getDouble("PRIXJOURVH"));
                vh.setImagVh(rs.getString("IMGVH"));
                vh.setStatutVh(rs.getBoolean("STATUTVH"));
                vh.setCat(cat);
                vh.setMo(mo);
                vh.setMa(mar);

                ls.add(vh);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

    public List<Vehicule> listerVhNotDi() {
        List<Vehicule> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV, v.IDCAT, v.DATACHAT, v.PRIXACHAT, v.KMT,v.MARQUEVH,v.MODVH,v.AC,v.NBPORT,v.NBPASSAGER,v.BOITVITESSE, v.PRIXJOURVH, v.IMGVH, v.STATUTVH,c.NOMCAT,l.NOMMODEL,l.ANNEEMODEL,m.NOMMARQUE FROM vehicule v,categorie c,Model l,marque m WHERE c.IDCAT=v.IDCAT AND v.MODVH =l.IDMODEL AND v.MARQUEVH=m.IDMARQUE AND  v.STATUTVH =False ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);

            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Vehicule>();
            while (rs.next()) {

                Categorie cat = new Categorie(1, rs.getString("NOMCAT"));

                Marque mar = new Marque(rs.getString("MARQUEVH"), rs.getString("NOMMARQUE"));

                Model mo = new Model(rs.getString("MODVH"), rs.getString("MARQUEVH"), rs.getString("NOMMODEL"), rs.getString("ANNEEMODEL"));

                Vehicule vh = new Vehicule();

                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                vh.setIdCat(rs.getInt("IDCAT"));
                vh.setDateAchat(rs.getDate("DATACHAT"));
                vh.setPrixAchat(rs.getDouble("PRIXACHAT"));
                vh.setKms(rs.getInt("KMT"));
                vh.setMarquVh(rs.getString("MARQUEVH"));
                vh.setModVh(rs.getString("MODVH"));
                vh.setAc(rs.getString("AC"));
                vh.setNbPort(rs.getInt("NBPORT"));
                vh.setNbPasssager(rs.getInt("NBPASSAGER"));
                vh.setBoitevitesse(rs.getString("BOITVITESSE"));
                vh.setPrixJourVh(rs.getDouble("PRIXJOURVH"));
                vh.setImagVh(rs.getString("IMGVH"));
                vh.setStatutVh(rs.getBoolean("STATUTVH"));
                vh.setCat(cat);
                vh.setMo(mo);
                vh.setMa(mar);

                ls.add(vh);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;

    }

    public List<Vehicule> listerprixVh(double prix) {
        List<Vehicule> ls = null;
        try {

            String sql = "SELECT v.MATRVH, v.IDREV, v.IDCAT, v.DATACHAT, v.PRIXACHAT, v.KMT,v.MARQUEVH,v.MODVH,v.AC,v.NBPORT,v.NBPASSAGER,v.BOITVITESSE, v.PRIXJOURVH, v.IMGVH, v.STATUTVH,c.NOMCAT,l.NOMMODEL,l.ANNEEMODEL,m.NOMMARQUE FROM vehicule v,categorie c,Model l,marque m WHERE c.IDCAT=v.IDCAT AND v.MODVH =l.IDMODEL AND v.MARQUEVH=m.IDMARQUE AND  v.PRIXJOURVH <=? ";
            bd.ouvrirConnection();
            PreparedStatement ps;
            ps = bd.preparerRequette(sql);
            ps.setDouble(1, prix);
            ResultSet rs = ps.executeQuery();
            ls = new ArrayList<Vehicule>();
            while (rs.next()) {

                Categorie cat = new Categorie(1, rs.getString("NOMCAT"));

                Marque mar = new Marque(rs.getString("MARQUEVH"), rs.getString("NOMMARQUE"));

                Model mo = new Model(rs.getString("MODVH"), rs.getString("MARQUEVH"), rs.getString("NOMMODEL"), rs.getString("ANNEEMODEL"));

                Vehicule vh = new Vehicule();

                vh.setMatrVh(rs.getString("MATRVH"));
                vh.setIdRev(rs.getString("IDREV"));
                vh.setIdCat(rs.getInt("IDCAT"));
                vh.setDateAchat(rs.getDate("DATACHAT"));
                vh.setPrixAchat(rs.getDouble("PRIXACHAT"));
                vh.setKms(rs.getInt("KMT"));
                vh.setMarquVh(rs.getString("MARQUEVH"));
                vh.setModVh(rs.getString("MODVH"));
                vh.setAc(rs.getString("AC"));
                vh.setNbPort(rs.getInt("NBPORT"));
                vh.setNbPasssager(rs.getInt("NBPASSAGER"));
                vh.setBoitevitesse(rs.getString("BOITVITESSE"));
                vh.setPrixJourVh(rs.getDouble("PRIXJOURVH"));
                vh.setImagVh(rs.getString("IMGVH"));
                vh.setStatutVh(rs.getBoolean("STATUTVH"));
                vh.setCat(cat);
                vh.setMo(mo);
                vh.setMa(mar);

                ls.add(vh);
            }
        } catch (SQLException ex) {
            System.out.println("**************" + ex.getMessage() + "*****************");
        }
        bd.fermerConnection();
        return ls;
    }

}
