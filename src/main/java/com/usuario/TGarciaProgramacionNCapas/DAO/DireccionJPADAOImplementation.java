
package com.usuario.TGarciaProgramacionNCapas.DAO;

import com.usuario.TGarciaProgramacionNCapas.JPA.Direccion;
import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class DireccionJPADAOImplementation implements IDireccionJPADAO{
    
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public Result UpDate(com.usuario.TGarciaProgramacionNCapas.ML.Usuario usuarioML) {
        
        Result result = new Result();
        
        try{
            Direccion direccionJPA = new Direccion(usuarioML);
            entityManager.merge(direccionJPA);
            result.correct = true;
            
        }catch(Exception ex){
            result.correct=false;
            result.errorMessage=ex.getLocalizedMessage();
            result.ex= ex;
        }
        return result;
        
    }
    
    @Transactional
    @Override
    public Result Delete(int IdDireccion) {
        
        Result result = new Result();
        
        try{
            Direccion direccionJPA = entityManager.find(Direccion.class, IdDireccion);
            entityManager.remove(direccionJPA);
            
            result.correct=true;
            
        }catch(Exception ex){
            result.correct=false;
            result.errorMessage=ex.getLocalizedMessage();
            result.ex=ex;
        }
        
        return result;
    }
    
    
}
