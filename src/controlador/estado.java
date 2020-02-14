package controlador;

import java.util.ArrayList;
import modelo.Mestado;

public class estado {
    private int codigo;
    private String detalle;
    private Mestado mes;

    public estado(int codigo, String detalle) {
        this.codigo = codigo;
        this.detalle = detalle;
        mes = new Mestado();
    }

    public estado() {
        mes = new Mestado();
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
    
    public String CargarEstados(ArrayList<estado> ARLest){
        return mes.SelectEstado(ARLest);
    }
}
