package ejercicio3;

import jakarta.persistence.*;
import java.util.List;

public class LibreriaRepository {
    private EntityManager entityManager;

    public LibreriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Libreria> getLibrerias(String ciudad) {
        Query query = entityManager.createQuery("SELECT l FROM Libreria l WHERE l.ciudad = :ciudad");
        query.setParameter("ciudad", ciudad);
        return query.getResultList();
    }

    public List<LibroPapel> getLibros(double precio) {
        Query query = entityManager.createQuery("SELECT lp FROM LibroPapel lp WHERE lp.precio <= :precio");
        query.setParameter("precio", precio);
        return query.getResultList();
    }

    public boolean haEscrito(Autor autor, Libro libro) {
        Query query = entityManager.createQuery("SELECT COUNT(l) FROM Libro l WHERE l.autor = :autor AND l = :libro");
        query.setParameter("autor", autor);
        query.setParameter("libro", libro);
        long count = (long) query.getSingleResult();
        return count > 0;
    }

    public long contarPedidosSinEntregar() {
        Query query = entityManager.createQuery("SELECT COUNT(p) FROM Pedido p WHERE p.entregado = false");
        return (long) query.getSingleResult();
    }

    public List<Libro> getLibros(String patronTitulo) {
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :patronTitulo");
        query.setParameter("patronTitulo", "%" + patronTitulo + "%");
        return query.getResultList();
    }
}

