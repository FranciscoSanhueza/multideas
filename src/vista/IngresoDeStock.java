/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.movimiento;
import controlador.producto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pancho-PC
 */
public class IngresoDeStock extends javax.swing.JInternalFrame implements Runnable {

    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<producto> cargarp = new ArrayList();
    ArrayList<producto> proVent = new ArrayList();
    ArrayList<ArrayList<String>> Stock = new ArrayList();
    static ListaProductos lp = new ListaProductos();
    static producto p = new producto();
    static movimiento mo = new movimiento();
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;

    /**
     * Creates new form IngresoDeStock
     */
    public IngresoDeStock() {
        initComponents();
        this.Spinnercantidad.setValue(1);
        txtCodigoProducto.requestFocusInWindow();
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Valor");
        modelo.addColumn("Cant");
        modelo.addColumn("SubTotal");
        this.TablaVenta.setModel(modelo);
        p.cargarProductos(cargarp);
        p.StockProductos(Stock);
        h1 = new Thread(this);
        h1.start();
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            this.labelHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    public void total() {
        int total = 0;
        int fila = this.TablaVenta.getRowCount();
        for (int i = 0; i < fila; i++) {
            total = total + Integer.parseInt(this.TablaVenta.getValueAt(i, 4).toString());
        }
        this.txtTotal.setText(total + "");
    }

    public boolean ValidarCantidad() {
        int fila = this.TablaVenta.getRowCount();
        for (producto pv : cargarp) {
            for (int i = 0; i < fila; i++) {
                if (Integer.parseInt(txtCodigoProducto.getText()) == Integer.parseInt(this.TablaVenta.getValueAt(i, 0).toString())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean ValidarCod() {
        for (producto pv : cargarp) {
            if (Integer.parseInt(txtCodigoProducto.getText()) == pv.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    public boolean validarSpinner() {
        if (this.Spinnercantidad.getValue().hashCode() >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public void CargarTabla() {
        if (validarSpinner()) {
            try {
                if (!cargarp.isEmpty()) {
                    if (ValidarCod()) {
                        if (ValidarCantidad()) {
                            for (producto pv : cargarp) {
                                if (Integer.parseInt(txtCodigoProducto.getText()) == pv.getCodigo()) {
                                    String[] a = new String[5];
                                    a[0] = pv.getCodigo() + "";
                                    a[1] = pv.getDetalle();
                                    a[2] = pv.getValor() + "";
                                    a[3] = this.Spinnercantidad.getValue().toString();
                                    a[4] = (pv.getValor() * Integer.parseInt(a[3])) + "";
                                    modelo.addRow(a);
                                }
                            }
                            total();
                        } else {
                            int fila = this.TablaVenta.getRowCount();
                            for (int i = 0; i < fila; i++) {
                                if (Integer.parseInt(txtCodigoProducto.getText()) == Integer.parseInt(this.TablaVenta.getValueAt(i, 0).toString())) {
                                    this.TablaVenta.setValueAt((Integer.parseInt(this.TablaVenta.getValueAt(i, 3).toString()) + Integer.parseInt(this.Spinnercantidad.getValue().toString())), i, 3);
                                    this.TablaVenta.setValueAt((Integer.parseInt(this.TablaVenta.getValueAt(i, 3).toString()) * Integer.parseInt(this.TablaVenta.getValueAt(i, 2).toString())), i, 4);
                                    total();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Producto no encontrado");
                    }
                }
            } catch (java.lang.NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El codigo solo puede ser numerico");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede ingresar cantidades negativas");
        }
        txtCodigoProducto.setText("");
    }

    public void limpiarTabla() {
        for (int i = 0; i < this.TablaVenta.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        panelingresoProducto = new javax.swing.JPanel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Spinnercantidad = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        PanelTabla = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        PanelTotal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        PanelFinalizar = new javax.swing.JPanel();
        botonFinalizar = new javax.swing.JButton();
        PanelHora = new javax.swing.JPanel();
        labelHora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setBorder(null);
        setTitle("Ingreso de Stock");

        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Codigo Producto :");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Cantidad :");

        botonBuscar.setText("Buscar Producto");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jButton1.setText("Registrar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelingresoProductoLayout = new javax.swing.GroupLayout(panelingresoProducto);
        panelingresoProducto.setLayout(panelingresoProductoLayout);
        panelingresoProductoLayout.setHorizontalGroup(
            panelingresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelingresoProductoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelingresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelingresoProductoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addGap(76, 76, 76)
                        .addGroup(panelingresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Spinnercantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelingresoProductoLayout.setVerticalGroup(
            panelingresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelingresoProductoLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(panelingresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelingresoProductoLayout.createSequentialGroup()
                        .addGroup(panelingresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelingresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Spinnercantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelingresoProductoLayout.createSequentialGroup()
                        .addGroup(panelingresoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );

        TablaVenta = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaVenta.setToolTipText("");
        TablaVenta.setComponentPopupMenu(jPopupMenu1);
        TablaVenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaVenta.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TablaVentaComponentAdded(evt);
            }
        });
        TablaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TablaVentaKeyTyped(evt);
            }
        });
        PanelTabla.setViewportView(TablaVenta);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTotalLayout = new javax.swing.GroupLayout(PanelTotal);
        PanelTotal.setLayout(PanelTotalLayout);
        PanelTotalLayout.setHorizontalGroup(
            PanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        PanelTotalLayout.setVerticalGroup(
            PanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTotalLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(PanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34))
        );

        botonFinalizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        botonFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imag/BotonIngresoMedio.png"))); // NOI18N
        botonFinalizar.setBorder(null);
        botonFinalizar.setBorderPainted(false);
        botonFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonFinalizar.setOpaque(false);
        botonFinalizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imag/BotonIngresoGrande.png"))); // NOI18N
        botonFinalizar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imag/BotonIngresoChico.png"))); // NOI18N
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFinalizarLayout = new javax.swing.GroupLayout(PanelFinalizar);
        PanelFinalizar.setLayout(PanelFinalizarLayout);
        PanelFinalizarLayout.setHorizontalGroup(
            PanelFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFinalizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelFinalizarLayout.setVerticalGroup(
            PanelFinalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFinalizarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(botonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        PanelHora.setMaximumSize(new java.awt.Dimension(256, 370));

        labelHora.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelHora.setText("Hora");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imag/MultiIdeasLogo.jpg"))); // NOI18N

        javax.swing.GroupLayout PanelHoraLayout = new javax.swing.GroupLayout(PanelHora);
        PanelHora.setLayout(PanelHoraLayout);
        PanelHoraLayout.setHorizontalGroup(
            PanelHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelHoraLayout.setVerticalGroup(
            PanelHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHoraLayout.createSequentialGroup()
                .addComponent(labelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelingresoProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTabla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelingresoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed

    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtCodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyPressed

    }//GEN-LAST:event_txtCodigoProductoKeyPressed

    private void txtCodigoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyReleased
        if (evt.getKeyCode() == 107) {
            if (this.Spinnercantidad.getValue().hashCode() >= 1) {
                this.Spinnercantidad.setValue(this.Spinnercantidad.getValue().hashCode() + 1);
            }
            txtCodigoProducto.setText("");
        } else if (evt.getKeyCode() == 109) {
            txtCodigoProducto.setText("");
            if (this.Spinnercantidad.getValue().hashCode() > 1) {
                this.Spinnercantidad.setValue(this.Spinnercantidad.getValue().hashCode() - 1);
            }
        } else if (evt.getKeyCode() == evt.VK_ENTER) {
            CargarTabla();
            this.Spinnercantidad.setValue(1);
        }
    }//GEN-LAST:event_txtCodigoProductoKeyReleased

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        ListaProductos v = new ListaProductos();
        v.setVisible(true);
        v.setLocation(590, 0);
        v.setResizable(false);
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void TablaVentaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TablaVentaComponentAdded

    }//GEN-LAST:event_TablaVentaComponentAdded

    private void TablaVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaVentaKeyTyped

    }//GEN-LAST:event_TablaVentaKeyTyped

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed

    }//GEN-LAST:event_txtTotalActionPerformed

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        try {
            int ingreso = 0;
            int cantidad = 0;
            int valor = 0;
            int producto = 0;

            int fila = this.TablaVenta.getRowCount();
            if (fila == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese productos antes de finalizar");
            } else {
                String rut = Login.TraLogin.getRun();
                mo.insertarIngresoStock(rut);
                ingreso = Integer.parseInt(mo.ultimoCodigoIngreso());
                for (int i = 0; i < fila; i++) {
                    cantidad = Integer.parseInt(this.TablaVenta.getValueAt(i, 3).toString());
                    valor = Integer.parseInt(this.TablaVenta.getValueAt(i, 2).toString());
                    producto = Integer.parseInt(this.TablaVenta.getValueAt(i, 0).toString());
                    mo.insertarProductosAIngreso(ingreso, producto, cantidad, valor);
                }
                JOptionPane.showMessageDialog(null, "ingreso Realizado con exito");
                limpiarTabla();
                this.txtTotal.setText("");
            }
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_botonFinalizarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (this.TablaVenta.getSelectedRow() >= 0) {
            int fila = this.TablaVenta.getSelectedRow();
            modelo.removeRow(fila);
            total();
        } else {
            JOptionPane.showMessageDialog(null, "seleccione uno antes de eliminar");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InicioAdmin.jButton1.doClick();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFinalizar;
    private javax.swing.JPanel PanelHora;
    private javax.swing.JScrollPane PanelTabla;
    private javax.swing.JPanel PanelTotal;
    private javax.swing.JSpinner Spinnercantidad;
    private javax.swing.JTable TablaVenta;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel labelHora;
    private javax.swing.JPanel panelingresoProducto;
    public static javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
