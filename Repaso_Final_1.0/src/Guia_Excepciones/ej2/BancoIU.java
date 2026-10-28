package Guia_Excepciones.ej2;

import java.util.Scanner;

public class BancoIU {
    private ClienteBanco cb;

    public BancoIU(ClienteBanco cb) {
        this.cb = cb;
    }

    public ClienteBanco getCb() {return cb;}
    public void setCb(ClienteBanco cb) {this.cb = cb;}

    public boolean verificarPin(int p) throws PINErroneo {
        boolean esCorrecto = false;

        if (getCb().getPin() != p)
            throw new PINErroneo("El PIN ingresado es INCORRECTO. Intente nuevamente.");
        else
            esCorrecto = true;

        return (esCorrecto);
    }

    public void operaciones(){
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto = false;

        System.out.print("Bienvenido/a " + getCb().getNombre() + "! Ingrese su pin para continuar: ");

        while (!esCorrecto) {

            try {
                int ingresaPin = sc.nextInt();
                cb.verificarPin(ingresaPin);
                esCorrecto = true;
            } catch (PINErroneo e) {
                System.err.println(e.getMessage());
                System.out.print("Ingrese su pin para continuar: ");
            }
        }

        int op = -1;
        while (op != 0) {
            System.out.println("0 - FIN DE OPERACIONES");
            System.out.println("1 - DEPOSITAR DINERO");
            System.out.println("2 - RETIRAR DINERO");
            System.out.println("3 - ESTADO DE LA CUENTA");
            System.out.print("Elegir una opcion para continuar: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Ingrese el valor a depositar: ");
                    double ing = sc.nextDouble();
                    cb.deposita(ing);
                    break;

                case 2:
                    System.out.print("Ingrese el valor a retirar: ");
                    double ret = sc.nextDouble();

                    try {
                        cb.retirar(ret);
                    } catch (SaldoInsuficiente insuficiente) {
                        System.err.println(insuficiente.getMessage());;
                    }

                    break;

                case 3:
                    System.out.println("Nombre: " + getCb().getNombre());
                    System.out.println("Saldo: $" + getCb().getSaldo());
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ClienteBanco cliente1 = new ClienteBanco("Santiago", 0, 790306);
        ClienteBanco cliente2 = new ClienteBanco("Olivia", 22730, 232323);
        ClienteBanco cliente3 = new ClienteBanco("Rodrigo", 12130, 323232);
        BancoIU banco = new BancoIU(cliente1);

        banco.operaciones();
    }
}
