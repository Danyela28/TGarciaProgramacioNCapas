
package com.usuario.TGarciaProgramacionNCapas.ML;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
    
    private int IdUsuario;
    @Size(min = 3, max = 20, message = "Texto de entre 3 y 20 letras")
    @NotEmpty(message = "Informacion necesaria")
    private String Nombre;
    @Size(min = 3, max = 20, message = "Texto de entre 3 y 20 letras")
    @NotBlank(message="Informacion necesaria")
    private String ApellidoMaterno;
    @Size(min = 3, max = 20, message = "Texto de entre 3 y 20 letras")
    @NotEmpty(message = "Informacion necesaria")
    private String ApellidoPaterno;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaNacimiento;
    @Pattern(regexp="^\\d{10}$", message = "Numero invalido")
    private String Celular;
    public String fechaStr;
    
    private String UserName;
    @NotBlank(message = "El email no puede estar vacío")
    private String Email;
    private String Password;
    private String Sexo;
    @Pattern(regexp="^\\d{10}$", message = "Numero invalido")
    private String Telefono;
    @Size(min = 10, max = 18, message = "Texto de entre 18 caracteres")
    @NotEmpty(message = "Informacion necesaria")
    private String CURP;
    
    public Rol Rol;
    public List<Direccion>Direcciones;
    private String Imagen;

    
    
    
    
    public Usuario(){}
    
    public Usuario(com.usuario.TGarciaProgramacionNCapas.JPA.Usuario usuarioJPA){
        this.IdUsuario = usuarioJPA.getIdUsuario();
        this.Nombre = usuarioJPA.getNombre();
        this.ApellidoPaterno = usuarioJPA.getApellidoPaterno();
        this.ApellidoMaterno = usuarioJPA.getApellidoMaterno();
        this.FechaNacimiento = usuarioJPA.getFechaNacimiento();
        this.Celular = usuarioJPA.getCelular();
        this.UserName = usuarioJPA.getUserName();
        this.Email = usuarioJPA.getEmail();
        this.Password = usuarioJPA.getPassword();
        this.Sexo = usuarioJPA.getSexo();
        this.Telefono = usuarioJPA.getTelefono();
        this.CURP = usuarioJPA.getCURP();
        this.Imagen = usuarioJPA.getImagen();
        this.Rol = new Rol();
        this.Rol.setIdRol(usuarioJPA.Rol.getIdRol());
        this.Rol.setNombre(usuarioJPA.Rol.getNombre());
        if(usuarioJPA.Direcciones !=null && usuarioJPA.Direcciones.size()>0){
            this.Direcciones = new ArrayList<>();
            for(com.usuario.TGarciaProgramacionNCapas.JPA.Direccion Direction : usuarioJPA.Direcciones){
                Direccion direccion = new Direccion();
                direccion.setIdDireccion(Direction.getIdDireccion());
                direccion.setCalle(Direction.getCalle());
                direccion.setNumeroExterior(Direction.getNumeroExterior());
                direccion.setNumeroInterior(Direction.getNumeroInterior());
                
                direccion.colonia = new Colonia();
                direccion.colonia.setIdColonia(Direction.colonia.getIdColonia());
                direccion.colonia.setNombre(Direction.colonia.getNombre());
                direccion.colonia.setCodigoPostal(Direction.colonia.getCodigoPostal());
                
                direccion.colonia.Municipio = new Municipio();
                direccion.colonia.Municipio.setIdMunicipio(Direction.colonia.Municipio.getIdMunicipio());
                direccion.colonia.Municipio.setNombre(Direction.colonia.Municipio.getNombre());
                
                direccion.colonia.Municipio.Estado = new Estado();
                direccion.colonia.Municipio.Estado.setIdEstado(Direction.colonia.Municipio.Estado.getIdEstado());
                direccion.colonia.Municipio.Estado.setNombre(Direction.colonia.Municipio.Estado.getNombre());
                
                direccion.colonia.Municipio.Estado.Pais = new Pais();
                direccion.colonia.Municipio.Estado.Pais.setIdPais(Direction.colonia.Municipio.Estado.Pais.getIdPais());
                direccion.colonia.Municipio.Estado.Pais.setNombre(Direction.colonia.Municipio.Estado.Pais.getNombre());
                
                this.Direcciones.add(direccion);
                
            }
            
        }
        
    }
    
    public void setIdUsuario(int idUsuario){
        this.IdUsuario=idUsuario;   
    } 
    public int getIdUsuario(){
        return this.IdUsuario;
    }
    public Usuario(String Nombre, String ApellidoPaterno, String ApellidoMaterno, Rol rol){
        this.Nombre=Nombre;
        this.ApellidoPaterno=ApellidoPaterno;
        this.ApellidoMaterno=ApellidoMaterno;
        this.Rol= rol;
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

    public List<Direccion> getDirecciones() {
        return Direcciones;
    }

    public void setDirecciones(List<Direccion> Direcciones) {
        this.Direcciones = Direcciones;
    }

   

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
