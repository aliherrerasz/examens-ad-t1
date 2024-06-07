package T2.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.mql.MqlValues;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Projections.computed;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.mql.MqlValues.current;

public class c3 {
    public static void main(String[] args) {
        try(MongoClient m = MongoClients.create("mongodb://dam:java@localhost:27017/?authSource=admin&readPreference=primary&ssl=false&directConnection=true")){
            MongoDatabase md  = m.getDatabase("repaso");
            MongoCollection<Document> col = md.getCollection("EXAMEN");
            Iterable<Document> consulta = col.aggregate(
                    List.of(
                          set(
                                  "numPasos", current().getArray("pasos").size()
                          )
                    )
            );
        }
    }
}
