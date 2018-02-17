/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Amine Smaki
 */
public class user {
    private String IDUTIL;
    private String NONUTIL;
    private String PASSUTIL;
    private String ROLE;

    public user() {

    }

    public user(String IDUTIL, String NONUTIL, String PASSUTIL, String ROLE) {
        this.IDUTIL = IDUTIL;
        this.NONUTIL = NONUTIL;
        this.PASSUTIL = PASSUTIL;
        this.ROLE = ROLE;
    }


    public String getIDUTIL() {
        return IDUTIL;
    }

    public void setIDUTIL(String IDUTIL) {
        this.IDUTIL = IDUTIL;
    }

    public String getNONUTIL() {
        return NONUTIL;
    }

    public void setNONUTIL(String NONUTIL) {
        this.NONUTIL = NONUTIL;
    }

    public String getPASSUTIL() {
        return PASSUTIL;
    }

    public void setPASSUTIL(String PASSUTIL) {
        this.PASSUTIL = PASSUTIL;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }


}
