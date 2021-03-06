/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.cargo;
import controlador.estado;
import controlador.trabajador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pancho-PC
 */
public class MantenedorTrabajador extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    static trabajador t = new trabajador();
    ArrayList<trabajador> atra = new ArrayList();
    trabajador tra = new trabajador();

    /**
     * Creates new form MantenedorTrabajador
     */
    public MantenedorTrabajador() {
        initComponents();
        this.panelCampos.setVisible(false);
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cargo");
        modelo.addColumn("Estado");
        this.tablaTranajador.setModel(modelo);
        t.cargarTrbajdores(atra);
        cargarTabla();
    }

    public void cargarTabla() {
        if (!atra.isEmpty()) {
            if (!this.checkInactivosTabla.isSelected()) {
                for (trabajador tr : atra) {
                    String[] a = new String[5];
                    if (tr.getEstado().getCodigo() == 1) {
                        a[0] = tr.getRun();
                        a[1] = tr.getNombre();
                        a[2] = tr.getApellido();
                        a[3] = tr.getCargo().getDetalle();
                        a[4] = tr.getEstado().getDetalle();
                        modelo.addRow(a);
                    }
                }
            } else {
                for (trabajador tr : atra) {
                    String[] a = new String[5];
                    a[0] = tr.getRun();
                    a[1] = tr.getNombre();
                    a[2] = tr.getApellido();
                    a[3] = tr.getCargo().getDetalle();
                    a[4] = tr.getEstado().getDetalle();
                    modelo.addRow(a);
                }
            }
        } else {
            String[] a = new String[1];
            a[0] = "no existen Usuarios";
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < this.tablaTranajador.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void buscarTrabajador(String rut) {
        tra = null;
        if (atra != null) {
            for (trabajador tr : atra) {
                if (tr.getRun().equals(rut)) {
                    tra = tr;
                }
            }
        }
    }

    public void limpiar() {
        this.txt_rut.setText("");
        this.txt_nombre.setText("");
        this.txt_apellido.setText("");
        this.txt_clave.setText("");
        this.checkActivo.setSelected(false);
        this.checkInactivoEstado.setSelected(false);
        this.checkAdmin.setSelected(false);
        this.checkVendedor.setSelected(false);
    }

    public boolean camposNullEditar() {
        if (!(this.txt_rut.getText().equals("") || this.txt_nombre.getText().equals("") || this.txt_apellido.getText().equals(""))) {
            if (!(this.txt_rut.getText().substring(0, 1).equals(" ") || this.txt_nombre.getText().substring(0, 1).equals(" ") || this.txt_apellido.getText().substring(0, 1).equals(" "))) {
                if (this.checkActivo.isSelected() || this.checkInactivoEstado.isSelected() && this.checkAdmin.isSelected() || this.checkVendedor.isSelected()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
        public boolean camposNullIngresar() {
        if (!(this.txt_rut.getText().equals("") || this.txt_nombre.getText().equals("") || this.txt_apellido.getText().equals("") || this.txt_clave.getText().equals(""))) {
            if (!(this.txt_rut.getText().substring(0, 1).equals(" ") || this.txt_nombre.getText().substring(0, 1).equals(" ") || this.txt_apellido.getText().substring(0, 1).equals(" ") || this.txt_clave.getText().substring(0,1).equals(" "))) {
                if (this.checkActivo.isSelected() || this.checkInactivoEstado.isSelected() && this.checkAdmin.isSelected() || this.checkVendedor.isSelected()) {
                    return true;
                } else {
                    return false;
                }
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

        jLabel6 = new javax.swing.JLabel();
        GrupoEstado = new javax.swing.ButtonGroup();
        GrupoCargo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTranajador = new javax.swing.JTable();
        panelCampos = new javax.swing.JPanel();
        txt_rut = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        checkAdmin = new javax.swing.JCheckBox();
        checkVendedor = new javax.swing.JCheckBox();
        checkActivo = new javax.swing.JCheckBox();
        checkInactivoEstado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_clave = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        BotonIngresarForm = new javax.swing.JButton();
        labelOpcionClave = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        checkInactivosTabla = new javax.swing.JCheckBox();
        BotonEliminar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        BotonIKngresar = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setBorder(null);
        setTitle("Administracion de Usuarios");

        tablaTranajador = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        tablaTranajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaTranajador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaTranajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTranajadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTranajador);

        panelCampos.setMaximumSize(new java.awt.Dimension(908, 280));

        txt_rut.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txt_nombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txt_apellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        GrupoCargo.add(checkAdmin);
        checkAdmin.setText("Administrador");

        GrupoCargo.add(checkVendedor);
        checkVendedor.setText("Vendedor");

        GrupoEstado.add(checkActivo);
        checkActivo.setText("Activo");

        GrupoEstado.add(checkInactivoEstado);
        checkInactivoEstado.setText("Inactivo");

        jLabel1.setText("Rut:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Clave:");

        txt_clave.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setText("Cargo:");

        jLabel7.setText("Estado:");

        botonGuardar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonCancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        BotonIngresarForm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BotonIngresarForm.setText("Ingresar");
        BotonIngresarForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIngresarFormActionPerformed(evt);
            }
        });

        labelOpcionClave.setText("(solo si se desea cambiar)");

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_rut)
                                    .addComponent(txt_clave, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(labelOpcionClave)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkVendedor)
                            .addComponent(checkAdmin))
                        .addGap(69, 69, 69)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkActivo)
                            .addComponent(checkInactivoEstado)))
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonIngresarForm, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)))
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkAdmin)
                            .addComponent(jLabel4)
                            .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkVendedor)
                            .addComponent(labelOpcionClave)))
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkActivo)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(checkInactivoEstado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonIngresarForm, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        checkInactivosTabla.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        checkInactivosTabla.setText("Ver Inactivos");
        checkInactivosTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInactivosTablaActionPerformed(evt);
            }
        });

        BotonEliminar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        BotonEliminar.setText("Activar/Desactivar");
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        BotonEditar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BotonEditar.setText("Editar");
        BotonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEditarActionPerformed(evt);
            }
        });

        BotonIKngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BotonIKngresar.setText("Ingresar");
        BotonIKngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIKngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(checkInactivosTabla))
                    .addComponent(BotonIKngresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(checkInactivosTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(BotonIKngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkInactivosTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInactivosTablaActionPerformed
        limpiarTabla();
        cargarTabla();
    }//GEN-LAST:event_checkInactivosTablaActionPerformed

    private void tablaTranajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTranajadorMouseClicked

    }//GEN-LAST:event_tablaTranajadorMouseClicked

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        if (this.tablaTranajador.getSelectedRow() >= 0) {
            int fila = this.tablaTranajador.getSelectedRow();
            JOptionPane.showMessageDialog(null, t.DesactivarTrabajador(this.tablaTranajador.getValueAt(fila, 0).toString()));
            limpiar();
            limpiarTabla();
            atra.removeAll(atra);
            t.cargarTrbajdores(atra);
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto para desactivar");
        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void BotonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEditarActionPerformed
        if (this.tablaTranajador.getSelectedRow() >= 0) {
            this.panelCampos.setVisible(true);
            this.BotonIngresarForm.setVisible(false);
            this.botonGuardar.setVisible(true);
            this.BotonEliminar.setVisible(false);
            this.BotonIKngresar.setVisible(false);
            this.BotonEditar.setVisible(false);
            this.txt_rut.setEditable(false);
            this.labelOpcionClave.setVisible(true);
            limpiar();
            int fila = this.tablaTranajador.getSelectedRow();
            String rut = this.tablaTranajador.getValueAt(fila, 0).toString();
            buscarTrabajador(rut);
            this.txt_rut.setText(rut);
            this.txt_nombre.setText(tra.getNombre());
            this.txt_apellido.setText(tra.getApellido());
            if (tra.getEstado().getCodigo() == 1) {
                this.checkActivo.setSelected(true);
                this.checkInactivoEstado.setSelected(false);
            } else {
                this.checkActivo.setSelected(false);
                this.checkInactivoEstado.setSelected(true);
            }
            if (tra.getCargo().getCodigo() == 1) {
                this.checkAdmin.setSelected(true);
            } else {
                this.checkVendedor.setSelected(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "seleccione un trabajador para editar");
        }
    }//GEN-LAST:event_BotonEditarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.panelCampos.setVisible(false);
        this.BotonEliminar.setVisible(true);
        this.BotonIKngresar.setVisible(true);
        this.BotonEditar.setVisible(true);
        limpiar();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void BotonIKngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIKngresarActionPerformed
        this.BotonIngresarForm.setVisible(true);
        this.botonGuardar.setVisible(false);
        this.panelCampos.setVisible(true);
        this.BotonIKngresar.setVisible(false);
        this.BotonEditar.setVisible(false);
        this.BotonEliminar.setVisible(false);
        this.txt_rut.setEditable(true);
        this.labelOpcionClave.setVisible(false);
        limpiar();
    }//GEN-LAST:event_BotonIKngresarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if (camposNullEditar()) {
            if (this.txt_clave.getText().equals("")) {
                tra.setRun(this.txt_rut.getText());
                tra.setNombre(this.txt_nombre.getText());
                tra.setApellido(this.txt_apellido.getText());
                if (this.checkAdmin.isSelected()) {
                    tra.setCargo(new cargo(1, "admin"));
                } else {
                    tra.setCargo(new cargo(2, "trabajador"));
                }
                if (this.checkActivo.isSelected()) {
                    tra.setEstado(new estado(1, "activo"));
                } else {
                    tra.setEstado(new estado(2, "inactivo"));
                }
                JOptionPane.showMessageDialog(null, t.ActualizarTrabajador(tra));
                limpiar();
                limpiarTabla();
                atra.removeAll(atra);
                t.cargarTrbajdores(atra);
                cargarTabla();
            } else {
                tra.setRun(this.txt_rut.getText());
                tra.setNombre(this.txt_nombre.getText());
                tra.setApellido(this.txt_apellido.getText());
                tra.setCalve(this.txt_clave.getText());
                if (this.checkAdmin.isSelected()) {
                    tra.setCargo(new cargo(1, "admin"));
                } else {
                    tra.setCargo(new cargo(2, "trabajador"));
                }
                if (this.checkActivo.isSelected()) {
                    tra.setEstado(new estado(1, "activo"));
                } else {
                    tra.setEstado(new estado(2, "inactivo"));
                }
                JOptionPane.showMessageDialog(null, t.ActualizarTrabajador(tra));
                limpiar();
                limpiarTabla();
                atra.removeAll(atra);
                t.cargarTrbajdores(atra);
                cargarTabla();
            }
            this.panelCampos.setVisible(false);
            this.BotonEliminar.setVisible(true);
            this.BotonIKngresar.setVisible(true);
            this.BotonEditar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Los Campos Nombre y Apellido son obligatorios");
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void BotonIngresarFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIngresarFormActionPerformed
        if(camposNullIngresar()){
        tra.setRun(this.txt_rut.getText());
        tra.setNombre(this.txt_nombre.getText());
        tra.setApellido(this.txt_apellido.getText());
        tra.setCalve(this.txt_clave.getText());
        if (this.checkAdmin.isSelected()) {
            tra.setCargo(new cargo(1, "admin"));
        } else {
            tra.setCargo(new cargo(2, "trabajador"));
        }
        if (this.checkActivo.isSelected()) {
            tra.setEstado(new estado(1, "activo"));
        } else {
            tra.setEstado(new estado(2, "inactivo"));
        }
        JOptionPane.showMessageDialog(null, t.insertarTrabajador(tra));
        limpiar();
        limpiarTabla();
        atra.removeAll(atra);
        t.cargarTrbajdores(atra);
        cargarTabla();
        this.panelCampos.setVisible(false);
        this.BotonEliminar.setVisible(true);
        this.BotonIKngresar.setVisible(true);
        this.BotonEditar.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Todos Los Campos son Obligatorios");
        }
    }//GEN-LAST:event_BotonIngresarFormActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonIKngresar;
    private javax.swing.JButton BotonIngresarForm;
    private javax.swing.ButtonGroup GrupoCargo;
    private javax.swing.ButtonGroup GrupoEstado;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JCheckBox checkActivo;
    private javax.swing.JCheckBox checkAdmin;
    private javax.swing.JCheckBox checkInactivoEstado;
    private javax.swing.JCheckBox checkInactivosTabla;
    private javax.swing.JCheckBox checkVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOpcionClave;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTable tablaTranajador;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JPasswordField txt_clave;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables
}
