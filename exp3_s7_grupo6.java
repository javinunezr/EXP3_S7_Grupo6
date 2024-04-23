/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp3_s7_grupo6;

/**
 *
 * @author javier
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Exp3_S7_Grupo6 {
    
        // Variables estáticas y globales
    static int precioVIP = 30000;
    static int precioPalco = 25000;
    static int precioPlatea = 20000;
    static int precioGaleria = 15000;
    static int descuentoEstudiante = 10;
    static int descuentoTerceraEdad = 15;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Listas para almacenar la información de las ventas
        ArrayList<String> ubicaciones = new ArrayList<>();
        ArrayList<Integer> preciosFinales = new ArrayList<>();
        ArrayList<Integer> descuentosAplicados = new ArrayList<>();

        System.out.println("Bienvenido al Teatro Moro");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Ver resumen de ventas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    comprarEntrada(scan, ubicaciones, preciosFinales, descuentosAplicados);
                    break;
                case 2:
                    verResumenVentas (ubicaciones, preciosFinales, descuentosAplicados);
                    break;
                case 3:
                    continuar = false;
                    System.out.println("¡Gracias por visitar el Teatro Moro!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void comprarEntrada(Scanner scan, ArrayList<String> ubicaciones, ArrayList<Integer> preciosFinales, ArrayList<Integer> descuentosAplicados) {
        System.out.println("\nIndique la entrada que desea comprar:");
        System.out.println("VIP:      $30000 ");
        System.out.println("PALCO:    $25000 ");
        System.out.println("PLATEA:   $20000 ");
        System.out.println("GALERIA:  $15000 ");
        String tipoDeEntrada = scan.next().toLowerCase();

        int precioBase = 0;
        switch (tipoDeEntrada) {
            case "vip":
                precioBase = precioVIP;
                break;
            case "palco":
                precioBase = precioPalco;
                break;
            case "platea":
                precioBase = precioPlatea;
                break;
            case "galeria":
                precioBase = precioGaleria;
                break;
            default:
                System.out.println("Tipo de entrada no válida.");
                return;
        }

        System.out.println("Por favor ingrese su edad:");
        int edad = scan.nextInt();
        int descuento = 0;
        if (edad <= 18) {
            descuento = descuentoEstudiante;
        } else if (edad >= 65) {
            descuento = descuentoTerceraEdad;
        }

        double precioFinal = precioBase * (1 - (double) descuento / 100);
        ubicaciones.add(tipoDeEntrada);
        preciosFinales.add((int) precioFinal);
        descuentosAplicados.add(descuento);

        System.out.println("------------------------------------");
        System.out.println("             Teatro Moro            ");
        System.out.println("------------------------------------");
        for (int i = 0; i < ubicaciones.size(); i++) {
            System.out.println("Ubicación: " + ubicaciones.get(i).toUpperCase());
            System.out.println("Costo base: $" + obtenerCostoBase(ubicaciones.get(i)));
            System.out.println("Descuento aplicado: " + descuentosAplicados.get(i) + "%");
            System.out.println("Costo final: $" + preciosFinales.get(i) + "\n");
                       
            
        // Calcular la suma total de los precios finales
        int total = 0;
        for (int precio : preciosFinales) {
            total += precio;
        }

        // Mostrar el resumen del pago total
        System.out.println("Resumen del Pago Total:");
        System.out.println("Total a pagar: $" + total);
        System.out.println("------------------------------------");
        System.out.println("Gracias por su visita al Teatro Moro");
        System.out.println("------------------------------------");
    }
    }
    
    
    public static int obtenerCostoBase(String ubicacion) {
    switch (ubicacion.toLowerCase()) {
        case "vip":
            return precioVIP;
        case "palco":
            return precioPalco;
        case "platea":
            return precioPlatea;
        case "galeria":
            return precioGaleria;
        default:
            return 0;
    }
    }
        public static void verResumenVentas (ArrayList<String> ubicaciones, ArrayList<Integer> preciosFinales, ArrayList<Integer> descuentosAplicados) {
        if (ubicaciones.isEmpty()) {
            System.out.println("No se han realizado ventas aún.");
            return;
        }

        System.out.println("\n----- Resumen de Ventas -----");
        for (int i = 0; i < ubicaciones.size(); i++) {
            System.out.println("Ubicación: " + ubicaciones.get(i).toUpperCase());
            System.out.println("Precio final: $" + preciosFinales.get(i));
            System.out.println("Descuento aplicado: " + descuentosAplicados.get(i) + "%\n");
                        
        }        
    }
}
