package clase;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        Amigos amigos = null;
        try{
            ObjectMapper om = new ObjectMapper().findAndRegisterModules().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            amigos = om.readValue(new File("ejercicio3.json"),Amigos.class);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        if(amigos==null){
            System.out.println("No se puede cargar el archivo");
        }else{
            System.out.println("Introduce el nombre de una persona");
            String nombre = new Scanner(System.in).nextLine();
            Persona persona = null;
            for (Persona p:amigos.getFriends()){
                if(p.getNombre().equals(nombre)){
                    persona = p;
                }
            }
            if(persona==null){
                System.out.println("Persona no encontrada");
            }else{
                System.out.println(persona.getId());
                System.out.println(persona.getCiudad());
                System.out.println(persona.getAmigos());
                for(Amigo a: persona.getAmigos()){
                    System.out.println(a.getNombre());
                }
                System.out.println("Introduce el nombre de un amigo");
                String nombreAmigo = new Scanner(System.in).nextLine();
                for(Amigo a: persona.getAmigos()){
                    if (a.getNombre().equals(nombre)){
                        for(String h  : a.getHobbies()){
                            System.out.println(h);
                        }
                    }
                }
            }
        }
    }
}
