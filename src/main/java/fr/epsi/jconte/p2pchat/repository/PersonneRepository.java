package fr.epsi.jconte.p2pchat.repository;

import fr.epsi.jconte.p2pchat.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    Optional<Personne> findPersonneByClePublique(String clePublique);
}
