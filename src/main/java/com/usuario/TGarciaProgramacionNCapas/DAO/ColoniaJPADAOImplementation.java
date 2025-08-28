
package com.usuario.TGarciaProgramacionNCapas.DAO;


import com.usuario.TGarciaProgramacionNCapas.JPA.Colonia;
import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ColoniaJPADAOImplementation implements IColoniaJPADAO {
        


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Result ColoniaByMunicipio(int IdMunicipio) {
        Result result = new Result();
        try {
            TypedQuery<Colonia> query = entityManager.createQuery(
                "FROM Colonia WHERE Colonia.Municipio.IdMunicipio = :IdMunicipio", Colonia.class);
            query.setParameter("IdMunicipio", IdMunicipio);
            
            List<Colonia> colonias = query.getResultList();
            result.objects = new ArrayList<>();
            
            for(Colonia colonia : colonias){
                result.objects.add(new com.usuario.TGarciaProgramacionNCapas.ML.Colonia(colonia));
            }
            System.out.println(result.objects.size());
            result.correct=true;

        } catch (Exception ex) {
            result.correct=false;
            result.errorMessage=ex.getLocalizedMessage();
            result.ex= ex;
            
        }
        return result;
    }
}

        

