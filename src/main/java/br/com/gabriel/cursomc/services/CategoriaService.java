package br.com.gabriel.cursomc.services;

import br.com.gabriel.cursomc.domain.Categoria;
import br.com.gabriel.cursomc.repositories.CategoriaRepository;
import br.com.gabriel.cursomc.services.exceptions.DataIntegrityException;
import br.com.gabriel.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
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

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

    public Categoria insert(Categoria obj) {
	    obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
	    find(obj.getId());
	    return repo.save(obj);
    }

    public void delete(Integer id){
	    find(id);
	    try{
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
        }

    }

    public List<Categoria> findAll() {
	    return repo.findAll();
    }
}
