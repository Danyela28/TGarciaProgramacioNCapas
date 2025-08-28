
package com.usuario.TGarciaProgramacionNCapas.DAO;

import com.usuario.TGarciaProgramacionNCapas.ML.Result;


public interface IDireccionJPADAO {
    
    Result UpDate(com.usuario.TGarciaProgramacionNCapas.ML.Usuario usuarioML);
    Result Delete(int IdDireccion);
    
}
