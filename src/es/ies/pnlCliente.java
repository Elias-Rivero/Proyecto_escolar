package es.ies;

import javax.swing.*;

/**
 *
 * @author Jorge
 */
public class pnlCliente extends javax.swing.JPanel {

    /**
     * Creates new form pnlCliente
     */
    Cliente cli = new Cliente();

    /**
     *
     */
    public pnlCliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
  
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblUsuario2 = new javax.swing.JLabel();
        lblPass2 = new javax.swing.JLabel();
        btnVerPass3 = new javax.swing.JToggleButton();
        lblPass3 = new javax.swing.JLabel();
        txtPass3 = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        txtPass2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        lblDir = new javax.swing.JLabel();
        txtTlf = new javax.swing.JTextField();
        lblDir1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDir2 = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rdbtnMas = new javax.swing.JRadioButton();
        rdbtnFem = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblUsuario2.setText("Usuario");

        lblPass2.setText("Contraseña");

        btnVerPass3.setText("ver");
        btnVerPass3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPass3ActionPerformed(evt);
            }
        });

        lblPass3.setText("Repetir contraseña");

        txtPass3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPass3FocusLost(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtPass2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPass2ActionPerformed(evt);
            }
        });

        jLabel1.setText("REGISTRAR CLIENTE");

        txtDir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirActionPerformed(evt);
            }
        });

        lblDir.setText("Direccion");

        txtTlf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTlf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTlfActionPerformed(evt);
            }
        });

        lblDir1.setText("Telefono");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblDir2.setText("Nombre");

        btnRegistrarCliente.setText("Registrar");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Sexo");

        buttonGroup1.add(rdbtnMas);
        rdbtnMas.setText("Masculino");
        rdbtnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnMasActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbtnFem);
        rdbtnFem.setText("Femenino");
        rdbtnFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnFemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPass2)
                                    .addComponent(lblUsuario2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPass3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPass3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDir)
                                .addGap(18, 18, 18)
                                .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDir1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(24, 24, 24)
                                        .addComponent(rdbtnMas)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbtnFem)
                                        .addGap(79, 79, 79))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDir2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerPass3)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(rdbtnMas)
                        .addComponent(rdbtnFem))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerPass3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPass2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPass3)
                            .addComponent(txtPass3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDir1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDir2))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerPass3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPass3ActionPerformed

        if (btnVerPass3.isSelected()) {
            txtPass3.setEchoChar((char) 0);
        } else {
            txtPass3.setEchoChar('*');
        }

        if (btnVerPass3.isSelected()) {
            txtPass2.setEchoChar((char) 0);
        } else {
            txtPass2.setEchoChar('*');
        }
    }//GEN-LAST:event_btnVerPass3ActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed

    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPass2ActionPerformed

    private void txtDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirActionPerformed

    private void txtTlfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTlfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTlfActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed
/**
 * 
 * @param evt 
 * Comprueba que no haya ningún campo vacío,crea el cliente y lo inserta.
 */
    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed

//<editor-fold defaultstate="collapsed" desc="contraseña">
        StringBuffer sb = new StringBuffer();
        char passw[] = txtPass2.getPassword();
        for (int j = 0; j < passw.length; j++) {
            sb.append(passw[j]);
        }
        String password1 = sb.toString();

//</editor-fold>
        if (password1.equals("")
                || txtDir.getText().equals("")
                || txtNombre.getText().equals("")
                || txtTlf.getText().equals("")
                || txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan campos por rellenar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String sexo = "";
            if (rdbtnFem.isSelected()) {
                sexo = "F";
            } else if (rdbtnMas.isSelected()) {
                sexo = "M";
            }

            cli.setIdCliente(txtUsuario.getText());
            cli.setNombre(txtNombre.getText());
            cli.setTelefono(txtTlf.getText());
            cli.setDireccion(txtDir.getText());

            String sql = "insert into clientes values( '" + cli.getIdCliente()
                    + "','" + cli.getNombre()+sexo
                    + "','" + cli.getTelefono()
                    + "','" + cli.getDireccion()
                    + "')";
            String sql2 = "insert into persona values( '" + cli.getIdCliente()
                    + "','" + password1
                    + "')";

            try {
                JOptionPane.showMessageDialog(null, "Operación realizada con éxito", "Sentencia SQL",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de operación " + e.getMessage(), "Sentencia SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed
/**
 * 
 * @param evt 
 * Compara las contraseñas de los 2 campos.
 */
    private void txtPass3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass3FocusLost

//<editor-fold defaultstate="collapsed" desc="Contraseñas">
        StringBuffer sb = new StringBuffer();
        char passw[] = txtPass2.getPassword();
        for (int j = 0; j < passw.length; j++) {
            sb.append(passw[j]);
        }
        String password1 = sb.toString();

        StringBuffer sb2 = new StringBuffer();
        char passw2[] = txtPass3.getPassword();
        for (int f = 0; f < passw2.length; f++) {
            sb2.append(passw2[f]);
        }
        String password2 = sb2.toString();

//</editor-fold>
        if (!password1.equals(password2)) {
            txtPass2.setText("");
            txtPass3.setText("");
        }
    }//GEN-LAST:event_txtPass3FocusLost

    private void rdbtnFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnFemActionPerformed
        cli.setNombre("F");
    }//GEN-LAST:event_rdbtnFemActionPerformed

    private void rdbtnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnMasActionPerformed
        cli.setNombre("M");
    }//GEN-LAST:event_rdbtnMasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JToggleButton btnVerPass3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblDir1;
    private javax.swing.JLabel lblDir2;
    private javax.swing.JLabel lblPass2;
    private javax.swing.JLabel lblPass3;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JRadioButton rdbtnFem;
    private javax.swing.JRadioButton rdbtnMas;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JPasswordField txtPass3;
    private javax.swing.JTextField txtTlf;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
