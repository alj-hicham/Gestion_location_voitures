/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 * @author Lenovo
 */
public class Vehicule {

    /*
CREATE TABLE `vehicule` (
  `MATRVH` varchar(25) NOT NULL,
  `IDREV` varchar(25) NOT NULL,
  `IDCAT` int(11) NOT NULL,
  `DATACHAT` date DEFAULT NULL,
  `PRIXACHAT` decimal(10,0) NOT NULL,
  `KMT` varchar(25) NOT NULL,
  `MARQUEVH` varchar(40) NOT NULL,
  `MODVH` varchar(40) NOT NULL,
  `AC` varchar(40) DEFAULT NULL,
  `NBPORT` int(11) DEFAULT NULL,
  `NBPASSAGER` int(11) DEFAULT NULL,
  `BOITVITESSE` varchar(25) DEFAULT NULL,
  `PRIXJOURVH` decimal(10,0) NOT NULL,
  `IMGVH` varchar(50) DEFAULT NULL,
  `STATUTVH` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

    private String matrVh;
    private String idRev;
    private int idCat;
    private Date dateAchat;
    private double prixAchat;
    private int kms;
    private String marquVh;
    private String modVh;
    private String Ac;
    private int nbPort;
    private int nbPasssager;
    private String boitevitesse;
    private double prixJourVh;
    private String imagVh;
    private boolean statutVh;
    private Rvesion rev;
    private Categorie cat;
    private Model mo;
    private Marque ma;

    public Vehicule(String matrVh, String idRev, int idCat, Date dateAchat, double prixAchat, int kms, String marquVh, String modVh, String Ac, int nbPort, int nbPasssager, String boitevitesse, double prixJourVh, String imagVh, boolean statutVh, Rvesion rev, Categorie cat, Model mo, Marque ma) {
        this.matrVh = matrVh;
        this.idRev = idRev;
        this.idCat = idCat;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
        this.kms = kms;
        this.marquVh = marquVh;
        this.modVh = modVh;
        this.Ac = Ac;
        this.nbPort = nbPort;
        this.nbPasssager = nbPasssager;
        this.boitevitesse = boitevitesse;
        this.prixJourVh = prixJourVh;
        this.imagVh = imagVh;
        this.statutVh = statutVh;
        this.rev = rev;
        this.cat = cat;
        this.mo = mo;
        this.ma = ma;
    }

    public Vehicule(String matrVh, String idRev, int idCat, Date dateAchat, double prixAchat, int kms, String marquVh, String modVh, String Ac, int nbPort, int nbPasssager, String boitevitesse, double prixJourVh, String imagVh, boolean statutVh) {
        this.matrVh = matrVh;
        this.idRev = idRev;
        this.idCat = idCat;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
        this.kms = kms;
        this.marquVh = marquVh;
        this.modVh = modVh;
        this.Ac = Ac;
        this.nbPort = nbPort;
        this.nbPasssager = nbPasssager;
        this.boitevitesse = boitevitesse;
        this.prixJourVh = prixJourVh;
        this.imagVh = imagVh;
        this.statutVh = statutVh;

    }

    public Vehicule() {
    }


    public Model getMo() {
        return mo;
    }

    public void setMo(Model mo) {
        this.mo = mo;
    }

    public Marque getMa() {
        return ma;
    }

    public void setMa(Marque ma) {
        this.ma = ma;
    }

    public String getMatrVh() {
        return matrVh;
    }

    public void setMatrVh(String matrVh) {
        this.matrVh = matrVh;
    }

    public String getIdRev() {
        return idRev;
    }

    public void setIdRev(String idRev) {
        this.idRev = idRev;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public String getMarquVh() {
        return marquVh;
    }

    public void setMarquVh(String marquVh) {
        this.marquVh = marquVh;
    }

    public String getModVh() {
        return modVh;
    }

    public void setModVh(String modVh) {
        this.modVh = modVh;
    }

    public String getAc() {
        return Ac;
    }

    public void setAc(String Ac) {
        this.Ac = Ac;
    }

    public int getNbPort() {
        return nbPort;
    }

    public void setNbPort(int nbPort) {
        this.nbPort = nbPort;
    }

    public int getNbPasssager() {
        return nbPasssager;
    }

    public void setNbPasssager(int nbPasssager) {
        this.nbPasssager = nbPasssager;
    }

    public String getBoitevitesse() {
        return boitevitesse;
    }

    public void setBoitevitesse(String boitevitesse) {
        this.boitevitesse = boitevitesse;
    }

    public double getPrixJourVh() {
        return prixJourVh;
    }

    public void setPrixJourVh(double prixJourVh) {
        this.prixJourVh = prixJourVh;
    }

    public String getImagVh() {
        return imagVh;
    }

    public void setImagVh(String imagVh) {
        this.imagVh = imagVh;
    }

    public boolean isStatutVh() {
        return statutVh;
    }

    public void setStatutVh(boolean statutVh) {
        this.statutVh = statutVh;
    }

    public Rvesion getRev() {
        return rev;
    }

    public void setRev(Rvesion rev) {
        this.rev = rev;
    }

    public Categorie getCat() {
        return cat;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "matrVh=" + matrVh + ", idRev=" + idRev + ", idCat=" + idCat + ", dateAchat=" + dateAchat + ", prixAchat=" + prixAchat + ", kms=" + kms + ", marquVh=" + marquVh + ", modVh=" + modVh + ", Ac=" + Ac + ", nbPort=" + nbPort + ", nbPasssager=" + nbPasssager + ", boitevitesse=" + boitevitesse + ", prixJourVh=" + prixJourVh + ", imagVh=" + imagVh + ", statutVh=" + statutVh + ", rev=" + rev + ", cat=" + cat + ", mo=" + mo + ", ma=" + ma + '}';
    }

    public String toString1() {
        return "||matrVh=" + matrVh + "||idRev=" + idRev + "||idCat=" + idCat + "||dateAchat=" + dateAchat + "||prixAchat=" + prixAchat + "||kms=" + kms + ", marquVh=" + marquVh + "||modVh=" + modVh + "||Ac=" + Ac + "|| nbPort=" + nbPort + "|| nbPasssager=" + nbPasssager + ", boitevitesse=" + boitevitesse + ", prixJourVh=" + prixJourVh + ", imagVh=" + imagVh + "|| statutVh=" + statutVh + "|| cat=" + cat.getNomCat() + "|| mo=" + mo.getNomModel() + "|| ma=" + ma.getNimMarque() + '}';
    }
}
