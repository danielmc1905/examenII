/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocorporacionglobito;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Global;
import logica.Vendedora;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.utils.SubstanceConstants;

/**
 *
 * @author Gloriana
 */
public class frmVendedora extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmVendedora
     */

    public frmVendedora() {
        initComponents();
        btnAceptar.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.RIGHT);
        btnCancelar.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        getRootPane().setDefaultButton(btnAceptar);
        imprimirEnTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        winVendedora = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cboSexo = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnGuadar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendedora = new javax.swing.JTable();
        lblTotalCantidad = new javax.swing.JLabel();

        winVendedora.setTitle("Guardar");
        winVendedora.setAlwaysOnTop(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vendedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Identificación:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Sexo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        cboSexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MUJER", "HOMBRE" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 141, Short.MAX_VALUE))
                    .addComponent(cboSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSexo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout winVendedoraLayout = new javax.swing.GroupLayout(winVendedora.getContentPane());
        winVendedora.getContentPane().setLayout(winVendedoraLayout);
        winVendedoraLayout.setHorizontalGroup(
            winVendedoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winVendedoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, winVendedoraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        winVendedoraLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        winVendedoraLayout.setVerticalGroup(
            winVendedoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winVendedoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(winVendedoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        winVendedoraLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vendedoras");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/business59.png"))); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnGuadar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/floppy18.png"))); // NOI18N
        btnGuadar.setText("Guardar");
        btnGuadar.setFocusable(false);
        btnGuadar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuadar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuadarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuadar);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/drawing4.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel3.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/electronic1.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setFocusable(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImprimir);

        tblVendedora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICACIÓN", "NOMBRE", "SEXO"
            }
        ));
        jScrollPane1.setViewportView(tblVendedora);

        lblTotalCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTotalCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuadarActionPerformed
        winVendedora.setSize(400, 275);
        winVendedora.setLocationRelativeTo(tblVendedora);
        winVendedora.setTitle("Guardar");
        ImageIcon img;
        img = new ImageIcon(getClass().getResource("/Imagenes/floppy18.png"));
        winVendedora.setIconImage(img.getImage());
        winVendedora.setVisible(true);
        limpiarCampos();
        txtIdentificacion.setEnabled(true);
    }//GEN-LAST:event_btnGuadarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblVendedora.getSelectedRow();
        if (fila != -1) {
            txtIdentificacion.setEnabled(false);
            txtIdentificacion.setText(tblVendedora.getValueAt(fila, 0).toString());
            txtNombre.setText(tblVendedora.getValueAt(fila, 1).toString());
            cboSexo.setSelectedItem(tblVendedora.getValueAt(fila, 2).toString());
            winVendedora.setSize(400, 275);
            winVendedora.setLocationRelativeTo(tblVendedora);
            winVendedora.setTitle("Editar");
            ImageIcon img;
            img = new ImageIcon(getClass().getResource("/Imagenes/drawing4.png"));
            winVendedora.setIconImage(img.getImage());
            winVendedora.setVisible(true);
            txtIdentificacion.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor seleccione la fila a editar", "Editar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblVendedora.getSelectedRow();
        if (fila != -1) {
            int resp = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el registro seleccioando?",
                    "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                Global.listaVendedora.quitarVendedora(Integer.parseInt(tblVendedora.getValueAt(fila, 0).toString()));
                Global.listaVendedora.escribirVendedoras();
                imprimirEnTabla();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor seleccione la fila a eliminar", "Eliminar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        //   Imprimir();
        // T   // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        winVendedora.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Vendedora vendedora;
        String errores = validarDatos();
        if (errores.equals("")) {
            vendedora = new Vendedora();
            vendedora.setIdentificacion(Integer.parseInt(txtIdentificacion.getText()));
            vendedora.setNombre(txtNombre.getText().toUpperCase());
            vendedora.setSexo(cboSexo.getSelectedItem().toString());
            if (winVendedora.getTitle().equals("Guardar")) {
                if (Global.listaVendedora.existeVendedora(vendedora.getIdentificacion())) {
                    JOptionPane.showMessageDialog(winVendedora, "Id ya existe");
                } else {//Si no existe
                    Global.listaVendedora.agregarVendedora(vendedora);
                    winVendedora.dispose();
                    Global.listaVendedora.escribirVendedoras();
                    imprimirEnTabla();
                    JOptionPane.showMessageDialog(winVendedora, "Guardado exitosamente");
                }
            } else {//Si desea editar
                Global.listaVendedora.editarVendedora(vendedora);
                JOptionPane.showMessageDialog(winVendedora, "Editado exitosamente");
                Global.listaVendedora.escribirVendedoras();
                imprimirEnTabla();
                winVendedora.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(winVendedora, errores, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuadar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox cboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTotalCantidad;
    private javax.swing.JTable tblVendedora;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JDialog winVendedora;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtIdentificacion.setText("");
        txtNombre.setText("");
        cboSexo.setSelectedIndex(0);
    }

    private String validarDatos() {
        String msg = "";
        if (txtIdentificacion.getText().equals("")) {
            msg = "Por favor ingrese el id";
            txtIdentificacion.requestFocus();
            return msg;
        } else {
            try {
                Integer.parseInt(txtIdentificacion.getText());
            } catch (NumberFormatException e) {
                msg = "Solo se aceptan numeros en id";
                txtIdentificacion.requestFocus();
                return msg;
            }
        }
        if (txtNombre.getText().equals("")) {
            msg = "Por favor ingrese nombre";
            txtNombre.requestFocus();
            return msg;
        }
        return msg;
    }

    private void imprimirEnTabla() {
        tblVendedora.setModel(Global.listaVendedora.imprimirTabla());
        lblTotalCantidad.setText("Cant. vendedoras: "+Global.listaVendedora.getListVendedora().size());
    }
}
