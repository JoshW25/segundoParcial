/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import compras.modelo.*;
import compras.modelo.*;
import seguridad.modelo.*;
import seguridad.controlador.clsProveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProveedor {

    private static final String SQL_SELECT = "SELECT codigo_proveedor, nombre_proveedor,direccion_proveedor,telefono_proveedor,estatus_proveedor FROM proveedores";
    private static final String SQL_INSERT = "INSERT INTO proveedores (codigo_proveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, estatus_proveedor) VALUES (?, ?, ? ,?,?)";
    private static final String SQL_UPDATE = "UPDATE proveedores SET  nombre_proveedor = ?, direccion_proveedor = ?, telefono_proveedor = ?, estatus_proveedor = ? WHERE proveedores.codigo_proveedor = ?";
    private static final String SQL_DELETE = "DELETE FROM proveedores WHERE proveedores.codigo_proveedor = ?";
    private static final String SQL_QUERY = "SELECT codigo_proveedor, nombre_proveedor,direccion_proveedor,telefono_proveedor,estatus_proveedor FROM proveedores WHERE proveedores.codigo_proveedor = ? ";

    public List<clsProveedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProveedor producto = null;
        List<clsProveedor> product = new ArrayList<clsProveedor>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_proveedor = rs.getString("codigo_proveedor");
                String nombre_proveedor = rs.getString("nombre_proveedor");
                String direccion_proveedor = rs.getString("direccion_proveedor");
                String telefono_proveedor = rs.getString("telefono_proveedor");
                String estatus_proveedor = rs.getString("estatus_proveedor");

                producto = new clsProveedor();
                producto.setCodigo_proveedor(codigo_proveedor);
                producto.setNombre_proveedor(nombre_proveedor);
                producto.setDireccion_proveedor(direccion_proveedor);
                producto.setTelefono_proveedor(telefono_proveedor);
                producto.setEstatus_proveedor(estatus_proveedor);

                product.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return product;
    }

    public int insert(clsProveedor producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getCodigo_proveedor());
            stmt.setString(2, producto.getNombre_proveedor());
            stmt.setString(3, producto.getDireccion_proveedor());
            stmt.setString(4, producto.getTelefono_proveedor());
            stmt.setString(5, producto.getEstatus_proveedor());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }


    public int update(clsProveedor producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, producto.getNombre_proveedor());
            stmt.setString(2, producto.getDireccion_proveedor());
            stmt.setString(3, producto.getTelefono_proveedor());
            stmt.setString(4, producto.getEstatus_proveedor());
            stmt.setString(5, producto.getCodigo_proveedor());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsProveedor producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, producto.getCodigo_proveedor());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsProveedor query(clsProveedor producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, producto.getCodigo_proveedor());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                String provid = rs.getString("nombre_proveedor");
                String prodnombre = rs.getString("direccion_proveedor");
                String prodmarca = rs.getString("telefono_proveedor");
                String prodprecio = rs.getString("estatus_proveedor");

                producto = new clsProveedor();
                producto.setNombre_proveedor(provid);
                producto.setDireccion_proveedor(prodnombre);
                producto.setTelefono_proveedor(prodmarca);
                producto.setEstatus_proveedor(prodprecio);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return producto;
    }
}
