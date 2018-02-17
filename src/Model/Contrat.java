/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Contrat {

    private String idCont;
    private String dateDebut;
    private String idutil;
    private String cin;
    private String matrVh;
    private String dateFin;
    private int duree;
    private boolean gps;
    private boolean Siegebebe;
    private boolean Chainesnaige;
    private Client cl;
    private Vehicule vh;
    private Model mod;
    private Marque mar;

    //`IDCONT`, `IDUTIL`, `CIN`, `MATRVH`, `DATEDEBUT`, `DATEFIN`, `DUREE`, `GPS`, `SIGEBEBE`, `CHAINESNAIGE`
    public Contrat() {
    }

    public Contrat(String idCont, String dateDebut, String idutil, String cin, String matrVh, String dateFin, int duree, boolean gps, boolean Siegebebe, boolean Chainesnaige) {
        this.idCont = idCont;
        this.dateDebut = dateDebut;
        this.idutil = idutil;
        this.cin = cin;
        this.matrVh = matrVh;
        this.dateFin = dateFin;
        this.duree = duree;
        this.gps = gps;
        this.Siegebebe = Siegebebe;
        this.Chainesnaige = Chainesnaige;
    }

    public Contrat(String idCont, String dateDebut, String dateFin, int duree, boolean gps, boolean Siegebebe, boolean Chainesnaige, Client cl, Vehicule vh) {
        this.idCont = idCont;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.duree = duree;
        this.gps = gps;
        this.Siegebebe = Siegebebe;
        this.Chainesnaige = Chainesnaige;
        this.cl = cl;
        this.vh = vh;
    }

    public Model getMod() {
        return mod;
    }

    public void setMod(Model mod) {
        this.mod = mod;
    }

    public Marque getMar() {
        return mar;
    }

    public void setMar(Marque mar) {
        this.mar = mar;
    }

    public String getIdCont() {
        return idCont;
    }

    public void setIdCont(String idCont) {
        this.idCont = idCont;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getIdutil() {
        return idutil;
    }

    public void setIdutil(String idutil) {
        this.idutil = idutil;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getMatrVh() {
        return matrVh;
    }

    public void setMatrVh(String matrVh) {
        this.matrVh = matrVh;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isSiegebebe() {
        return Siegebebe;
    }

    public void setSiegebebe(boolean Siegebebe) {
        this.Siegebebe = Siegebebe;
    }

    public boolean isChainesnaige() {
        return Chainesnaige;
    }

    public void setChainesnaige(boolean Chainesnaige) {
        this.Chainesnaige = Chainesnaige;
    }

    public Client getCl() {
        return cl;
    }

    public void setCl(Client cl) {
        this.cl = cl;
    }

    public Vehicule getVh() {
        return vh;
    }

    public void setVh(Vehicule vh) {
        this.vh = vh;
    }

    @Override
    public String toString() {
        return "Contrat{" + "idCont=" + idCont + ", dateDebut=" + dateDebut + ", idutil=" + idutil + ", cin=" + cin + ", matrVh=" + matrVh + ", dateFin=" + dateFin + ", duree=" + duree + ", gps=" + gps + ", Siegebebe=" + Siegebebe + ", Chainesnaige=" + Chainesnaige + ", cl=" + cl + ", vh=" + vh + '}';
    }

}
