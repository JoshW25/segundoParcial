package seguridad.controlador;

import compras.controlador.*;
import compras.vista.*;

public class clsProveedor {

    private String codigo_proveedor;
    private String nombre_proveedor;
    private String direccion_proveedor;
    private String telefono_proveedor;
    private String estatus_proveedor;

    public clsProveedor() {
    }

    public clsProveedor(String codigo_proveedor, String nombre_proveedor, String direccion_proveedor, String telefono_proveedor, String estatus_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.estatus_proveedor = estatus_proveedor;
    }

    public String getCodigo_proveedor() {
        return codigo_proveedor;
    }

    public void setCodigo_proveedor(String codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getEstatus_proveedor() {
        return estatus_proveedor;
    }

    public void setEstatus_proveedor(String estatus_proveedor) {
        this.estatus_proveedor = estatus_proveedor;
    }

    @Override
    public String toString() {
        return "clsProveedor{" + "codigo_proveedor=" + codigo_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", direccion_proveedor=" + direccion_proveedor + ", telefono_proveedor=" + telefono_proveedor + ", estatus_proveedor=" + estatus_proveedor + '}';
    }
    
    
 
    
}
