package clase;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Amigos {
    @JsonProperty
    List<Persona> friends;
    @JsonCreator
    public Amigos(@JsonProperty("friends") List<Persona> friends) {
        this.friends = friends;
    }

    public List<Persona> getFriends() {
        return friends;
    }
}
