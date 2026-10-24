package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej3;

import java.util.ArrayList;
import java.util.List;

public class Equipo implements Comparable<Equipo> {
    private String nombreEquipo;
    private List<Jugador> jugadores;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador j) {
        if (getJugadores().size() < 4) {
            getJugadores().add(j);
            j.setEquipo(this);
        }
    }

    public int getRankingEquipo() {
        int acumRank = 0;

        for (Jugador j : jugadores)
            acumRank += j.getRanking();

        return (acumRank);
    }

    public double getEdadPromedio() {
        int acumEdad = 0;

        for (Jugador j : jugadores)
            acumEdad += j.getEdad();

        return (getJugadores().isEmpty() ? 0 : (double) acumEdad / getJugadores().size());
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public int compareTo(Equipo o) {
        return Integer.compare(getRankingEquipo(), o.getRankingEquipo());
    }
}