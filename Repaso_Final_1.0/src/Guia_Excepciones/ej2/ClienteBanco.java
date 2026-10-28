package Guia_Excepciones.ej2;

import java.util.Scanner;

public class ClienteBanco {

    private String nombre;
    private double saldo;
    private int pin;
    private BancoIU iu;

    public ClienteBanco(String nombre, double saldo, int pin) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.pin = pin;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public double getSaldo() {return saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}
    public int getPin() {return pin;}
    public void setPin(int pin) {this.pin = pin;}

    public static void main(String[] args) {
        ClienteBanco cliente1 = new ClienteBanco("Santiago", 0, 790306);
        ClienteBanco cliente2 = new ClienteBanco("Olivia", 22730, 232323);
        ClienteBanco cliente3 = new ClienteBanco("Rodrigo", 12130, 323232);


    }
}
