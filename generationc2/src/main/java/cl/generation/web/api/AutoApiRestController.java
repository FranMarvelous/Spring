package cl.generation.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Auto;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.AutoServiceImpl;
import cl.generation.web.services.UsuarioServiceImpl;

@RestController
public class AutoApiRestController {
	@Autowired
	private AutoServiceImpl autoServiceImpl;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	//GUARDAR AUTO
	@RequestMapping("/guardar/auto")
	public Auto guardarUsuario(@RequestBody Auto auto){
		
		autoServiceImpl.guardarAuto(auto);
		return auto;
		
	}



}

