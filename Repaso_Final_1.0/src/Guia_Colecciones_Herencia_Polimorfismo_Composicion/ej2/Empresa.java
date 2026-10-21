package Guia_Colecciones_Herencia_Polimorfismo_Composicion.ej2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {

    private ArrayList<Empleado> empleados;
    private ArrayList<Cliente> clientes;

    public Empresa() {
        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregar(Cliente c){
        this.clientes.add(c);
    }

    public void agregar(Empleado e){
        this.empleados.add(e);
    }

    public void listarClientes(){
        System.out.println("CLIENTES");
        System.out.println();

        for (Cliente cliente : this.clientes){
            System.out.println(cliente);
            System.out.println();
        }
    }

    public void listarEmpleados(){
        System.out.println("EMPLEADOS");
        System.out.println();

        for (Empleado empleado : this.empleados) {
            System.out.println(empleado);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        Cliente cliente1 = new Cliente("Carlos", LocalDate.of(1990, 1, 14), "996991992", 900);
        Cliente cliente2 = new Cliente("Juan", LocalDate.of(1995, 12, 22), "225447411", 0);
        Empleado empleado1 = new Empleado("Fernando", LocalDate.of(1986, 11, 12), 11111);
        Empleado empleado2 = new Empleado("Andrea", LocalDate.of(1955, 11, 12), 22222);
        Empleado empleado3 = new Empleado("Mario", LocalDate.of(1986, 11, 1), 44444);
        Directivo directivo1 = new Directivo("Mascherano", LocalDate.of(1960, 8, 30), 33333, "Desarrollo");
        Directivo directivo2 = new Directivo("Clara", LocalDate.of(1975, 12, 12), 55555, "Gerencia");

        empresa.agregar(cliente1);
        empresa.agregar(cliente2);
        empresa.agregar(empleado1);
        empresa.agregar(empleado2);
        empresa.agregar(empleado3);

        empresa.agregar(directivo1);
        directivo1.agregarEmpleado(empleado1);
        directivo1.agregarEmpleado(empleado2);

        empresa.agregar(directivo2);
        directivo2.agregarEmpleado(empleado3);

        empresa.listarClientes();
        empresa.listarEmpleados();
    }
}
