package br.com.hierarquia.colaboradores.repository;

import br.com.hierarquia.colaboradores.model.Hierarquia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierarquiaRepository extends JpaRepository<Hierarquia, Integer> {
}
