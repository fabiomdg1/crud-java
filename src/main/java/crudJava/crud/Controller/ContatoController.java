package crudJava.crud.Controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import crudJava.crud.Model.Contato;
import crudJava.crud.Service.ContatoService;

@CrossOrigin
@RestController
@RequestMapping("agenda")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;
	
	//Mostra todos os contatos
	@GetMapping("/contatos")
	public List<Contato> mostrarTodosContatos(){
		List<Contato> contatos = contatoService.todosContatos();
		return contatos;
	}
	
	//Mostra um contato conforme ID do contato
	@GetMapping("/contato/{id_contato}")
	public ResponseEntity<?> mostrarUmContato(@PathVariable Integer id_contato){
		Contato contato = contatoService.mostrarUmContato(id_contato);
		return ResponseEntity.ok().body(contato);
	}
	
	//Inserir um contato
	@PostMapping("/contato")
	public ResponseEntity<Contato> inserirContato(@RequestBody Contato contato){
		contato = contatoService.inserirUmContato(contato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(contato.getId_contato()).toUri();
		return ResponseEntity.created(uri).build();
	}	
	
	//Deletar um contato
	@DeleteMapping("/contato/{id_contato}")
	public ResponseEntity<Void> deletarUmContato(@PathVariable Integer id_contato){
		contatoService.deletarUmContato(id_contato);
		return ResponseEntity.noContent().build();
	}
	
	//Editar contato
	@PutMapping("/contato/{id_contato}")
	public ResponseEntity<Void> editarContato(@PathVariable Integer id_contato, @RequestBody Contato contato){
		contato.setId_contato(id_contato);
		contato = contatoService.editarUmContato(contato);
		return ResponseEntity.noContent().build();
	}
	
	
}
