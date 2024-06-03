package clase;

public class LibroDigital extends Libro{
    private Formato formato;

    public LibroDigital(){

    }
    public LibroDigital(String isbn, String titulo, double precio, Formato f) {
        super(isbn, titulo, precio);
        formato = f;
    }
}
