package br.com.gabriel.cursomc.services;

import br.com.gabriel.cursomc.domain.Categoria;
import br.com.gabriel.cursomc.repositories.CategoriaRepository;
import br.com.gabriel.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
		
	
	}


    public Categoria insert(Categoria obj) {
	    obj.setId(null);
	    return repo.save(obj);
    }
}
