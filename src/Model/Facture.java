/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Facture {
    private String idfact;
    private String Idcont;
    private String date;
    private String montafatct;

    public Facture(String idfact, String Idcont, String date, String montafatct) {
        this.idfact = idfact;
        this.Idcont = Idcont;
        this.date = date;
        this.montafatct = montafatct;
    }


    public Facture() {
    }

    public String getIdfact() {
        return idfact;
    }

    public void setIdfact(String idfact) {
        this.idfact = idfact;
    }

    public String getIdcont() {
        return Idcont;
    }

    public void setIdcont(String Idcont) {
        this.Idcont = Idcont;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMontafatct() {
        return montafatct;
    }

    public void setMontafatct(String montafatct) {
        this.montafatct = montafatct;
    }

    @Override
    public String toString() {
        return "Facture{" + "idfact=" + idfact + ", Idcont=" + Idcont + ", date=" + date + ", montafatct=" + montafatct + '}';
    }


}
