package clase;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Persona {
    @JsonProperty
    private int id;
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("city")
    private String ciudad;
    @JsonProperty("age")
    private int edad;
    @JsonProperty("friends")
    private List<Amigo> amigos;
    @JsonCreator
    public Persona(@JsonProperty("id") int id, @JsonProperty("name") String nombre,
                   @JsonProperty("city") String ciudad,@JsonProperty("age") int edad,
                   @JsonProperty("friends") List<Amigo> amigos) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
        this.amigos = amigos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }
}
