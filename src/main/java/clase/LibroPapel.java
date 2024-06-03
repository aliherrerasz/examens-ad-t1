package clase;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;
@Entity
public class LibroPapel extends Libro {
    @Min(1)
    @Max(2000)
    private int numeroPaginas;
    @ManyToMany
    private List<Libreria> librerias;
    public LibroPapel(String isbn, String titulo, double precio, int np) {
        super(isbn, titulo, precio);
        numeroPaginas = np;
        librerias = new ArrayList<>();
    }


    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public List<Libreria> getLibrerias() {
        return librerias;
    }

    public void setLibrerias(List<Libreria> librerias) {
        this.librerias = librerias;
    }
}
