/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import compras.modelo.*;
import compras.modelo.*;
import seguridad.modelo.*;
import seguridad.controlador.clsLinea;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoLinea {

    private static final String SQL_SELECT = "SELECT codigo_linea,nombre_linea,estatus_linea FROM lineas";
    private static final String SQL_INSERT = "INSERT INTO lineas (codigo_linea, nombre_linea, estatus_linea) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE lineas SET  nombre_linea = ?, estatus_linea = ? WHERE lineas.codigo_linea = ?";
    private static final String SQL_DELETE = "DELETE FROM linea WHERE linea.codigo_linea = ?";
    private static final String SQL_QUERY = "SELECT codigo_linea,nombre_linea,estatus_linea FROM lineas WHERE lineas.codigo_linea = ?";

    public List<clsLinea> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsLinea producto = null;
        List<clsLinea> product = new ArrayList<clsLinea>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_linea = rs.getString("codigo_linea");
                String nombre_linea = rs.getString("nombre_linea");
                String estatus_linea = rs.getString("estatus_linea");
               

                producto = new clsLinea();
                producto.setCodigo_linea(codigo_linea);
                producto.setNombre_linea(nombre_linea);             
                producto.setEstaus_linea(estatus_linea);

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

    public int insert(clsLinea producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getCodigo_linea());
            stmt.setString(2, producto.getNombre_linea());
            stmt.setString(3, producto.getEstaus_linea());
        

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


    public int update(clsLinea producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, producto.getNombre_linea());
            stmt.setString(2, producto.getEstaus_linea());
            stmt.setString(3, producto.getCodigo_linea());

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

    public int delete(clsLinea producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, producto.getCodigo_linea());
            
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

    public clsLinea query(clsLinea producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, producto.getCodigo_linea());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                String marcanombre = rs.getString("nombre_linea");
                String estusdmarca = rs.getString("estatus_linea");
                

                producto = new clsLinea();
                producto.setNombre_linea(marcanombre);
                producto.setEstaus_linea(estusdmarca);
               
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
