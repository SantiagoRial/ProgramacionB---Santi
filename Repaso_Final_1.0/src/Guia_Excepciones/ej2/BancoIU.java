package Guia_Excepciones.ej2;

import java.util.Scanner;

public class BancoIU {
    private ClienteBanco cb;

    public ClienteBanco getCb() {return cb;}
    public void setCb(ClienteBanco cb) {this.cb = cb;}

    public void deposita(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el valor a depositar: ");
        double ing = sc.nextDouble();

        getCb().setSaldo(getCb().getSaldo() + ing);
    }

    public void retirar() throws SaldoInsuficiente{
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el valor a retirar: ");
        double ret = sc.nextDouble();

        if ((getCb().getSaldo() - ret) < 0){
            throw new SaldoInsuficiente("Saldo insuficiente. Ingrese un valor válido. Saldo actual: $" + getCb().getSaldo());
        }
        else
            getCb().setSaldo(getCb().getSaldo() - ret);
    }

    public void muestraEstado(){
        System.out.println("Nombre: " + getCb().getNombre());
        System.out.println("Saldo: $" + getCb().getSaldo());
    }

    public boolean verificarPin(int p) throws PINErroneo {
        boolean esCorrecto = false;

        if (getCb().getPin() != p)
            throw new PINErroneo("El PIN ingresado es INCORRECTO. Intente nuevamente.");
        else
            esCorrecto = true;

        return (esCorrecto);
    }

    public void operaciones() throws PINErroneo, SaldoInsuficiente {
        Scanner sc = new Scanner(System.in);

        System.out.print("Bienvenido/a " + getCb().getNombre() + "! Ingrese su pin para continuar: ");
        int ingresaPin = sc.nextInt();

        while (!verificarPin(ingresaPin)){
            System.out.print("Ingrese su pin para continuar: ");
            ingresaPin = sc.nextInt();
        }

        System.out.println("0 - FIN DE OPERACIONES");
        System.out.println("1 - DEPOSITAR DINERO");
        System.out.println("2 - RETIRAR DINERO");
        System.out.println("3 - ESTADO DE LA CUENTA");
        System.out.println("Elegir una opcion para continuar: ");
        int op = sc.nextInt();

        while (op != 0) {
            switch (op) {
                case 1:
                    deposita();
                    break;

                case 2:
                    retirar();
                    break;

                case 3:
                    muestraEstado();
                    break;
            }

            System.out.println("Elegir una opcion para continuar: ");
            op = sc.nextInt();
        }
    }
}
