package controlador;

import java.util.ArrayList;
import modelo.Mtrabajador;

public class trabajador {

    private String run;
    private String nombre;
    private String apellido;
    private String calve;
    private cargo cargo;
    private estado estado;
    private Mtrabajador mtra;

    public trabajador() {
        mtra = new Mtrabajador();
    }

    public trabajador(String run, String nombre, String apellido, String calve, cargo cargo, estado estado) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calve = calve;
        this.cargo = cargo;
        this.estado = estado;
        mtra = new Mtrabajador();
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCalve() {
        return calve;
    }

    public void setCalve(String calve) {
        this.calve = calve;
    }

    public cargo getCargo() {
        return cargo;
    }

    public void setCargo(cargo cargo) {
        this.cargo = cargo;
    }

    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

    public String cargarTrbajdores(ArrayList<trabajador> ARLtra) {
        return mtra.SelectTrabajador(ARLtra);
    }

    public String insertarTrabajador(trabajador tra) {
        return mtra.insertTrabajador(tra);
    }

    public String ActualizarTrabajador(trabajador tra) {
        return mtra.UpdateTrabajador(tra);
    }

    public String DesactivarTrabajador(String rut) {
        return mtra.CambiarEstadoTrabajador(rut);
    }

    public String Login(String rut, String clave) {
        return mtra.ValidarLogin(rut, clave);
    }

    public String BuscarCargoTrabajador(String run) {
        return mtra.cargoTrabajador(run);
    }

    public trabajador buscarTradbajador(String rut) {
        return mtra.BuscarTrabajador(rut);
    }

}
