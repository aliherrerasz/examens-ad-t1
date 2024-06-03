package clase;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ProgramacionDAO {
    public static void generarProgramacion(List<Programa> programas){
        try(
                OutputStream a = new FileOutputStream("programacion.bin", true);
                BufferedOutputStream b = new BufferedOutputStream(a);
                DataOutputStream c = new DataOutputStream(b);
                ObjectOutputStream d = new ObjectOutputStream(c);
                )
        {
            // Escribe la cantidad de programas en el archivo
            d.writeInt(programas.size());
            for(Programa p:programas){
                d.writeObject(p.horaInicio()); // Esto es el objeto serializable
                d.writeUTF(p.titulo());
            }

        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static List<Programa> getProgramas(){
        List<Programa> lista = new ArrayList<>();
        try(
                InputStream a = new FileInputStream("programas.bin");
                BufferedInputStream b = new BufferedInputStream(a);
                ObjectInputStream  c = new ObjectInputStream(b);
                ){
            int cantidad = c.readInt();
            for(int i = 0; i<cantidad;i++){
                LocalTime hora = (LocalTime) c.readObject();
                String titulo = c.readUTF();
                lista.add(new Programa(titulo,hora));
            }

        }catch (IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
