
package com.usuario.TGarciaProgramacionNCapas.DAO;

import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EstadoJPADAOImplementation implements IEstadoJPADAO {
    
    @Autowired
    private EntityManager entityManager;

    @Override
    public Result EstadoByPais(int IdPais) {
        
        Result result = new Result();
        
        try{
            
            
        }catch(Exception ex){
            result.correct=false;
            result.errorMessage=ex.getLocalizedMessage();
            result.ex=ex;
        }
        return result;
    }
    
}
