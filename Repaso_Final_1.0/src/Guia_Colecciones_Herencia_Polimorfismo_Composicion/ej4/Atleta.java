package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej4;

import java.util.Scanner;

public class Atleta {
    private String nombre;
    private String categoria;
    private Atleta[] atletas;

    public Atleta(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Atleta(){

    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
    public Atleta[] getAtletas() {return atletas;}
    public void setAtletas(Atleta[] atletas) {this.atletas = atletas;}

    public void correr(){}

    public void cargarDatos(){
        boolean termina = false;
        Scanner sc = new Scanner(System.in);
        int i = 0;
        String op;

        while (termina) {
            System.out.print("Ingrese el nombre del atleta: ");
            String nomb = sc.nextLine();

            System.out.print("Ingrese la categoria del atleta: ");
            String cat = sc.nextLine();

            atletas[i] = new Atleta(nomb, cat);

            do {
                System.out.println("Desea agregar otro atleta?");
                System.out.println("S - SI");
                System.out.println("N - NO");
                op = sc.nextLine();
            } while (op.equals("SI") || op.equals("NO"));

            if (op.equals("NO"))
                termina = true;
            else
                i++;
        }
    }

    public void verDatos(){
        for (Atleta a : atletas)
            System.out.println("Nombre del atleta: " + a.getNombre() + " - Categoria: " + a.getCategoria());

    }

    public static void main(String[] args) {
        Atleta a = new Atleta();

        a.cargarDatos();
        a.verDatos();
    }
}
