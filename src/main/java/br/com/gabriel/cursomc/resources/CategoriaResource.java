package br.com.gabriel.cursomc.resources;

import br.com.gabriel.cursomc.domain.Categoria;
import br.com.gabriel.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
