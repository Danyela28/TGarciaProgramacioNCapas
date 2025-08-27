
package com.usuario.TGarciaProgramacionNCapas.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idpais")
    private int IdPais;
    @Column(name="nombre")
    private String Nombre;

    public Pais() {
    }
    public Pais(int aInt, String string) {
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
