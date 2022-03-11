package crudJava.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crudJava.crud.Model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{

}
