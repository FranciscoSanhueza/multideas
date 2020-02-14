
package modelo;

import conexion.conexionBD;
import controlador.categoria;
import controlador.estado;
import controlador.producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Mproducto extends conexionBD {

    private PreparedStatement ps;
    private ResultSet rs;

    public Mproducto() {
        conectarBD_C();
    }

    public String SelectProducto(ArrayList<producto> ARLpro) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("SELECT * from producto"
                        + " INNER JOIN categoria on producto.categoria = categoria.codigo"
                        + " INNER JOIN estado on producto.estado = estado.codigo"
                        + " ORDER BY producto.categoria, producto.descripcion ASC");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLpro.add(new producto(rs.getInt(1), rs.getString(2), rs.getInt(3), new categoria(rs.getByte(6), rs.getString(7)), new estado(rs.getByte(8), rs.getString(9))));
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

    public String BusquedaProducto(ArrayList<producto> Apro, String busqueda) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("SELECT * FROM producto"
                        + " INNER JOIN categoria on producto.categoria = categoria.codigo"
                        + " INNER JOIN estado on producto.estado = estado.codigo"
                        + " WHERE producto.codigo LIKE CONCAT('%','"+busqueda+"','%')"
                        + " or producto.descripcion LIKE CONCAT('%','"+busqueda+"','%')"
                        + " or producto.valor LIKE CONCAT('%','"+busqueda+"','%')"
                        + " AND producto.estado = 1"
                        + " ORDER BY producto.categoria, producto.descripcion ASC");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        Apro.add(new producto(rs.getInt(1), rs.getString(2), rs.getInt(3), new categoria(rs.getByte(6), rs.getString(7)), new estado(rs.getByte(8), rs.getString(9))));
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

    public boolean verificarCampoPrimario(int campoP) throws SQLException {
        try {
            ps = super.obtenerConexion().prepareStatement("select * from producto where codigo= '" + campoP + "'");
            rs = ps.executeQuery();
            rs.last();
            return rs.getRow() > 0;
        } catch (SQLException SQLEX) {
            throw new SQLException(SQLEX.getMessage());
        }
    }

    public String InsertProducto(producto pro) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("CALL InsertValidaNombreProducto ('" + pro.getDetalle() + "', " + pro.getValor() + ", " + pro.getCategoria().getCodigo() + ")");
                ps.execute();
                return "Almacenado Correctamente";
            } catch (SQLException SQLEX) {
                return "ERROR SQL: " + SQLEX.getMessage();
            }
        } else {
            return "no existe ninguna conexion abierta";
        }
    }

    public String UpdateProducto(producto pro) {
        try {
            if (this.verificarCampoPrimario(pro.getCodigo()) == true) {
                ps = super.obtenerConexion().prepareStatement("UPDATE producto SET descripcion = '" + pro.getDetalle() + "', valor = '" + pro.getValor() + "', categoria = '" + pro.getCategoria().getCodigo() + "', estado = '" + pro.getEstado().getCodigo() + "' WHERE producto.codigo = " + pro.getCodigo());
                ps.execute();
                return "Cambiado";
            } else {
                return "el campo que desea actualizar no exite";
            }
        } catch (SQLException sqlex) {
            return "ERROR SQL: " + sqlex.getMessage();
        }
    }

    public String CambiarEstadoProducto(int campoP) {
        try {
            if (this.verificarCampoPrimario(campoP) == true) {
                ps = super.obtenerConexion().prepareStatement("CALL CambiarEstadoProducto (" + campoP + ")");
                ps.execute();
                return "Cambiado";
            } else {
                return "el campo que desea eliminar no exite";
            }
        } catch (SQLException sqlex) {
            return "ERROR SQL: " + sqlex.getMessage();
        }
    }
    
    public String StockProducto(ArrayList<ArrayList<String>> Stock) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("CALL Stock ()");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ArrayList<String> t = new ArrayList();
                        t.add(rs.getString(1));
                        t.add(rs.getString(2));
                        Stock.add(t);
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
