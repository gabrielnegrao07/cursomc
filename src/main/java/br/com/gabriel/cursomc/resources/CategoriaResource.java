 package br.com.gabriel.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.cursomc.domain.Categoria;

@RestController 
@RequestMapping(value="/categorias")
//Aqui criamos uma classe que vai ser o controlador Rest e vai responder pelo endpoint do RequestMapping
 public class CategoriaResource {

//	No padrão Rest precisamos atribuir os verbos HTTP adquados para cada operação. 
//	Como ela é uma funcao Rest 	eu preciso associar ela a um dos verbos do HTTP.
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {	
		
		Categoria cat1 = new Categoria(1, "Infomática");
		Categoria cat2 = new Categoria(2, "Escritória");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
		
	}

}
