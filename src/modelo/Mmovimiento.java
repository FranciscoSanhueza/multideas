package modelo;

import conexion.conexionBD;
import controlador.cargo;
import controlador.categoria;
import controlador.estado;
import controlador.movimiento;
import controlador.producto;
import controlador.tipo;
import controlador.trabajador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Mmovimiento extends conexionBD {
    private PreparedStatement ps;
    private ResultSet rs;
    public Mmovimiento() {
        conectarBD_C();
    }

    public String SelectMoviento(ArrayList<movimiento> ARLmo) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("SELECT * FROM movimiento"
                        + " INNER JOIN tipo on movimiento.tipo = tipo.codigo"
                        + " INNER JOIN trabajador on movimiento.trabajador = trabajador.run"
                        + " INNER JOIN cargo on trabajador.cargo = cargo.codigo\n"
                        + " INNER JOIN estado on trabajador.estado = estado.codigo");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLmo.add(new movimiento(rs.getInt(1), rs.getDate(2), new tipo(rs.getByte(5), rs.getString(6)), new trabajador(rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), new cargo(rs.getByte(13), rs.getString(14)), new estado(rs.getByte(15), rs.getString(16)))));
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

    public String Insertventa(String rutTrabajador) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("INSERT INTO movimiento (codigo, fecha, tipo, trabajador) VALUES (NULL, CURRENT_TIMESTAMP, '" + 2 + "', '" + rutTrabajador + "')");
                ps.execute();
                return "Almacenado Correctamente";
            } catch (SQLException SQLEX) {
                return "ERROR SQL: " + SQLEX.getMessage();
            }
        } else {
            return "no existe ninguna conexion abierta";
        }
    }

    public String ProductoVenta(int cod_venta, int cod_producto, int cantidad, int valor) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("INSERT INTO producto_movimiento (codigo_movimiento, codigo_producto, cantidad, valor) VALUES (" + cod_venta + ", " + cod_producto + ", " + cantidad + ", " + valor + ")");
                ps.execute();
                return "Almacenado Correctamente";
            } catch (SQLException SQLEX) {
                return "ERROR SQL: " + SQLEX.getMessage();
            }
        } else {
            return "no existe ninguna conexion abierta";
        }
    }

    public String UltimaVentaCod() {
        if (super.obtenerConexion() != null) {
            try {
                int venta = 0;
                ps = super.obtenerConexion().prepareStatement("CALL retornarUltimaVenta()");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        venta = rs.getInt(1);
                    }
                    return venta + "";
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

    public String selectVentas(ArrayList<movimiento> ARLmo) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("SELECT * FROM movimiento"
                        + " INNER JOIN tipo on movimiento.tipo = tipo.codigo"
                        + " INNER JOIN trabajador on movimiento.trabajador = trabajador.run"
                        + " INNER JOIN cargo on trabajador.cargo = cargo.codigo\n"
                        + " INNER JOIN estado on trabajador.estado = estado.codigo"
                        + " where tipo = 2");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLmo.add(new movimiento(rs.getInt(1), rs.getDate(2), new tipo(rs.getByte(5), rs.getString(6)), new trabajador(rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), new cargo(rs.getByte(13), rs.getString(14)), new estado(rs.getByte(15), rs.getString(16)))));
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

    public String VentasPorFecha(ArrayList<movimiento> ARLmo, String fecha) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement(" CALL ventasPorFecha('" + fecha + "')");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLmo.add(new movimiento(rs.getInt(1), rs.getDate(2), new tipo(), new trabajador(rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), new cargo(rs.getByte(9), ""), new estado(rs.getByte(10), rs.getString(2)))));
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
    
        public String VentasPorRamgoFecha(ArrayList<movimiento> ARLmo, String fecha1, String fecha2) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement(" CALL ventasPorRangoDeFecha('" + fecha1 + "' , '"+fecha2+"')");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLmo.add(new movimiento(rs.getInt(1), rs.getDate(2), new tipo(), new trabajador(rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), new cargo(rs.getByte(9), ""), new estado(rs.getByte(10), rs.getString(2)))));
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

    public ArrayList<producto> BuscarProductosVenta(int v) {
        if (super.obtenerConexion() != null) {
            try {
                ArrayList<producto> p = new ArrayList();
                ps = super.obtenerConexion().prepareStatement("SELECT producto.codigo, producto.descripcion, categoria.codigo, categoria.detalle, producto_movimiento.valor, producto_movimiento.cantidad"
                        + " from producto_movimiento"
                        + " INNER JOIN producto on producto_movimiento.codigo_producto = producto.codigo"
                        + " INNER JOIN movimiento on producto_movimiento.codigo_movimiento = movimiento.codigo"
                        + " INNER JOIN categoria on producto.categoria = categoria.codigo"
                        + " WHERE movimiento.tipo = 2 AND movimiento.codigo = "+v+" ;");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        p.add(new producto(rs.getInt(1), rs.getString(2), rs.getInt(5), new categoria(rs.getInt(6), rs.getString(4)), new estado()));
                    }
                    return p;

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
    
    //--------------------------------- ingresos ---------------------------------------//

     public String insertarIngreso(String rutTrabajador) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("INSERT INTO movimiento (codigo, fecha, tipo, trabajador) VALUES (NULL, CURRENT_TIMESTAMP, '" + 1 + "', '" + rutTrabajador + "')");
                ps.execute();
                return "Almacenado Correctamente";
            } catch (SQLException SQLEX) {
                return "ERROR SQL: " + SQLEX.getMessage();
            }
        } else {
            return "no existe ninguna conexion abierta";
        }
    }

    public String ProductosDEIngreso(int cod_venta, int cod_producto, int cantidad, int valor) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("INSERT INTO producto_movimiento (codigo_movimiento, codigo_producto, cantidad, valor) VALUES (" + cod_venta + ", " + cod_producto + ", " + cantidad + ", " + valor + ")");
                ps.execute();
                return "Almacenado Correctamente";
            } catch (SQLException SQLEX) {
                return "ERROR SQL: " + SQLEX.getMessage();
            }
        } else {
            return "no existe ninguna conexion abierta";
        }
    }

    public String UltimoIngresoCod() {
        if (super.obtenerConexion() != null) {
            try {
                int venta = 0;
                ps = super.obtenerConexion().prepareStatement("CALL UltimoIngresoCod()");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        venta = rs.getInt(1);
                    }
                    return venta + "";
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

    public String SelectIngresos(ArrayList<movimiento> ARLmo) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement("SELECT * FROM movimiento"
                        + " INNER JOIN tipo on movimiento.tipo = tipo.codigo"
                        + " INNER JOIN trabajador on movimiento.trabajador = trabajador.run"
                        + " INNER JOIN cargo on trabajador.cargo = cargo.codigo\n"
                        + " INNER JOIN estado on trabajador.estado = estado.codigo"
                        + " where tipo = 1");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLmo.add(new movimiento(rs.getInt(1), rs.getDate(2), new tipo(rs.getByte(5), rs.getString(6)), new trabajador(rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), new cargo(rs.getByte(13), rs.getString(14)), new estado(rs.getByte(15), rs.getString(16)))));
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

    public String IngresosPorFecha(ArrayList<movimiento> ARLmo, String fecha1, String fecha2) {
        if (super.obtenerConexion() != null) {
            try {
                ps = super.obtenerConexion().prepareStatement(" CALL ingresosPorRangoDeFEcha('" + fecha1 + "', '"+fecha2+"')");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        ARLmo.add(new movimiento(rs.getInt(1), rs.getDate(2), new tipo(), new trabajador(rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), new cargo(rs.getByte(9), ""), new estado(rs.getByte(10), rs.getString(2)))));
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

    public ArrayList<producto> BuscarProductosIngreso(int v) {
        if (super.obtenerConexion() != null) {
            try {
                ArrayList<producto> p = new ArrayList();
                ps = super.obtenerConexion().prepareStatement("SELECT producto.codigo, producto.descripcion, categoria.codigo, categoria.detalle, producto_movimiento.valor, producto_movimiento.cantidad"
                        + " from producto_movimiento"
                        + " INNER JOIN producto on producto_movimiento.codigo_producto = producto.codigo"
                        + " INNER JOIN movimiento on producto_movimiento.codigo_movimiento = movimiento.codigo"
                        + " INNER JOIN categoria on producto.categoria = categoria.codigo"
                        + " WHERE movimiento.tipo = 1 AND movimiento.codigo = "+v+" ;");
                rs = ps.executeQuery();
                rs.last();
                if (rs.getRow() > 0) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        p.add(new producto(rs.getInt(1), rs.getString(2), rs.getInt(5), new categoria(rs.getInt(6), rs.getString(4)), new estado()));
                    }
                    return p;

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
    
    //-------------------------------------------- conex --------------------------------------------//
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
