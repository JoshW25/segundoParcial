/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import compras.modelo.*;
import compras.modelo.*;
import seguridad.modelo.*;
import seguridad.controlador.clsMarca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMarca {

    private static final String SQL_SELECT = "SELECT codigo_marca,nombre_marca,estatus_marca FROM marcas";
    private static final String SQL_INSERT = "INSERT INTO marcas (codigo_marca, nombre_marca, estatus_marca) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE marcas SET  nombre_marca = ?, estatus_marca = ? WHERE marcas.codigo_marca = ?";
    private static final String SQL_DELETE = "DELETE FROM marcas WHERE marcas.codigo_marca = ?";
    private static final String SQL_QUERY = "SELECT codigo_marca,nombre_marca,estatus_marca FROM marcas WHERE marcas.codigo_marca = ?";

    public List<clsMarca> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMarca producto = null;
        List<clsMarca> product = new ArrayList<clsMarca>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo_marca = rs.getString("codigo_marca");
                String nombre_marca = rs.getString("nombre_marca");
                String estatus_marca = rs.getString("estatus_marca");
               

                producto = new clsMarca();
                producto.setCodigo_marca(codigo_marca);
                producto.setNombre_marca(nombre_marca);             
                producto.setEstatus_marca(estatus_marca);

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

    public int insert(clsMarca producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getCodigo_marca());
            stmt.setString(2, producto.getNombre_marca());
            stmt.setString(3, producto.getEstatus_marca());
        

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


    public int update(clsMarca producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, producto.getNombre_marca());
            stmt.setString(2, producto.getEstatus_marca());
            stmt.setString(3, producto.getCodigo_marca());

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

    public int delete(clsMarca producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, producto.getCodigo_marca());
            
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

    public clsMarca query(clsMarca producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, producto.getCodigo_marca());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                String marcanombre = rs.getString("nombre_marca");
                String estusdmarca = rs.getString("estatus_marca");
                

                producto = new clsMarca();
                producto.setNombre_marca(marcanombre);
                producto.setEstatus_marca(estusdmarca);
               
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
