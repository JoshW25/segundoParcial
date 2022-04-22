/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import compras.modelo.*;
import compras.modelo.*;
import seguridad.modelo.*;
import seguridad.controlador.clsProducto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProducto {

    private static final String SQL_SELECT = "SELECT codigo_producto, nombre_producto,codigo_linea,codigo_marca,estatus_producto FROM productos";
    private static final String SQL_INSERT = "INSERT INTO productos (codigo_producto, nombre_producto, codigo_linea, codigo_marca, estatus_producto) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE productos SET  nombre_producto = ?, codigo_linea = ?, codigo_marca= ? ,estatus_producto=? WHERE productos.codigo_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE productos.codigo_producto = 123";
    private static final String SQL_QUERY = "SELECT codigo_producto, nombre_producto,codigo_linea,codigo_marca,estatus_producto FROM productos WHERE productos.codigo_producto = ? ";

    public List<clsProducto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProducto producto = null;
        List<clsProducto> product = new ArrayList<clsProducto>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_producto = rs.getString("codigo_producto");
                String nombre_producto = rs.getString("nombre_producto");
                String codigo_linea = rs.getString("codigo_linea");
                String codigo_marca = rs.getString("codigo_marca");
                String estatus_producto = rs.getString("estatus_producto");

                producto = new clsProducto();
                producto.setCodigo_producto(codigo_producto);
                producto.setNombre_producto(nombre_producto );
                producto.setCodigo_linea(codigo_linea);
                producto.setCodigo_marca(codigo_marca );
                producto.setEstatus_producto(estatus_producto);

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

    public int insert(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getCodigo_producto());
            stmt.setString(2, producto.getNombre_producto());
            stmt.setString(3, producto.getCodigo_linea());
            stmt.setString(4, producto.getCodigo_marca());
            stmt.setString(5, producto.getEstatus_producto());

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


    public int update(clsProducto producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, producto.getNombre_producto());
            stmt.setString(2, producto.getCodigo_linea());
            stmt.setString(3, producto.getCodigo_marca());
            stmt.setString(4, producto.getEstatus_producto());
            stmt.setString(5, producto.getCodigo_producto());
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

    public int delete(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, producto.getCodigo_producto());
            
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

    public clsProducto query(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, producto.getCodigo_producto());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                String provid = rs.getString("nombre_producto");
                String prodnombre = rs.getString("codigo_linea");
                String prodmarca = rs.getString("codigo_marca");
                String prodprecio = rs.getString("estatus_producto");

                producto = new clsProducto();
                producto.setNombre_producto(provid);
                producto.setCodigo_linea(prodnombre);
                producto.setCodigo_marca(prodmarca);
                producto.setEstatus_producto(prodprecio);
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
