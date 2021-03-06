/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.modelo.*;
import seguridad.modelo.*;
import compras.controlador.clsProducto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProducto {

    private static final String SQL_SELECT = "SELECT prodid, provid, prodnombre,prodmarca,prodprecio FROM tbl_producto";
    private static final String SQL_INSERT = "INSERT INTO tbl_producto ( provid, prodnombre, prodmarca, prodprecio) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_producto SET prodnombre = ?, prodmarca = ?, prodprecio = ? WHERE tbl_producto.prodid = ? AND tbl_producto.provid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_producto WHERE tbl_producto.prodid = ? AND tbl_producto.provid = ?";
    private static final String SQL_QUERY = "SELECT prodid, provid, prodnombre,prodmarca,prodprecio FROM tbl_producto WHERE prodid=?";

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
                int prodid = rs.getInt("prodid");
                int provid = rs.getInt("provid");
                String prodnombre = rs.getString("prodnombre");
                String prodmarca = rs.getString("prodmarca");
                int prodprecio = rs.getInt("prodprecio");

                producto = new clsProducto();
                producto.setProdid(prodid);
                producto.setProvid(provid);
                producto.setProdnombre(prodnombre);
                producto.setProdmarca(prodmarca);
                producto.setProdprecio(prodprecio);

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
            stmt.setInt(1, producto.getProvid());
            stmt.setString(2, producto.getProdnombre());
            stmt.setString(3, producto.getProdmarca());
            stmt.setInt(4, producto.getProdprecio());

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
            stmt.setString(1, producto.getProdnombre());
            stmt.setString(2, producto.getProdmarca());
            stmt.setInt(3, producto.getProdprecio());
            stmt.setInt(4, producto.getProdid());
            stmt.setInt(5, producto.getProvid());

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
            stmt.setInt(1, producto.getProdid());
            stmt.setInt(2, producto.getProvid());
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
            stmt.setInt(1, producto.getProdid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                int provid = rs.getInt("provid");
                String prodnombre = rs.getString("prodnombre");
                String prodmarca = rs.getString("prodmarca");
                int prodprecio = rs.getInt("prodprecio");

                producto = new clsProducto();
                producto.setProvid(provid);
                producto.setProdnombre(prodnombre);
                producto.setProdmarca(prodmarca);
                producto.setProdprecio(prodprecio);
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
