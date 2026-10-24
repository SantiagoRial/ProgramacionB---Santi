package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej4;

public class Delfin extends Animal implements Nadador {
    public Delfin(String especie, String grupo) {
        super(especie, grupo);
    }

    @Override
    public String nadar() {
        return (getEspecie() + ", Delfin nadando");
    }
}
