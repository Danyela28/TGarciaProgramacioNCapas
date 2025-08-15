
package com.usuario.TGarciaProgramacionNCapas.ML;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    private int Edad;
    private double Estatura;
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

    /**
     *
     */
    public List<Direccion>Direcciones;

    
    
    
    
    
    public Usuario(){}
    
    public Usuario(int idUsuario, String nombre, String apellidoMaterno, String apellidoPaterno, Date fechaNacimiento, int edad, double estatura, String celular,
            String userName, String email, String password, String sexo, String telefono, String curp, Rol rol){
        this.IdUsuario=idUsuario;
        this.Nombre=nombre;
        this.ApellidoMaterno= apellidoMaterno;
        this.ApellidoPaterno=apellidoPaterno;
        this.FechaNacimiento=fechaNacimiento;
        this.Edad=edad;
        this.Estatura=estatura;
        this.Celular=celular;
        this.UserName=userName;
        this.Email=email;
        this.Password=password;
        this.Sexo=sexo;
        this.Telefono=telefono;
        this.CURP=curp;
        this.Rol=rol;
        
    }
    
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
    public void setEdad(int edad){
        this.Edad=edad;
    }
    public int getEdad(){
        return Edad;
    }

    public double getEstatura() {
        return Estatura;
    }

    public void setEstatura(double Estatura) {
        this.Estatura = Estatura;
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

    

   
    
    
   
    
    
}
