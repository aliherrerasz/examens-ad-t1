package T2.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Aggregates.group;

public class C2 {
    public static void main(String[] args) {
        try(MongoClient mc = MongoClients.create()){
            MongoDatabase md = mc.getDatabase("repaso");
            MongoCollection<Document> col = md.getCollection("EXAMEN");
            Iterable<Document> d = col.aggregate(
                    List.of(group(null, avg("media","$calorias.valor")))
                    // List.of(group(null, avg("media", current().getInteger("calorias.valor"))
            );
            for(Document consulta:d){
                System.out.println(consulta);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
