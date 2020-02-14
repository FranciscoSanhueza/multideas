package controlador;

import java.util.ArrayList;
import modelo.Mcargo;

public class cargo {
    private int codigo;
    private String detalle;
    private Mcargo mc;

    public cargo(int codigo, String detalle) {
        this.codigo = codigo;
        this.detalle = detalle;
        mc= new Mcargo();
    }

    public cargo() {
        mc= new Mcargo();
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
    
    public String CargarCargos(ArrayList<cargo> ARLcar){
        return mc.SelectCargo(ARLcar);
    }
}
