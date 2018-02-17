/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Amine Smaki
 */
public class Client {
    private String CIN;
    private String NUMPT;
    private String NOMCLI;
    private String PRENCLI;
    private String DATENAIS;
    private String VILLENAIS;
    private String ADRES;
    private String TEL1;
    private String TEL2;
    private String IMGCLI;

    public Client() {
    }

    public Client(String CIN, String NUMPT, String NOMCLI, String PRENCLI, String DATENAIS, String VILLENAIS, String ADRES, String TEL1, String TEL2, String IMGCLI) {
        this.CIN = CIN;
        this.NUMPT = NUMPT;
        this.NOMCLI = NOMCLI;
        this.PRENCLI = PRENCLI;
        this.DATENAIS = DATENAIS;
        this.VILLENAIS = VILLENAIS;
        this.ADRES = ADRES;
        this.TEL1 = TEL1;
        this.TEL2 = TEL2;
        this.IMGCLI = IMGCLI;
    }

    public Client(String CIN, String NUMPT, String NOMCLI, String PRENCLI, String DATENAIS, String VILLENAIS, String ADRES, String TEL1, String TEL2) {
        this.CIN = CIN;
        this.NUMPT = NUMPT;
        this.NOMCLI = NOMCLI;
        this.PRENCLI = PRENCLI;
        this.DATENAIS = DATENAIS;
        this.VILLENAIS = VILLENAIS;
        this.ADRES = ADRES;
        this.TEL1 = TEL1;
        this.TEL2 = TEL2;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getDATENAIS() {
        return DATENAIS;
    }

    public void setDATENAIS(String DATENAIS) {
        this.DATENAIS = DATENAIS;
    }

    public String getNUMPT() {
        return NUMPT;
    }

    public void setNUMPT(String NUMPT) {
        this.NUMPT = NUMPT;
    }

    public String getNOMCLI() {
        return NOMCLI;
    }

    public void setNOMCLI(String NOMCLI) {
        this.NOMCLI = NOMCLI;
    }

    public String getPRENCLI() {
        return PRENCLI;
    }

    public void setPRENCLI(String PRENCLI) {
        this.PRENCLI = PRENCLI;
    }

    public String getVILLENAIS() {
        return VILLENAIS;
    }

    public void setVILLENAIS(String VILLENAIS) {
        this.VILLENAIS = VILLENAIS;
    }

    public String getADRES() {
        return ADRES;
    }

    public void setADRES(String ADRES) {
        this.ADRES = ADRES;
    }

    public String getTEL1() {
        return TEL1;
    }

    public void setTEL1(String TEL1) {
        this.TEL1 = TEL1;
    }

    public String getTEL2() {
        return TEL2;
    }

    public void setTEL2(String TEL2) {
        this.TEL2 = TEL2;
    }

    public String getIMGCLI() {
        return IMGCLI;
    }

    public void setIMGCLI(String IMGCLI) {
        this.IMGCLI = IMGCLI;
    }


}
