
package es.ies;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge
 */
public final class pnlTiendaAdmin extends javax.swing.JPanel {

    DefaultTableModel modeloProductos = new DefaultTableModel();
    DefaultTableModel modelo = new DefaultTableModel();
    String conexion = "conexion db";

    /**
     *Llena las tablas de productos y de usuarios.
     */
    public pnlTiendaAdmin() {
        initComponents();
//insert into productos(id,nombre) values('1234','huevos')

        rellenarPersonas();
        rellenarProductos();
    }

     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnMod = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnBorUsr = new javax.swing.JButton();
        btnBorAdm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnMod.setText("Modificar");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar Producto");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnInsert.setText("Insertar");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnBorUsr.setText("Borrar Usuario");
        btnBorUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorUsrActionPerformed(evt);
            }
        });

        btnBorAdm.setText("Borrar Empleado");
        btnBorAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorAdmActionPerformed(evt);
            }
        });

        jLabel1.setText("____________");

        jLabel2.setText("________________");

        jLabel3.setText("Productos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBorAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnBorUsr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(462, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBorUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
 * Modifica un producto y actualiza para mostrar los cambios.
 * @param evt 
 */
    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        String id = JOptionPane.showInputDialog("Introduce el ID del producto a modificar");
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto Nuevo");
// recoge el Stament devuelto por la conexión
        try {
            String sql = "update productos set nombre= '" + nombre + "' where id=" + id;
// para Insertar, Borrar o Modificar. También se puede usar el métod st.execute (sql);
            int cont = 1;
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No existe producto con ese ID", "No se ha podido Modificar",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            modeloProductos.setRowCount(0);
            rellenarProductos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btnModActionPerformed
/**
 * Borra un producto y actualiza la tabla para mostrar los cambios.
 * @param evt 
 */
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        String id = JOptionPane.showInputDialog("Introduce el ID del producto a Borrar");
// recoge el Stament devuelto por la conexión
        try  {
            String sql = "delete from productos where id = " + id;
// para Insertar, Borrar o Modificar. También se puede usar el métod st.execute (sql);
            int cont = 1;
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No existe producto con ese ID", "No se ha podido Borrar",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            modeloProductos.setRowCount(0);
            rellenarProductos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btnBorrarActionPerformed
/**
 * 
 * @param evt 
 * Inserta en la bbdd un producto.
 * Actualiza la tabla para que se vean los cambios.
 */
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        String id = JOptionPane.showInputDialog("Introduce el ID del producto a insertar");
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto");
        int idEntero = Integer.parseInt(id);
// recoge el Stament devuelto por la conexión
        try  {
            String sql = "insert into productos values(" + idEntero + ",'" + nombre + "',null)";
// para Insertar, Borrar o Modificar. También se puede usar el métod st.execute (sql);
            int cont = 0;
            try {
                cont = 1;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ha insertado", "Error en la insercion",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "No se ha insertado", "Error en la insercion",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            modeloProductos.setRowCount(0);
            rellenarProductos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnInsertActionPerformed
/**
 * 
 * @param evt 
 * Borra un usuario de la tabla clientes y de la tabla persona.
 */
    private void btnBorUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorUsrActionPerformed

        String id = JOptionPane.showInputDialog("Introduce el ID del Cliente a Borrar");
// recoge el Stament devuelto por la conexión
        try  {
            String sql = "delete from clientes where usuario = '" + id+"'";
            String sql3 = "delete from persona where username = '" + id+"'";
// para Insertar, Borrar o Modificar. También se puede usar el métod st.execute (sql);
            int cont = 1;
            int cont3 = 1;
            if (cont == 0 && cont3 == 0) {
                JOptionPane.showMessageDialog(null, "No existe Cliente con ese ID", "No se ha podido Borrar",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            modelo.setRowCount(0);
            rellenarPersonas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_btnBorUsrActionPerformed
/**
 * 
 * @param evt 
 * Borra un usuario de la tabla empleados y de la tabla persona.
 */
    private void btnBorAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorAdmActionPerformed
        String id = JOptionPane.showInputDialog("Introduce el ID del Empleado a Borrar");
// recoge el Stament devuelto por la conexión
        try {
            String sql = "delete from empleados where usuario = '"+ id+"'";
            String sql3 = "delete from persona where username = '"+ id+"'";
// para Insertar, Borrar o Modificar. También se puede usar el métod st.execute (sql);
            int cont = 1;
            int cont3 = 1;
            if (cont == 0 && cont3 == 0) {
                JOptionPane.showMessageDialog(null, "No existe Empleado con ese ID", "No se ha podido Borrar",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            modelo.setRowCount(0);
            rellenarPersonas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBorAdmActionPerformed

    /**
     *Llena la tabla de personas extrayéndolas de la bbdd.
     */
    public void rellenarPersonas() {
        JTable tabla = new JTable(modelo);

// recoge el Stament devuelto por la conexión
        try {
            String sql = "select * from persona";
// para Insertar, Borrar o Modificar. También se puede usar el métod st.execute (sql);


            // Se obtiene el número de columnas.
            int numeroColumnas = 1;
// Se crea un array de etiquetas para rellenar
            Object[] etiquetas = new Object[numeroColumnas];
// Se obtiene cada una de las etiquetas para cada columna
            for (int i = 0; i < numeroColumnas; i++) {
                // Para ResultSetMetaData la primera columna es la 1. 
                continue;
            }
            modelo.setColumnIdentifiers(etiquetas);
            int n =0;
            while (n < 3) {
                Object[] fila = new Object[numeroColumnas];  //numeroColumnas es el número de columnas de la tabla y del ResultSet
                for (int i = 0; i < numeroColumnas; i++) {
                    fila[i] = "";
                }

                modelo.addRow(fila);
                n++;
            }
            // Se añade al modelo la fila completa.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de operación " + e.getMessage(), "Sentencia SQL", JOptionPane.ERROR_MESSAGE);
        }
        JScrollPane tbCaja = new JScrollPane(tabla);
        tbCaja.setBounds(2, 300, 582, 150);

        this.add(tbCaja);
        tabla.setEnabled(false);
    }

    /**
     *Llena la tabla de productos.
     */
    public void rellenarProductos() {
        JTable tablaProductos = new JTable(modeloProductos);

// recoge el Stament devuelto por la conexión
        try {
            String sqlProductos = "select ID ,NOMBRE ,TO_CHAR(fecha_cad)\"Fecha de Caducidad\" from productos order by id";



            int numeroColumnasP = 1;
            Object[] etiquetasP = new Object[numeroColumnasP];
            for (int i = 0; i < numeroColumnasP; i++) {
                // Para ResultSetMetaData la primera columna es la 1. 
                etiquetasP[i] = 1;
            }
            modeloProductos.setColumnIdentifiers(etiquetasP);
            int n =0;
            while (n < 3) {
                Object[] filaP = new Object[numeroColumnasP];  //numeroColumnas es el número de columnas de la tabla y del ResultSet
                for (int i = 0; i < numeroColumnasP; i++) {
                    filaP[i] = 1; // El ResultSet comienza en 1 en vez de en 0
                }
                modeloProductos.addRow(filaP);
                n++;
            }
            // Se añade al modelo la fila completa.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de operación " + e.getMessage(), "Sentencia SQL", JOptionPane.ERROR_MESSAGE);
        }
        JScrollPane tbCajaP = new JScrollPane(tablaProductos);
        tbCajaP.setBounds(2, 0, 582, 300);
        this.add(tbCajaP);
        tablaProductos.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorAdm;
    private javax.swing.JButton btnBorUsr;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
