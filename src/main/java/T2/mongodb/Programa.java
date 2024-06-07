package T2.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class Programa {
    public static void main(String[] args) {
        try(MongoClient mc = MongoClients.create("mongodb://dam:java@localhost:27017/?authSource=admin&readPreference=primary&ssl=false&directConnection=true")){
            MongoDatabase mb = mc.getDatabase("repaso");
            MongoCollection<Document> coleccion = mb.getCollection("EXAMEN");
            Document d = new Document()
                    .append("nombre","Bocadillo de jamón")
                    .append("calorias", new Document()
                            .append("valor",350)
                            .append("unidad","kcal")
                    )
                    .append("pasos", List.of(
                            "Partir el pan",
                            "Poner tomato",
                            "Poner aceite",
                            "Poner lonchas de jamón"
                    ));
            coleccion.insertOne(d);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
