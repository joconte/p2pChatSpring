package fr.epsi.jconte.p2pchat.controller.front;


import fr.epsi.jconte.p2pchat.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@RequestMapping("/chat/conversation")
public interface IConversationController {

    /**
     * Permet de récupérer les messages non chiffrés d'une personne par son id.
     * @param idPersonne
     * @return
     * @throws Exception
     */
    @GetMapping
    @RequestMapping("{idPersonne}")
    List<Message> getCleanMessageFromPersonne(@PathVariable Long idPersonne) throws Exception;
}

