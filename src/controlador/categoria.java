package controlador;

import java.util.ArrayList;
import modelo.Mcategoria;

public class categoria {
    private int codigo;
    private String detalle;
    private Mcategoria Mca;

    public categoria(int codigo, String detalle) {
        this.codigo = codigo;
        this.detalle = detalle;
        Mca = new Mcategoria();
    }

    public categoria() {
        Mca = new Mcategoria();
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
    
    public String cargarCategorias(ArrayList<categoria> ARLcat){
        return Mca.SelectCategoria(ARLcat);
    }
}
