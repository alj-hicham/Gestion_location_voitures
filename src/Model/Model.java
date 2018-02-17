/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Lenovo
 */
public class Model {
    private String idModel;
    private String idMarque;
    private String nomModel;
    private String annee;
    private Marque m;

    public Model(String idModel, String idMarque, String nomModel, String annee, Marque m) {
        this.idModel = idModel;
        this.idMarque = idMarque;
        this.nomModel = nomModel;
        this.annee = annee;
        this.m = m;
    }

    public Model(String idModel, String idMarque, String nomModel, String annee) {
        this.idModel = idModel;
        this.idMarque = idMarque;
        this.nomModel = nomModel;
        this.annee = annee;
    }


    public Model() {
    }

    public String getNomModel() {
        return nomModel;
    }

    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }

    public Marque getM() {
        return m;
    }

    public void setM(Marque m) {
        this.m = m;
    }

    public String getIdModel() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Model{" + "idModel=" + idModel + ", idMarque=" + idMarque + ", nomModel=" + nomModel + ", annee=" + annee + ", m=" + m + '}';
    }


}
