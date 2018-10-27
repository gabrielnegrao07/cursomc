package br.com.gabriel.cursomc.repositories;

import br.com.gabriel.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository é um tipo especial do Spring capaz de acessar os dados com base em um tipo que for passado.
//Os parâmetros passados, são o tipo do objeto e o tipo do atributo identificador
//Esse objeto realizará operações de acesso a dados (busca, salvar, alterar, deletar) todas referentes ao objeto ItemPedido que está
//mapeado com a tabela ItemPedido no banco de dados.

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
