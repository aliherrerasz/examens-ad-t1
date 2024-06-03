package clase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

public class LibreriaDAO {
    private EntityManager entityManager;

    public LibreriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public LibreriaDAO() {
        entityManager = Persistence.createEntityManagerFactory("PU_LIBROS")
                .createEntityManager();
    }
    public Libro nuevoLibro(Autor autor, String isbn, String titulo, double precio){
        Libro libro = new Libro(isbn,titulo,precio);
        libro.setAutor(autor);
        autor.getLibros().add(libro);
        entityManager.getTransaction().begin();
        entityManager.persist(libro);
        entityManager.getTransaction().commit();
        return libro;
    }
    public boolean actualizarAutor(Libro libro, Autor nuevoAutor){
        boolean actualizado = true;
        try{
            entityManager.getTransaction().begin();
            libro.setAutor(nuevoAutor);
            nuevoAutor.getLibros().add(libro);
            entityManager.getTransaction().commit();

        }catch (Exception e){
            actualizado = false;
        }
        return actualizado;
    }
    public boolean vender(Libreria libreria, Libro l){
        boolean vendido = true;
        try {
            entityManager.getTransaction().begin();
            libreria.getLibros().remove(l);
            libreria.setCaja(libreria.getCaja()+l.getPrecio());
            entityManager.getTransaction().commit();
        }catch (Exception e){
            vendido = false;
        }
        return vendido;
    }
}
