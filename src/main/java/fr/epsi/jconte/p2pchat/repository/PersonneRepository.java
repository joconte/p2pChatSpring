package fr.epsi.jconte.p2pchat.repository;

import fr.epsi.jconte.p2pchat.model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long> {

    Optional<Personne> findPersonneByClePublique(String clePublique);
}
