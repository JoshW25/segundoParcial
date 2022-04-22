package logistica.controlador;

import compras.controlador.*;

public class clsMarca {
 private int marid;
 private String marnombre,marlinea,marestado;

    public clsMarca() {
    }

    public clsMarca(int marid, String marnombre, String marlinea, String marestado) {
        this.marid = marid;
        this.marnombre = marnombre;
        this.marlinea = marlinea;
        this.marestado = marestado;
    }

    public int getMarid() {
        return marid;
    }

    public void setMarid(int marid) {
        this.marid = marid;
    }

    public String getMarnombre() {
        return marnombre;
    }

    public void setMarnombre(String marnombre) {
        this.marnombre = marnombre;
    }

    public String getMarlinea() {
        return marlinea;
    }

    public void setMarlinea(String marlinea) {
        this.marlinea = marlinea;
    }

    public String getMarestado() {
        return marestado;
    }

    public void setMarestado(String marestado) {
        this.marestado = marestado;
    }

    @Override
    public String toString() {
        return "clsMarca{" + "marid=" + marid + ", marnombre=" + marnombre + ", marlinea=" + marlinea + ", marestado=" + marestado + '}';
    }
 
 

 
    
}
