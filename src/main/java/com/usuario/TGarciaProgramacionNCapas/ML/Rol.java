
package com.usuario.TGarciaProgramacionNCapas.ML;

public class Rol {
    private int IdRol;
    private String Nombre;
    
    public Rol(){}
    
    public Rol(int idRol, String nombre){
        this.IdRol = idRol;
        this.Nombre = nombre;
    }
    public Rol(Integer idRol){
        this.IdRol= IdRol;
    }

    public Rol(com.usuario.TGarciaProgramacionNCapas.JPA.Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
    
    

