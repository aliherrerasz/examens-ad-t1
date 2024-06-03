package clase;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Amigo {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty
    private List<String> hobbies;

    @JsonCreator
    public Amigo(@JsonProperty("name") String nombre, @JsonProperty("hobbies") List<String> hobbies) {
        this.nombre = nombre;
        this.hobbies = hobbies;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}
