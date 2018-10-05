package br.com.gabriel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.cursomc.domain.Categoria;
import br.com.gabriel.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	/**
	 * Operação capaz de buscar uma categoria por código.
	 * Assim preciso implementar um serviço que busca uma 
	 * categoria.
	 * Servico que vai chamar a operação do objeto de acesso a 
	 * dados.
	 * Assim vou ter que declarar uma dependencia do objeto do tipo
	 * CategoriaRepository
	 * Para instanciar esse repositório, precisamos chamar uma anotação
	 * chamada @Autowired que instancia  a dependencia automaticamente.
	 * Pelo mecanismo de injecao de dependencia ou inversao de controle.
	 */

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		
		
	
	}
	

}
