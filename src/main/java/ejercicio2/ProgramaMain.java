package ejercicio2;

import java.time.LocalDate;
import java.util.List;

public class ProgramaMain {
    public static void main(String[] args) {
        List<Programa> programas = List.of(
                new Programa("Noticiero", LocalDate.of(2024, 6, 2)),
                new Programa("Película", LocalDate.of(2024, 6, 2)),
                new Programa("Documental", LocalDate.of(2024, 6, 2))
        );

        ProgramacionDAO.generarProgramacion(programas);

        List<Programa> leidos = ProgramacionDAO.getProgramas();
        for (Programa programa : leidos) {
            System.out.println("Título: " + programa.titulo() + ", Hora de inicio: " + programa.horaInicio());
        }
    }
}
