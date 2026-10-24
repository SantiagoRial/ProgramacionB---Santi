package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej4;

public class Triatleta extends Atleta implements Nadador, Ciclista {

    public Triatleta(String nombre, String categoria) {
        super(nombre, categoria);
    }

    @Override
    public void andar() {}

    @Override
    public void nadar() {}
}
