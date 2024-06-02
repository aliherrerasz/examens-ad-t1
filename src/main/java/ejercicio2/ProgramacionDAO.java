package ejercicio2;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ProgramacionDAO {
    public static void generarProgramacion(List<Programa> programas) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("programacion.bin"))) {
            dos.writeInt(programas.size());
            for (Programa programa : programas) {
                dos.writeUTF(programa.horaInicio()+"");
                dos.writeUTF(programa.titulo());
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    public static List<Programa> getProgramas(){
        List<Programa> programas = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream("programacion.bin"))) {
            int numProgramas = dis.readInt();
            for (int i = 0; i < numProgramas; i++) {
                LocalDate horaInicio = LocalDate.parse(dis.readUTF());
                String titulo = dis.readUTF();
                programas.add(new Programa(titulo, horaInicio));
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return programas;
    }
}
