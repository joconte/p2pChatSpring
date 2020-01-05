package fr.epsi.jconte.p2pChatSpring.repository;

import fr.epsi.jconte.p2pChatSpring.model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long> {

    Optional<Personne> findPersonneByClePublique(String clePublique);
}
