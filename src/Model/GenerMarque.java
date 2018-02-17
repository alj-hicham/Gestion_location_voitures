package Model;

public class GenerMarque {

    private int dato;
    private int cont = 1;
    private String num = "";

    public void generar(int dato) {
        this.dato = dato;

        if ((this.dato >= 1000) && (this.dato < 10000)) {

            num = "" + this.dato;
        }
        if ((this.dato >= 100) && (this.dato < 1000)) {

            num = "0" + this.dato;

        }
        if ((this.dato >= 10) && (this.dato < 100)) {

            num = "00" + this.dato;
        }
        if (this.dato < 10) {

            num = "000" + this.dato;
        }

    }

    public String serie() {
        return this.num;
    }

}
