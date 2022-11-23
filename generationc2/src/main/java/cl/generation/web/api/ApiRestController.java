package cl.generation.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	// http://localhost:8080/api/hola //RUTA FIJA
	@RequestMapping("/hola")
	public String hola() {
		return "hola api";
	}

	// http://localhost:8080/api/edad/42 //RUTA DINAMICA
	@RequestMapping("/edad/{edad}")
	public String rutaDinamica(@PathVariable("edad") int edad) {
		return "capturando edad:" + edad;
	}

	// http://localhost:8080/api/nombre/fran
	@RequestMapping("/nombre/{nombre}")
	public String capturarNombre(@PathVariable("nombre") String nombre) {
		return "El nombre capturado es:" + nombre;
	}

	// http://localhost:8080/api/14/noviembre/2022
	@RequestMapping("/{dia}/{mes}/{año}")
	public String capturarFecha(@PathVariable("dia") int dia, @PathVariable("mes") String mes,
			@PathVariable("año") int año) {
		return "La fecha capturada es:" + dia + " " + mes + " " + año;
	}

	// http://localhost:8080/api?id=--1 ->pasando parametro //peticion tipo GET
	// http://localhost:8080/api/usuario?usuarioId=1
	//PEDIR ID USUARIO
	@RequestMapping("/usuario") // ruta
	public String parametro(@RequestParam(value = "usuarioId", required = false) Integer id) { // desde request estamoscapturando el valor ydesde Integer asignamos TIPODATO
		// int, long, float = 0
		// Integer, Long, Float... pueden ser nulos
		if (id == null) {
			return "parametro no existe";
		} else {
			return "parametro por get, id número:" + id;
		}
	}

	//PEDIR ID Y NOMBRE USUARIO
	// http://localhost:8080/api/usuario2?usuarioId=1&nombre=fran
	@RequestMapping("/usuario2")
	public String parametro2(@RequestParam(value="usuarioId",required = false) Integer id,
			@RequestParam(value="nombre",required = false) String nombre) {

		if(id == null) {
			return "parametro no existe";
		}else {
			return "parametro por get, id número:"+id + ", de nombre:"+nombre;
		}
	}


}
