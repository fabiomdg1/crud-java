package crudJava.crud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudJava.crud.Model.Contato;
import crudJava.crud.Repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	//Mostrar todos os contatos
	public List<Contato> todosContatos(){
		return contatoRepository.findAll();
	}	
	
	//Mostrar contato por id
	public Contato mostrarUmContato(Integer id_contato) {
		//Optional - nos ajuda a evitar os erros NullPointerException
		//tira a necessidade da verificação de criarmos codificação (if aluno != null)
		
		//orElseThrow() -se o aluno estiver presente no banco de dando, retorna o aluno,
		//se naão lança uma exceção
		
		Optional<Contato> contato = contatoRepository.findById(id_contato);
		return contato.orElseThrow();
	}
	
	//Inserir Contato
	public Contato inserirUmContato(Contato contato) {
		contato.setId_contato(null);
		return contatoRepository.save(contato);
	}
	
	//Deletar contato
	public void deletarUmContato(Integer id_contato) {
		contatoRepository.deleteById(id_contato);		
	}
	
	//Editar um contato
	public Contato editarUmContato(Contato contato) {
		mostrarUmContato(contato.getId_contato());
		return contatoRepository.save(contato);
	}

}
