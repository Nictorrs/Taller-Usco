/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendacomputadoras;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SistemaAutomotriz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Variables para almacenar las selecciones
        String tipoVehiculo = "";
        String colorVehiculo = "";
        int opcionTipo, opcionColor;
        
        // Menú para seleccionar el tipo de vehículo
        System.out.println("===== SELECCIÓN DE VEHÍCULO =====");
        System.out.println("1. Auto");
        System.out.println("2. SUV");
        System.out.println("3. Camioneta");
        System.out.print("Seleccione el tipo de vehículo (1-3): ");
        
        opcionTipo = Integer.parseInt(br.readLine());
        
        // Estructura switch para el tipo de vehículo
        switch (opcionTipo) {
            case 1:
                tipoVehiculo = "Auto";
                
                System.out.println("\n==== SELECCIÓN DE COLOR PARA AUTO ====");
                System.out.println("1. Negro");
                System.out.println("2. Blanco");
                System.out.println("3. Rojo");
                System.out.print("Seleccione el color del auto (1-3): ");
                
                opcionColor = Integer.parseInt(br.readLine());
                
                // Switch anidado para el color
                switch (opcionColor) {
                    case 1:
                        colorVehiculo = "Negro";
                        break;
                    case 2:
                        colorVehiculo = "Blanco";
                        break;
                    case 3:
                        colorVehiculo = "Rojo";
                        break;
                    default:
                        colorVehiculo = "Color no válido";
                }
                break;
                
            case 2:
                tipoVehiculo = "SUV";
                
                // Menú anidado para seleccionar el color del SUV
                System.out.println("\n==== SELECCIÓN DE COLOR PARA SUV ====");
                System.out.println("1. Negro");
                System.out.println("2. Blanco");
                System.out.println("3. Rojo");
                System.out.print("Seleccione el color del SUV (1-3): ");
                
                opcionColor = Integer.parseInt(br.readLine());
                
                switch (opcionColor) {
                    case 1:
                        colorVehiculo = "Negro";
                        break;
                    case 2:
                        colorVehiculo = "Blanco";
                        break;
                    case 3:
                        colorVehiculo = "Rojo";
                        break;
                    default:
                        colorVehiculo = "Color no válido";
                }
                break;
                
            case 3:
                tipoVehiculo = "Camioneta";
                
                System.out.println("\n==== SELECCIÓN DE COLOR PARA CAMIONETA ====");
                System.out.println("1. Negro");
                System.out.println("2. Blanco");
                System.out.println("3. Rojo");
                System.out.print("Seleccione el color de la camioneta (1-3): ");
                
                opcionColor = Integer.parseInt(br.readLine());
                
                switch (opcionColor) {
                    case 1:
                        colorVehiculo = "Negro";
                        break;
                    case 2:
                        colorVehiculo = "Blanco";
                        break;
                    case 3:
                        colorVehiculo = "Rojo";
                        break;
                    default:
                        colorVehiculo = "Color no válido";
                }
                break;
                
            default:
                tipoVehiculo = "Tipo no válido";
        }
        
        // Mostrar el resultado de la selección
        System.out.println("\n===== SELECCIÓN REALIZADA =====");
        System.out.println("Tipo de vehículo: " + tipoVehiculo);
        System.out.println("Color: " + colorVehiculo);
        
        br.close();
    }
}