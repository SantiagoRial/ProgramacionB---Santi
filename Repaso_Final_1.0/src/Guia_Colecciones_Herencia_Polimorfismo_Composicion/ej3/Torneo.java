package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Torneo {
    private String nombre;
    private List<Equipo> equipos;

    public Torneo() {
        this.equipos = new ArrayList<>();
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
        try (BufferedReader br = new BufferedReader(new FileReader(arch))){
            String linea;
            setNombre(br.readLine().trim());

            while ((linea = br.readLine()) != null){
                String[] lineaEquipo = linea.split(";");
                Equipo nuevoEquipo =  new Equipo(lineaEquipo[0].trim());

                for (int i = 1; i < lineaEquipo.length; i++) {
                    String[] lineaJug = lineaEquipo[i].split(",");

                    String nombJug = lineaJug[0].trim();
                    int edad = Integer.parseInt(lineaJug[1].trim());
                    int ranking = Integer.parseInt(lineaJug[2].trim());

                    nuevoEquipo.agregarJugador(new Jugador(nombJug, edad, ranking));
                }
                getEquipos().add(nuevoEquipo);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo - TorneoTenis.txt - no encontrado");
        }catch (IOException e){
            System.err.println("Error al leer archivo TorneoTenis.txt");
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