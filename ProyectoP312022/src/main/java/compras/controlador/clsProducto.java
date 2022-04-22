package compras.controlador;

import compras.vista.*;

public class clsProducto {
 private int prodid;   
 private int provid;
 private String prodnombre;
 private String prodmarca;
 private int prodprecio;

    public clsProducto() {
    }

    public clsProducto(int prodid,int provid, String prodnombre, String prodmarca, int prodprecio) {
        this.prodid = prodid; 
        this.provid = provid;
        this.prodnombre = prodnombre;
        this.prodmarca = prodmarca;
        this.prodprecio = prodprecio;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }
 

    public int getProvid() {
        return provid;
    }

    public void setProvid(int provid) {
        this.provid = provid;
    }

    public String getProdnombre() {
        return prodnombre;
    }

    public void setProdnombre(String prodnombre) {
        this.prodnombre = prodnombre;
    }

    public String getProdmarca() {
        return prodmarca;
    }

    public void setProdmarca(String prodmarca) {
        this.prodmarca = prodmarca;
    }

    public int getProdprecio() {
        return prodprecio;
    }

    public void setProdprecio(int prodprecio) {
        this.prodprecio = prodprecio;
    }

    @Override
    public String toString() {
        return "clsProducto{" + "prodid=" + prodid + ", provid=" + provid + ", prodnombre=" + prodnombre + ", prodmarca=" + prodmarca + ", prodprecio=" + prodprecio + '}';
    }

 
    
}
