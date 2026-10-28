package Guia_Excepciones.ej1;

public class PracticaExcepciones {

    public static int dividir(int dividendo, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            System.out.println("Intente nuevamente, no es posible dividir por 0.");
            throw new ArithmeticException(); // mensaje predeterminado
        }
        return (dividendo/divisor);
    }

    public static void main(String[] args) {
        System.out.println("El resultado de la division es: " + dividir(10, 0));
    }
}
