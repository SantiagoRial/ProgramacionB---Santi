package Guia_Sintaxis.ej12;

// Ej 12
public class Automovil {
    private String patente;
    private String owner;
    private Motor motor;

    public Automovil(String patente, String owner, int cilindrada, TipoMotor tipo) {
        this.patente = patente;
        this.owner = owner;
        this.motor = new Motor(cilindrada, tipo);
    }

    public String getPatente() {return patente;}
    public void setPatente(String patente) {this.patente = patente;}
    public String getOwner() {return owner;}
    public void setOwner(String owner) {this.owner = owner;}
    public Motor getMotor() {return motor;}
    public void setMotor(Motor motor) {this.motor = motor;}

    public static void main(String[] args) {
        Automovil auto1 = new Automovil("AX 101 BB", "S. Rial", 1150, TipoMotor.DIESEL);
        Automovil auto2 = new Automovil("AY 202 BC", "O. Rodrigo", 1350, TipoMotor.NAFTERO);
        Automovil auto3 = new Automovil("AZ 101 BD", "L. Messi", 1550, TipoMotor.ELECTRICO);

        Automovil[] vecAutos = {auto1, auto2, auto3};

        for (int i = 0; i < vecAutos.length; i++){
            System.out.println("Dueño del vehículo: " + vecAutos[i].getOwner());
            System.out.println("Patente del vehículo: " +  vecAutos[i].getPatente());
            System.out.println("Tipo de motor: " + vecAutos[i].getMotor().getTipo());
            System.out.println("Cilindrada del motor: " + vecAutos[i].getMotor().getCilindrada());
            System.out.println("------------------------------------------------");
        }
    }
}
