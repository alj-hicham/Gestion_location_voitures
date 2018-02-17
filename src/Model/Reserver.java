/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.Objects;

/**
 * @author Lenovo
 */
public class Reserver {
 /*   CREATE TABLE `reserver` (
  `CIN` varchar(25) NOT NULL,
  `MATRVH` varchar(25) NOT NULL,
  `IDCONT` varchar(25) NOT NULL,
  `DATERES` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

    private String cin;
    private String matrVh;
    private String idCont;
    private Date dateRes;
    private Client cl;
    private Vehicule vh;


    public Reserver(String cin, String matrVh, String idCont, Date dateRes) {
        this.cin = cin;
        this.matrVh = matrVh;
        this.idCont = idCont;
        this.dateRes = dateRes;
    }

    public Reserver(String idCont, Date dateRes, Client cl, Vehicule vh) {
        this.idCont = idCont;
        this.dateRes = dateRes;
        this.cl = cl;
        this.vh = vh;
    }

    public Reserver() {
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

    public String getIdCont() {
        return idCont;
    }

    public void setIdCont(String idCont) {
        this.idCont = idCont;
    }

    public Date getDateRes() {
        return dateRes;
    }

    public void setDateRes(Date dateRes) {
        this.dateRes = dateRes;
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
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idCont);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserver other = (Reserver) obj;
        return Objects.equals(this.idCont, other.idCont);
    }


    public String toString1() {
        return "Reserver{" + "cin=" + cin + ", matrVh=" + matrVh + ", idCont=" + idCont + ", dateRes=" + dateRes + ", cl=" + cl.toString() + ", vh=" + vh.toString() + '}';
    }

    @Override
    public String toString() {
        return "Reserver{" + "cin=" + cin + ", matrVh=" + matrVh + ", idCont=" + idCont + ", dateRes=" + dateRes + '}';
    }


}
