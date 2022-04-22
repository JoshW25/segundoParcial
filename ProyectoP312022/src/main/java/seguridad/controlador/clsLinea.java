package seguridad.controlador;

import compras.controlador.*;
import compras.vista.*;

public class clsLinea {

private String codigo_linea;
private String nombre_linea;
private String estaus_linea;

    public clsLinea() {
    }

    public clsLinea(String codigo_linea, String nombre_linea, String estaus_linea) {
        this.codigo_linea = codigo_linea;
        this.nombre_linea = nombre_linea;
        this.estaus_linea = estaus_linea;
    }

    public String getCodigo_linea() {
        return codigo_linea;
    }

    public void setCodigo_linea(String codigo_linea) {
        this.codigo_linea = codigo_linea;
    }

    public String getNombre_linea() {
        return nombre_linea;
    }

    public void setNombre_linea(String nombre_linea) {
        this.nombre_linea = nombre_linea;
    }

    public String getEstaus_linea() {
        return estaus_linea;
    }

    public void setEstaus_linea(String estaus_linea) {
        this.estaus_linea = estaus_linea;
    }

    @Override
    public String toString() {
        return "clsLinea{" + "codigo_linea=" + codigo_linea + ", nombre_linea=" + nombre_linea + ", estaus_linea=" + estaus_linea + '}';
    }
 
    
    
 
    
}
