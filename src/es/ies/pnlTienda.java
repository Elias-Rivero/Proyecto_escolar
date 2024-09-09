
package es.ies;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class pnlTienda extends javax.swing.JPanel {

    DefaultTableModel modeloProductos = new DefaultTableModel();
    String conexion = "conexion con base de datos";
    Cliente cli = new Cliente();

    public int cantidadNum = 0;
    private String cantidad;
    private String id;

    public pnlTienda() {
        initComponents();
        generarCliente();
        cli.setNumCompras(0);
        rellenarProductos();

    }

    private void initComponents() {

        bntComprar = new javax.swing.JButton();
        btnTicket = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        bntComprar.setText("Comprar");
        bntComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntComprarActionPerformed(evt);
            }
        });

        btnTicket.setText("Imprimir Ticket");
        btnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(bntComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(397, Short.MAX_VALUE)
                .addComponent(bntComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
    }
/**
 * 
 * @param evt 
 * Conecta con la bbdd e introduce en el fichero pdf párrafos con los datos de cada producto.
 */
    private void bntComprarActionPerformed(java.awt.event.ActionEvent evt) {
        try  {
            this.id = JOptionPane.showInputDialog("Introduce el ID del producto a comprar");
            this.cantidad = JOptionPane.showInputDialog("Introduce la cantidad");
            cantidadNum = cantidadNum + Integer.parseInt(this.cantidad);
            cli.comprar(cantidadNum);
            cli.participarSorteo(cli.getIdCliente(), cantidadNum);
            String sqlNombre = "select * from productos where id = '" + this.id + "'";


            String id = "id";
            String nom = "nombre";
            String fec = "fecha_cad";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de operación " + e.getMessage(), "Sentencia SQL", JOptionPane.ERROR_MESSAGE);
        }


    }

    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {
        JLabel lbl = new JLabel("¿Quiere abrir el ticket?");
        JButton btn = new JButton();
        JDialog dia = new JDialog();
        dia.setTitle("Dialogo");
        btn.setBounds(120, 70, 50, 30);
        btn.setText("✓");
        dia.add(btn);
        dia.add(lbl);
        dia.setBounds(550, 300, 200, 150);
        dia.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File path = new File("fichero.pdf");
                    Desktop.getDesktop().open(path);
                    dia.setVisible(false);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error de operación " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }
    private javax.swing.JButton bntComprar;
    private javax.swing.JButton btnTicket;

    private void rellenarProductos() {
        JTable tablaProductos = new JTable(modeloProductos);

        try {
            String sqlProductos = "select ID ,NOMBRE ,TO_CHAR(fecha_cad)\"Fecha de Caducidad\" from productos order by nombre";



            int numeroColumnasP = 5;
            Object[] etiquetasP = new Object[numeroColumnasP];
            modeloProductos.setColumnIdentifiers(etiquetasP);
            int n = 1;
            while (n<3) {
                Object[] filaP = new Object[numeroColumnasP];
                for (int i = 0; i < numeroColumnasP; i++) {
                    System.out.println(n);
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
/**
 * Genera un cliente a partir del id que se logueó (previamente introducido en un fichero
 * lo lee y busca sus datos en la bbdd.
 */
    private void generarCliente() {
        File f2 = new File("nombreCli.txt");

        Lector lee = new Lector(f2);
        String nombreCli = lee.verContenido();

        cli.setIdCliente(nombreCli);
        cli.setNumCompras(cantidadNum);

    }
}
