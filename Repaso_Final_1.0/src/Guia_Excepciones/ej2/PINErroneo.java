package Guia_Excepciones.ej2;

public class PINErroneo extends Exception {
    public PINErroneo(String message) {
        super(message);
    }
}
