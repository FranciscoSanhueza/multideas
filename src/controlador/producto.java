package controlador;

import java.util.ArrayList;
import modelo.Mproducto;

public class producto {
    private int codigo;
    private String detalle;
    private int valor;
    private categoria categoria;
    private estado estado;
    private Mproducto mpro;

    public producto() {
        mpro = new Mproducto();
    }

    public producto(int codigo, String detalle, int valor, categoria categoria, estado estado) {
        this.codigo = codigo;
        this.detalle = detalle;
        this.valor = valor;
        this.categoria = categoria;
        this.estado = estado;
        mpro = new Mproducto();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }

    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }
    
    public String cargarProductos(ArrayList<producto> ARLpro){
        return mpro.SelectProducto(ARLpro);
    }
    
    public String buscarProducto(ArrayList<producto> Apro, String busqueda){
        return mpro.BusquedaProducto(Apro, busqueda);
    }
    
    public String ingresarProducto(producto p){
        return mpro.InsertProducto(p);
    }
    
    public String ActualizarProducto(producto p){
        return mpro.UpdateProducto(p);
    }
    
    public String CambiarEstado(int campoP){
        return mpro.CambiarEstadoProducto(campoP);
    }
    
    public String StockProductos(ArrayList<ArrayList<String>> Stock){
        return mpro.StockProducto(Stock);
    }
}
