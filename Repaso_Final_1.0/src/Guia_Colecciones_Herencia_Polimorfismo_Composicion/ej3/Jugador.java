package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej3;

public class Jugador implements Comparable<Jugador> {
    private String nombre;
    private int ranking;
    private int edad;
    private Equipo equipo; // Inciso c

    public Jugador(String nombre, int ranking, int edad) throws EdadInvalida{
        if (edad < 16 || edad > 80)
            throw new EdadInvalida("Edad invalida (" + edad + ") para el jugador " + nombre);

        this.nombre = nombre;
        this.ranking = ranking;
        this.edad = edad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Jugador o) {
        return Integer.compare(getRanking(), o.getRanking());
    }

    @Override
    public String toString() {
        return (" --> " + getNombre() + " (" + getRanking() + "º) - " + getEquipo().getNombreEquipo());
    }
}
