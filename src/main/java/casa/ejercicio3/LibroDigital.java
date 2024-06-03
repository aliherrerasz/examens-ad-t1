package casa.ejercicio3;

public class LibroDigital extends Libro {
    private Formato formato;

    public LibroDigital(String isbn, String titulo, Double precio, Formato formato) {
        super(isbn, titulo,precio);
        this.formato = formato;
    }
}
