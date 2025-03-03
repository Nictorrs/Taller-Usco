import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SistemaJubilacion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("=== SISTEMA DE CLASIFICACIÓN DE JUBILACIONES 2004 ===");
        System.out.println("Por favor, ingrese los datos de la persona:");
        
        // Captura de datos
        System.out.print("Nombre: ");
        String nombre = br.readLine();
        
        System.out.print("Edad: ");
        int edad = Integer.parseInt(br.readLine());
        
        System.out.print("Años de antigüedad en su empleo: ");
        int antiguedad = Integer.parseInt(br.readLine());
        
        // Determinar tipo de jubilación
        String tipoJubilacion;
        
        if (edad >= 60 && antiguedad < 25) {
            tipoJubilacion = "Jubilación por edad";
        } else if (edad < 60 && antiguedad >= 25) {
            tipoJubilacion = "Jubilación por antigüedad joven";
        } else if (edad >= 60 && antiguedad >= 25) {
            tipoJubilacion = "Jubilación por antigüedad adulta";
        } else {
            tipoJubilacion = "No cumple con los requisitos para jubilación en 2004";
        }
        
        // Mostrar resultado
        System.out.println("\n=== RESULTADO DE CLASIFICACIÓN ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Antigüedad: " + antiguedad + " años");
        System.out.println("Clasificación: " + tipoJubilacion);
        
        // Mostrar detalles adicionales según el tipo de jubilación
        if (!tipoJubilacion.equals("No cumple con los requisitos para jubilación en 2004")) {
            System.out.println("\nDetalles de la clasificación:");
            
            if (tipoJubilacion.equals("Jubilación por edad")) {
                System.out.println("- Aplica para personas de 60 años o más");
                System.out.println("- Con antigüedad laboral menor a 25 años");
            } else if (tipoJubilacion.equals("Jubilación por antigüedad joven")) {
                System.out.println("- Aplica para personas menores de 60 años");
                System.out.println("- Con antigüedad laboral de 25 años o más");
            } else {
                System.out.println("- Aplica para personas de 60 años o más");
                System.out.println("- Con antigüedad laboral de 25 años o más");
            }
            
            System.out.println("\nLa persona se jubilará en el año 2004.");
        }
        
        br.close();
    }
}