/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.movimiento;
import controlador.producto;
import java.time.Instant;

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
public class VentasDelDiaTra extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloPro = new DefaultTableModel();
    static movimiento V = new movimiento();
    ArrayList<producto> Productos = new ArrayList();
    ArrayList<movimiento> Ventas = new ArrayList();
    String fecha = fechaactual();
    String hora, minutos, ampm;
    Calendar calendario;

    /**
     * Creates new form VentasDelDiaTra
     */
    public VentasDelDiaTra() {
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
        this.jTable1.setModel(modelo);
        V.VentasPorFecha(Ventas, fecha);
        cargarTabla();
        total();
    }

    public void total() {
        if (Ventas.isEmpty()) {
            this.txt_total.setText("0");
        } else {
            try {
                int total = 0;
                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    total = total + Integer.parseInt(this.jTable1.getValueAt(i, 3).toString());
                }
                this.txt_total.setText(total + "");
            } catch (java.lang.NumberFormatException e) {
                this.txt_total.setText("0");
            }
        }
    }

    public String hora(String fecha) {
        String hora = fecha.substring(11, 19);
        return hora;
    }

    public String fechaactual() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fa = año + "-" + (mes + 1) + "-" + dia;
        return fa;
    }

    public void cargarTabla() {
        if (Ventas.isEmpty()) {
            String[] a = new String[1];
            a[0] = "no existen ventas hoy";
            modelo.addRow(a);
        } else {
            for (movimiento mm : Ventas) {
                if (Login.TraLogin.getRun().equals(mm.getTrabajador().getRun())) {
                    int total = 0;
                    String[] a = new String[6];
                    a[0] = mm.getCodigo() + "";
                    a[1] = mm.getFecha() + "";
                    a[2] = hora(mm.getTrabajador().getEstado().getDetalle());
                    a[4] = mm.getTrabajador().getNombre() + " " + mm.getTrabajador().getApellido();
                    a[5] = Login.TraLogin.getCargo().getDetalle();
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
    }

    public void limpiarTablapro() {
        for (int i = 0; i < this.tablaProductos.getRowCount(); i++) {
            modeloPro.removeRow(i);
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

        dialogoProductosVenta = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_total = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogoProductosVentaLayout.setVerticalGroup(
            dialogoProductosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoProductosVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBorder(null);
        setTitle("Ventas Diarias");

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Total Diario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            this.limpiarTablapro();
            int fila = this.jTable1.getSelectedRow();
            int codigoVenta = Integer.parseInt(this.jTable1.getValueAt(fila, 0).toString());
            String detalle = "";
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

    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog dialogoProductosVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
