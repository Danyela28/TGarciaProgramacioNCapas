
package com.usuario.TGarciaProgramacionNCapas.DAO;


import com.usuario.TGarciaProgramacionNCapas.ML.Result;

public interface IUsuarioJPADAO {
    
    Result GetAll();
    Result Add(com.usuario.TGarciaProgramacionNCapas.ML.Usuario usuarioML);
    
}
