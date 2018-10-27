 package br.com.gabriel.cursomc.resources;

 import br.com.gabriel.cursomc.domain.Pedido;
 import br.com.gabriel.cursomc.services.PedidoService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RestController;

 @RestController
 @RequestMapping(value="/pedidos")
 //Aqui criamos uma classe que vai ser o controlador Rest e vai responder pelo endpoint do RequestMapping
  public class PedidoResource {

     @Autowired
     private PedidoService service;

 //	No padrão Rest precisamos atribuir os verbos HTTP adquados para cada operação.
 //	Como ela é uma funcao Rest 	eu preciso associar ela a um dos verbos do HTTP.
     @RequestMapping(value="/{id}", method=RequestMethod.GET)
     public ResponseEntity<Pedido> find(@PathVariable Integer id) {
         Pedido obj = service.find(id);
         return ResponseEntity.ok().body(obj);


     }

 }
