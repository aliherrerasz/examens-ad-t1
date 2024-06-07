package T2;

import java.util.List;

public record Grado(int id, String nombre, int duracion, List<Asignatura> asignaturas) {
    public int creditos(){
        int creditos = 0;
        for(Asignatura a: asignaturas){
            creditos+=a.creditos();
        }
        return creditos;
    }
}
