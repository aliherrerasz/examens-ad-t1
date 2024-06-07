package T2;

import java.util.List;

public interface GradoDAO {
    public boolean inicializar();
    public List<Grado> consultarGrados();
    public Grado guardar(String n, int d, List<Asignatura> a);
    public Grado actualizar(Grado g, String n,  int d, List<Asignatura> a);
    public boolean borrar(Grado g);
    public boolean cerrar();
}
