package seguridad.controlador;

import compras.controlador.*;
import compras.vista.*;

public class clsProducto {

  private String codigo_producto;
  private String nombre_producto;
  private String codigo_linea;
  private String codigo_marca;
  private String estatus_producto;

    public clsProducto() {
    }

    public clsProducto(String codigo_producto, String nombre_producto, String codigo_linea, String codigo_marca, String estatus_producto) {
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.codigo_linea = codigo_linea;
        this.codigo_marca = codigo_marca;
        this.estatus_producto = estatus_producto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getCodigo_linea() {
        return codigo_linea;
    }

    public void setCodigo_linea(String codigo_linea) {
        this.codigo_linea = codigo_linea;
    }

    public String getCodigo_marca() {
        return codigo_marca;
    }

    public void setCodigo_marca(String codigo_marca) {
        this.codigo_marca = codigo_marca;
    }

    public String getEstatus_producto() {
        return estatus_producto;
    }

    public void setEstatus_producto(String estatus_producto) {
        this.estatus_producto = estatus_producto;
    }

    @Override
    public String toString() {
        return "clsProducto{" + "codigo_producto=" + codigo_producto + ", nombre_producto=" + nombre_producto + ", codigo_linea=" + codigo_linea + ", codigo_marca=" + codigo_marca + ", estatus_producto=" + estatus_producto + '}';
    }
  
  
    
 
    
}
