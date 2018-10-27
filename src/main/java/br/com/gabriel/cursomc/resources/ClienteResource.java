 package br.com.gabriel.cursomc.resources;

 import br.com.gabriel.cursomc.domain.Cliente;
 import br.com.gabriel.cursomc.services.ClienteService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value="/clientes")
//Aqui criamos uma classe que vai ser o controlador Rest e vai responder pelo endpoint do RequestMapping
 public class ClienteResource {
	
	@Autowired
	private ClienteService service;

//	No padrão Rest precisamos atribuir os verbos HTTP adquados para cada operação. 
//	Como ela é uma funcao Rest 	eu preciso associar ela a um dos verbos do HTTP.
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {	
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
								
		
	}

}
