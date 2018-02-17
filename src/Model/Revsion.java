
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
public class Revsion {
    //`IDREV`, `DATEFINAS`, `DATEVIST`, `DATEVID`

    private String idRev;
    private Date dateFinas;
    private Date dateVist;
    private int Vid;
    private Vehicule v;

    public Revsion(String idRev, Date dateFinas, Date dateVist, int Vid) {
        this.idRev = idRev;
        this.dateFinas = dateFinas;
        this.dateVist = dateVist;
        this.Vid = Vid;
    }

    public Revsion() {
    }

    public String getIdRev() {
        return idRev;
    }

    public void setIdRev(String idRev) {
        this.idRev = idRev;
    }

    public Date getDateFinas() {
        return dateFinas;
    }

    public void setDateFinas(Date dateFinas) {
        this.dateFinas = dateFinas;
    }

    public Vehicule getV() {
        return v;
    }

    public void setV(Vehicule v) {
        this.v = v;
    }

    public Date getDateVist() {
        return dateVist;
    }

    public void setDateVist(Date dateVist) {
        this.dateVist = dateVist;
    }

    public int getVid() {
        return Vid;
    }

    public void setVid(int Vid) {
        this.Vid = Vid;
    }

    @Override
    public String toString() {
        return "Rvesion{" + "idRev=" + idRev + ", dateFinas=" + dateFinas + ", dateVist=" + dateVist + ", dateVid=" + Vid + '}';
    }


}
