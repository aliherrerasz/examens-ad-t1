package casa.ejercicio3;

import java.util.List;

public class LibroPapel extends Libro{
    private int numeroPaginas;
    private List<Libreria> librerias;
    public LibroPapel(String isbn, String titulo, double precio) {
        super(isbn, titulo, precio);
    }
}
