package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Directivo extends Empleado {
    private String areaAcargo;
    private ArrayList<Empleado> empleadosAcargo;

    public Directivo(String nombre, LocalDate fechaNacimiento, float sueldo, String areaAcargo) {
        super(nombre, fechaNacimiento, sueldo);
        this.areaAcargo = areaAcargo;
        this.empleadosAcargo = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e){
        this.empleadosAcargo.add(e);
    }


    @Override
    public String toString() {
        return (super.toString() + "\nArea: " + getAreaAcargo() + "     DIRECTIVO       Empleados a cargo: " + getEmpleadosAcargo());
    }
    public ArrayList<Empleado> getEmpleadosAcargo() {return empleadosAcargo;}
    public void setEmpleadosAcargo(ArrayList<Empleado> empleadosAcargo) {this.empleadosAcargo = empleadosAcargo;}
    public String getAreaAcargo() {return areaAcargo;}
    public void setAreaAcargo(String areaAcargo) {this.areaAcargo = areaAcargo;}
}
