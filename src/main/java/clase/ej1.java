package clase;

import java.io.*;
import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        // También se puede usar el RandomAccessFile
        System.out.println("Introduce la ruta");
        String ruta = new Scanner(System.in).nextLine();
        try(
                // Leer el archivo origen
                InputStream a =  new FileInputStream(ruta);
                BufferedInputStream b = new BufferedInputStream(a);
                // Escribir en el archivo destino
                OutputStream c = new FileOutputStream(ruta+".bak");
                BufferedOutputStream  d = new BufferedOutputStream(c);
                ) {
            byte[] bloque = new byte[4096];
            int datosLeidos = 0;
            while((datosLeidos = b.read(bloque))!=1){
                d.write(bloque,0,datosLeidos);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
