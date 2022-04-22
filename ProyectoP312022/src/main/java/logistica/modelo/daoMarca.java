/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import compras.modelo.*;
import compras.modelo.*;
import seguridad.modelo.*;

import logistica.controlador.clsMarca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMarca {

    private static final String SQL_SELECT = "SELECT marid, marnombre,marlinea,marestado FROM tbl_marca";
    private static final String SQL_INSERT = "INSERT INTO tbl_marca ( marnombre, marlinea, marestado) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_marca SET marnombre = ?, marlinea = ?, marestado = ? WHERE tbl_marca.marid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_marca WHERE tbl_marca.marid = ?";
    private static final String SQL_QUERY = "SELECT marid, marnombre,marlinea,marestado FROM tbl_marca WHERE marid=?";

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
                int marid = rs.getInt("marid");
                String marnombre = rs.getString("marnombre");
                String marlinea= rs.getString("marlinea");
                String marestado= rs.getString("marestado");
                

                producto = new clsMarca();
                producto.setMarid(marid);
                producto.setMarnombre(marnombre);
                producto.setMarlinea(marlinea);
                producto.setMarestado(marestado);
                

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
            stmt.setString(1, producto.getMarnombre());
            stmt.setString(2, producto.getMarlinea());
            stmt.setString(3, producto.getMarestado());

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
            stmt.setString(1, producto.getMarnombre());
            stmt.setString(2, producto.getMarlinea());
            stmt.setString(3, producto.getMarestado());
            stmt.setInt(4, producto.getMarid());
            

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
            stmt.setInt(1, producto.getMarid());
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
            stmt.setInt(1, producto.getMarid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String marnombre = rs.getString("marnombre");
                String marlinea= rs.getString("marlinea");
               String marestado= rs.getString("marestado");

                producto = new clsMarca();
              
                producto.setMarnombre(marnombre);
                producto.setMarlinea(marlinea);
                producto.setMarestado(marestado);
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
