/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Lenovo
 */
public class GenerModel {

    private int dato;
    private int cont = 1;
    private String num = "";

    public void generar(int dato) {
        this.dato = dato;
        if ((this.dato >= 10000) && (this.dato < 100000)) {
            num = "" + this.dato;
        }
        if ((this.dato >= 1000) && (this.dato < 10000)) {

            num = "0" + this.dato;
        }
        if ((this.dato >= 100) && (this.dato < 1000)) {

            num = "00" + this.dato;
        }
        if ((this.dato >= 10) && (this.dato < 100)) {

            num = "000" + this.dato;
        }
        if (this.dato < 10) {
            num = "0000" + this.dato;
        }

    }

    public String serie() {
        return this.num;
    }

}
