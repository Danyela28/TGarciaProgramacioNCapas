
package com.usuario.TGarciaProgramacionNCapas.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Colonia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcolonia")
    private int IdColonia;
    @Column(name="nombre")
    private String Nombre;
    @Column(name="codigopostal")
    private String CodigoPostal;
    @ManyToOne
    @JoinColumn(name="idmunicipio")
    public Municipio Municipio;
    
    
    public Colonia(){}
    
    public Colonia(com.usuario.TGarciaProgramacionNCapas.ML.Colonia coloniaML){
        this.IdColonia = coloniaML.getIdColonia();
        this.Nombre = coloniaML.getNombre();
        this.Municipio = new Municipio();
        this.Municipio.setIdMunicipio(coloniaML.Municipio.getIdMunicipio());
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
