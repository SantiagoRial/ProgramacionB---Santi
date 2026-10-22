package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Torneo {
    private String nombre;
    private ArrayList<Equipo> equipos;

    public Torneo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void agregar (Equipo e){
        getEquipos().add(e);
    }

    public void listaEquipos(){
        for (Equipo e: getEquipos()){
            System.out.println("Equipo: " + e.getNombreEquipo());
            System.out.println("--> Jugadores: ");

            for (Jugador j : e.getJugadores())
                System.out.println("    --> Nombre: " + j.getNombre() + " - Edad: " + j.getEdad() + " - Ranking: Nº" + j.getRanking());

            System.out.println();
        }
    }

    public void listaEquiposPorRanking(){
        for (Equipo e: getEquipos()){
            int rank = e.getRankingEquipo();


        }
    }

    public void leeArchTxt(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("TorneoTenis.txt"));
            String linea;

            String nombreTorneo = br.readLine().trim();

            Torneo t = new Torneo(nombreTorneo);

            while ((linea = br.readLine()) != null){
                String[] lineaEquipo = linea.split(";");
                String nomb =  lineaEquipo[0].trim();
                ArrayList<Jugador> jug = new ArrayList<>();

                for (int i = 1; i < lineaEquipo.length; i++) {
                    String[] lineaJug = lineaEquipo[i].split(",");

                    String nombJug = lineaJug[0].trim();
                    int edad = Integer.parseInt(lineaJug[1].trim());
                    int ranking = Integer.parseInt(lineaJug[2].trim());

                    Jugador jugador = new Jugador(nombJug, edad, ranking);
                    jug.add(jugador);
                }

                Equipo eq = new Equipo(nomb, jug);

                t.agregar(eq);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo - TorneoTenis.txt - no encontrado");
        }catch (IOException e){
            System.err.println("Error al leer archivo TorneoTenis.txt");
        }
    }

    public static void main(String[] args) {

    }
}
