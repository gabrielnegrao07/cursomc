package br.com.gabriel.cursomc.resources;

import br.com.gabriel.cursomc.domain.Categoria;
import br.com.gabriel.cursomc.dto.CategoriaDTO;
import br.com.gabriel.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
//Aqui criamos uma classe que vai ser o controlador Rest e vai responder pelo endpoint do RequestMapping
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    //No padrão Rest precisamos atribuir os verbos HTTP adquados para cada operação.
    //Como ela é uma funcao Rest eu preciso associar ela a um dos verbos do HTTP.
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = service.findAll();
        // O stream é um recurso do java 8 que serve para percorrer a lista.
        // O map, serve para efetuar uma operacao para cada elemento da lista.
        // A funcao anonima recebe o 'obj' e instancia um objeto do tipo CategoriaDTO recebendo esse obj
        // feito isso temos que retornar esse stream de objetos para o tipo lista.
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method =RequestMethod.POST )
    public ResponseEntity<Void> insert(@RequestBody Categoria obj){
        obj = service.insert(obj);
        // Serve para retornar a nova uri que foi atribuida para a categoria inserida.
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
