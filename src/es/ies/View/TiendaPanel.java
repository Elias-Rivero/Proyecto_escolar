package es.ies.View;


import es.ies.modeloTxtDB.ProductsManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.awt.BorderLayout.NORTH;

public class TiendaPanel extends JPanel {

    ProductsManager pPath = new ProductsManager();

    public TiendaPanel() throws IOException {
        setLayout(new BorderLayout(30, 30));
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new BoxLayout(tituloPanel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Tiendax");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel subtitulo = new JLabel("Productos disponibles a la venta");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));

        tituloPanel.add(titulo);
        tituloPanel.add(subtitulo);
        add(tituloPanel, NORTH);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(700, 800);

        // Ejemplo de productos
        /*Producto[] productos = {
                new Producto("Producto 1", 1.2, 10, "10x10x10", "2 días", "ruta/a/imagen1.jpg"),
                new Producto("Producto 2", 0.5, 5, "5x5x5", "1 día", "ruta/a/imagen2.jpg"),
                new Producto("Producto 2", 0.5, 5, "5x5x5", "1 día", "ruta/a/imagen2.jpg")
        };

        */


        JPanel comprarButtonPanel = new JPanel();
        comprarButtonPanel.setLayout(new BoxLayout(tituloPanel, BoxLayout.Y_AXIS));


        JButton comprarButton = new JButton("Comprar");
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = 0;
                for (Component component : getComponents()) {
                    if (component instanceof JPanel) {
                        JPanel panel = (JPanel) component;
                        JCheckBox checkBox = (JCheckBox) panel.getComponent(0);
                        if (checkBox.isSelected()) {
                            JComboBox<Integer> comboBox = (JComboBox<Integer>) panel.getComponent(1);
                            total += (int) comboBox.getSelectedItem();
                        }
                    }
                }
                JOptionPane.showMessageDialog(TiendaPanel.this, "Total: " + total);
            }
        });
        comprarButton.setMargin(new Insets(6, 10, 6, 10));

        /*comprarButtonPanel.add(comprarButton);
        comprarButtonPanel.setBorder(new EmptyBorder(10,30,50,30));*/
        add(comprarButton);


        for (Object producto : pPath.getAllMaterials()) {
            System.out.println();
            add(crearItemProducto((Producto) producto));
        }
    }

    private JPanel crearItemProducto(Producto producto) {
        JPanel panel = new JPanel();
        PanelRound panelRound = new PanelRound();
        panelRound.setBorder(new EmptyBorder(15,15,15,15));
        panelRound.setBackground(new Color(53, 64, 81));
        panelRound.setRoundBottomLeft(25);
        panelRound.setRoundBottomRight(25);
        panelRound.setRoundTopRight(25);
        panelRound.setRoundTopLeft(25);
        panelRound.setSize(600,80);

        panelRound.setLayout(new FlowLayout());

        JCheckBox checkBox = new JCheckBox();
        JComboBox<Integer> comboBox = new JComboBox<>();
        comboBox.setEnabled(false);
        JPanel panelComboBox = new JPanel();
        panelComboBox.setBorder(new EmptyBorder(2,7,2,10));
        panelComboBox.add(comboBox);

        for (int i = 1; i <= producto.cantidadDisponible; i++) {
            comboBox.addItem(i);
        }

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox.setEnabled(checkBox.isSelected());
            }
        });

        JLabel nombreLabel = new JLabel(producto.nombre);
        JLabel pesoLabel = new JLabel("Peso: " + producto.peso + " kg");
        JLabel dimensionesLabel = new JLabel("Dimensiones: " + producto.dimensiones);
        JLabel tiempoEntregaLabel = new JLabel("Tiempo de entrega: " + producto.tiempoEntrega);
        JLabel imagenLabel = new JLabel(new ImageIcon(producto.rutaImagen));


        panelRound.add(imagenLabel);
        panelRound.add(nombreLabel);
        panelRound.add(pesoLabel);
        panelRound.add(dimensionesLabel);
        panelRound.add(tiempoEntregaLabel);

        panelRound.add(panelComboBox);
        panelRound.add(checkBox);

        panel.setBorder(new EmptyBorder(2,10,2,10));
        panel.add(panelRound, NORTH);



        return panel;
    }

    public static void main(String[] args) throws IOException {
        JFrame frameTienda = new JFrame("Tienda");
        frameTienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTienda.setSize(800, 600);
        frameTienda.add(new TiendaPanel());
        frameTienda.setVisible(true);
    }
}

class Producto {
    int id;
    String nombre;
    double peso;
    String dimensiones;
    float precio;
    String tiempoEntrega;
    int cantidadDisponible;
    String rutaImagen;

    public Producto(String nombre, double peso, String dimensiones, float precio, String tiempoEntrega, int cantidadDisponible, String rutaImagen) {
        this.nombre = nombre;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.precio = precio;
        this.tiempoEntrega = tiempoEntrega;
        this.cantidadDisponible = cantidadDisponible;
        this.rutaImagen = rutaImagen;
    }
}
