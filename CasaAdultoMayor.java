import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CasaAdultoMayor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Constantes
        final int TOTAL_PERSONAS = 37;
        final int EDAD_MINIMA = 85;
        
        // Arreglos para almacenar los datos
        String[] nombres = new String[TOTAL_PERSONAS];
        int[] edades = new int[TOTAL_PERSONAS];
        
        System.out.println("=== SISTEMA DE REGISTRO CASA DEL ADULTO MAYOR ===");
        System.out.println("Por favor, ingrese los datos de las " + TOTAL_PERSONAS + " personas:");
        
        // Captura de datos
        for (int i = 0; i < TOTAL_PERSONAS; i++) {
            System.out.println("\nPersona " + (i + 1) + ":");
            
            System.out.print("Nombre: ");
            nombres[i] = br.readLine();
            
            System.out.print("Edad: ");
            edades[i] = Integer.parseInt(br.readLine());
        }
        
        // Generar reporte
        System.out.println("\n=== REPORTE DE ADULTOS MAYORES DE " + EDAD_MINIMA + " AÑOS ===");
        System.out.println("-----------------------------------------------");
        
        boolean hayPersonas = false;
        
        for (int i = 0; i < TOTAL_PERSONAS; i++) {
            if (edades[i] > EDAD_MINIMA) {
                System.out.println("Nombre: " + nombres[i] + " | Edad: " + edades[i] + " años");
                hayPersonas = true;
            }
        }
        
        if (!hayPersonas) {
            System.out.println("No hay personas mayores de " + EDAD_MINIMA + " años registradas.");
        }
        
        br.close();
    }
}