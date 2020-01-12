package fr.epsi.jconte.p2pchat.repository;

import fr.epsi.jconte.p2pchat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByPersonne_Id(Long idPersonne);
}
