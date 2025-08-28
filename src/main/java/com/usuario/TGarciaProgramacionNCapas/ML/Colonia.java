
package com.usuario.TGarciaProgramacionNCapas.ML;

public class Colonia {
    private int IdColonia;
    private String Nombre;
    private String CodigoPostal;
    public Municipio Municipio;

    public Colonia(com.usuario.TGarciaProgramacionNCapas.JPA.Colonia colonia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Colonia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public int getIdColonia(){
        return IdColonia;
    }
    public void setIdColonia(int IdColonia){
        this.IdColonia = IdColonia;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    public String getCodigoPostal(){
        return CodigoPostal;
    }
    public void setCodigoPostal(String CodigoPostal){
        this.CodigoPostal= CodigoPostal;
    }

    
}
