package com.usuario.TGarciaProgramacionNCapas.DAO;

import com.usuario.TGarciaProgramacionNCapas.JPA.Usuario;
import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioJPADAOImplementation implements IUsuarioJPADAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Result GetAll() {

        Result result = new Result();

        try {
            TypedQuery<Usuario> queryUsuario = entityManager.createQuery("FROM Usuario ORDER BY IdUsuario", Usuario.class);
            List<Usuario> usuarios = queryUsuario.getResultList();

            result.objects = new ArrayList<>();

            for (Usuario usuario : usuarios) {
                result.objects.add(new com.usuario.TGarciaProgramacionNCapas.ML.Usuario(usuario));
            }

            System.out.println(result.objects.size());
            result.correct = true;
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;

    }
    @Transactional
    @Override
    public Result Add(com.usuario.TGarciaProgramacionNCapas.ML.Usuario usuarioML) {
        Result result = new Result();
        
        try{
            Usuario usuarioJPA = new Usuario(usuarioML);
            entityManaher.persist(usuarioJPA);
            result.correct = true;
        }catch (Exception ex){
            result.correct = false;
            result.errorMessage=ex.getLocalizedMessage();
            result.ex=ex;
        }
        return result;
        
    }
    
}
