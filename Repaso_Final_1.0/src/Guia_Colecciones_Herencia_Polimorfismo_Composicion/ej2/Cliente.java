package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej2;

import java.time.LocalDate;

public class Cliente extends Persona {
    private String telefono;
    private float deuda;

    public Cliente(String nombre, LocalDate fechaNacimiento, String telefono, float deuda) {
        super(nombre, fechaNacimiento);
        this.telefono = telefono;
        this.deuda = deuda;
    }

    @Override
    public String toString() {
        return (super.toString() +  "\nTelefono: " + getTelefono() + "\nDeuda acumulada: $" + getDeuda());
    }
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public float getDeuda() {return deuda;}
    public void setDeuda(float deuda) {this.deuda = deuda;}
}
