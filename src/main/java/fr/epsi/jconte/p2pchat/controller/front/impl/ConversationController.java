package fr.epsi.jconte.p2pchat.controller.front.impl;

import fr.epsi.jconte.p2pchat.controller.front.IConversationController;
import fr.epsi.jconte.p2pchat.model.Message;
import fr.epsi.jconte.p2pchat.repository.MessageRepository;
import fr.epsi.jconte.p2pchat.service.IDecryptService;
import fr.epsi.jconte.p2pchat.service.IGetPrivateKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConversationController implements IConversationController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private IDecryptService decryptService;

    @Autowired
    private IGetPrivateKeyService getPrivateKeyService;

    @Override
    public List<Message> getCleanMessageFromPersonne(@PathVariable Long idPersonne) throws Exception {

        List<Message> cleanMessages = new ArrayList<>();
        List<Message> encryptedMessages = messageRepository.findAllByPersonne_Id(idPersonne);

        // Pour chaque message chiffré
        for (Message encryptedMessage : encryptedMessages) {

            // On déchiffre le message à l'aide de notre clé privée
            encryptedMessage.setContenu(decryptService.decryptString(encryptedMessage.getContenu(), getPrivateKeyService.getPrivateKeyFromResource("secret.key")));

            // On ajoute le message dans notre liste de message déchiffré
            cleanMessages.add(encryptedMessage);
        }

        // On retourne la liste de message déchiffré.
        return cleanMessages;
    }
}
