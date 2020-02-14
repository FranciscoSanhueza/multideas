package modelo;

import conexion.conexionBD;
import controlador.cargo;
import controlador.estado;
import controlador.trabajador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Mtrabajador extends conexionBD {

    private PreparedStatement ps;
    private ResultSet rs;

    public Mtrabajador() {
        conectarBD_C();
    }

    public String SelectTrabajador(ArrayList<trabajador> ARLtra) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("SELECT * FROM trabajador"
                        + " inner JOIN cargo on trabajador.cargo = cargo.codigo"
                        + " INNER JOIN estado on trabajador.estado = estado.codigo");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLtra.add(new trabajador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), new cargo(rs.getByte(7), rs.getString(8)), new estado(rs.getByte(9), rs.getString(10))));
                    }
                    return "cargado";

                } else {
                    return "ERROR al cargar";
                }
            } catch (SQLException SQLEX) {
                return "ERROR SQL: " + SQLEX.getMessage();
            }
        } else {
            return "no existe ninguna conexion abierta";
        }
    }

    public trabajador BuscarTrabajador(String rut) {
        if (super.obtenerConexion() != null) {
            try {
                trabajador tra = new trabajador();
                ps = super.obtenerConexion().prepareStatement("SELECT * FROM trabajador"
                        + " inner JOIN cargo on trabajador.cargo = cargo.codigo"
                        + " INNER JOIN estado on trabajador.estado = estado.codigo where trabajador.run = " + rut);
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        tra.setRun(rs.getString(1));
                        tra.setNombre(rs.getString(2));
                        tra.setApellido(rs.getString(3));
                        tra.setCalve(rs.getString(4));
                        tra.setCargo(new cargo(rs.getByte(7), rs.getString(8)));
                        tra.setEstado(new estado(rs.getByte(9), rs.getString(10)));
                    }
                    return tra;

                } else {
                    return null;
                }
            } catch (SQLException SQLEX) {
                return null;
            }
        } else {
            return null;
        }
    }

    public boolean verificarCampoPrimario(String campoP) throws SQLException {
        try {
            ps = super.obtenerConexion().prepareStatement("select * from trabajador where run= '" + campoP + "'");
            rs = ps.executeQuery();
            rs.last();
            return rs.getRow() > 0;
        } catch (SQLException SQLEX) {
            throw new SQLException(SQLEX.getMessage());
        }
    }

    public String insertTrabajador(trabajador tra) {
        try {
            if (this.verificarCampoPrimario(tra.getRun()) == false) {
                ps = super.obtenerConexion().prepareStatement("INSERT INTO trabajador (run, nombre, apellido, clave, cargo, estado) VALUES ('" + tra.getRun() + "', '" + tra.getNombre() + "', '" + tra.getApellido() + "', '" + tra.getCalve() + "', '" + tra.getCargo().getCodigo() + "', '1')");
                ps.execute();
                return "insertado Correctamente";
            } else {
                return "el campo que desea insertar ya existe";
            }
        } catch (SQLException sqlex) {
            return "ERROR SQL: " + sqlex.getMessage();
        }
    }

    public String UpdateTrabajador(trabajador tra) {
        try {
            if (this.verificarCampoPrimario(tra.getRun()) == true) {
                ps = super.obtenerConexion().prepareStatement("UPDATE trabajador SET nombre = '" + tra.getNombre() + "', apellido = '" + tra.getApellido() + "', clave = '" + tra.getCalve() + "', cargo = '" + tra.getCargo().getCodigo() + "', estado = '" + tra.getEstado().getCodigo() + "' "
                        + "WHERE trabajador.run = '" + tra.getRun() + "'");
                ps.execute();
                return "Cambiado";
            } else {
                return "el campo que desea actualizar no exite";
            }
        } catch (SQLException sqlex) {
            return "ERROR SQL: " + sqlex.getMessage();
        }
    }

    public String CambiarEstadoTrabajador(String campoP) {
        try {
            if (this.verificarCampoPrimario(campoP) == true) {
                ps = super.obtenerConexion().prepareStatement("CALL CambiarEstadoTrabajador ('"+campoP+"')");
                ps.execute();
                return "Cambiado";
            } else {
                return "el campo que desea eliminar no exite";
            }
        } catch (SQLException sqlex) {
            return "ERROR SQL: " + sqlex.getMessage();
        }
    }

    public String cargoTrabajador(String rut) {
        if (super.obtenerConexion() != null) {
            try {
                if (this.verificarCampoPrimario(rut) == true) {
                    ps = super.obtenerConexion().prepareStatement("CALL cargoTrabajador('" + rut + "')");
                    rs = ps.executeQuery();
                    rs.last();
                    if (rs.getRow() > 0) {
                        rs.beforeFirst();
                        while (rs.next()) {
                            if (rs.getString(1).equals("1")) {
                                return "Admin";
                            } else {
                                return "Trabajador";
                            }
                        }
                    } else {
                        return "ERROR al cargar BD";
                    }
                } else {
                    return "El  rut " + rut + " no esta registrado";
                }
                return "";
            } catch (SQLException SQLEX) {
                return "ERROR SQL: " + SQLEX.getMessage();
            }
        } else {
            return "no existe ninguna conexion abierta";
        }
    }

    public String ValidarLogin(String rut, String clave) {
        if (super.obtenerConexion() != null) {
            try {
                if (this.verificarCampoPrimario(rut) == true) {
                    ps = super.obtenerConexion().prepareStatement("call validarLogin (?,?)");
                    ps.setString(1, rut);
                    ps.setString(2, clave);
                    rs = ps.executeQuery();
                    rs.last();
                    if (rs.getRow() > 0) {
                        if (rs.getString(1).equals("1")) {
                            return "admin";
                        } else if (rs.getString(1).equals("2")) {
                            return "trabajador";
                        } else {
                            return "Rut o Contraseña incorrectos";
                        }
                    } else {
                        return "Rut o Contraseña incorrectos";
                    }
                } else {
                    return "El usuario Run: " + rut + " no esta registrado";
                }
            } catch (SQLException SQLEX) {
                throw new UnsupportedOperationException(SQLEX.getMessage());
            }
        } else {
            throw new UnsupportedOperationException("no se puede conectar con la base de datos");
        }
    }

    public void conectarBD_C() {
        try {
            ConectarBD();
            System.out.println("Conexion Exitosa");
        } catch (SQLException SQLE) {
            System.out.println("ERORR SQL: " + SQLE.getMessage());
        } catch (java.lang.ClassNotFoundException CNFE) {
            System.out.println("ERROR al cargar el driver: " + CNFE.getMessage());
        }
    }
}
