package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej3;

import java.util.ArrayList;

public class Equipo {
    private String nombreEquipo;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        ArrayList<Jugador> jugadores = new ArrayList<>();
    }

    public String getNombreEquipo() {return nombreEquipo;}
    public void setNombreEquipo(String nombreEquipo) {this.nombreEquipo = nombreEquipo;}
}
