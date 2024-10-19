import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Ingrese su API KEY para acceder a la API de tipos de cambios: ");
        String apiKey = new Scanner(System.in).nextLine();

        BusquedaMoneda busqueda = new BusquedaMoneda(apiKey);

        boolean salir = false;

        do {
            System.out.println("\n --- CONVERTIDOR DE MONEDAS ---");
            System.out.println("1. Realizar cambio de divisas");
            System.out.println("2. Salir");
            System.out.print("Opcion -> ");
            var opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n --- DIVISAS --- ");
                    System.out.println("1. Dólar (USD) -> Peso Argentino (ARS)");
                    System.out.println("2. Dólar (USD) -> Peso Chileno (CLP)");
                    System.out.println("3. Peso Argentino (ARS) -> Dólar (USD)");
                    System.out.println("4. Peso Argentino (ARS) -> Peso Chileno (CLP)");
                    System.out.println("5. Peso Chileno (CLP) -> Dólar (USD)");
                    System.out.println("6. Peso Chileno (CLP) -> Peso Argentino (ARS)");
                    System.out.print("Opcion -> ");
                    var opcion2 = new Scanner(System.in).nextInt();
                    String monedaBase = "";
                    String monedaDestino = "";

                    switch (opcion2) {
                        case 1:
                            monedaBase = "USD";
                            monedaDestino = "ARS";
                            break;
                        case 2:
                            monedaBase = "USD";
                            monedaDestino = "CLP";
                            break;
                        case 3:
                            monedaBase = "ARS";
                            monedaDestino = "USD";
                            break;
                        case 4:
                            monedaBase = "ARS";
                            monedaDestino = "CLP";
                            break;
                        case 5:
                            monedaBase = "CLP";
                            monedaDestino = "USD";
                            break;
                        case 6:
                            monedaBase = "CLP";
                            monedaDestino = "ARS";
                            break;
                        default:
                            System.out.println("Opcion no valida!, intente nuevamente");
                            continue;
                    }

                    System.out.print("\nIngrese el monto a convertir: ");
                    double monto = new Scanner(System.in).nextDouble();

                    try{
                        double tasaCambio = busqueda.obtenerTasaDeCambio(monedaBase, monedaDestino);
                        double montoConvertido = monto * tasaCambio;
                        System.out.printf("%.2f %s -> %.2f %s%n", monto, monedaBase , montoConvertido, monedaDestino);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }catch (Exception e) {
                        System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
                    }
                    break;

                case 2:
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion no valida!, intente nuevamente");
            }
        }while (!salir);
    }
}