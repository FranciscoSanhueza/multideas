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
public class InformesVentas extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloPro = new DefaultTableModel();
    static movimiento V = new movimiento();
    ArrayList<producto> Productos = new ArrayList();
    ArrayList<movimiento> Ventas = new ArrayList();
    String fecha11 = fechaactual();
    String fecha22;
    String hora, minutos, ampm;
    Calendar calendario;

    /**
     * Creates new form InformesVentas
     */
    public InformesVentas() {
        initComponents();
        modelo.addColumn("Codigo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Total");
        modelo.addColumn("Trabajador");
        modelo.addColumn("Cargo");
        modeloPro.addColumn("Codigo");
        modeloPro.addColumn("Descripcion");
        modeloPro.addColumn("Categoria");
        modeloPro.addColumn("Cantidad");
        modeloPro.addColumn("Valor");
        this.tablaProductos.setModel(modeloPro);
        this.tablaVentas.setModel(modelo);
        V.VentasPorRangoFecha(Ventas, fecha11, fecha11);
        cargarTabla();
        cargarFechasDEfecto();
    }

    public void cargarFechasDEfecto() {
        Calendar fecha = new GregorianCalendar();
        this.fecha1.setDate(fecha.getTime());
        this.fecha2.setDate(fecha.getTime());
    }

    public String fechaactual() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fa = año + "-" + (mes + 1) + "-" + dia;
        return fa;
    }

    public boolean fechaLimite() {
        Calendar fecha = new GregorianCalendar();
        if (this.fecha1.getDate().compareTo(fecha.getTime()) <= 0 && this.fecha2.getDate().compareTo(fecha.getTime()) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String hora(String fecha) {
        String hora = fecha.substring(11, 19);
        return hora;
    }

    public void cargarTabla() {
        if (Ventas.isEmpty()) {
            String[] a = new String[1];
            a[0] = "no existen ventas";
            modelo.addRow(a);
        } else {
            for (movimiento mm : Ventas) {
                int total = 0;
                String[] a = new String[6];
                a[0] = mm.getCodigo() + "";
                a[1] = mm.getFecha() + "";
                a[2] = hora(mm.getTrabajador().getEstado().getDetalle());
                a[4] = mm.getTrabajador().getNombre() + " " + mm.getTrabajador().getApellido();
                if (mm.getTrabajador().getCargo().getCodigo() == 1) {
                    a[5] = "Administrador";
                } else {
                    a[5] = "Vendedor";
                }
                if (V.BuscarProductosVenta(mm.getCodigo()) != null) {
                    Productos = V.BuscarProductosVenta(mm.getCodigo());
                    for (producto p : Productos) {
                        total = total + (p.getValor() * p.getCategoria().getCodigo());
                    }
                }
                a[3] = total + "";
                modelo.addRow(a);
            }
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < this.tablaVentas.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void limpiarTablapro() {
        for (int i = 0; i < this.tablaProductos.getRowCount(); i++) {
            modeloPro.removeRow(i);
            i -= 1;
        }
    }

    public String FormatoFecha1() {
        String mes = "";
        String año = (this.fecha1.getDate().getYear() + 1900) + "";
        String dia = "";
        if ((this.fecha1.getDate().getDate() + 1) < 10) {
            dia = "0" + (this.fecha1.getDate().getDate());
        } else {
            dia = "" + (this.fecha1.getDate().getDate());
        }
        if ((this.fecha1.getDate().getMonth() + 1) < 10) {
            mes = "0" + (this.fecha1.getDate().getMonth() + 1);
        } else {
            mes = "" + (this.fecha1.getDate().getMonth() + 1);
        }
        return año + "-" + mes + "-" + dia;
    }

    public String FormatoFecha2() {
        String mes = "";
        String año = (this.fecha2.getDate().getYear() + 1900) + "";
        String dia = "";
        if ((this.fecha2.getDate().getDate() + 1) < 10) {
            dia = "0" + (this.fecha2.getDate().getDate());
        } else {
            dia = "" + (this.fecha2.getDate().getDate());
        }
        if ((this.fecha2.getDate().getMonth() + 1) < 10) {
            mes = "0" + (this.fecha2.getDate().getMonth() + 1);
        } else {
            mes = "" + (this.fecha2.getDate().getMonth() + 1);
        }
        return año + "-" + mes + "-" + dia;
    }

    public boolean diferencia() {
        if (this.fecha1.getDate().compareTo(this.fecha2.getDate()) < 0) {
            return true;
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

        dialogoProductosVenta = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fecha1 = new org.jdesktop.swingx.JXDatePicker();
        fecha2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();

        tablaProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaProductos);

        javax.swing.GroupLayout dialogoProductosVentaLayout = new javax.swing.GroupLayout(dialogoProductosVenta.getContentPane());
        dialogoProductosVenta.getContentPane().setLayout(dialogoProductosVentaLayout);
        dialogoProductosVentaLayout.setHorizontalGroup(
            dialogoProductosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoProductosVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        dialogoProductosVentaLayout.setVerticalGroup(
            dialogoProductosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoProductosVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBorder(null);
        setTitle("Informe de ventas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Filtro de ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Selecciona un rango de fechas: ");

        jLabel2.setText("Desde :");

        jLabel3.setText("Hasta :");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(367, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaVentas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (diferencia()) {
            if (fechaLimite()) {
                fecha11 = FormatoFecha1();
                fecha22 = FormatoFecha2();
                Ventas.removeAll(Ventas);
                V.VentasPorRangoFecha(Ventas, fecha11, fecha22);
                limpiarTabla();
                this.cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Las fechas no pueden ser mayores a la fecha actual");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La fecha inicias deve ser menor a la final");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        try {
            this.limpiarTablapro();
            int fila = this.tablaVentas.getSelectedRow();
            int codigoVenta = Integer.parseInt(this.tablaVentas.getValueAt(fila, 0).toString());
            String detalle = "";
            String fecha;
            if (V.BuscarProductosVenta(codigoVenta) != null) {
                Productos = V.BuscarProductosVenta(codigoVenta);
                if (Productos == null) {
                    JOptionPane.showMessageDialog(null, "No existen productos en esa venta");
                } else {
                    for (producto pp : Productos) {
                        String[] a = new String[5];
                        a[0] = pp.getCodigo() + "";
                        a[1] = pp.getDetalle() + "";
                        a[2] = pp.getCategoria().getDetalle() + "";
                        a[3] = pp.getCategoria().getCodigo() + "";
                        a[4] = pp.getValor() + "";
                        modeloPro.addRow(a);
                    }
                    this.dialogoProductosVenta.setVisible(true);
                    this.dialogoProductosVenta.setSize(600, 300);
                    this.dialogoProductosVenta.setLocationRelativeTo(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Venta Sin Productos");
            }
        } catch (java.lang.NumberFormatException e) {

        }
    }//GEN-LAST:event_tablaVentasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog dialogoProductosVenta;
    private org.jdesktop.swingx.JXDatePicker fecha1;
    private org.jdesktop.swingx.JXDatePicker fecha2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}
