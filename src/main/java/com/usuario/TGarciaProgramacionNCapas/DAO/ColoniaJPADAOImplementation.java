
package com.usuario.TGarciaProgramacionNCapas.DAO;


import com.usuario.TGarciaProgramacionNCapas.JPA.Colonia;
import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
                "SELECT c FROM Colonia c WHERE c.municipio.idMunicipio = :idMunicipio", Colonia.class);
            query.setParameter("idMunicipio", IdMunicipio);

            List<Colonia> colonias = query.getResultList();
            result.setObjects(colonias);
            result.setCorrect(true);
        } catch (Exception ex) {
            result.setCorrect(false);
            result.setErrorMessage(ex.getMessage());
        }
        return result;
    }
}

        

