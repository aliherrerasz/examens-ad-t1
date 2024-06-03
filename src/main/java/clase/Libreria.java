package clase;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Libreria implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }

    @OneToOne
    @NotNull
    private Direccion direccion;
    private String telefono;
    @ManyToMany
    private List<Libro> libros;
    private double caja;

    public Libreria() {
    }

    public Libreria(Direccion direccion, String telefono, double caja) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.caja = caja;
        libros =new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public double getCaja() {
        return caja;
    }
}
