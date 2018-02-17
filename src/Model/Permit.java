/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Amine Smaki
 */
public class Permit {
    private String NUMPT;
    private String CATPT;


    public Permit() {
    }

    public Permit(String NUMPT, String CATPT) {
        this.NUMPT = NUMPT;
        this.CATPT = CATPT;
    }

    public String getNUMPT() {
        return NUMPT;
    }

    public void setNUMPT(String NUMPT) {
        this.NUMPT = NUMPT;
    }

    public String getCATPT() {
        return CATPT;
    }

    public void setCATPT(String CATPT) {
        this.CATPT = CATPT;
    }


}
