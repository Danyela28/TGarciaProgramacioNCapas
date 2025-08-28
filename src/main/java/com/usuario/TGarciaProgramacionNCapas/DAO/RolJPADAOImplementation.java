
package com.usuario.TGarciaProgramacionNCapas.DAO;


import com.usuario.TGarciaProgramacionNCapas.JPA.Rol;
import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolJPADAOImplementation implements IRolJPADAO {
    
    @Autowired
    private EntityManager entityManager;
    
    

    @Override
    public Result GetAll() {
        
        Result result = new Result();
        
        try {
            TypedQuery<Rol> queryUsuario = entityManager.createQuery("FROM Rol ORDER BY IdRol", Rol.class);
            List<Rol> roles = queryUsuario.getResultList();

            result.objects = new ArrayList<>();

            for (Rol rol : roles) {
                com.usuario.TGarciaProgramacionNCapas.ML.Rol rolML = new com.usuario.TGarciaProgramacionNCapas.ML.Rol();
                
            }

            System.out.println(result.objects.size());
            result.correct = true;
        } catch (Exception ex) {s
            System.out.println(ex.getLocalizedMessage());
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;

    }
    
    
    
}
