
package com.usuario.TGarciaProgramacionNCapas.JPA;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;  
import java.util.List;


@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private int IdUsuario;
    @Column(name="nombre")
    private String Nombre;
    @Column(name="apellidomaterno")
    private String ApellidoMaterno;
    @Column(name="apellidopaterno")
    private String ApellidoPaterno;
    @Column(name="fechanacimiento")
    private Date FechaNacimiento;
    @Column(name="celular")
    private String Celular;
    @Column(name="username")
    private String UserName;
    @Column(name="email")
    private String Email;
    @Column(name="password")
    private String Password;
    @Column(name="sexo")
    private String Sexo;
    @Column(name="telefono")
    private String Telefono;
    @Column(name="curp")
    private String CURP;
    @Lob
    @Column( name="imagen")
    private String Imagen;
    @ManyToOne
    @JoinColumn (name="idrol")
    public Rol Rol;
    
    @OneToMany(mappedBy="Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Direccion>Direcciones = new ArrayList<>();
    
    public Usuario(com.usuario.TGarciaProgramacionNCapas.ML.Usuario usuarioML){
        this.Nombre = usuarioML.getNombre();
        this.ApellidoPaterno = usuarioML.getApellidoPaterno();
        this.ApellidoMaterno = usuarioML.getApellidoMaterno();
        this.FechaNacimiento = usuarioML.getFechaNacimiento();
        this.Celular = usuarioML.getCelular();
        this.UserName = usuarioML.getUserName();
        this.Email = usuarioML.getEmail();
        this.Password = usuarioML.getPassword();
        this.Sexo = usuarioML.getSexo();
        this.Telefono = usuarioML.getTelefono();
        this.CURP = usuarioML.getCURP();
        this.Imagen = usuarioML.getImagen();
        this.Rol = new Rol();
        this.Rol.setIdRol(usuarioML.Rol.getIdRol());
        if(usuarioML.Direcciones.get(0).getIdDireccion() == -1){
            
            usuarioML.Direcciones = null;   
        }else{
            for (com.usuario.TGarciaProgramacionNCapas.ML.Direccion Direction : usuarioML.Direcciones ){
            Direccion direccion = new Direccion();
            direccion.setCalle(Direction.getCalle());
            direccion.setNumeroExterior(Direction.getNumeroExterior());
            direccion.setNumeroInterior(Direction.getNumeroInterior());
            direccion.colonia = new Colonia();
            direccion.colonia.setIdColonia(Direction.colonia.getIdColonia());
            direccion.Usuario = this;
            
            Direcciones.add(direccion);
        }
    }
}
            
    public Usuario(){}
    
    
    public void setIdUsuario(int idUsuario){
        this.IdUsuario=idUsuario;   
    } 
    public int getIdUsuario(){
        return this.IdUsuario;
    }

    public void setNombre(String nombre){
        this.Nombre=nombre;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setApellidoMaterno(String apellidoMaterno){
        this.ApellidoMaterno=apellidoMaterno;
    }
    public String getApellidoMaterno(){
        return ApellidoMaterno;
    }
    public void setApellidoPaterno( String apellidoPaterno){
        this.ApellidoPaterno=apellidoPaterno;
    }
    public String getApellidoPaterno(){
        return ApellidoPaterno;
    }
    public void setFechaNacimiento(Date fechaNacimiento){
        this.FechaNacimiento = fechaNacimiento;  
    }

    public Date getFechaNacimiento(){
        return FechaNacimiento;
    }
    

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }
    public String getUserName(){
        return UserName;
    }
    public void setUserName(String userName){
        this.UserName = userName;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String email){
        this.Email = email;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String password){
        this.Password = password;
    }
    public String getSexo(){
        return Sexo;
    }
    public void setSexo(String sexo){
        this.Sexo = sexo;
    }
    public String getTelefono(){
        return Telefono;
    }
    public void setTelefono(String telefono){
        this.Telefono = telefono;          
    }
    public String getCURP(){
        return CURP;
    }
    public void setCURP(String curp){
        this.CURP = curp;
    }

//    public List<Direccion> getDirecciones() {
//        return Direcciones;
//    }
//
//    public void setDirecciones(List<Direccion> Direcciones) {
//        this.Direcciones = Direcciones;
//    }

   

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    

   
    
    
   
    
    
}
