package es.ies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConectorBD {

    public ConectorBD() {
    }

    /**
     * @return la conexión con la base de datos si ha sido posible o null si ha dado error
     */
    public Statement connec() {
        Connection conexion = null;
        Statement statement = null;
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Class.forName("oracle.jdbc.OracleDriver");
            conexion = DriverManager.getConnection(url, "tienda", "jeje2018");
            if (conexion != null) {
                statement = conexion.createStatement();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos.", "",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver de la base de datos: " + e.getMessage(), "",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage(), "",
                    JOptionPane.ERROR_MESSAGE);
        }
        return statement;
    }
}
