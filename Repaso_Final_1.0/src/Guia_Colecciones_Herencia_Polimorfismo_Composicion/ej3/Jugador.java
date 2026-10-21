package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej3;

public class Jugador {
    private String nombre;
    private int ranking;
    private int edad;

    public Jugador(String nombre, int ranking, int edad) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.edad = edad;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getRanking() {return ranking;}
    public void setRanking(int ranking) {this.ranking = ranking;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
}
