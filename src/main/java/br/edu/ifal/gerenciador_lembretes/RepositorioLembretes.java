package br.edu.ifal.gerenciador_lembretes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLembretes extends CrudRepository<Lembrete, Long>{

}