
package com.usuario.TGarciaProgramacionNCapas.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddireccion")
    private int IdDireccion;
    @Column(name="calle")
    private String Calle;
    @Column(name="numerointerior")
    private String NumeroInterior;
    @Column(name="numeroexterior")
    private String NumeroExterior;
    @ManyToOne
    @JoinColumn(name="idcolonia")
    public Colonia colonia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idusuario", nullable = false)
    public Usuario Usuario;

   
    public Direccion(){}
    
    public Direccion(com.usuario.TGarciaProgramacionNCapas.ML.Usuario usuarioML){
        
        com.usuario.TGarciaProgramacionNCapas.ML.Direccion direccionML = usuarioML.Direcciones.get(0);
        
        this.IdDireccion=direccionML.getIdDireccion();
        this.Calle = direccionML.getCalle();
        this.NumeroExterior = direccionML.getNumeroExterior();
        this.NumeroInterior = direccionML.getNumeroInterior();
        this.colonia = new Colonia();
        this.colonia.setIdColonia(direccionML.colonia.getIdColonia());
        this.Usuario = new Usuario();
        this.Usuario.setIdUsuario(usuarioML.getIdUsuario());
        
    }
    
    public Direccion(int IdDireccion) {
        this.IdDireccion = IdDireccion;
    }
    
    public int getIdDireccion() {
        return IdDireccion;
    }

    public void setIdDireccion(int IdDireccion) {
        this.IdDireccion = IdDireccion;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getNumeroInterior() {
        return NumeroInterior;
    }

    public void setNumeroInterior(String NumeroInterior) {
        this.NumeroInterior = NumeroInterior;
    }

    public String getNumeroExterior() {
        return NumeroExterior;
    }

    public void setNumeroExterior(String NumeroExterior) {
        this.NumeroExterior = NumeroExterior;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }
    
    

  
}
