import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SistemaMeteorologico {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Arreglo con los nombres de los días
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        // Arreglo para almacenar temperaturas
        double[] temperaturas = new double[7];
        
        System.out.println("=== SISTEMA METEOROLÓGICO LOCAL ===");
        System.out.println("Capture la temperatura promedio de cada día de la semana:");
        
        // Captura de temperaturas
        for (int i = 0; i < diasSemana.length; i++) {
            System.out.print(diasSemana[i] + ": ");
            temperaturas[i] = Double.parseDouble(br.readLine());
        }
        
        // Reporte de temperaturas y percepciones
        System.out.println("\n=== REPORTE SEMANAL DE TEMPERATURAS ===");
        System.out.println("Día\t\tTemperatura\tPercepción");
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < diasSemana.length; i++) {
            String percepcion = obtenerPercepcion(temperaturas[i]);
            
            String dia = diasSemana[i];
            if (dia.length() < 8) {
                dia += "\t";
            }
            
            System.out.println(dia + "\t" + temperaturas[i] + "°C\t\t" + percepcion);
        }
        
        br.close();
    }
    
    public static String obtenerPercepcion(double temperatura) {
        if (temperatura <= 0) {
            return "Congelante";
        } else if (temperatura <= 10) {
            return "Muy frío";
        } else if (temperatura <= 20) {
            return "Frío";
        } else if (temperatura <= 24) {
            return "Templado";
        } else if (temperatura <= 29) {
            return "Agradable";
        } else if (temperatura <= 35) {
            return "Caliente";
        } else {
            return "Muy caliente";
        }
    }
}