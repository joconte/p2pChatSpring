package fr.epsi.jconte.p2pChatSpring.repository;

import fr.epsi.jconte.p2pChatSpring.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAllByPersonne_Id(Long idPersonne);
}
