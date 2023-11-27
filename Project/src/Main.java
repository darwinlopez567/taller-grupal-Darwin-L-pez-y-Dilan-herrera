import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        int opcion;
        do {
            System.out.println("Opciones:");
            System.out.println("1. Ingresar un carro al parqueadero");
            System.out.println("2. Dar salida a un carro del parqueadero");
            System.out.println("3. Informar los ingresos del parqueadero");
            System.out.println("4. Consultar la cantidad de puestos disponibles");
            System.out.println("5. Avanzar el reloj del parqueadero");
            System.out.println("6. Cambiar la tarifa del parqueadero");
            System.out.println("7. Salir");

            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro: ");
                    String placa = scanner.next();

                    int numPuestoCarroExistente = parqueadero.buscarPuestoCarro(placa);
                    if (numPuestoCarroExistente != Parqueadero.CARRO_NO_EXISTE) {
                        System.out.println("Ya hay un carro con esa placa en el parqueadero. No se puede ingresar otro");
                        break;
                    }

                    int resultadoIngreso = parqueadero.entrarCarro(placa);
                    if (resultadoIngreso == Parqueadero.NO_HAY_PUESTO) {
                        System.out.println("El parqueadero está lleno. No hay puestos disponibles");
                    } else if (resultadoIngreso == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado. No se pueden ingresar carros");
                    } else if (resultadoIngreso == Parqueadero.CARRO_YA_EXISTE) {
                        System.out.println("Ya hay un carro con esa placa en el parqueadero");
                    } else {
                        System.out.println("Carro ingresado correctamente al puesto " + resultadoIngreso);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la placa del carro que desea sacar: ");
                    String placaSalida = scanner.next();
                    int resultadoSalida = parqueadero.sacarCarro(placaSalida);
                    if (resultadoSalida == Parqueadero.CARRO_NO_EXISTE) {
                        System.out.println("No hay un carro con esa placa en el parqueadero");
                    } else if (resultadoSalida == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado. No se pueden sacar carros");
                    } else {
                        System.out.println("Carro sacado correctamente. \nTotal a pagar: $" + resultadoSalida);
                    }
                    break;

                case 3:
                    System.out.println("Ingresos del parqueadero: $" + parqueadero.darMontoCaja());
                    break;

                case 4:
                    System.out.println("Puestos disponibles: " + parqueadero.calcularPuestosLibres());
                    break;

                case 5:
                    parqueadero.avanzarHora();
                    System.out.println("Reloj avanzado. \nHora actual: " + parqueadero.darHoraActual());
                    break;

                case 6:
                    System.out.print("Ingrese la nueva tarifa del parqueadero: ");
                    int nuevaTarifa = scanner.nextInt();
                    parqueadero.cambiarTarifa(nuevaTarifa);
                    System.out.println("Tarifa cambiada correctamente. Nueva tarifa: $" + parqueadero.darTarifa());
                    break;

                case 7:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 7);
    }
}
