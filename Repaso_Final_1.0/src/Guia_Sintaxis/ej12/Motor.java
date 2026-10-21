package Guia_Sintaxis.ej12;

public class Motor {
    private int cilindrada;
    private TipoMotor tipo;

    public Motor(int cilindrada, TipoMotor tipo) {
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public void setTipo(TipoMotor tipo) {
        this.tipo = tipo;
    }
}
