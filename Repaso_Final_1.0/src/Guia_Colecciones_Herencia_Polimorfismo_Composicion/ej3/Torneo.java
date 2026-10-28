package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Torneo {
    private String nombre;
    private List<Equipo> equipos;
    private static final Logger logger = Logger.getLogger(Torneo.class.getName());

    public Torneo() {
        this.equipos = new ArrayList<>();

        try {
            FileHandler fh = new FileHandler("edades_invalidas.log", false);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        }catch (Exception e){
            System.err.println("Error al configurar el log.");
        }
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Equipo> getEquipos() {return equipos;}
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    public void agregar (Equipo e){
        getEquipos().add(e);
    }

    public void listaEquipos(){
        System.out.println("------------ EQUIPOS E INTEGRANTES ------------");
        for (Equipo e: getEquipos()){
            System.out.println("Equipo: " + e.getNombreEquipo());
            System.out.println("--> Jugadores ");

            for (Jugador j : e.getJugadores())
                System.out.println("   --> Nombre: " + j.getNombre() + " - Edad: " + j.getEdad() + " - Ranking: Nº" + j.getRanking());

            System.out.println();
        }
    }

    public void listaEquiposPorRanking(){
        System.out.println("-------- EQUIPOS ORDENADOS POR RANKING --------");
        List<Equipo> equiposOrdenados = new ArrayList<>(getEquipos());
        Collections.sort(equiposOrdenados);

        for (int i = 0; i < equiposOrdenados.size(); i++) {
            System.out.println("Pos. Nº" + (i + 1) + " - " + equiposOrdenados.get(i).getNombreEquipo());
        }
        System.out.println();
    }

    public void jugadoresOrdenadosPorRanking(){
        System.out.println("------- JUGADORES ORDENADOS POR RANKING -------");
        List<Jugador> allPlayers = new ArrayList<>();

        for (Equipo e : getEquipos()){
            allPlayers.addAll(e.getJugadores());
        }

        Collections.sort(allPlayers);
        for (Jugador j : allPlayers){
            System.out.println(j);
        }
    }

    public void leeArchTxt(String arch){
        int cantJug = 0; // ej 6
        int cantInv = 0; // ej 6

        try (BufferedReader br = new BufferedReader(new FileReader(arch))){
            String linea;
            setNombre(br.readLine().trim());

            while ((linea = br.readLine()) != null){
                String[] lineaEquipo = linea.split(";");
                Equipo nuevoEquipo =  new Equipo(lineaEquipo[0].trim());

                for (int i = 1; i < lineaEquipo.length; i++) {
                    String[] lineaJug = lineaEquipo[i].split(",");

                    String nombJug = lineaJug[0].trim();
                    int ranking = Integer.parseInt(lineaJug[1].trim());
                    int edad = Integer.parseInt(lineaJug[2].trim());
                    cantJug++; // ej 6

                    try {
                        nuevoEquipo.agregarJugador(new Jugador(nombJug, ranking, edad));
                    }catch (EdadInvalida ei){
                        logger.warning(nuevoEquipo.getNombreEquipo() + " - " + ei.getMessage());
                        cantInv++; // ej 6

                        try { // ej 6
                            nuevoEquipo.agregarJugador(new Jugador(nombJug, ranking , -1)); // ej 6
                        }catch (EdadInvalida e){} // ej 6
                    }
                }
                getEquipos().add(nuevoEquipo);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo - TorneoTenis.txt - no encontrado");
        }catch (IOException e){
            System.err.println("Error al leer archivo TorneoTenis.txt");
        }
        finally { // ej 6
            double porcentaje = (cantInv*100)/cantJug; // ej 6
            System.out.println("  --> ESTADÍSTICA: " + porcentaje + "% de los jugadores fueron ingresados con una edad invalida."); // ej 6
        }
    }

    public static void main(String[] args) {
        Torneo t = new Torneo();

        t.leeArchTxt("TorneoTenis.txt");
        t.listaEquipos();
        t.listaEquiposPorRanking();
        t.jugadoresOrdenadosPorRanking();
    }
}