/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendacomputadoras;
/**
 *
 * @author 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TiendaComputadoras {
    public static void main(String[] args) {
        try {   
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
          
            System.out.print("Ingrese cantidad de computadoras: ");
            int cantidad = Integer.parseInt(br.readLine());
            if (cantidad <= 0 ) {
                System.out.println("ERROR LA CANITDAD DIGITADA NO PUEDE SER MENOR O IGUAL A 0"); 
            }
           else {
            // Precio fijo
            double precio = 500.0;
            
            // Calcular subtotal
            double subtotal = cantidad * precio;
             
            double descuento = 0;
            
            if (cantidad < 5) {
                descuento = subtotal * 0.10; 
            } else if (cantidad < 10) {
                descuento = subtotal * 0.20; 
            } else {
                descuento = subtotal * 0.40; 
            }
            
            // Calcular total
            double total = subtotal - descuento;
            
            // Mostrar resultados
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("Descuento: $" + descuento);
            System.out.println("Total: $" + total);
            }     
            br.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
