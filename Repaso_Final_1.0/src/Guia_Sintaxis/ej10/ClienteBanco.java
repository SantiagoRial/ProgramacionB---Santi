package Guia_Sintaxis.ej10;

import java.util.Scanner;
// Ej 10
public class ClienteBanco {
    private String nombre;
    private float saldo;
    private int pin;

    public ClienteBanco(String nombre, float saldo, int pin) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.pin = pin;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public float getSaldo() {return saldo;}
    public void setSaldo(float saldo) {this.saldo = saldo;}
    public int getPin() {return pin;}
    public void setPin(int pin) {this.pin = pin;}

    public void depositaDinero(float s) {
        setSaldo(getSaldo() + s);
    }

    public void retiraDinero(float s) {
        if (getSaldo() - s >= 0)
            setSaldo(getSaldo() - s);
    }

    public void muestraEstado() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Saldo: $" + getSaldo());
    }

    public void realizaOperaciones() {
        Scanner scanner = new Scanner(System.in);
        int pinCorrecto = 0;

        System.out.println(getNombre() + ", ingrese su pin para continuar: ");
        int ingresaPin = scanner.nextInt();

        while (ingresaPin != getPin()) {
            System.out.println("Pin INCORRECTO. Ingrese nuevamente su pin para continuar: ");
            ingresaPin = scanner.nextInt();
        }

        System.out.println("Bienvenido " + getNombre() + "!");

        System.out.println("1 - DEPOSITAR DINERO");
        System.out.println("2 - RETIRAR DINERO");
        System.out.println("3 - ESTADO DE LA CUENTA");
        System.out.println("Elegir una opcion para continuar: ");
        int op = scanner.nextInt();

        while (op != 0) {
            switch (op) {
                case 1:
                    System.out.println("Ingrese la cantidad a depositar: ");
                    float ingresa = scanner.nextFloat();
                    depositaDinero(ingresa);
                    break;

                case 2:
                    System.out.println("Ingrese la cantidad a retirar: ");
                    float retira = scanner.nextFloat();
                    retiraDinero(retira);
                    break;

                case 3:
                    muestraEstado();
            }

            System.out.println("Elegir una opcion para continuar: ");
            op = scanner.nextInt();
        }
    }

    public static void main(String[] args) {
        ClienteBanco cliente1 = new ClienteBanco("Santiago", 0, 790306);
        ClienteBanco cliente2 = new ClienteBanco("Olivia", 22730, 232323);
        ClienteBanco cliente3 = new ClienteBanco("Rodrigo", 12130, 323232);

        cliente1.realizaOperaciones();
    }
}
