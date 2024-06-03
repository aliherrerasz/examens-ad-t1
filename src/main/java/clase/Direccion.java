package clase;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity
public class Direccion implements Serializable {
    @OneToOne
    private Libreria libreria;
    @Id
    private String ciudad;
    @Id
    private String calle;
    @Id
    private int numero;

    public Direccion() {
    }

    public Direccion(String ciudad, int numero) {
        this.ciudad = ciudad;
        this.numero = numero;
    }

    public Libreria getLibreria() {
        return libreria;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }
}
