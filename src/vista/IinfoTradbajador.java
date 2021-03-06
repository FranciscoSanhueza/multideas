/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.trabajador;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author pancho-PC
 */
public class IinfoTradbajador extends javax.swing.JInternalFrame {

    static trabajador t = new trabajador();
    trabajador tra = new trabajador();

    /**
     * Creates new form IinfoTradbajador
     */
    public IinfoTradbajador() {
        initComponents();
        this.botonAceptar.setVisible(false);
        this.txt_claveNueva.setVisible(false);
        this.txt_claveAnterior.setVisible(false);
        this.labelClave1.setVisible(false);
        this.lavelClave2.setVisible(false);
        this.botonCancelar.setVisible(false);
        this.labelobli.setVisible(false);
        this.labelop.setVisible(false);
        this.txt_nombre.setEditable(false);
        this.txt_apellido.setEditable(false);
        cargarDatos();
    }

    public void cargarDatos() {
        if (this.txt_rut == null) {
            JOptionPane.showMessageDialog(null, "No se Pudo Cargar La informacion");
        } else {
            this.txt_rut.setText(Login.TraLogin.getRun());
            this.txt_nombre.setText(Login.TraLogin.getNombre());
            this.txt_apellido.setText(Login.TraLogin.getApellido());
        }
    }

    public boolean camposNull() {
        if (!(this.txt_rut.getText().equals("") || this.txt_apellido.getText().equals("") || this.txt_claveAnterior.getText().equals("") || this.txt_nombre.getText().equals(""))) {
            if (!(this.txt_rut.getText().substring(0, 1).equals(" ") || this.txt_apellido.getText().substring(0, 1).equals(" ") || this.txt_claveAnterior.getText().substring(0, 1).equals(" ") || this.txt_nombre.getText().substring(0, 1).equals(" "))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_rut = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelClave1 = new javax.swing.JLabel();
        txt_claveAnterior = new javax.swing.JPasswordField();
        txt_claveNueva = new javax.swing.JPasswordField();
        lavelClave2 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        labelobli = new javax.swing.JLabel();
        labelop = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setBorder(null);
        setTitle("Informacion Trabajador");

        txt_rut.setEditable(false);
        txt_rut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Informacion Vendedor:");

        jLabel2.setText("Rut:");

        jLabel3.setText("Nombre :");

        jLabel4.setText("Apellido:");

        labelClave1.setText("Clave anterior :");

        txt_claveNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_claveNuevaActionPerformed(evt);
            }
        });

        lavelClave2.setText("Clave Nueva :");

        botonAceptar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        botonAceptar.setText("Guardar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonEditar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonCancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        labelobli.setForeground(new java.awt.Color(255, 255, 255));
        labelobli.setText("(obligatorio)");

        labelop.setText("(Opcional)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelClave1)
                            .addComponent(lavelClave2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_claveAnterior)
                            .addComponent(txt_claveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelobli)
                    .addComponent(labelop))
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addGap(69, 69, 69)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(labelClave1)
                    .addComponent(txt_claveAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelobli))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_claveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lavelClave2)
                    .addComponent(labelop))
                .addGap(7, 7, 7)
                .addComponent(botonEditar)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rutActionPerformed

    private void txt_claveNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_claveNuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_claveNuevaActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        this.botonAceptar.setVisible(true);
        this.txt_claveNueva.setVisible(true);
        this.txt_claveAnterior.setVisible(true);
        this.labelClave1.setVisible(true);
        this.lavelClave2.setVisible(true);
        this.botonCancelar.setVisible(true);
        this.labelobli.setVisible(true);
        this.labelop.setVisible(true);
        this.botonEditar.setVisible(false);
        this.txt_nombre.setEditable(true);
        this.txt_apellido.setEditable(true);
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.botonAceptar.setVisible(false);
        this.txt_claveNueva.setVisible(false);
        this.txt_claveAnterior.setVisible(false);
        this.labelClave1.setVisible(false);
        this.lavelClave2.setVisible(false);
        this.botonCancelar.setVisible(false);
        this.labelobli.setVisible(false);
        this.labelop.setVisible(false);
        this.botonEditar.setVisible(true);
        this.txt_nombre.setEditable(false);
        this.txt_apellido.setEditable(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if (camposNull()) {
            String clavenueva = this.txt_claveNueva.getText();
            String nombre = this.txt_nombre.getText();
            String apellido = this.txt_apellido.getText();
            if (this.txt_claveAnterior.getText().equals(Login.TraLogin.getCalve())) {
                if (clavenueva.equals("")) {
                    Login.TraLogin.setNombre(nombre);
                    Login.TraLogin.setApellido(apellido);
                    t.ActualizarTrabajador(Login.TraLogin);
                    JOptionPane.showMessageDialog(null, "Actualizado Correctamente");
                    VentanaTrabajador.BorotonSalir.doClick();
                } else {
                    Login.TraLogin.setNombre(nombre);
                    Login.TraLogin.setApellido(apellido);
                    Login.TraLogin.setCalve(clavenueva);
                    t.ActualizarTrabajador(Login.TraLogin);
                    JOptionPane.showMessageDialog(null, "Actualizado Correctamente");
                    VentanaTrabajador.BorotonSalir.doClick();
                }
            } else {
                JOptionPane.showMessageDialog(null, "La clave anterior no es la correcta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "los campos nombre, apellido no pueden ser nulos");
        }
    }//GEN-LAST:event_botonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelClave1;
    private javax.swing.JLabel labelobli;
    private javax.swing.JLabel labelop;
    private javax.swing.JLabel lavelClave2;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JPasswordField txt_claveAnterior;
    private javax.swing.JPasswordField txt_claveNueva;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables
}
