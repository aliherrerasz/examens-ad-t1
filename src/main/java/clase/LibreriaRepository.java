package clase;

import jakarta.persistence.EntityManager;

import java.util.List;

public class LibreriaRepository {
    private EntityManager entityManager;

    public LibreriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Libreria> getLibrerias(String ciudad){
        String consulta = "SELECT l FROM Libreria l where l.direccion.ciudad='"+ciudad+"'";
        return entityManager.createQuery(consulta, Libreria.class).getResultList();
    }
    public List<LibroPapel> getLibros(double precio){
        String consulta = "SELECT l from LibroPapel l where l.precio<="+precio;
        return entityManager.createQuery(consulta, LibroPapel.class).getResultList();
    }
    public boolean haEscrito(Autor autor, Libro libro){
        String consulta ="select l from Libro l where l.autor.id=  ?1  and l.isbn=?2";
        Libro l = entityManager.createQuery(consulta,Libro.class)
                .setParameter(1,autor.getId())
                .setParameter(2,libro.getIsbn())
                .getSingleResult();
    return l!=null;
    }
    public List<Libro> getLibros(String patronTitulo){
        String consulta  = "SELECT l FROM Libro l WHERE l.titulo LIKE '%"+patronTitulo+"%'";
        return entityManager.createQuery(consulta,Libro.class).getResultList();
    }
}
