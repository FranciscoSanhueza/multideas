package controlador;

import java.util.ArrayList;
import modelo.Mtipo;

public class tipo {
    private int codigo;
    private String detalle;
    private Mtipo mti;

    public tipo(int codigo, String detalle) {
        this.codigo = codigo;
        this.detalle = detalle;
        mti = new Mtipo();
    }

    public tipo() {
        mti = new Mtipo();
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
    
    public String CargarTipo(ArrayList<tipo> ARLti){
        return mti.SelectTipo(ARLti);
    }
}
