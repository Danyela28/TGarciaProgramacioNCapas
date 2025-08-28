
package com.usuario.TGarciaProgramacionNCapas.DAO;

import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MunicipioJPADAOImplementation implements IMunicipioJPADAO {
    
    @Autowired
    private EntityManager entityManger;

    @Override
    public Result MunicipioByEstado(int IdMunicipio) {
        Result result = new Result();
        
        try{
            
        }catch(Exception ex){
            result.correct= false;
            result.errorMessage=ex.getLocalizedMessage();
            result.ex= ex;
        }
        return result;
    
    }
    
}
