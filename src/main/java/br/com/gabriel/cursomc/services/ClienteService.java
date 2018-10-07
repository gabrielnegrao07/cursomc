package br.com.gabriel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.cursomc.domain.Cliente;
import br.com.gabriel.cursomc.repositories.ClienteRepository;
import br.com.gabriel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	/**
	 * Operação capaz de buscar uma categoria por código.
	 * Assim preciso implementar um serviço que busca uma 
	 * categoria.
	 * Servico que vai chamar a operação do objeto de acesso a 
	 * dados.
	 * Assim vou ter que declarar uma dependencia do objeto do tipo
	 * ClienteRepository
	 * Para instanciar esse repositório, precisamos chamar uma anotação
	 * chamada @Autowired que instancia  a dependencia automaticamente.
	 * Pelo mecanismo de injecao de dependencia ou inversao de controle.
	 */

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
		
	
	}
	

}
