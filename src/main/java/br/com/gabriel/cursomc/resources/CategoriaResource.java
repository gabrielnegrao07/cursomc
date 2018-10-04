 package br.com.gabriel.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value="/categorias")
//Aqui criamos uma classe que vai ser o controlador Rest e vai responder pelo endpoint do RequestMapping
 public class CategoriaResource {

//	No padrão Rest precisamos atribuir os verbos HTTP adquados para cada operação. 
//	Como ela é uma funcao Rest 	eu preciso associar ela a um dos verbos do HTTP.
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {	
		return "REST está funcionando!";
		
	}

}
