package T2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradoMySQLDAO implements GradoDAO {
    private static final String CADENA_CONEXION = "jdbc:mysql://192.168.40.107:3306/Carreras";
    private static final String USUARIO = "dam";
    private static final String CLAVE = "java";
    private Connection conexion;


    @Override
    public boolean inicializar() {
        boolean conectado = true;
        try {
            conexion = DriverManager.getConnection(CADENA_CONEXION,USUARIO,CLAVE);
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar");
            conectado = false;
        }
        return conectado;
    }

    @Override
    public List<Grado> consultarGrados() {
        List<Grado> lista = new ArrayList<>();
        String sql = "SELECT Grado g FROM Grados";

        try {
            Statement s = conexion.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()){
                int id = r.getInt("ID");
                String nombre = r.getString("NOMBRE");
                int duracion = r.getInt("DURACION");
                String sqlAsignatura = "SELECT Asignatura a FROM Asignaturas WHERE ID_GRADO="+id;
                Statement ss = conexion.createStatement();
                ResultSet rr = ss.executeQuery(sqlAsignatura);
                List<Asignatura> asignaturas = new ArrayList<>();
                while (rr.next()){
                    String nombreAsignatura = rr.getString("NOMBRE");
                    int curso = rr.getInt("CURSO");
                    int creditos = rr.getInt("CREDITOS");
                    asignaturas.add(new Asignatura(nombreAsignatura,curso,creditos));
                }
                lista.add(new Grado(id,nombre,duracion,asignaturas));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Grado guardar(String n, int d, List<Asignatura> a) {
       // String sql = "INSERT INTO Grados VALUES ("+n+","+d+")";
    //    Statement s = conexion.createStatement();
        return null;
    }

    @Override
    public Grado actualizar(Grado g, String n, int d, List<Asignatura> a) {
        return null;
    }

    @Override
    public boolean borrar(Grado g) {
        return false;
    }

    @Override
    public boolean cerrar() {
        return false;
    }
}
