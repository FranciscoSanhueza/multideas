package modelo;

import conexion.conexionBD;
import controlador.cargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Mcargo extends conexionBD {

    private PreparedStatement ps;
    private ResultSet rs;

    public Mcargo() {
        conectarBD_C();
    }

   public  String SelectCargo(ArrayList<cargo> ARLcar) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("select * from cargo");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLcar.add(new cargo(rs.getByte(1), rs.getString(2)));
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
