package clase;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor implements Serializable {
    private int id;
    @Column(length = 100)
    private String nombre;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "Autor")
    private List<Libro> libros;

    public Autor(String nombre) {
        this.nombre = nombre;
        libros = new ArrayList<>();
    }

    public Autor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
