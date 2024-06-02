package ejercicio1;

import java.io.*;
import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {

        // Pedir al usuario la ruta del archivo
        System.out.print("Introduce la ruta del archivo: ");
        String ruta = new Scanner(System.in).nextLine();
        String copiaRuta = ruta + ".bak";

        // Leer y copiar el archivo en bloques de 4096 bytes
        try (FileInputStream a = new FileInputStream(ruta);
             FileOutputStream b = new FileOutputStream(copiaRuta)) {

            byte[] buffer = new byte[4096];
            int bytesLeidos;

            while ((bytesLeidos = a.read(buffer)) != -1) {
                b.write(buffer, 0, bytesLeidos);
            }

            System.out.println("Archivo duplicado con éxito: " + copiaRuta);
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no fue encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }
}
