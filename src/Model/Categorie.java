/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author soufyane
 */
public class Categorie {
    private int idCat;
    private String NomCat;

    public Categorie(int idCat, String NomCat) {
        this.idCat = idCat;
        this.NomCat = NomCat;
    }

    public Categorie() {
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return NomCat;
    }

    public void setNomCat(String NomCat) {
        this.NomCat = NomCat;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCat=" + idCat + ", NomCat=" + NomCat + '}';
    }

}
