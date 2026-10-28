package Guia_Excepciones.ej2;

import java.util.Scanner;

public class ClienteBanco {

    private String nombre;
    private double saldo;
    private int pin;

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

    public void deposita(double dep){
        setSaldo(getSaldo() + dep);
    }

    public void retirar(double ret) throws SaldoInsuficiente{
        if ((getSaldo() - ret) < 0){
            throw new SaldoInsuficiente("Saldo insuficiente. Ingrese un valor válido. Saldo actual: $" + getSaldo());
        }
        else
            setSaldo(getSaldo() - ret);
    }

    public boolean verificarPin(int p) throws PINErroneo {
        boolean esCorrecto = false;

        if (getPin() != p)
            throw new PINErroneo("El PIN ingresado es INCORRECTO. Intente nuevamente.");
        else
            esCorrecto = true;

        return (esCorrecto);
    }
}
