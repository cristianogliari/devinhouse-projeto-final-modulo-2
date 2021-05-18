package br.com.devinhouse.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devinhouse.backend.entities.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer>{
//	Uso de mapeamento de ojeto relacional usando a especificação JPA;
}
