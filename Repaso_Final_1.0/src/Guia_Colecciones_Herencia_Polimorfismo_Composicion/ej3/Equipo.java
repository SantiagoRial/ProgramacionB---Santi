package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej3;

import java.util.ArrayList;

public class Equipo {
    private String nombreEquipo;
    ArrayList<Jugador> jugadores;

    public Equipo(String nombreEquipo,  ArrayList<Jugador> jugadores) {
        this.nombreEquipo = nombreEquipo;
        jugadores = new ArrayList<>();
    }

    public int getRankingEquipo(){
        int acumRank = 0;

        for (Jugador j : jugadores)
            acumRank +=  j.getRanking();

        return (acumRank);
    }

    public float getEdadPromedio(){
        int acumEdad = 0;

        for (Jugador j : jugadores)
            acumEdad +=  j.getEdad();

        return ((float) acumEdad/jugadores.size());
    }
    public String getNombreEquipo() {return nombreEquipo;}
    public void setNombreEquipo(String nombreEquipo) {this.nombreEquipo = nombreEquipo;}
    public ArrayList<Jugador> getJugadores() {return jugadores;}
    public void setJugadores(ArrayList<Jugador> jugadores) {this.jugadores = jugadores;}
}
