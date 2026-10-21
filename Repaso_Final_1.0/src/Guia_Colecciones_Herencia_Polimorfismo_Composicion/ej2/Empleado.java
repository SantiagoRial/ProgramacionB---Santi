package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej2;

import java.time.LocalDate;

public class Empleado extends Persona {
    private float sueldo;

    public Empleado(String nombre, LocalDate fechaNacimiento, float sueldo) {
        super(nombre, fechaNacimiento);
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nSueldo: " + getSueldo());
    }
    public float getSueldo() {return sueldo;}
    public void setSueldo(float sueldo) {this.sueldo = sueldo;}
}
