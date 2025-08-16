package com.usuario.TGarciaProgramacionNCapas.DAO;

import com.usuario.TGarciaProgramacionNCapas.ML.Colonia;
import com.usuario.TGarciaProgramacionNCapas.ML.Direccion;
import com.usuario.TGarciaProgramacionNCapas.ML.Estado;
import com.usuario.TGarciaProgramacionNCapas.ML.Municipio;
import com.usuario.TGarciaProgramacionNCapas.ML.Pais;
import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import com.usuario.TGarciaProgramacionNCapas.ML.Rol;
import com.usuario.TGarciaProgramacionNCapas.ML.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImplementation implements IUsuarioDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Result UsuarioDireccionGetAll() {
        Result result = new Result();

        try {
            jdbcTemplate.execute("{CALL UsuarioDireccionGetAll(?)}", (CallableStatementCallback<Integer>) callableStatement -> {
                callableStatement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

                callableStatement.execute();

                ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

                result.objects = new ArrayList<>();
                while (resultSet.next()) {

                    int idUsuario = resultSet.getInt("IdUsuario");

                    if (!result.objects.isEmpty() && idUsuario == ((Usuario) (result.objects.get(result.objects.size() - 1))).getIdUsuario()) {

                        Direccion direccion = new Direccion();
                        direccion.setIdDireccion(resultSet.getInt("IdDireccion"));
                        direccion.setCalle(resultSet.getString("Calle"));
                        direccion.setNumeroExterior(resultSet.getString("NumeroExterior"));
                        direccion.setNumeroInterior(resultSet.getString("NumeroInterior"));

                        direccion.colonia = new Colonia();
                        direccion.colonia.setIdColonia(resultSet.getInt("IdColonia"));
                        direccion.colonia.setNombre(resultSet.getString("NombreColonia"));
                        direccion.colonia.setCodigoPostal(resultSet.getString("CodigoPostal"));

                        direccion.colonia.Municipio = new Municipio();
                        direccion.colonia.Municipio.setIdMunicipio(resultSet.getInt("IdMunicipio"));
                        direccion.colonia.Municipio.setNombre(resultSet.getString("NombreMunicipio"));

                        direccion.colonia.Municipio.Estado = new Estado();
                        direccion.colonia.Municipio.Estado.setIdEstado(resultSet.getInt("IdEstado"));
                        direccion.colonia.Municipio.Estado.setNombre(resultSet.getString("NombreEstado"));

                        direccion.colonia.Municipio.Estado.Pais = new Pais(resultSet.getInt("IdPais"), resultSet.getString("Nombre"));
                        direccion.colonia.Municipio.Estado.Pais.setIdPais(resultSet.getInt("IdPais"));
                        direccion.colonia.Municipio.Estado.Pais.setNombre(resultSet.getString("NombrePais"));
                        ((Usuario) (result.objects.get(result.objects.size() - 1))).Direcciones.add(direccion);
                    } else {

                        Usuario usuario = new Usuario();

                        usuario.setIdUsuario(resultSet.getInt("IdUsuario"));
                        usuario.setNombre(resultSet.getString("NombreUsuario"));
                        usuario.setApellidoMaterno(resultSet.getString("ApellidoMaterno"));
                        usuario.setApellidoPaterno(resultSet.getString("ApellidoPaterno"));
                        usuario.setFechaNacimiento(resultSet.getDate("FechaNacimiento"));
                        usuario.setCelular(resultSet.getString("Celular"));
                        usuario.setUserName(resultSet.getString("UserName"));
                        usuario.setEmail(resultSet.getString("Email"));
                        usuario.setPassword(resultSet.getString("Password"));
                        usuario.setSexo(resultSet.getString("Sexo"));
                        usuario.setTelefono(resultSet.getString("Telefono"));
                        usuario.setCURP(resultSet.getString("CURP"));

                        usuario.Rol = new Rol();
                        usuario.Rol.setIdRol(resultSet.getInt("IdRol"));
                        usuario.Rol.setNombre(resultSet.getString("Nombre"));

                        int idDireccion;
                        if ((idDireccion = resultSet.getInt("IdDireccion")) != 0) {

                            usuario.Direcciones = new ArrayList<>();

                            Direccion direccion = new Direccion();
                            direccion.setIdDireccion(resultSet.getInt("IdDireccion"));
                            direccion.setCalle(resultSet.getString("Calle"));
                            direccion.setNumeroExterior(resultSet.getString("NumeroExterior"));
                            direccion.setNumeroInterior(resultSet.getString("NumeroInterior"));

                            direccion.colonia = new Colonia();
                            direccion.colonia.setIdColonia(resultSet.getInt("IdColonia"));
                            direccion.colonia.setNombre(resultSet.getString("NombreColonia"));
                            direccion.colonia.setCodigoPostal(resultSet.getString("CodigoPostal"));

                            direccion.colonia.Municipio = new Municipio();
                            direccion.colonia.Municipio.setIdMunicipio(resultSet.getInt("IdMunicipio"));
                            direccion.colonia.Municipio.setNombre(resultSet.getString("NombreMunicipio"));

                            direccion.colonia.Municipio.Estado = new Estado();
                            direccion.colonia.Municipio.Estado.setIdEstado(resultSet.getInt("IdEstado"));
                            direccion.colonia.Municipio.Estado.setNombre(resultSet.getString("NombreEstado"));

                            direccion.colonia.Municipio.Estado.Pais = new Pais(resultSet.getInt("IdPais"), resultSet.getString("Nombre"));
                            direccion.colonia.Municipio.Estado.Pais.setIdPais(resultSet.getInt("IdPais"));
                            direccion.colonia.Municipio.Estado.Pais.setNombre(resultSet.getString("NombrePais"));

                            usuario.Direcciones.add(direccion);
                        }
                        result.objects.add(usuario);
                    }

                }
                result.correct = true;
                return 1;
            });
        } catch (Exception ex) {
            result.ex = ex;
            result.errorMessage = ex.getLocalizedMessage();
            result.correct = false;
        }
        return result;

    }

    @Override
    public Result DireccionGetByIdUsuario(int idUsuario) {
        Result result = new Result();

        try {
            jdbcTemplate.execute("{CALL DireccionGetByIdUsuario(?,?)}", (CallableStatementCallback<Integer>) callableStatement -> {
                callableStatement.setInt(1, idUsuario);
                callableStatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);

                callableStatement.execute();

                ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

                if (resultSet.next()) {

                    Usuario usuario = new Usuario();

                    usuario.setIdUsuario(idUsuario);
                    usuario.setNombre(resultSet.getString("NombreUsuario"));
                    usuario.setApellidoMaterno(resultSet.getString("ApellidoMaterno"));
                    usuario.setApellidoPaterno(resultSet.getString("ApellidoPaterno"));
                    usuario.setFechaNacimiento(resultSet.getDate("FechaNacimiento"));
                    usuario.setCelular(resultSet.getString("Celular"));
                    usuario.setUserName(resultSet.getString("UserName"));
                    usuario.setEmail(resultSet.getString("Email"));
                    usuario.setPassword(resultSet.getString("Password"));
                    usuario.setSexo(resultSet.getString("Sexo"));
                    usuario.setTelefono(resultSet.getString("Telefono"));
                    usuario.setCURP(resultSet.getString("CURP"));

                    usuario.Rol = new Rol();
                    usuario.Rol.setIdRol(resultSet.getInt("IdRol"));
                    usuario.Rol.setNombre(resultSet.getString("Nombre"));

                    int idDireccion;
                    if ((idDireccion = resultSet.getInt("IdDireccion")) != 0) {

                        usuario.Direcciones = new ArrayList<>();

                        do {
                            Direccion direccion = new Direccion();
                            direccion.setIdDireccion(resultSet.getInt("IdDireccion"));
                            direccion.setCalle(resultSet.getString("Calle"));
                            direccion.setNumeroExterior(resultSet.getString("NumeroExterior"));
                            direccion.setNumeroInterior(resultSet.getString("NumeroInterior"));

                            direccion.colonia = new Colonia();
                            direccion.colonia.setIdColonia(resultSet.getInt("IdColonia"));
                            direccion.colonia.setNombre(resultSet.getString("NombreColonia"));
                            direccion.colonia.setCodigoPostal(resultSet.getString("CodigoPostal"));

                            direccion.colonia.Municipio = new Municipio();
                            direccion.colonia.Municipio.setIdMunicipio(resultSet.getInt("IdMunicipio"));
                            direccion.colonia.Municipio.setNombre(resultSet.getString("NombreMunicipio"));

                            direccion.colonia.Municipio.Estado = new Estado();
                            direccion.colonia.Municipio.Estado.setIdEstado(resultSet.getInt("IdEstado"));
                            direccion.colonia.Municipio.Estado.setNombre(resultSet.getString("NombreEstado"));

                            direccion.colonia.Municipio.Estado.Pais = new Pais(resultSet.getInt("IdPais"), resultSet.getString("Nombre"));
                            direccion.colonia.Municipio.Estado.Pais.setIdPais(resultSet.getInt("IdPais"));
                            direccion.colonia.Municipio.Estado.Pais.setNombre(resultSet.getString("NombrePais"));

                            usuario.Direcciones.add(direccion);
                        } while (resultSet.next());
                    }
                    result.object = usuario;
                }

                result.correct = true;
                return 1;
            }
            );
        } catch (Exception ex) {
            result.ex = ex;
            result.errorMessage = ex.getLocalizedMessage();
            result.correct = false;
        }
        return result;

    }

    @Override
    public Result UsuarioDireccionAdd(Usuario usuario) {
        Result result = new Result();

        try {
            result.correct = jdbcTemplate.execute("CALL UsuarioDireccionAdd(?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    (CallableStatementCallback<Boolean>) callablestatement -> {

                        callablestatement.setString(1, usuario.getNombre());
                        callablestatement.setString(2, usuario.getApellidoPaterno());
                        callablestatement.setString(3, usuario.getApellidoMaterno());
                        callablestatement.setDate(4, (Date) usuario.getFechaNacimiento());
                        callablestatement.setString(5, usuario.getCelular());
                        callablestatement.setString(6, usuario.getUserName());
                        callablestatement.setString(7, usuario.getEmail());
                        callablestatement.setString(8, usuario.getPassword());
                        callablestatement.setString(9, usuario.getSexo());
                        callablestatement.setString(10, usuario.getTelefono());
                        callablestatement.setString(11, usuario.getCURP());
                        callablestatement.setInt(12, usuario.Rol.getIdRol());
                        callablestatement.setString(13, usuario.Direcciones.get(0).getCalle());
                        callablestatement.setString(14, usuario.Direcciones.get(0).getNumeroInterior());
                        callablestatement.setString(15, usuario.Direcciones.get(0).getNumeroExterior());
                        callablestatement.setInt(16, usuario.Direcciones.get(0).colonia.getIdColonia());

                        int isCorrect = callablestatement.executeUpdate();

                        if (isCorrect == -1) {
                            return true;

                        }
                        return false;
                    });
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;

        }
        return result;

    }
    @Override
    public Result UsuarioUpDate(Usuario usuario) {
        Result result = new Result();

        try {
            result.correct = jdbcTemplate.execute("CALL UsuarioUpDate(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    (CallableStatementCallback<Boolean>) callableStatement -> {
                        callableStatement.setInt(1, usuario.getIdUsuario());
                        callableStatement.setString(2, usuario.getNombre());
                        callableStatement.setString(3, usuario.getApellidoMaterno());
                        callableStatement.setString(4, usuario.getApellidoPaterno());
                        callableStatement.setDate(5, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
                        callableStatement.setString(6, usuario.getCelular());
                        callableStatement.setString(7, usuario.getUserName());
                        callableStatement.setString(8, usuario.getEmail());
                        callableStatement.setString(9, usuario.getPassword());
                        callableStatement.setString(10, usuario.getSexo());
                        callableStatement.setString(11, usuario.getTelefono());
                        callableStatement.setString(12, usuario.getCURP());

                        int rowsAffected = callableStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            result.correct = true;
                        } else {
                            result.correct = false;
                            result.errorMessage = "No se encontró el usuario para actualizar.";
                        }
                        return false;
                    }
            );
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }
    @Override
    public Result UsuarioAddDireccion(Usuario usuario) {
        Result result = new Result();
        try {
            result.correct = jdbcTemplate.execute("CALL UsuarioAddDireccion(?, ?, ?, ?, ?, ?)",
                    (CallableStatementCallback<Boolean>) callableStatement -> {

                        callableStatement.setInt(1, usuario.getIdUsuario());
                        callableStatement.setString(2, usuario.Direcciones.get(0).getCalle());
                        callableStatement.setString(3, usuario.Direcciones.get(0).getNumeroInterior());
                        callableStatement.setString(4, usuario.Direcciones.get(0).getNumeroExterior());
                        callableStatement.setInt(5, usuario.Direcciones.get(0).colonia.getIdColonia());

                        int isCorrect = callableStatement.executeUpdate();
                        if (isCorrect == -1) {
                            return true;

                        }
                        return false;
                    });
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getMessage();
            result.ex = ex;
        }
        return result;
    }


}

