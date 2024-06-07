package T2.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Projections.*;

public class Consultas {
    public static void main(String[] args) {
        try(MongoClient mc = MongoClients.create("mongodb://dam:java@localhost:27017/?authSource=admin&readPreference=primary&ssl=false&directConnection=true")){
            MongoDatabase md = mc.getDatabase("repaso");
            MongoCollection<Document> col = md.getCollection("EXAMEN");
            Iterable<Document> consulta = col.find(
                    gte("calorias.valor",200)
            )
                    .projection(fields(
                            include("nombre"),
                            exclude("_id")
                    ));
            for(Document d : consulta){
                System.out.println(d);
            }
        }
    }

}
