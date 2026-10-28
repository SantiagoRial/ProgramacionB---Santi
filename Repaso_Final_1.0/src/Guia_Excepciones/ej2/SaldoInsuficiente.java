package Guia_Excepciones.ej2;

public class SaldoInsuficiente extends Exception {
    public SaldoInsuficiente(String message) {
        super(message);
    }
}
