package cl.generation.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@RestController
public class UsuarioApiRestController {
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	// GUARDAR USUARIO
	@RequestMapping("/guardar/usuario")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		/*
		 * {
		 * "nombre":"Mijail",
		 * "correo":"a@a.cl",
		 * "password": "secret"
		 * }
		 */
		usuarioServiceImpl.guardarUsuario(usuario);
		return usuario;
	}
	
	//ELIMINAR USUARIO
	@RequestMapping("/eliminar/usuario")
	public String eliminarUsuario(@RequestParam(value="id",required = false) Long id) {
		//llamando el metodo en el service
		/*String respuesta = usuarioServiceImpl.eliminarUsuario
		 * return respuesta;*/
		 
		return usuarioServiceImpl.eliminarUsuario(id);
	}

	// ACTUALIZAR USUARIO
	@RequestMapping("/actualizar/usuario")
	public String actualizarUsuario(@RequestBody Usuario usuario) {
		//validacion lógica: viene o no viene el id?
		if(usuario.getId()!=null) {
		String mensaje = usuarioServiceImpl.actualizarUsuario(usuario);	
		return mensaje;
		}
		return "No se actualizará ningún usuario";
	}
	
	//OBTENER USUARIO
	@RequestMapping("/obtener/usuario")
	public Usuario obtenerUsuario(@RequestParam(value="id",required = false) Long id
			){
		
		Usuario mensaje = usuarioServiceImpl.obtenerUsuario(id);
				return mensaje;
				
	}

	//LISTAR TODOS LOS USUARIOS
	@GetMapping("/listar/usuario")
	public List<Usuario> obtenerListaUsuarios(){
		return usuarioServiceImpl.obtenerListaUsuarios();
		
	}


}
