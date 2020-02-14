package controlador;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import modelo.Mmovimiento;

public class movimiento {

    private int codigo;
    private Date fecha;
    private tipo tipo;
    private trabajador trabajador;
    private ArrayList<producto> productos;
    private Mmovimiento mmo;

    public movimiento(int codigo, Date fecha, tipo tipo, trabajador trabajador) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.tipo = tipo;
        this.trabajador = trabajador;
        mmo = new Mmovimiento();
    }

    public movimiento() {
        mmo = new Mmovimiento();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public tipo getTipo() {
        return tipo;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    public trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public String cargarMovimientos(ArrayList<movimiento> ARLmo) {
        return mmo.SelectMoviento(ARLmo);
    }

    public String UltimaVenta() {
        return mmo.UltimaVentaCod();
    }

    public String insertarVenta(String rut) {
        return mmo.Insertventa(rut);
    }

    public String ProductosEnVenta(int cod_venta, int cod_producto, int cantidad, int valor) {
        return mmo.ProductoVenta(cod_venta, cod_producto, cantidad, valor);
    }
    
    public String selectVentas(ArrayList<movimiento> ARLmo){
        return mmo.selectVentas(ARLmo);
    }
    
    public String VentasPorFecha(ArrayList<movimiento> ARLmo, String fecha){
        return mmo.VentasPorFecha(ARLmo, fecha);
    }
    
    public ArrayList<producto> BuscarProductosVenta(int m){
        return mmo.BuscarProductosVenta(m);
    }

    public ArrayList<producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<producto> productos) {
        this.productos = productos;
    }
    
    public String insertarIngresoStock(String rut){
        return mmo.insertarIngreso(rut);
    }
    
    public String insertarProductosAIngreso(int cod_venta, int cod_producto, int cantidad, int valor){
        return mmo.ProductosDEIngreso(cod_venta, cod_producto, cantidad, valor);
    }
    
    public String ultimoCodigoIngreso(){
        return mmo.UltimoIngresoCod();
    }
    
    public String selectIngresos(ArrayList<movimiento> ARLmo){
        return mmo.SelectIngresos(ARLmo);
    }
    
    public String IngresosPorFecha(ArrayList<movimiento> ARLmo, String fecha1, String fecha2){
        return mmo.IngresosPorFecha(ARLmo, fecha1, fecha2);
    }
    
    public ArrayList<producto> BuscarProductosIngreso(int v) {
        return mmo.BuscarProductosIngreso(v);
    }
    
    public String VentasPorRangoFecha(ArrayList<movimiento> ARLmo, String fecha1, String fecha2){
        return mmo.VentasPorRamgoFecha(ARLmo, fecha1, fecha2);
    }
}
