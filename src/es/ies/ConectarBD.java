package es.ies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


//imports

/**
 *
 * @author -Iraides Jones
 */
public class ConectarBD {

    /**
     *
     */
    public ConectarBD() {
    }

    /**
     * @return @retun la conexión con la base de datos si ha sido posible o null
     * si ha dado error
     * En getConnection irá la ruta de la base de datos con el puerto y el nombre y contraseña del usuario.
     */
    public Statement connec() {
        try {
// si la base de datos es MySql la url=" jdbc : mysql://hostname (localhost)/database-name";
            String url = "jdbc:oracle://localhost/XE";
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "tienda", "jeje2018");
            Statement statement = conexion.createStatement();
            return statement;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la BD " + e.getMessage() + e, "",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

}
