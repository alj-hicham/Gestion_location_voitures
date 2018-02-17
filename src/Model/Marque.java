/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Lenovo
 */
public class Marque {

    private String idMarque;
    private String nimMarque;

    public Marque(String idMarque, String nimMarque) {
        this.idMarque = idMarque;
        this.nimMarque = nimMarque;
    }

    public Marque() {
    }

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    public String getNimMarque() {
        return nimMarque;
    }

    public void setNimMarque(String nimMarque) {
        this.nimMarque = nimMarque;
    }

    @Override
    public String toString() {
        return "Model{" + "idMarque=" + idMarque + ", nimMarque=" + nimMarque + '}';
    }
}
