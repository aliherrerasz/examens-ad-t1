package ejercicio3;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Libreria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;

    private String telefono;

    @OneToMany(mappedBy = "libreria", cascade = CascadeType.ALL)
    private List<Libro> libros;

    private double caja;

    public Libreria(Direccion direccion, String telefono, double caja) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.caja = caja;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }
}
