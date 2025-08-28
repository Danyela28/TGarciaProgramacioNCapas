
package com.usuario.TGarciaProgramacionNCapas.ML;

public class Pais {

    public Pais(int aInt, String string) {
    }
    private int IdPais;
    private String Nombre;

    public Pais() {
    }

    public Pais(com.usuario.TGarciaProgramacionNCapas.JPA.Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public int getIdPais(){
        return IdPais;
    }
    public void setIdPais(int IdPais){
        this.IdPais = IdPais;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
}
