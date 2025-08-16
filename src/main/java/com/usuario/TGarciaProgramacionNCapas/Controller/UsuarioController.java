package com.usuario.TGarciaProgramacionNCapas.Controller;

import com.usuario.TGarciaProgramacionNCapas.DAO.ColoniaDAOImplementation;
import com.usuario.TGarciaProgramacionNCapas.DAO.EstadoDAOImplementation;
import com.usuario.TGarciaProgramacionNCapas.DAO.MunicipioDAOImplementation;
import com.usuario.TGarciaProgramacionNCapas.DAO.PaisDAOImplementation;
import com.usuario.TGarciaProgramacionNCapas.DAO.RolDAOImplementation;
import com.usuario.TGarciaProgramacionNCapas.DAO.UsuarioDAOImplementation;
import com.usuario.TGarciaProgramacionNCapas.ML.Direccion;
import com.usuario.TGarciaProgramacionNCapas.ML.Result;
import com.usuario.TGarciaProgramacionNCapas.ML.Usuario;
import jakarta.validation.Valid;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDAOImplementation usuarioDAOImplementation;

    @Autowired
    private RolDAOImplementation rolDAOImplementation;

    @Autowired
    private PaisDAOImplementation paisDAOImplementation;

    @Autowired
    private EstadoDAOImplementation estadoDAOImplementation;

    @Autowired
    private MunicipioDAOImplementation municipioDAOImplementation;

    @Autowired
    private ColoniaDAOImplementation coloniaDAOImplementation;

    @GetMapping
    public String Index(Model model) {
        Result result = usuarioDAOImplementation.UsuarioDireccionGetAll();

        if (result.correct) {
            model.addAttribute("usuarios", result.objects);
        } else {
            model.addAttribute("usuario", null);
        }

        return "UsuarioIndex";
    }

    @GetMapping("/action/{IdUsuario}")
    public String add(Model model, @PathVariable("IdUsuario") int IdUsuario) {

        if (IdUsuario == 0) {
            Result result = rolDAOImplementation.GetAll();

            model.addAttribute("roles", result.objects);
            model.addAttribute("paises", paisDAOImplementation.GetAllPais().objects);
            model.addAttribute("Usuario", new Usuario());

            return "UsuarioForm";
        } else {
            Result result = usuarioDAOImplementation.DireccionGetByIdUsuario(IdUsuario);

            if (result.correct) {
                model.addAttribute("usuario", result.object);
            } else {
                model.addAttribute("usuario", null);
            }
            return "UsuarioDetail";
        }
    }

    @GetMapping("formEditable")
    public String formEditable(
            @RequestParam int IdUsuario,
            @RequestParam(required = false) Integer IdDireccion,
            Model model){


///---Editar Usuario------------
        if(IdDireccion == null){
            Result result = usuarioDAOImplementation.DireccionGetByIdUsuario(IdUsuario);
            if(result.correct){
                model.addAttribute("Usuario", result.object);
            }else{
                model.addAttribute("Usuario", new Usuario());
            }
//-----------Agregar Dirección---------------------
        } else if (IdDireccion == 0) {
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(IdUsuario);
        model.addAttribute("Usuario", usuario);
        }
 /* -----------Editar Dirección---------------------      
        } else {
        Result result = usuarioDAOImplementation.DireccionGetById(IdDireccion);
        if (result.correct) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(IdUsuario);
            usuario.setDireccion(new ArrayList<>());
            model.addAttribute("Usuario", usuario);
        } else {
            model.addAttribute("Usuario", new Usuario());
        }
    }*/

    model.addAttribute("paises", paisDAOImplementation.GetAllPais().objects);
    model.addAttribute("roles", rolDAOImplementation.GetAll().objects);
    return "UsuarioForm";
  }



@PostMapping("/action/")
public String Add(@Valid
@ModelAttribute("Usuario") Usuario usuario,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("Usuario", usuario);
            return "UsuarioForm";
        } else {
            Result result = usuarioDAOImplementation.UsuarioDireccionAdd(usuario);
            return "redirect:/usuario";

        }
    }
    @GetMapping("getEstadosByIdPais/{IdPais}")
@ResponseBody
public Result EstadoByPais(@PathVariable int IdPais){
        
        return estadoDAOImplementation.EstadoByPais(IdPais);
    }
    
    @GetMapping("getMunicipiosByIdEstado/{IdEstado}")
@ResponseBody
public Result MunicipioByEstado (@PathVariable int IdEstado){
        
        return municipioDAOImplementation.MunicipioByEstado(IdEstado);
    }
    
    @GetMapping("getColoniasByIdMunicipio/{IdMunicipio}")
@ResponseBody
public Result ColoniaByMunicipio (@PathVariable int IdMunicipio){
        
        return coloniaDAOImplementation.ColoniaByMunicipio(IdMunicipio);
    }
            }
    

    
