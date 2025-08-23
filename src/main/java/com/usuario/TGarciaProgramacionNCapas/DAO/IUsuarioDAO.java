
package com.usuario.TGarciaProgramacionNCapas.DAO;

import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import com.usuario.TGarciaProgramacionNCapas.ML.Usuario;


public interface IUsuarioDAO {
    
    Result UsuarioDireccionGetAll(Usuario usuario);
    Result DireccionGetByIdUsuario(int idUsuario);
    Result UsuarioDireccionAdd(Usuario usuario);
    Result UsuarioUpDate(Usuario usuario);
    Result UsuarioAddDireccion(Usuario usuario);
    Result UsuarioGetById(int idUsuario);
}
